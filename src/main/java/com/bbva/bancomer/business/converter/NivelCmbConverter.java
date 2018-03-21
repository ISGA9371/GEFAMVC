package com.bbva.bancomer.business.converter;

import com.bbva.bancomer.business.model.NivelCmb;
import com.bbva.bancomer.business.model.NivelCmbModel;
import org.springframework.stereotype.Component;

@Component("nivelCmbConverter")
public class NivelCmbConverter {

    public NivelCmb nivelModel2nivel(NivelCmbModel nivelCmbModel){
        NivelCmb nivel=new NivelCmb();
        nivel.setCd_nivel(nivelCmbModel.getCd_nivel());
        nivel.setCd_nivel_superior(nivelCmbModel.getCd_nivel_superior());
        nivel.setCd_requerimiento(nivelCmbModel.getCd_requerimiento());
        nivel.setCd_tipo_nivel(nivelCmbModel.getCd_tipo_nivel());
        nivel.setCd_usuario_resp(nivelCmbModel.getCd_usuario_resp());
        nivel.setNb_nivel(nivelCmbModel.getNb_nivel());

        return nivel;
    }

    public NivelCmbModel nivel2nivelCmbModel(NivelCmb nivelCmb){
        NivelCmbModel nivel=new NivelCmbModel();
        nivel.setCd_nivel(nivelCmb.getCd_nivel());
        nivel.setCd_nivel_superior(nivelCmb.getCd_nivel_superior());
        nivel.setCd_requerimiento(nivelCmb.getCd_requerimiento());
        nivel.setCd_tipo_nivel(nivelCmb.getCd_tipo_nivel());
        nivel.setCd_usuario_resp(nivelCmb.getCd_usuario_resp());
        nivel.setNb_nivel(nivelCmb.getNb_nivel());

        return nivel;
    }

}
