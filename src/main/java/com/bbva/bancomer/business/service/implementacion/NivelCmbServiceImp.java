package com.bbva.bancomer.business.service.implementacion;

import com.bbva.bancomer.business.converter.NivelCmbConverter;
import com.bbva.bancomer.business.model.NivelCmb;
import com.bbva.bancomer.business.model.NivelCmbModel;
import com.bbva.bancomer.business.repository.NivelCmbRepository;
import com.bbva.bancomer.business.service.NivelCmbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("nivelServiceImp")
public class NivelCmbServiceImp implements NivelCmbService {

    @Autowired
    @Qualifier("nivelCmbRepository")
    private NivelCmbRepository nivelCmbRepository;

    @Autowired
    @Qualifier("nivelCmbConverter")
    private NivelCmbConverter nivelCmbConverter;

    @Override
    public List<NivelCmbModel> listaNiveles() {

        List<NivelCmb> niveles = nivelCmbRepository.findAll();
        List<NivelCmbModel> nivelesModel = new ArrayList<NivelCmbModel>();

        for(NivelCmb nivelCmb : niveles){

            nivelesModel.add(nivelCmbConverter.nivel2nivelCmbModel(nivelCmb));

        }

        return nivelesModel;
    }
}
