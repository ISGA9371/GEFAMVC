package com.bbva.bancomer.controller;

import com.bbva.bancomer.business.model.Level;
import com.bbva.bancomer.business.repository.LevelRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/nivel")
public class LevelController {

    private static final Logger log = Logger.getLogger(LevelController.class.getName());

    private LevelRepository levelRepository;
    private Gson gson = new Gson();

    @GetMapping(value = "/{dirId}/subdir")
    @ResponseBody
    @Transactional
    public String buscaSubdirPorDir(@PathVariable Integer dirId) {
        Optional<Level> dir = levelRepository.findById(dirId);

        log.info("DIRNAME "+dir.get().getLevelName());

        List<Level> subdirs = levelRepository.findAllByLevelSuperior(dir.get());

        return gson.toJson(subdirs);
    }

    @Autowired
    public void setLevelRepository(LevelRepository levelRepository){
        this.levelRepository = levelRepository;
    }

}
