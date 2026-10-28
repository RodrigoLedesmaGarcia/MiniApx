package apx.ejercicio.MiniApx.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tarjetas")
public class TarjetaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titular;

    @Column(name = "numero_tarjeta", nullable = false)
    private String numeroTarjeta;

    @Column(nullable = false)
    private String estado;

    public TarjetaEntity() {
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
