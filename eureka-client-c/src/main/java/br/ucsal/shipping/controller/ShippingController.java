package br.ucsal.shipping.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import br.ucsal.shipping.ShippingRequest;

@RestController
@RequestMapping("/shipping")
public class ShippingController {
    @Autowired
    private RestTemplate restTemplate;
    
    private List<Integer> ordersNotShipped = new ArrayList<Integer>();
    private List<Integer> ordersShipped = new ArrayList<Integer>();
    
    @PostMapping("/dispatch")
    public String dispatchOrder(@RequestBody ShippingRequest shippingRequest) {
    	try {
    		if(ordersNotShipped.contains(shippingRequest.getOrderId())){
    			restTemplate.postForEntity("http://EUREKA-CLIENT-A/order/" + shippingRequest.getOrderId() + "/dispatch", null, Void.class); 
    			ordersNotShipped.remove(Integer.valueOf(shippingRequest.getOrderId()));
    			ordersShipped.add(shippingRequest.getOrderId());
    		}else {
    			return "Pedido não disponível para envio";
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    		System.out.println(e.getMessage());
    	}
    	
        return "Produto despachado para o pedido " + shippingRequest.getOrderId() + " com frete " + shippingRequest.getShippingType();
    }
    
    @PostMapping("/{orderId}/paid")
    public void addOrderToOrderNotShipped(@PathVariable int orderId) {
    	if(!ordersNotShipped.contains(orderId) && !ordersShipped.contains(orderId)) {
    		ordersNotShipped.add(orderId);
    	}
    }
}