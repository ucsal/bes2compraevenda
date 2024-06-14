package br.ucsal.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.ucsal.paymentservice.Payment;
import br.ucsal.paymentservice.PaymentRequest;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/process")
    public String processPayment(@RequestBody PaymentRequest paymentRequest) {
    	try {
    		
        int orderValue = restTemplate.getForObject("http://EUREKA-CLIENT-A/order/" + paymentRequest.getOrderId(),
                Payment.class).getOrderValue();

        if (orderValue == paymentRequest.getPaymentAmount()) {
            System.out.println("Pagamento processado com sucesso para o pedido: " + paymentRequest.getOrderId());

            restTemplate.postForEntity("http://EUREKA-CLIENT-A/order/" + paymentRequest.getOrderId() + "/pay", null, Void.class);
            restTemplate.postForEntity("http://EUREKA-CLIENT-C/shipping/" + paymentRequest.getOrderId() + "/paid", null, Void.class);
            return "Pagamento bem-sucedido!";
        } else {
            return "Falha no pagamento!";
        }
    	}catch(Exception e) {
    		e.printStackTrace();
    		System.out.println(e.getMessage());
    		return e.getMessage();
    	}
    }
}