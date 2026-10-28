package apx.ejercicio.MiniApx.mapper;

import apx.ejercicio.MiniApx.dto.TarjetaDTO;
import apx.ejercicio.MiniApx.entity.TarjetaEntity;

public class TarjetaMapper {

    private TarjetaMapper() {
    }

    public static TarjetaDTO toDTO(TarjetaEntity entity) {

        return new TarjetaDTO(
                entity.getId(),
                entity.getTitular(),
                entity.getEstado()
        );
    }
}
