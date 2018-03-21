package com.bbva.bancomer.business.service.implementacion;

import com.bbva.bancomer.business.converter.AreaConverter;
import com.bbva.bancomer.business.model.Area;
import com.bbva.bancomer.business.model.AreaModel;
import com.bbva.bancomer.business.repository.AreaRepository;
import com.bbva.bancomer.business.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("areaServiceImp")
public class AreaServiceImp implements AreaService{

    @Autowired
    @Qualifier("areaRepository")
    private AreaRepository areaRepository;

    @Autowired
    @Qualifier("areaConverter")
    private AreaConverter areaConverter;

    @Override
    public List<AreaModel> listaAreas() {
        List<Area> niveles = areaRepository.findAll();
        List<AreaModel> nivelesModel = new ArrayList<AreaModel>();

        for(Area area : niveles){

            nivelesModel.add(areaConverter.area2areaModel(area));

        }

        return nivelesModel;
    }
}
