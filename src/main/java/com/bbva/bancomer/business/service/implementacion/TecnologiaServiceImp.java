package com.bbva.bancomer.business.service.implementacion;


import com.bbva.bancomer.business.converter.TecnologiaConverter;
import com.bbva.bancomer.business.model.Tecnologia;
import com.bbva.bancomer.business.model.TecnologiaModel;

import com.bbva.bancomer.business.repository.TecnologiaRepository;
import com.bbva.bancomer.business.service.TecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("tecnologiaServiceImp")
public class TecnologiaServiceImp implements TecnologiaService{

    @Autowired
    @Qualifier("tecnologiaRepository")
    private TecnologiaRepository tecnologiaRepository;

    @Autowired
    @Qualifier("tecnologiaConverter")
    private TecnologiaConverter tecnologiaConverter;


    @Override
    public List<TecnologiaModel> listaTecnologias() {
        List<Tecnologia> niveles = tecnologiaRepository.findAll();

        List<TecnologiaModel> nivelesModel = new ArrayList<TecnologiaModel>();

        for(Tecnologia tecnologia : niveles){

            nivelesModel.add(tecnologiaConverter.tecnologiaModel2tecnologia(tecnologia));

        }

        return nivelesModel;
    }
}
