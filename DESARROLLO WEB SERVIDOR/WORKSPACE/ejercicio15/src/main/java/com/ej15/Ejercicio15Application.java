package com.ej15;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ej15.model.Curso;
import com.ej15.model.Estudiante;
import com.ej15.service.CursoService;
import com.ej15.service.EstudianteService;

@SpringBootApplication
public class Ejercicio15Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio15Application.class, args);
	}

	@Autowired
	CursoService cursoService;
	
	@Autowired
	EstudianteService estudianteService;

	@Override
	public void run(String... args) throws Exception {
		// Crear cursos
		Curso curso1 = new Curso();
		curso1.setNombre("Curso de Matemáticas");
		curso1.setDescripcion("Curso avanzado de matemáticas");

		
		Curso curso2 = new Curso();
		curso2.setNombre("Curso de Historia");
		curso2.setDescripcion("Historia Universal");

		cursoService.crearCurso(curso1);
		cursoService.crearCurso(curso2);
		
		
		// Crear estudiantes
		Estudiante estudiante1 = new Estudiante();
		estudiante1.setNombre("Juan Pérez");
		estudiante1.setEmail("juanperez@email.com");
		
		
		Estudiante estudiante2 = new Estudiante();
		estudiante2.setNombre("María López");
		estudiante2.setEmail("marialopez@email.com");
		
		// Asociar estudiantes a cursos
		curso1.addEstudiante(estudiante1);
		curso1.addEstudiante(estudiante2);
		
		
		// Guardar cursos con estudiantes
		System.out.println(curso1.getId());
		cursoService.crearCurso(curso1);//, curso1.getEstudiantes());
		cursoService.crearCurso(curso2);//, new ArrayList<>());

		
		// Consultar todos los cursos
		System.out.println("Todos los cursos:");
		cursoService.obtenerTodos().forEach(c -> {
			System.out.println("Curso: " + c.getNombre() + ", Estudiantes: " + c.getEstudiantes().size());
		});

		// Consultar un curso por ID
		
				Curso cursoConsultado = cursoService.obtenerPorId(curso1.getId());
				System.out.println("Curso consultado: " + cursoConsultado.getNombre());
				for (Estudiante est : cursoConsultado.getEstudiantes()) {
					System.out.println(est.getNombre());
				}
				
				//Buscar cursos con la palabra curso
				System.out.println("Cursos con la palabra curso");
				List<Curso> cursos = cursoService.buscarPorNombre("curso");
				for (Curso curso : cursos) {
					System.out.println(curso.getNombre());
				}
				
				//Consultar estudiante
				Estudiante uno = estudianteService.obtenerTodos().get(0);
				Estudiante unoMapeado = estudianteService.obtenerPorId(uno.getId());
				System.out.println("El estudiante 1 es: " + unoMapeado.getNombre() + " " + unoMapeado.getEmail());
				
				
				
				
				//Eliminar el estudiante 1 del curso 1
				cursoService.eliminarEstudiante(cursoConsultado.getId(), unoMapeado.getId());
				
				// Consultar un curso por ID		
				Curso c1 = cursoService.obtenerPorId(curso1.getId());
				System.out.println("Curso consultado: " + c1.getNombre());
				for (Estudiante est : c1.getEstudiantes()) {
					System.out.println(est.getNombre());
				}				
				
				// Eliminar un curso
				cursoService.eliminarCurso(curso2.getId());

				// Verificar eliminación
				System.out.println("Cursos después de eliminación:");
				cursoService.obtenerTodos().forEach(c -> {
					System.out.println("Curso: " + c.getNombre());
				});
				
				
				List<Estudiante> ests = estudianteService.obtenerTodos();
				for (Estudiante estudiante : ests) {
					System.out.println(estudiante.getNombre());
				}
				
				Estudiante actualizado = estudianteService.actualizarEmail(ests.get(0).getId(), "nuevoCorreo@gmail.com");
				System.out.println("Estudiante actu: "  + actualizado.getNombre() + ", " + actualizado.getEmail());
				
				//Estudiantes con maria
				
				List<Estudiante> marias = estudianteService.buscarPorNombre("María");
				System.out.println("Hay " + marias.size() + " marias como estudiantes");
				for (Estudiante estudiante : marias) {
					System.out.println("nombre: " + estudiante.getNombre());
				} 
	}

}
