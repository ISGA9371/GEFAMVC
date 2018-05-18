package com.mx.bbva.controller;

import com.mx.bbva.business.dto.ResponseDTO;
import com.mx.bbva.business.entity.User;
import com.mx.bbva.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.logging.Logger;

import static com.mx.bbva.util.ViewsURLs.*;

@Controller
@RequestMapping(value = "/users")
public class UserAdminController {
    private static final Logger LOG = Logger.getLogger(UserAdminController.class.getName());

    private UserService userService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResponseEntity<?> userInfo(Principal principal) {

        User user = userService.findUser(principal.getName());

        return new ResponseEntity<Object>(new ResponseDTO(user), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String createUser(Model model) {
        // TODO Validate user
        LOG.info("Creating new user");
        model.addAttribute("user", new User());
        //TODO Add catalogs
        return URL_ADMIN + ADMIN_USERS;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        // TODO Validate user
        userService.saveUser(user);

        return REDIRECT + "users/" + user.getUserInternalId();
    }

    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    public String editUser(Model model, @PathVariable(value = "userId") String userId) {
        // TODO Validate user
        LOG.info("Updating user, ID: " + userId);
        if (null != userId) {
            User user = userService.findUser(userId);
            model.addAttribute("user", user);
        } else {
            model.addAttribute("user", new User());
        }
        return URL_ADMIN + ADMIN_USERS;
    }

    @RequestMapping(path = "/{userId}", method = RequestMethod.DELETE)
    public String deleteUser(Model model, @PathVariable(value = "userId") String userId) {
        // TODO Validate user

        userService.deleteUser(userId);
        return URL_ADMIN + ADMIN_USERS;
    }

    @RequestMapping(value = "/filters", method = RequestMethod.GET)
    public String filtersForUsers(Model model) {

        return URL_ADMIN + ADMIN_USERS;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchForUsers(Model model) {
        // TODO Work in progress
        model.addAttribute("users", this.userService.findAllUsers());
        return URL_ADMIN + ADMIN_USERS;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
