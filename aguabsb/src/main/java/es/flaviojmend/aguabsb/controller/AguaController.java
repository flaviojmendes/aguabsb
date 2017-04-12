package es.flaviojmend.aguabsb.controller;

import es.flaviojmend.aguabsb.service.AguaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/agua")
public class AguaController {


    @Autowired
    AguaService aguaService;

//    @RequestMapping(method = RequestMethod.POST)
//    public Iterable<CrazyAirFlight> search(@RequestBody CrazyAirFilterCommand crazyAirFilterCommand) {
//
//        return crazyAirService.listFlights(crazyAirFilterCommand);
//    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public ResponseEntity<?> save(@RequestBody CrazyAirFlight crazyAirFlight) {
//        HttpHeaders httpHeaders = new HttpHeaders();
//        return new ResponseEntity<>(crazyAirService.save(crazyAirFlight), httpHeaders, HttpStatus.OK);
//    }

    @RequestMapping(method = RequestMethod.GET)
    @CrossOrigin
    public ResponseEntity<?> agua() {

        try {
            return new ResponseEntity<>(aguaService.getVolumes(), HttpStatus.OK );
        } catch (IOException e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}