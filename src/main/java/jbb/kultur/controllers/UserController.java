package jbb.kultur.controllers;

import jbb.kultur.models.Band;
import jbb.kultur.models.User;
import jbb.kultur.models.Venue;
import jbb.kultur.services.IUserService;
import jbb.kultur.services.IVenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private IUserService userService;
    private IVenueService venueService;
    public UserController(IUserService userService, IVenueService venueService){
        this.userService = userService;
        this.venueService = venueService;
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
    @GetMapping("/getUserByName")
    public ResponseEntity<List<User>> getBandByName(String name){
        return new ResponseEntity<>(userService.findUserByName(name), HttpStatus.OK);
    }

    @PostMapping("/createLike")
    public ResponseEntity<String> createLike(@RequestParam Long userID, @RequestParam Long venueID){
        Optional<User> user_ = userService.findById(userID);
        Optional<Venue> venue_ = venueService.findById(venueID);
        if (user_.isPresent() && venue_.isPresent()){
            user_.get().getVenuesLiked().add(venue_.get());
            userService.save(user_.get());
            return new ResponseEntity<>("Gemt like på user: " + userID + " Venue: " + venueID, HttpStatus.OK);
        }
        return new ResponseEntity<>("Fejlede ved oprettelse af like" + venueID, HttpStatus.BAD_REQUEST);
    }
}
