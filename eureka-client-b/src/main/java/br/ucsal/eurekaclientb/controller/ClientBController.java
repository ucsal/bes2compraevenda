package br.ucsal.eurekaclientb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import br.ucsal.eurekaclientb.PaymentRequest;

@RestController
@RequestMapping("/payment")
public class ClientBController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/process")
    public String processPayment(@RequestBody PaymentRequest paymentRequest) {
        int orderValue = restTemplate.getForObject("http://order-service/order/value/" + paymentRequest.getOrderId(),
                int.class);

        if (orderValue == paymentRequest.getPaymentAmount()) {
            return "Pagamento bem-sucedido!";
        } else {
            return "Falha no pagamento!";
        }
    }
}
