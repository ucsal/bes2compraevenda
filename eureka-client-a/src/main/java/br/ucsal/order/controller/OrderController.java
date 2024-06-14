package br.ucsal.order.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.ucsal.order.Order;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private int nextOrderId = 1;

    private List<Order> orders = new ArrayList<>();

    @PostMapping("/create")
    public Order createOrder(@RequestBody Order orderRequest) {
    	try {
	        orderRequest.setOrderId(nextOrderId++);
	        orderRequest.setOrderValue(orderRequest.getQuantity() * orderRequest.getUnitPrice());
	        orderRequest.setStatus("Criado");
	        orders.add(orderRequest);
	        //notifyPaymentService(orderRequest);
    	}catch(Exception e) {
    		e.printStackTrace();
    		System.out.println(e.getMessage());
    	}
    	return orderRequest;
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    @PostMapping("/{orderId}/pay")
    public void payOrder(@PathVariable int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                order.setStatus("Pago");
                return;
            }
        }
        throw new RuntimeException("Pedido não encontrado: " + orderId);
    }
    
    @PostMapping("/{orderId}/dispatch")
    public void dispatchOrder(@PathVariable int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                order.setStatus("Enviado");
                return;
            }
        }
        throw new RuntimeException("Pedido não encontrado: " + orderId);
    }

}