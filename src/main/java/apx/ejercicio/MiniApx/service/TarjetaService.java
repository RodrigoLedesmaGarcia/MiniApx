package apx.ejercicio.MiniApx.service;

import apx.ejercicio.MiniApx.dto.*;
import apx.ejercicio.MiniApx.entity.TarjetaEntity;
import apx.ejercicio.MiniApx.mapper.TarjetaMapper;
import apx.ejercicio.MiniApx.repository.TarjetasRepository;

import apx.ejercicio.MiniApx.repository.TarjetasResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

@Service
public class TarjetaService {

    private final TarjetasRepository repository;

    public TarjetaService(TarjetasRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<TarjetaEntity> listarTarjetas() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public TarjetaEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException(
                                "No existe la tarjeta: " + id
                        )
                );
    }

    @Transactional
    public TarjetaEntity guardarTarjeta(TarjetaEntity tarjeta) {

        if (tarjeta == null
                || tarjeta.getTitular() == null
                || tarjeta.getTitular().isBlank()) {

            throw new IllegalArgumentException(
                    "El titular es obligatorio"
            );
        }

        return repository.save(tarjeta);
    }

    // método nuevo
    @Transactional(readOnly = true)
    public TarjetaDTO buscarTarjetaDTO(Long id) {

        TarjetaEntity tarjeta = buscarPorId(id);

        return TarjetaMapper.toDTO(tarjeta);
    }

    @Transactional(readOnly = true)
    public Page<TarjetaDTO> buscarPorEstado(
            String estado,
            int pagina,
            int tamanio) {

        if (estado == null || estado.isBlank()) {
            throw new IllegalArgumentException(
                    "El estado es obligatorio"
            );
        }

        if (pagina < 0 || tamanio < 1 || tamanio > 25) {
            throw new IllegalArgumentException(
                    "Paginación inválida"
            );
        }

        Pageable pageable = PageRequest.of(
                pagina,
                tamanio,
                Sort.by("id").ascending()
        );

        return repository
                .findByEstadoIgnoreCase(estado, pageable)
                .map(TarjetaMapper::toDTO);
    }


    @Transactional(readOnly = true)
    public TarjetasResponseDTO obtenerTarjetas(
            TarjetasRequestDTO request) {


        String estado = normalizar(request.getEstado());
        String titular = normalizar(request.getTitular());

        Pageable pageable = PageRequest.of(
                request.getPagina() - 1,
                request.getTamanio(),
                Sort.by("id").ascending()
        );

        Page<TarjetaEntity> resultado =
                repository.buscarTarjetas(
                        estado,
                        titular,
                        pageable
                );

        // 1. Obtener parámetros del DTO
        int pagina = request.getPagina();
        int tamanio = request.getTamanio();

        // 2. Validaciones
        if (pagina < 1) {
            throw new IllegalArgumentException(
                    "La página debe ser mayor o igual a 1"
            );
        }

        if (tamanio < 1 || tamanio > 25) {
            throw new IllegalArgumentException(
                    "El tamaño debe estar entre 1 y 25"
            );
        }


        if (estado == null || estado.isBlank()) {
            resultado = repository.findAll(pageable);
        } else {
            resultado = repository
                    .findByEstadoIgnoreCase(
                            estado.trim(),
                            pageable
                    );
        }

        // 5. Convertir Entity a DTO
        List<TarjetaDTO> tarjetas = resultado
                .getContent()
                .stream()
                .map(t -> new TarjetaDTO(
                        t.getId(),
                        t.getTitular(),
                        t.getEstado()
                ))
                .toList();

        // 6. Crear información de paginación
        PaginationDTO pagination = new PaginationDTO(
                pagina,
                tamanio,
                resultado.getTotalPages(),
                Math.toIntExact(resultado.getTotalElements())
        );

        // 7. Construir respuesta
        return new TarjetasResponseDTO(
                tarjetas,
                pagination
        );
    }


    @Transactional
    public TarjetaCreadaDTO crearTarjeta(
            CrearTarjetaRequestDTO request) {

        TarjetaEntity tarjeta = new TarjetaEntity();

        tarjeta.setTitular(request.titular().trim());
        tarjeta.setNumeroTarjeta(request.numeroTarjeta().trim());
        tarjeta.setEstado(request.estado());

        TarjetaEntity guardada = repository.save(tarjeta);

        return new TarjetaCreadaDTO(
                guardada.getId(),
                guardada.getTitular(),
                guardada.getEstado()
        );
    }


    // método para normalizar un string
    private String normalizar(String valor) {
        if (valor == null || valor.isBlank()) {
            return null;
        }

        return valor.trim();
    }
}