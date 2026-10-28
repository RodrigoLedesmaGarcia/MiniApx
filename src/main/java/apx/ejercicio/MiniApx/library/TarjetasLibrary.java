package apx.ejercicio.MiniApx.library;


import apx.ejercicio.MiniApx.dto.CrearTarjetaRequestDTO;
import apx.ejercicio.MiniApx.dto.TarjetaCreadaDTO;
import apx.ejercicio.MiniApx.dto.TarjetasRequestDTO;
import apx.ejercicio.MiniApx.repository.TarjetasResponseDTO;

public interface TarjetasLibrary {

    // Consultar tarjetas con filtros y paginación
    TarjetasResponseDTO executeGetBusinessCards(
            TarjetasRequestDTO request
    );

    // Crear una tarjeta nueva
    TarjetaCreadaDTO executeCreateBusinessCard(
            CrearTarjetaRequestDTO request
    );
}