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

@Controller
@RequestMapping(value = "/")
@SessionAttributes("user")
public class AppController {

    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String init(@ModelAttribute("user") User user) {
        // TODO something here
        user.setUserInternalId("XMY0000");
        user.setProfileType(new ProfileType(4));
        return "indexGefa";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String submit(@ModelAttribute("user") User user, Model model) {
        // Implement your business logic
        //userService.findUserByInternalId(user.getUserInternalId());
        user.setUserInternalId("XMY0000");
        user.setProfileType(new ProfileType(4));
        return "indexGefa";
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
