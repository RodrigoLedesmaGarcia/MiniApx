package apx.ejercicio.MiniApx.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tarjetas")
public class TarjetaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El titular es obligatorio")
    private String titular;

    @NotBlank(message = "El número de tarjeta es obligatorio")
    @Size(max = 30, message = "Máximo 30 caracteres")
    private String numeroTarjeta;

    @NotBlank(message = "El estado es obligatorio")
    @Pattern(
            regexp = "ACTIVA|INACTIVA",
            message = "El estado debe ser ACTIVA o INACTIVA"
    )
    private String estado;

    public TarjetaEntity() {
    }

    public TarjetaEntity(String titular){
        super();
    }

    public TarjetaEntity(String titular, String numeroTarjeta) {
        this.titular = titular;
        this.numeroTarjeta = numeroTarjeta;
    }

    public TarjetaEntity(String titular, String numeroTarjeta, String estado) {
        this.titular = titular;
        this.numeroTarjeta = numeroTarjeta;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "TarjetaEntity{" +
                "id=" + id +
                ", titular='" + titular + '\'' +
                ", numeroTarjeta='" + "{dato confidencial}" + '\'' +
                ", estado='" + estado + '\'' +
                '}'+
                "\n ";
    }
}
