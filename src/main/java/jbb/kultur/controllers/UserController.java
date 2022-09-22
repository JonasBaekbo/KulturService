package jbb.kultur.controllers;

import jbb.kultur.models.User;
import jbb.kultur.services.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private IUserService userService;
    public UserController(IUserService userService){
        this.userService = userService;
    }
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user){
        String msg="";
        if (userService.save(user)!=null){
            msg="Bruger oprettet: " + user.getName();
        }else{
            msg="Fejl i oprettelsen af " + user.getName();
        }
            return new ResponseEntity<>(msg, HttpStatus.OK);

    }
}
