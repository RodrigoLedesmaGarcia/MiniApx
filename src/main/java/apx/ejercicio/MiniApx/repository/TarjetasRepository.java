package apx.ejercicio.MiniApx.repository;

import apx.ejercicio.MiniApx.entity.TarjetaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetasRepository extends JpaRepository<TarjetaEntity, Long> {

    // Método para paginar
    Page<TarjetaEntity> findByEstadoIgnoreCase(
            String estado,
            Pageable pageable
    );

    @Query("""
    SELECT t
    FROM TarjetaEntity t
    WHERE (:estado IS NULL
           OR UPPER(t.estado) = UPPER(:estado))
      AND (:titular IS NULL
           OR LOWER(t.titular)
              LIKE LOWER(CONCAT('%', :titular, '%')))
    """)
    Page<TarjetaEntity> buscarTarjetas(
            @Param("estado") String estado,
            @Param("titular") String titular,
            Pageable pageable
    );


}
