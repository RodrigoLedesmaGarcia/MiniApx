package apx.ejercicio.MiniApx.library;

import apx.ejercicio.MiniApx.dto.CrearTarjetaRequestDTO;
import apx.ejercicio.MiniApx.dto.TarjetaCreadaDTO;
import apx.ejercicio.MiniApx.dto.TarjetasRequestDTO;
import apx.ejercicio.MiniApx.repository.TarjetasResponseDTO;
import apx.ejercicio.MiniApx.service.TarjetaService;
import org.springframework.stereotype.Service;

@Service
public class TarjetasLibraryImpl implements TarjetasLibrary {

    private final TarjetaService tarjetaService;

    public TarjetasLibraryImpl(TarjetaService tarjetaService) {
        this.tarjetaService = tarjetaService;
    }


    @Override
    public TarjetasResponseDTO executeGetBusinessCards(
            TarjetasRequestDTO request) {

        return tarjetaService.obtenerTarjetas(request);
    }

    @Override
    public TarjetaCreadaDTO executeCreateBusinessCard(
            CrearTarjetaRequestDTO request) {

        return tarjetaService.crearTarjeta(request);
    }
}