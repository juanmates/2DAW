package com.ej09;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ej09.model.Perfil;
import com.ej09.model.Usuario;
import com.ej09.service.UsuarioService;

@SpringBootApplication
public class Ejercicio09Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio09Application.class, args);
	}

	@Autowired
	UsuarioService usuarioService;

	@Override
	public void run(String... args) throws Exception {

		// 1. Insertar el usuario con nombre Pepe Ruiz y correo ppruiz@gmail.com.
		// Con biografia ‘perfildepepe’ y estado DISPONIBLE.
		System.out.println("*****************1************************");

		Perfil perf1 = new Perfil("perfildepepe", "DISPONIBLE");
		Usuario usu1 = new Usuario("Pepe Ruiz", "ppruizzz@gmail.com", perf1);
		perf1.setUsu(usu1);
		usuarioService.insertar(usu1);

		// 2. Insertar el usuario con nombre Andrés Ramírez y correo aramirez@gmail.com.
		// Con biografia ‘perfildeandres’ y estado NO DISPONIBLE
		System.out.println("*****************2************************");
		Perfil perf2 = new Perfil("perfildeandres", "NO DISPONIBLE");
		Usuario usu2 = new Usuario("Andrés Ramírez", "aramirezzzz@gmail.com", perf2);
		perf2.setUsu(usu2);
		usuarioService.insertar(usu2);
		// 3. Mostrar la lista de todos los usuarios
		System.out.println("*****************3************************");
		mostrarUsuarios();
		// 4. Obtener los datos del usuario con el id de Andrés.
		System.out.println("*****************4************************");
		Usuario usu = usuarioService.obtenerPorId(usu2.getId());
		System.out.println(usu);

		// 5. Dado el id de Pepe Ruiz, actualizar sus datos: correo ppruiz2@gmail.com y
		// estado NO DISPONIBLE

		usu = usuarioService.obtenerPorId(usu1.getId());
		//usu.setEmail("ppruiz2@gmail.com");
		usu.getPerfil().setEstado("NO DISPONIBLE");
		usuarioService.insertar(usu);

		// 6. Mostrar la lista de todos los usuarios y comprobar la actualización.
		System.out.println("*****************6************************");
		mostrarUsuarios();

		// 7. Obtener el perfil de Andrés.
		System.out.println("*****************7************************");
		usu = usuarioService.obtenerPorId(usu2.getId());
		System.out.println(usu.getPerfil());

		// 8. Mostrar la lista de todos los usuarios cuya biografía contenga la palabra
		// ‘perfil’.
		System.out.println("*****************8************************");
		List<Usuario> lista = usuarioService.buscarPorBio("perfil");
		for (Usuario usuario : lista) {
			System.out.println(usuario);
		}

		// 9. Mostrar el primer usuario disponible.
		System.out.println("*****************9************************");
		System.out.println(usuarioService.obtenerPrimerDisponible());

		// 10. Mostrar todos los usuarios no disponibles
		System.out.println("*****************10************************");

		lista = usuarioService.obtenerNoDisponibles();
		for (Usuario usuario : lista) {
			System.out.println(usuario);
		}

		// 11. Actualizar todos los usuarios a disponibles.
		System.out.println("*****************11************************");
		usuarioService.actualizarTodosADisponible();
		mostrarUsuarios();

		// 12. Eliminar el usuario de Pepe.

		System.out.println("*****************12************************");
		usuarioService.eliminar(usu1.getId());
		mostrarUsuarios();

		System.out.println("*****************13************************");
		// 13 Modificar el perfil de Andrés: Con biografia ‘perfildeandresModificado’ y
		// estado NO DISPONIBLE.
		Perfil p = new Perfil();
		p.setBio("perfildeandresModificado");
		p.setEstado("NO DISPONIBLE");
		p.setUsu(usu2);
		usuarioService.actualizarPerfil(usu2.getId(), p);
		mostrarUsuarios();
	}

	private void mostrarUsuarios() {

		List<Usuario> usuarios = usuarioService.obtenerTodos();
		for (Usuario usu : usuarios) {
			System.out.println(usu);
		}
	}

}
