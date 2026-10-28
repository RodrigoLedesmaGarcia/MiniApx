package apx.ejercicio.MiniApx.controller;

import apx.ejercicio.MiniApx.dto.CrearTarjetaRequestDTO;
import apx.ejercicio.MiniApx.dto.TarjetaCreadaDTO;
import apx.ejercicio.MiniApx.dto.TarjetasRequestDTO;
import apx.ejercicio.MiniApx.library.TarjetasLibrary;
import apx.ejercicio.MiniApx.repository.TarjetasResponseDTO;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tarjetas")
public class TarjetasController {

    private final TarjetasLibrary tarjetasLibrary;

    public TarjetasController(TarjetasLibrary tarjetasLibrary) {
        this.tarjetasLibrary = tarjetasLibrary;
    }


    @GetMapping
    public TarjetasResponseDTO obtenerTarjetas(@RequestParam(required = false) String estado, @RequestParam(defaultValue = "1") int pagina, @RequestParam(defaultValue = "10") int tamanio, @RequestParam(required = false) String titular) {

        TarjetasRequestDTO request = new TarjetasRequestDTO();

        request.setEstado(estado);
        request.setPagina(pagina);
        request.setTamanio(tamanio);
        request.setTitular(titular);
        return tarjetasLibrary.executeGetBusinessCards(request);
    }


    @PostMapping
    public ResponseEntity<TarjetaCreadaDTO> crearTarjeta( @Valid @RequestBody CrearTarjetaRequestDTO request) {

        TarjetaCreadaDTO respuesta = tarjetasLibrary.executeCreateBusinessCard(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }

}
