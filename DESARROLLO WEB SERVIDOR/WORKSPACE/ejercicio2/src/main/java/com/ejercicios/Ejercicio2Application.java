package com.ejercicios;

import java.util.ArrayList;
import java.util.List;
import com.ejercicios.servicio.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ejercicios.modelo.Producto;
import com.ejercicios.repository.ProductoRepository;
import com.ejercicios.servicio.ProductoService;

@SpringBootApplication
public class Ejercicio2Application  implements CommandLineRunner{

    private final ProductoServiceImpl productoServiceImpl;

    private final ProductoRepository croductoRepository;
	
	@Autowired
	ProductoService servicio;

    Ejercicio2Application(ProductoRepository croductoRepository, ProductoServiceImpl productoServiceImpl) {
        this.croductoRepository = croductoRepository;
        this.productoServiceImpl = productoServiceImpl;
    }

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("===== Creando lista de productos =====");
		List<Producto> lista = new ArrayList<>();
		
		Producto p1 = new Producto("Libro", 12.99f);
		Producto p2 = new Producto("Bolígrafo", 1.33f);
		Producto p3 = new Producto("Licor", 1.10f);
		Producto p4 = new Producto("Palito", 0.3f);
		Producto p5 = new Producto("Pelota", 4.99f);
		Producto p6 = new Producto("Mesa", 21.50f);
		
		lista.add(p6);
		lista.add(p5);
		lista.add(p4);
		lista.add(p3);
		lista.add(p2);
		lista.add(p1);
		
		System.out.println("Ya esta preparada la lista");
		
		System.out.println("GUARDAMOS LA LISTA EN LA BASE DE DATOS");
		servicio.insertarProductos(lista);
		System.out.println("PRODUCTOS  INSERTADOS\n");
		
		System.out.println("\n PRODUCTOS QUE EMPIECEN POR 'L' Y SU PRECIO SEA INFERIOR A 5€");
		for(Producto p : servicio.getProductoNombreyPrecioInferior("L", 5f)) {
			System.out.println(p);
		}
		
		System.out.println("\n PRODUCTOS QUE CONTIENEN EN EL NOMBRE 'li'");
		for(Producto p : servicio.getProductoContieneNombre("li")) {
			System.out.println(p);
		}
		
		System.out.println("\n PRODUCTOS CUYO PRECIO ESTA ENTRE 1 Y 3,5 EUROS");
		for(Producto p : servicio.getProductoRangoPrecio(1f, 3.5f)) {
			System.out.println(p);
		}
		
		System.out.println("\n INSERTAR UNA LISTA DE 3 PRODUCTOS DONDE DOS NO ESTEN Y UNO SI");
		List<Producto> listaInsertar = new ArrayList<>();
		
		Producto p7 = new Producto("Librito", 13f);
		Producto p8 = new Producto("Bolígrafo", 1.33f);
		Producto p9 = new Producto("Maleta", 1.33f);
		p7.setId(0);
		
		listaInsertar.add(p9);
		listaInsertar.add(p8);
		listaInsertar.add(p7);
		
		System.out.println("GUARDAMOS LA SEGUNDA LISTA EN LA BASE DE DATOS");
		servicio.insertarProductos(lista);
		System.out.println("PRODUCTOS  INSERTADOS\n");
		
		System.out.println("\n PRODUCTOS CUYO PRECIO ESTA ENTRE 0 Y 100 EUROS");
		for(Producto p : servicio.getProductoRangoPrecio(0f, 100f)) {
			System.out.println(p);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
