package com.bbva.bancomer.business.service.implementacion;

import com.bbva.bancomer.business.model._Requerimiento;
import com.bbva.bancomer.business.repository.RequerimientoJpaRepository;
import com.bbva.bancomer.business.service.RequerimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("requerimientoServiceImp")
public class RequerimientoServiceImp implements RequerimientoService {

    @Autowired
    @Qualifier("requerimientoJpaRepository")
    private RequerimientoJpaRepository requerimientoJpaRepository;

    @Override
    public List<_Requerimiento> listaTodosRequerimientos() {
        return requerimientoJpaRepository.findAll();
    }

    @Override
    public _Requerimiento agregaRequerimiento(_Requerimiento requerimiento) {
        return requerimientoJpaRepository.save(requerimiento);
    }

    @Override
    public _Requerimiento modificaRequerimiento(_Requerimiento requerimiento) {
        return requerimientoJpaRepository.save(requerimiento);
    }


}
