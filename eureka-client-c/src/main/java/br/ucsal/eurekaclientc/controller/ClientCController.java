package br.ucsal.eurekaclientc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.ucsal.eurekaclientc.ShippingRequest;

@RestController
@RequestMapping("/shipping")
public class ClientCController {

    @PostMapping("/dispatch")
    public String dispatchOrder(@RequestBody ShippingRequest shippingRequest) {
        // Lógica de despacho simulada
        return "Produto despachado para o pedido " + shippingRequest.getOrderId();
    }
}