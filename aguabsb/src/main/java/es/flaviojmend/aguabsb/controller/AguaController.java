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
import java.util.Calendar;

@RestController
@RequestMapping("/agua")
public class AguaController {


    @Autowired
    AguaService aguaService;


    @RequestMapping(method = RequestMethod.GET)
    @CrossOrigin
    public ResponseEntity<?> agua() {

        Calendar today = Calendar.getInstance();

        String cacheKey = today.get(Calendar.YEAR)
                + "" + today.get(Calendar.MONTH)
                + "" + today.get(Calendar.DAY_OF_MONTH)
                + "" + today.get(Calendar.HOUR_OF_DAY) +"";

        try {
            return new ResponseEntity<>(aguaService.getVolumes(cacheKey), HttpStatus.OK );
        } catch (IOException e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}