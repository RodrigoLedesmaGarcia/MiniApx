package apx.ejercicio.MiniApx.repository;

import apx.ejercicio.MiniApx.dto.PaginationDTO;
import apx.ejercicio.MiniApx.dto.TarjetaDTO;

import java.util.List;

public class TarjetasResponseDTO {

    private List<TarjetaDTO> tarjetas;
    private PaginationDTO pagination;

    public TarjetasResponseDTO(
            List<TarjetaDTO> tarjetas,
            PaginationDTO pagination) {

        this.tarjetas = tarjetas;
        this.pagination = pagination;
    }

    public List<TarjetaDTO> getTarjetas() {
        return tarjetas;
    }

    public PaginationDTO getPagination() {
        return pagination;
    }
}