package jbb.kultur.controllers;

import jbb.kultur.models.Band;
import jbb.kultur.services.IBandService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BandController {
    private IBandService bandService;
    public BandController(IBandService bandService){
        this.bandService = bandService;
    }
    @PostMapping("/createBand")
    public ResponseEntity<String> createBand(@RequestBody Band band){
        String msg="";
        if (bandService.save(band)!=null){
            msg="Bruger oprettet: " + band.getName();
        }else{
            msg="Fejl i oprettelsen af " + band.getName();
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }
}
