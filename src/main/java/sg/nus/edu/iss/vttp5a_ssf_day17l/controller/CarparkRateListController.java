package sg.nus.edu.iss.vttp5a_ssf_day17l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.nus.edu.iss.vttp5a_ssf_day17l.model.CarparkRate;
import sg.nus.edu.iss.vttp5a_ssf_day17l.service.restservice.CarparkRatesRestService;

@Controller
@RequestMapping("/list")
public class CarparkRateListController {
    
    @Autowired
    CarparkRatesRestService carparkRatesRestService;

    @GetMapping()
    public String getCarparkRatesList(Model model){
        List<CarparkRate> carparkRates = carparkRatesRestService.getAllCarparkRates(); 
        model.addAttribute("carparkRates", carparkRates);
        return "carparkRatesList";
    }
}
