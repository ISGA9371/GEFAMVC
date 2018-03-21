package com.bbva.bancomer.business.converter;


import com.bbva.bancomer.business.model.Area;
import com.bbva.bancomer.business.model.AreaModel;

import org.springframework.stereotype.Component;

@Component("areaConverter")
public class AreaConverter {

    public Area areaModel2area(AreaModel areaModel){
        Area area=new Area();
        area.setCd_area(areaModel.getCd_area());
        area.setNb_area(areaModel.getNb_area());

        return area;
    }

    public AreaModel area2areaModel(Area area){
        AreaModel areaModel=new AreaModel();
        areaModel.setCd_area(area.getCd_area());
        areaModel.setNb_area(area.getNb_area());

        return areaModel;
    }
}
