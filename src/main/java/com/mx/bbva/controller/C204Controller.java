package com.mx.bbva.controller;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.*;
import com.mx.bbva.business.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.mx.bbva.util.UploadItem;
import com.mx.bbva.util.Util;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import org.apache.commons.fileupload.FileUploadException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.mx.bbva.util.ViewsURLs.*;

@Controller
@RequestMapping("/c204")
public class C204Controller {
    private static final Logger LOG = Logger.getLogger(DoubtController.class.getName());

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addDoubt(Model model) {
        //UploadItem uploadItem = new UploadItem();
        //LOG.info("llega al metodo con " + uploadItem);
        //model.addAttribute("uploadItem", uploadItem);
        return URL_FACTORY + UPLOAD_FILE;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String saveDoubt(UploadItem uploadItem) {
        LOG.info("llego al metodo");
        try {
            String nomArchivo = uploadItem.getFileData().getOriginalFilename();

            LOG.info("aqui esta el nombre del archivo " + nomArchivo);

            Util subeArchivo = new Util();
            String ecualizacion = subeArchivo.codificaArchivo(uploadItem);
            //Clob clob = new SerialClob(ecualizacion.toCharArray());

            // movimiento.setTxEcualizacion(ecualizacion);

            // movimiento.setNbEcualizacion(nomArchivo);

            LOG.info("aqui esta el bit del archivo " + ecualizacion);
        }catch(Exception e){
            System.out.println(e);
        }

        return URL_FACTORY + UPLOAD_FILE;
    }
}
