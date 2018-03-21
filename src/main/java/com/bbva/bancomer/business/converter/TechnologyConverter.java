
package com.bbva.bancomer.business.converter;

import com.bbva.bancomer.business.model.Technology;
import com.bbva.bancomer.business.model.TechnologyModel;
import org.springframework.stereotype.Component;

@Component("tecnologiaConverter")
public class TechnologyConverter {



    public Technology tecnologia2tecnologiaModel(TechnologyModel tecnologiaModel){

        Technology tecno=new Technology();
        tecno.setId(tecnologiaModel.getId());
        tecno.setNombre(tecnologiaModel.getNombre());

        return tecno;
    }

    public TechnologyModel tecnologiaModel2tecnologia(Technology tecnologia){

        TechnologyModel tecMod= new TechnologyModel();
        tecMod.setId(tecnologia.getId());
        tecMod.setNombre(tecnologia.getNombre());

        return tecMod;
    }
}
