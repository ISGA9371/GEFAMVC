
package com.bbva.bancomer.business.converter;

import com.bbva.bancomer.business.model.Tecnologia;
import com.bbva.bancomer.business.model.TecnologiaModel;
import org.springframework.stereotype.Component;

@Component("tecnologiaConverter")
public class TecnologiaConverter {



    public Tecnologia tecnologia2tecnologiaModel(TecnologiaModel tecnologiaModel){

        Tecnologia tecno=new Tecnologia();
        tecno.setId(tecnologiaModel.getId());
        tecno.setNombre(tecnologiaModel.getNombre());

        return tecno;
    }

    public TecnologiaModel tecnologiaModel2tecnologia(Tecnologia tecnologia){

        TecnologiaModel tecMod= new TecnologiaModel();
        tecMod.setId(tecnologia.getId());
        tecMod.setNombre(tecnologia.getNombre());

        return tecMod;
    }
}
