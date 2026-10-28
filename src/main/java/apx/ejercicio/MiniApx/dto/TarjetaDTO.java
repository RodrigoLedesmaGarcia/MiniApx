package apx.ejercicio.MiniApx.dto;


public class TarjetaDTO {

    private Long id;
    private String titular;
    private String estado;

    public TarjetaDTO(
            Long id,
            String titular,
            String estado) {

        this.id = id;
        this.titular = titular;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public String getTitular() {
        return titular;
    }

    public String getEstado() {
        return estado;
    }

}