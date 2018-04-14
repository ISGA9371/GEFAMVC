package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseDTO;
import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.User;
import com.mx.bbva.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    private static final Logger LOG = Logger.getLogger(UserController.class.getName());

    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllUsers() {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<Object>(new ResponseListDTO(users), HttpStatus.OK);
    }

    @RequestMapping(value = "/{userInternalId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findUser(@PathVariable("userInternalId") String userInternalId) {
        User user = userService.findUser(userInternalId);
        return new ResponseEntity<Object>(new ResponseDTO(user), HttpStatus.OK);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
