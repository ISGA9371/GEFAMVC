package com.mx.bbva.controller;

import com.mx.bbva.business.entity.*;
import com.mx.bbva.business.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

import static com.mx.bbva.util.ViewsURLs.*;

@Controller
@RequestMapping(value = "/dispersion")
public class DispersionController {
    private static final Logger LOG = Logger.getLogger(DispersionController.class.getName());



    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createIssue(Model model, @RequestParam(value = "componentId") Integer componentId) {
        // TODO Validate user
        //TODO Add catalogs
        return URL_BUDGET + NEW_DISPERSION;
    }



}
