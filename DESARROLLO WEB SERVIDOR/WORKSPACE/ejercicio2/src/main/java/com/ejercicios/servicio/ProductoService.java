package com.ejercicios.servicio;

import java.util.List;

import com.ejercicios.modelo.Producto;

public interface ProductoService {
	
	List<Producto> getProductoNombreyPrecioInferior(String nombre, Float precio);
	
	List<Producto> getProductoContieneNombre(String nombre);
	
	List<Producto> getProductoRangoPrecio(Float p1, Float p2);
	
	void insertarProductos (List<Producto> lista); // Los nuevos han de insertarse y los existentes 
	// 												  se tienen que actualizar

}
