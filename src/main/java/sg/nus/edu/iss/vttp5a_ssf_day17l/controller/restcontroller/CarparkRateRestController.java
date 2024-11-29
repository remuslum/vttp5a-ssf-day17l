package sg.nus.edu.iss.vttp5a_ssf_day17l.controller.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.nus.edu.iss.vttp5a_ssf_day17l.model.CarparkRate;
import sg.nus.edu.iss.vttp5a_ssf_day17l.service.restservice.CarparkRatesRestService;

@RestController
@RequestMapping("/carpark")
public class CarparkRateRestController {
    @Autowired
    CarparkRatesRestService carparkRatesRestService;

    @GetMapping()
    public ResponseEntity<List<CarparkRate>> getCarparkRates(){
        List<CarparkRate> carparkRates = carparkRatesRestService.getAllCarparkRates();
        return ResponseEntity.ok().body(carparkRates);
    }
}
