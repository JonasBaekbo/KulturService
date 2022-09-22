package jbb.kultur.controllers;


import jbb.kultur.models.Band;
import jbb.kultur.models.Event;
import jbb.kultur.models.User;
import jbb.kultur.services.IBandService;
import jbb.kultur.services.IEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Optional;

@RestController
public class EventController {
    private IEventService eventService;
    private IBandService bandService;

    public EventController(IEventService eventService, IBandService bandService) {
        this.eventService = eventService;
        this.bandService = bandService;


    }
    @PostMapping("/createEvent")
    public ResponseEntity<String> createEvent(@RequestBody Event event, @RequestParam Long bandID, @RequestParam Timestamp time
    ) {

        // Hent band
        Optional<Band> band = bandService.findById(bandID);
        if (band.isPresent()) {
            event.setBand(band.get());
            event.setTimestamp(time);
            eventService.save(event);
            return new ResponseEntity<>("Oprettet event", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Band ikke fundet " + bandID, HttpStatus.OK);
        }
    }

}
