package com.mx.bbva.controller;

import com.mx.bbva.business.entity.ProfileType;
import com.mx.bbva.business.entity.User;
import com.mx.bbva.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/")
@SessionAttributes("user")
public class AppController {

    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String init(Model model, @ModelAttribute("user") User user) {
        /*
        TODO something here... here we will receive a google token, get the email maybe and check if exist in our
        database... generate a log and create a token maybe... save the user in the session
         */
        user.setUserInternalId("XMY3453");
        user.setProfileType(new ProfileType(4));
        return "indexGefa";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") User user, Model model, HttpSession session) {
        // Implement your business logic

        User finalUser = userService.findUserByInternalId(user.getUserInternalId());
        session.setAttribute("user", finalUser);
        session.setMaxInactiveInterval(10);

        return "indexGefa";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.DELETE)
    public String logout(@ModelAttribute("user") User user, HttpSession session) {
        // Implement your business logic
        session.removeAttribute("user");
        session.invalidate();

        return "logout";
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
