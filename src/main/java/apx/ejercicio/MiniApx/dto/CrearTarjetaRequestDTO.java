package apx.ejercicio.MiniApx.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CrearTarjetaRequestDTO(

        @NotBlank(message = "El titular es obligatorio")
        String titular,

        @NotBlank(message = "El número de tarjeta es obligatorio")
        @Size(max = 30, message = "Máximo 30 caracteres")
        String numeroTarjeta,

        @NotBlank(message = "El estado es obligatorio")
        @Pattern(
                regexp = "ACTIVA|INACTIVA",
                message = "Estado inválido"
        )
        String estado
) {}