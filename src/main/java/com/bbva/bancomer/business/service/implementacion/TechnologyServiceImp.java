package com.bbva.bancomer.business.service.implementacion;


import com.bbva.bancomer.business.converter.TechnologyConverter;
import com.bbva.bancomer.business.model.Technology;
import com.bbva.bancomer.business.model.TechnologyModel;

import com.bbva.bancomer.business.repository.TechnologyRepository;
import com.bbva.bancomer.business.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("tecnologiaServiceImp")
public class TechnologyServiceImp implements TechnologyService{

    @Autowired
    @Qualifier("tecnologiaRepository")
    private TechnologyRepository tecnologiaRepository;

    @Autowired
    @Qualifier("tecnologiaConverter")
    private TechnologyConverter tecnologiaConverter;


    @Override
    public List<TechnologyModel> listaTecnologias() {
        List<Technology> niveles = (List<Technology>) tecnologiaRepository.findAll();

        List<TechnologyModel> nivelesModel = new ArrayList<TechnologyModel>();

        for(Technology tecnologia : niveles){

            nivelesModel.add(tecnologiaConverter.tecnologiaModel2tecnologia(tecnologia));

        }

        return nivelesModel;
    }
}
