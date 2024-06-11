package br.ucsal.eurekaclienta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import br.ucsal.eurekaclienta.OrderRequest;

@RestController
@RequestMapping("/order")
public class ClientAController {

        @Autowired
        private RestTemplate restTemplate;

        @PostMapping("/create")
        public int createOrder(@RequestBody OrderRequest orderRequest) {
                
                int orderValue = orderRequest.getQuantity() * orderRequest.getUnitPrice();
                return orderValue;
        }
        @GetMapping("/value/{orderId}")
        public int getOrderValue(@PathVariable int orderId) {
                
                return 100; 
        }
}
