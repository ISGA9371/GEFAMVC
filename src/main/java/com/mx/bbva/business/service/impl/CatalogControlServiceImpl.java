package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.CatalogControl;
import com.mx.bbva.business.repository.CatalogControlRepository;
import com.mx.bbva.business.service.CatalogControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogControlServiceImpl implements CatalogControlService {
    private CatalogControlRepository catalogControlRepository;

    @Override
    public List<CatalogControl> findAllCatalogControls() {
        return catalogControlRepository.findAll();
    }

    @Autowired
    public void setCatalogControlRepository(CatalogControlRepository catalogControlRepository) {
        this.catalogControlRepository = catalogControlRepository;
    }
}
