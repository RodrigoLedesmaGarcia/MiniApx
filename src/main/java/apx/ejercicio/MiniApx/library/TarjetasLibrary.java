package apx.ejercicio.MiniApx.library;


import apx.ejercicio.MiniApx.dto.CrearTarjetaRequestDTO;
import apx.ejercicio.MiniApx.dto.TarjetaCreadaDTO;
import apx.ejercicio.MiniApx.repository.TarjetasResponseDTO;

public interface TarjetasLibrary {

    TarjetasResponseDTO executeGetBusinessCards(
            String estado,
            int pagina,
            int tamanio // tamaño
    );

    TarjetaCreadaDTO executeCreateBusinessCard(
            CrearTarjetaRequestDTO request);
}

