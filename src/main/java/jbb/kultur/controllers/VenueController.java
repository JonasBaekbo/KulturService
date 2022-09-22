package jbb.kultur.controllers;

import jbb.kultur.models.User;
import jbb.kultur.models.Venue;
import jbb.kultur.services.IUserService;
import jbb.kultur.services.IVenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VenueController {
    private IVenueService venueService;

    public VenueController(IVenueService venueService) {
        this.venueService = venueService;
    }

    @PostMapping("/createVenue")
    public ResponseEntity<String> createVenue(@RequestBody Venue venue) {
        String msg = "";
        if (venueService.save(venue) != null) {
            msg = "Venue oprettet: " + venue.getName();
        } else {
            msg = "Fejl i oprettelsen af " + venue.getName();
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }

}
