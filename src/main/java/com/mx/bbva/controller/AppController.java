package com.mx.bbva.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class AppController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String init() {
        // TODO something here
        return "login";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String submit() {
        // TODO something here
        return "indexGefa";
    }
}
