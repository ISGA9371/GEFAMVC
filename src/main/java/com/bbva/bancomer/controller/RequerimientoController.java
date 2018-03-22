package com.bbva.bancomer.controller;


import com.bbva.bancomer.business.model.*;
import com.bbva.bancomer.business.repository.LevelRepository;
import com.bbva.bancomer.business.repository.LevelTypeRepository;
import com.bbva.bancomer.business.repository.TechnologyRepository;
import com.bbva.bancomer.business.repository.NivelCmbRepository;
import com.bbva.bancomer.business.service.AreaService;
import com.bbva.bancomer.business.service.NivelCmbService;
import com.bbva.bancomer.business.service.RequerimientoService;

import com.bbva.bancomer.business.service.TechnologyService;
import com.bbva.bancomer.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/requerimiento")
public class RequerimientoController {

    private static final String REQUERIMIENTO_VISTA = "fabrica/AltaDeRequerimiento";
    private static final String MODIFICA_REQ_VISTA = "fabrica/ModificarRequerimiento";
    private static final String BUSCAR_REQ_VISTA = "fabrica/BusquedaDeRequerimientos";

    private RequerimientoService requerimientoService;

    private TechnologyRepository tecnologiaRepository;
    private LevelRepository levelRepository;
    private LevelTypeRepository levelTypeRepository;

    private static final Logger log = Logger.getLogger(RequerimientoController.class.getName());


    @Autowired
    @Qualifier("nivelServiceImp")
    private NivelCmbService nivelServiceImp;

    @Autowired
    @Qualifier("areaServiceImp")
    private AreaService areaServiceImp;

    @Autowired
    @Qualifier("tecnologiaServiceImp")
    private TechnologyService tecnologiaServiceImp;


    @GetMapping("/inicialRequerimiento")
    public ModelAndView entraRequerimiento() {

        ModelAndView modelReq = new ModelAndView(REQUERIMIENTO_VISTA);
        modelReq.addObject("nivelesCmb", nivelServiceImp.listaNiveles());
        modelReq.addObject("areasCmb", areaServiceImp.listaAreas());
        modelReq.addObject("tecnologiasCmb", tecnologiaServiceImp.listaTecnologias());
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

        Iterable<Technology> coso= tecnologiaRepository.findAll();

        List<Technology> todas = (List<Technology>) tecnologiaRepository.findAll();

        LevelType direccionType = levelTypeRepository.findByNombre(Constants.TIPO_NIVEL_DIRECCION);

        List<Level> direcciones = levelRepository.findAllByType(direccionType);

        for(Level l : direcciones){
            log.info("TEC "+l.getNb_nivel());
        }

        model.addAttribute("tecnologias",coso);
        model.addAttribute("direcciones",direcciones);

        return BUSCAR_REQ_VISTA;
    }

    @Autowired
    public void setRequerimientoService(RequerimientoService requerimientoService) {
        this.requerimientoService = requerimientoService;
    }
    @Autowired
    public void setTecnologiaRepository(TechnologyRepository tecnologiaRepository){
        this.tecnologiaRepository = tecnologiaRepository;
    }
    @Autowired
    public void setLevelRepository(LevelRepository levelRepository){
        this.levelRepository = levelRepository;
    }
    @Autowired
    public void setLevelTypeRepository(LevelTypeRepository levelTypeRepository){
        this.levelTypeRepository = levelTypeRepository;
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
