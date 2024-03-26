package br.ucsal.eurekaserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientCController {

    @GetMapping("/numero-aleatorio")
    public int getRandomNumber() {

        return (int) (Math.random() * 100);

    }
}
