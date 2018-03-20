package com.bbva.bancomer.business.service;

import com.bbva.bancomer.business.model.Requerimiento;

import java.util.List;

public interface RequerimientoService {

    public abstract List<Requerimiento> listaTodosRequerimientos();

    public abstract Requerimiento agregaRequerimiento(Requerimiento requerimiento);

    Requerimiento modificaRequerimiento(Requerimiento requerimiento);

    Requerimiento buscaRequerimiento(Integer id);
}
