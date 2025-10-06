package com.ejercicios.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.modelo.Producto;
import com.ejercicios.repository.ProductoRepository;

import jakarta.transaction.Transactional;

@Transactional

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository repositorio;

	@Override
	public List<Producto> getProductoNombreyPrecioInferior(String nombre, Float precio) {
		// TODO Auto-generated method stub
		return repositorio.findByNombreStartingWithAndPrecioLessThanEqual(nombre, precio);
	}

	@Override
	public List<Producto> getProductoContieneNombre(String nombre) {
		// TODO Auto-generated method stub
		return repositorio.findByNombreContainingIgnoreCase(nombre);
	}

	@Override
	public List<Producto> getProductoRangoPrecio(Float p1, Float p2) {
		// TODO Auto-generated method stub
		return repositorio.findByPrecioBetween(p1, p2);
	}

	@Override
	public void insertarProductos(List<Producto> lista) {
		// TODO Auto-generated method stub
		for(Producto p:lista) {
			repositorio.save(p);
		}
	}
	
	
	
	

}
