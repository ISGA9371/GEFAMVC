package com.mx.bbva.controller;

import com.mx.bbva.business.entity.CatalogControl;
import com.mx.bbva.business.service.CatalogControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

import static com.mx.bbva.util.ViewsURLs.ADMIN_CATALOGS;
import static com.mx.bbva.util.ViewsURLs.URL_ADMIN;

@Controller
@RequestMapping(value = "/catalogs")
public class CatalogControlController {
    private static final Logger LOG = Logger.getLogger(CatalogControlController.class.getName());

    private CatalogControlService controlService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String createCatalog(Model model) {
        // TODO Validate catalog
        LOG.info("Creating new catalog");
        model.addAttribute("catalog", new CatalogControl());
        //TODO Add catalogs
        return URL_ADMIN + ADMIN_CATALOGS;
    }

    @Autowired
    public void setControlService(CatalogControlService controlService) {
        this.controlService = controlService;
    }
}
