package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseDTO;
import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.ProfileType;
import com.mx.bbva.business.entity.User;
import com.mx.bbva.business.service.ProfileTypeService;
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
@RequestMapping(value = "/api/profile-types")
public class ProfileTypeController {
    private static final Logger LOG = Logger.getLogger(ProfileTypeController.class.getName());

    private ProfileTypeService profileTypeService;
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllProfileTypes() {
        List<ProfileType> profileTypes = profileTypeService.findAllProfileTypes();
        return new ResponseEntity<Object>(new ResponseListDTO(profileTypes), HttpStatus.OK);
    }

    @RequestMapping(value = "/{profileTypeId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findOneProfileType(@PathVariable("profileTypeId") Integer profileTypeId) {
        ProfileType profileType = profileTypeService.findOneProfileType(profileTypeId);
        return new ResponseEntity<Object>(new ResponseDTO(profileType), HttpStatus.OK);
    }

    @RequestMapping(value = "/{profileTypeId}/users", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllUsersByProfile(@PathVariable(name = "profileTypeId") Integer profileTypeId) {
        LOG.info("find users by type..." + profileTypeId);
        List<User> users = userService.findUsersByType(profileTypeId);
        return new ResponseEntity<Object>(new ResponseListDTO(users), HttpStatus.OK);
    }

    @RequestMapping(value = "/{profileTypeId}/users/{userInternalId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getUserByProfile(@PathVariable(name = "profileTypeId") Integer profileTypeId,
                                              @PathVariable("userInternalId") String userInternalId) {
        LOG.info("find users by type..." + profileTypeId);
        User user = userService.findUserByIdAndType(userInternalId, profileTypeId);
        return new ResponseEntity<Object>(new ResponseDTO(user), HttpStatus.OK);
    }

    @Autowired
    public void setProfileTypeService(ProfileTypeService profileTypeService) {
        this.profileTypeService = profileTypeService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
