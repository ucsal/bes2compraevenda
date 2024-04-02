package br.ucsal.eurekaclienta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientAController {

    @Autowired
    private RestTemplate restTemplate;

    @SuppressWarnings("null")
    @GetMapping("/iniciar")
    public int callService() {
        int result;

        try {
            result = restTemplate.getForObject("http://localhost:8081/business", int.class);
        } catch (Exception e) {
            return -1;
        }
        return result;
    }
}
