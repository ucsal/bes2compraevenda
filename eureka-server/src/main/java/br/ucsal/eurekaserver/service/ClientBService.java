package br.ucsal.eurekaserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientBService {

    @Autowired
    private RestTemplate restTemplate;

    @SuppressWarnings("null")
    public int clientBSum() {

        int clientCRandomNumber = restTemplate.getForObject("http://localhost:8082/numero-aleatorio", Integer.class);

        int localRandomValue = (int) (Math.random() * 100);
        return clientCRandomNumber + localRandomValue;
    }
}
