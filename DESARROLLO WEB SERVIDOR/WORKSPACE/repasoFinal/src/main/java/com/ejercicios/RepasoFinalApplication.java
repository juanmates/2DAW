package com.ejercicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ejercicios.modelo.Ingrediente;
import com.ejercicios.modelo.Muestrario;
import com.ejercicios.modelo.Receta;
import com.ejercicios.service.IngredienteService;
import com.ejercicios.service.MuestrarioService;
import com.ejercicios.service.RecetaService;

@SpringBootApplication
public class RepasoFinalApplication implements CommandLineRunner {

	@Autowired
	IngredienteService ingredienteService;
	
	@Autowired
	RecetaService recetaService;
	
	@Autowired
	MuestrarioService muestrarioService;

	public static void main(String[] args) {
		SpringApplication.run(RepasoFinalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("========== CARGANDO DATOS DE PRUEBA ==========");

        // 1. Crear ingredientes
        Ingrediente harina = ingredienteService.save(new Ingrediente( "Harina", 350));
        Ingrediente azucar = ingredienteService.save(new Ingrediente( "Azúcar", 400));
        Ingrediente huevo = ingredienteService.save(new Ingrediente( "Huevo", 150));
        Ingrediente chocolate = ingredienteService.save(new Ingrediente( "Chocolate", 500));

        // 2. Crear recetas
        Receta brownie = recetaService.save(new Receta( "Brownie", 9));
        Receta bizcocho = recetaService.save(new Receta( "Bizcocho", 8));
        Receta tarta = recetaService.save(new Receta("Tarta", 10));

        // 3. Crear muestrarios
        Muestrario tradicionales = muestrarioService.save(new Muestrario( "Postres tradicionales"));
        Muestrario modernos = muestrarioService.save(new Muestrario( "Postres modernos"));

        // 4. Asignar ingredientes a recetas
        recetaService.addIngrediente(brownie.getId(), harina.getId());
        recetaService.addIngrediente(brownie.getId(), azucar.getId());
        recetaService.addIngrediente(brownie.getId(), chocolate.getId());

        recetaService.addIngrediente(bizcocho.getId(), harina.getId());
        recetaService.addIngrediente(bizcocho.getId(), huevo.getId());

        recetaService.addIngrediente(tarta.getId(), harina.getId());
        recetaService.addIngrediente(tarta.getId(), azucar.getId());
        recetaService.addIngrediente(tarta.getId(), huevo.getId());

        // 5. Asignar recetas a muestrarios
        muestrarioService.addReceta(tradicionales.getId(), brownie.getId());
        muestrarioService.addReceta(tradicionales.getId(), bizcocho.getId());
        muestrarioService.addReceta(modernos.getId(), tarta.getId());

        muestrarioService.mostrarRecetasEIngredientes(tradicionales.getId());
        
        // 6. Probar métodos especiales
        System.out.println("\nIngredientes con más de 300 calorías:");
        ingredienteService.findByCaloriasGreaterThan(300)
                .forEach(i -> System.out.println("- " + i.getNombre() + ": " + i.getCalorias()));

        System.out.println("\nReceta con mayor puntuación:");
        recetaService.findTopByOrderByPuntuacionDesc()
                .ifPresent(r -> System.out.println("-> " + r.getNombre() + " (" + r.getPuntuacion() + ")"));

        System.out.println("\nPrimera receta alfabética del muestrario 'Postres tradicionales':");
        muestrarioService.findFirstRecetaAlphabetically(tradicionales.getId())
                .ifPresent(r -> System.out.println("-> " + r.getNombre()));

       
	}

}
