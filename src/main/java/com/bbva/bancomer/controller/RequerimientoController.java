package com.bbva.bancomer.controller;


import com.bbva.bancomer.business.model.NivelCmb;
import com.bbva.bancomer.business.model.QNivelCmb;
import com.bbva.bancomer.business.model.Requerimiento;
import com.bbva.bancomer.business.repository.NivelCmbRepository;
import com.bbva.bancomer.business.service.NivelCmbService;
import com.bbva.bancomer.business.service.RequerimientoService;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import java.util.logging.Logger;

@Controller
@RequestMapping("/requerimiento")
public class RequerimientoController {

    private static final String REQUERIMIENTO_VISTA = "fabrica/AltaDeRequerimiento";
    private static final String MODIFICA_REQ_VISTA = "fabrica/ModificarRequerimiento";

    private RequerimientoService requerimientoService;

    private static final Logger log = Logger.getLogger(RequerimientoController.class.getName());


    @Autowired
    @Qualifier("nivelServiceImp")
    private NivelCmbService nivelServiceImp;


    @GetMapping("/inicialRequerimiento")
    public ModelAndView entraRequerimiento() {

        ModelAndView modelReq = new ModelAndView(REQUERIMIENTO_VISTA);
        modelReq.addObject("niveles", nivelServiceImp.listaNiveles());
        modelReq.addObject("requerimiento", new Requerimiento());

        return modelReq;
    }

    @PostMapping("/guardaReq")
    public String guardaRequerimiento(@ModelAttribute("requerimiento") Requerimiento requerimiento) {
        requerimientoService.agregaRequerimiento(requerimiento);
        System.out.print("LLega");
        return "redirect:/requerimiento/ModificaRequerimiento";

    }

    @GetMapping("/{id}")
    public String buscaRequerimiento(Model model, @PathVariable Integer id) {

        log.info("ID " + id);

        Requerimiento requerimiento = requerimientoService.buscaRequerimiento(id);

        model.addAttribute("req", requerimiento);

        return MODIFICA_REQ_VISTA;
    }

    @Autowired
    public void setRequerimientoService(RequerimientoService requerimientoService) {
        this.requerimientoService = requerimientoService;
    }


//    @PersistenceContext
//    private EntityManager EM;
//
//    private QNivelCmb nivelCombo= QNivelCmb.nivelCmb;
//
//    public List<NivelCmb> buscaNiveles(){
//
//        JPAQuery<NivelCmb> niveles=new JPAQuery<NivelCmb>(EM);
//
//        List<NivelCmb> consulta = niveles.select(nivelCombo).from(nivelCombo).where(nivelCombo.cd_tipo_nivel.eq(1)).fetch();
//
//        return consulta;
//    }

}
