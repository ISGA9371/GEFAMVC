package com.bbva.bancomer.controller;


import com.bbva.bancomer.business.model.NivelCmb;
import com.bbva.bancomer.business.model.Requerimiento;
import com.bbva.bancomer.business.model.Tecnologia;
import com.bbva.bancomer.business.repository.TecnologiaRepository;
import com.bbva.bancomer.business.repository.NivelCmbRepository;
import com.bbva.bancomer.business.service.NivelCmbService;
import com.bbva.bancomer.business.service.RequerimientoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/requerimiento")
public class RequerimientoController {

    private static final String REQUERIMIENTO_VISTA = "fabrica/AltaDeRequerimiento";
    private static final String MODIFICA_REQ_VISTA = "fabrica/ModificarRequerimiento";
    private static final String BUSCAR_REQ_VISTA = "fabrica/BusquedaDeRequerimientos";

    private RequerimientoService requerimientoService;
    private TecnologiaRepository tecnologiaRepository;

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
    public String verRequerimiento(Model model, @PathVariable Integer id) {

        log.info("ID " + id);

        Requerimiento requerimiento = requerimientoService.buscaRequerimiento(id);

        model.addAttribute("req", requerimiento);

        return MODIFICA_REQ_VISTA;
    }

    @GetMapping("/buscar")
    public String buscar(Model model) {

        Iterable<Tecnologia> coso= tecnologiaRepository.findAll();
        for(Tecnologia t : coso){
            log.info("TEC "+t.getNombre());
        }

        List<Tecnologia> todas = (List<Tecnologia>) tecnologiaRepository.findAll();
        model.addAttribute("tecnologias",coso);

        return BUSCAR_REQ_VISTA;
    }

    @Autowired
    public void setRequerimientoService(RequerimientoService requerimientoService) {
        this.requerimientoService = requerimientoService;
    }
    @Autowired
    public void setTecnologiaRepository(TecnologiaRepository tecnologiaRepository){
        this.tecnologiaRepository = tecnologiaRepository;
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
