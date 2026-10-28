package apx.ejercicio.MiniApx.dto;

public record CrearTarjetaRequestDTO(
        String titular,
        String numeroTarjeta,
        String estado
) {}