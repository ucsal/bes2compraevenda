package br.ucsal.eurekaserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.eurekaserver.service.ClientBService;

@RestController
public class ClientAController {

    @Autowired
    private ClientBService clientBService;

    @GetMapping("/soma")
    public int RandomNumbersSum() {

        int statusA = clientBService.validateClientA();
        int statusC = clientBService.validateClientC();

        if (statusA == 0 && statusC == 0) {

            return clientBService.clientBSum();

        } else if (statusA != 0) {

            return -1;

        } else {

            return -2;

        }
    }
}
