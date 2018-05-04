package com.mx.bbva.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/catalogs")
public class CatalogsController {
    private static final Logger LOG = Logger.getLogger(CatalogsController.class.getName());

}
