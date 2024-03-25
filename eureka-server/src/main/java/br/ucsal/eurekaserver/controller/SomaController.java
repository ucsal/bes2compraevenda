package br.ucsal.eurekaserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

@RestController
public class SomaController {

    @GetMapping("/soma")
    public int somaValoresAleatorios() {

        Random random = new Random();
        int valor1 = random.nextInt(100);
        int valor2 = random.nextInt(100);

        int soma = valor1 + valor2;

        return soma;
    }
}
