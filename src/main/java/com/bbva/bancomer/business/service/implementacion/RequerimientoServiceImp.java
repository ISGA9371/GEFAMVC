package com.bbva.bancomer.business.service.implementacion;

import com.bbva.bancomer.business.repository.RequerimientoJpaRepository;
import com.bbva.bancomer.business.service.RequerimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("requerimientoServiceImp")
public class RequerimientoServiceImp implements RequerimientoService {

    private RequerimientoJpaRepository requerimientoJpaRepository;

    @Override
    public List<Requerimiento> listaTodosRequerimientos() {
        return (List<Requerimiento>) requerimientoJpaRepository.findAll();
    }

    @Override
    public Requerimiento agregaRequerimiento(Requerimiento requerimiento) {
        return requerimientoJpaRepository.save(requerimiento);
    }

    @Override
    public Requerimiento modificaRequerimiento(Requerimiento requerimiento) {
        return requerimientoJpaRepository.save(requerimiento);
    }

    @Override
    public Requerimiento buscaRequerimiento(Integer id) {
        if (requerimientoJpaRepository.findById(id).isPresent())
            return requerimientoJpaRepository.findById(id).get();
        else
            return null;
    }

    @Autowired
    public void setRequerimientoJpaRepository(RequerimientoJpaRepository requerimientoJpaRepository) {
        this.requerimientoJpaRepository = requerimientoJpaRepository;
    }

}
