package com.bbva.bancomer.business.service.implementacion;

import com.bbva.bancomer.business.model.Requerimiento;
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
    public List<Requerimiento> listaTodosRequerimientos() {
        return requerimientoJpaRepository.findAll();
    }

    @Override
    public Requerimiento agregaRequerimiento(Requerimiento requerimiento) {
        return requerimientoJpaRepository.save(requerimiento);
    }

    @Override
    public Requerimiento modificaRequerimiento(Requerimiento requerimiento) {
        return requerimientoJpaRepository.save(requerimiento);
    }


}
