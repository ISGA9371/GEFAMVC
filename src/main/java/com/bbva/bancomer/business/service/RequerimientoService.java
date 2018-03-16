package com.bbva.bancomer.business.service;

import java.util.List;

public interface RequerimientoService {

    public abstract List<Requerimiento> listaTodosRequerimientos();

    public abstract Requerimiento agregaRequerimiento(Requerimiento requerimiento);

    public abstract Requerimiento modificaRequerimiento(Requerimiento requerimiento);

    Requerimiento buscaRequerimiento(Integer id);
}
