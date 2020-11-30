package com.kalinowt.restapp.controller;


import com.kalinowt.restapp.dto.Inbound.AddressCheckRequest;
import com.kalinowt.restapp.dto.Inbound.AddressCheckResponse;
import com.kalinowt.restapp.services.IpApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
public class AddressCheckController {

    @Autowired
    private IpApiService ipApiService;

    @GetMapping("/north-countries")
    public ResponseEntity<AddressCheckResponse> getCountriesForNorthHemisphere(@RequestParam(value = "ip") List<String> ips){
        AddressCheckRequest request = new AddressCheckRequest().setAddresses(ips);
        if(request.getAddresses().size() == 0 || ips.size() > 5){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  //at least 1 proper ip and maximum of 5 in request
        }
        AddressCheckResponse response = ipApiService.getCountriesForNorthHemisphere(request);
        if(response.getCountries().size() == 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  //return bad request if no countries were returned
        }
        return ResponseEntity.ok(ipApiService.getCountriesForNorthHemisphere(request));
    }
    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

}
