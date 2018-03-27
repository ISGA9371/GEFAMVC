package com.mx.bbva.controller;

import com.mx.bbva.business.entity.Doubt;
import com.mx.bbva.business.service.DoubtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

import static com.mx.bbva.util.ViewsURLs.*;

@Controller
@RequestMapping("/incidence")
public class IncidenceController {

        private static final Logger LOG = Logger.getLogger(IncidenceController.class.getName());

       // private DoubtService doubtService;

        @RequestMapping(value = "/add", method = RequestMethod.GET)
        public String addDoubt(Model model) {
       // model.addAttribute("doubt", new Doubt());
        return NEW_INCIDENCE;
    }

        @RequestMapping(value = "", method = RequestMethod.POST)
        public String saveDoubt(@ModelAttribute("doubt") Doubt doubt) {
        //doubtService.saveDoubt(doubt);
        return EDIT_DOUBT;

    }

        @RequestMapping(value = "/{doubtId}", method = RequestMethod.GET)
        public String getOneDoubt(Model model, @PathVariable Integer doubtId) {
        //Doubt doubt = doubtService.findDoubt(doubtId);
        //model.addAttribute("doubt", doubt);
        return SEARCH_INCIDENCE;
    }

        //@Autowired
        //public void setDoubtService(DoubtService doubtService) {
        //this.doubtService = doubtService;
    //}
}
