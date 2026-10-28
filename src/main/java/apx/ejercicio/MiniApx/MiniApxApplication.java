package apx.ejercicio.MiniApx;

import apx.ejercicio.MiniApx.dto.TarjetaDTO;
import apx.ejercicio.MiniApx.repository.TarjetasResponseDTO;
import apx.ejercicio.MiniApx.service.TarjetaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;

@SpringBootApplication
public class MiniApxApplication {

	public static void main(String... args) {
		SpringApplication.run(
				MiniApxApplication.class, args
		);
	}

	/*
	@Bean
    CommandLineRunner prueba(TarjetaRepository repository) {

		return args -> {

			if (repository.count() == 0) {

				TarjetaEntity tarjeta = new TarjetaEntity(
						"Carlos",
						"TARJ-TEST-001",
						"ACTIVA"
				);

				repository.save(tarjeta);
			}

			repository.findAll().forEach(t -> {
				System.out.println(
						"ID: " + t.getId()
								+ " | Titular: " + t.getTitular()
								+ " | Estado: " + t.getEstado()
				);
			});
		};
	}
	*/

	/*

	@Bean
	CommandLineRunner prueba(TarjetaService service) {

		return args -> {

			TarjetaEntity tarjeta = service.buscarPorId(1L);

			System.out.println("Tarjeta encontrada:");
			System.out.println("ID: " + tarjeta.getId());
			System.out.println("Titular: " + tarjeta.getTitular());
			System.out.println("Estado: " + tarjeta.getEstado());

		};
	}
	*/

	/*
	@Bean
	CommandLineRunner prueba(TarjetaService service) {

		return args -> {

			TarjetaDTO dto = service.buscarTarjetaDTO(1L);

			System.out.println("DTO obtenido:");
			System.out.println("ID: " + dto.getId());
			System.out.println("Titular: " + dto.getTitular());
			System.out.println("Estado: " + dto.getEstado());

		};
	}
	 */

  /*
	@Bean
	CommandLineRunner prueba(TarjetaService service) {
		return args -> {

			// 1. Consultar las tarjetas activas
			TarjetasResponseDTO respuesta =
					service.obtenerTarjetas("ACTIVA", 1, 5);

			// 2. Mostrar las tarjetas
			System.out.println("TARJETAS ENCONTRADAS:");

			respuesta.getTarjetas().forEach(tarjeta -> {
				System.out.println(
						tarjeta.getId() + " | " +
								tarjeta.getTitular() + " | " +
								tarjeta.getEstado()
				);
			});

			// 3. Mostrar información de paginación
			System.out.println(
					"Página: " +
							respuesta.getPagination().getPage()
			);

			System.out.println(
					"Total: " +
							respuesta.getPagination().getTotalElements()
			);

			System.out.println(
					"Páginas: " +
							respuesta.getPagination().getTotalPages()
			);

		};
	}


   */
} // fin de la clase