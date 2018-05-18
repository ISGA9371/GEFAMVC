package com.mx.bbva.controller;

import com.mx.bbva.business.entity.User;
import com.mx.bbva.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

import static com.mx.bbva.util.ViewsURLs.REDIRECT;

@Controller
@RequestMapping(value = "/")
public class AppController {

    private UserService userService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String init(Model model) {
        /*
        TODO something here... here we will receive a google token, get the email maybe and check if exist in our
        database... generate a log and create a token maybe... save the user in the session
         */
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model model, Principal principal) {
        if (principal == null) {
            return REDIRECT + "login";
        }
        // Implement your business logic
        return "indexGefa";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        // Implement your business logic
        return "logout";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String error403() {
        // Implement your business logic
        return "error403";
    }

    /*
     * Add user in model attribute
     */
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
