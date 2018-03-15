package com.bbva.bancomer.business.service;

import com.bbva.bancomer.business.model._Requerimiento;

import java.util.List;

public interface RequerimientoService {

    public abstract List<_Requerimiento> listaTodosRequerimientos();

    public abstract _Requerimiento agregaRequerimiento(_Requerimiento requerimiento);

    public abstract _Requerimiento modificaRequerimiento(_Requerimiento requerimiento);
}
