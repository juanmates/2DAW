package com.ej10.service;

import java.util.List;

import com.ej10.model.Empleado;

public interface EmpleadoService {
    Empleado crear(Empleado e);
    List<Empleado> listar();
    Empleado buscarPorId(Integer id);
    Empleado actualizar(Empleado e);
    void eliminar(Integer id);
    List<Empleado> buscarPorPuesto(String puesto);
}
