package br.ucsal.eurekaclientb.controller;

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
    public int sum() {

        int result;

        try {

            int clientCRandomNumber = restTemplate.getForObject("http://localhost:8082/numero-aleatorio",
                    int.class);

            int localRandomValue = (int) (Math.random() * 100);

            result = clientCRandomNumber + localRandomValue;

        } catch (Exception e) {

            return -2;

        }

        return result;

    }
}
