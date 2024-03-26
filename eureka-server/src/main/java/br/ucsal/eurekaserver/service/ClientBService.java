package br.ucsal.eurekaserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;

@Service
public class ClientBService {

    @Autowired
    private RestTemplate restTemplate;

    public int validateClientA() {

        ResponseEntity<String> response = restTemplate.getForEntity("http://app-a/health", String.class);
        if (response.getStatusCode() == HttpStatus.OK) {

            return 0;
        } else {

            return -1;

        }
    }

    public int validateClientC() {

        ResponseEntity<String> response = restTemplate.getForEntity("http://app-c/health", String.class);
        if (response.getStatusCode() == HttpStatus.OK) {

            return 0;
        } else {

            return -2;

        }
    }

    @SuppressWarnings("null")
    public int clientBSum() {

        int clientCRandomNumber = restTemplate.getForObject("http://localhost:8082/numero-aleatorio", Integer.class);

        int localRandomValue = (int) (Math.random() * 100);
        return clientCRandomNumber + localRandomValue;
    }
}
