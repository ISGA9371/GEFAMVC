package com.bbva.bancomer.controller;


import com.bbva.bancomer.business.model._Requerimiento;
import com.bbva.bancomer.business.service.RequerimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/requerimiento")
public class RequerimientoController {

    private static final String REQUERIMIENTO_VISTA = "fabrica/AltaDeRequerimiento";
    private static final String MODIFICA_REQ_VISTA = "fabrica/ModificarRequerimiento";


    @Autowired
    @Qualifier("requerimientoServiceImp")
    private RequerimientoService requerimientoService;


    @GetMapping("/inicialRequerimiento")
    public ModelAndView entraRequerimiento(){

        ModelAndView modelReq = new ModelAndView(REQUERIMIENTO_VISTA);
        modelReq.addObject("requerimiento", new _Requerimiento());

        return modelReq;
    }

    @PostMapping("/guardaReq")
    public String guardaRequerimiento(@ModelAttribute("requerimiento") _Requerimiento requerimiento){
        requerimientoService.agregaRequerimiento(requerimiento);
        System.out.print("LLega");
        return "redirect:/requerimiento/ModificaRequerimiento";

    }

    @GetMapping("/ModificaRequerimiento")
    public ModelAndView buscaRequerimiento(){

        ModelAndView modelReq = new ModelAndView(MODIFICA_REQ_VISTA);

        return modelReq;
    }

}
