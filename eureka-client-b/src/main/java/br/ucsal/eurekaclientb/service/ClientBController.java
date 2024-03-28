package br.ucsal.eurekaclientb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientBController {

    @Autowired
    private RestTemplate restTemplate;

    @SuppressWarnings("null")
    @GetMapping("/business")
    public Integer sum() {

        Integer clientCRandomNumber = restTemplate.getForObject("http://localhost:8082/numero-aleatorio", Integer.class);

        int localRandomValue = (int) (Math.random() * 100);
        return clientCRandomNumber + localRandomValue;
    }
}
