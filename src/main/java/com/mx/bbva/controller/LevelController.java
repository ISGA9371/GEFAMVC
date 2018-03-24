package com.mx.bbva.controller;

import com.mx.bbva.business.model.Level;
import com.mx.bbva.business.model.LevelType;
import com.mx.bbva.business.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/levels")
public class LevelController {

    private static final Logger LOG = Logger.getLogger(LevelController.class.getName());

    private LevelRepository levelRepository;

    @RequestMapping(value = "/{levelTypeId}", method = RequestMethod.GET)
    public String findByLevelType(Model model, @PathVariable Integer levelTypeId) {
        // TODO Validate IN values
        List<Level> levels = levelRepository.findAllByLevelType(new LevelType(levelTypeId));
        model.addAttribute("levels", levels);
        return "someURL";
    }

    @Autowired
    public void setLevelRepository(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

}
