package br.ucsal.eurekaclienta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientAController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/iniciar")
    public Integer callService() {


        return restTemplate.getForObject("http://localhost:8081/business", Integer.class);

    }
}

