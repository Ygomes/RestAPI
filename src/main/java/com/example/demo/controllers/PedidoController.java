package com.example.demo.controllers;

import com.example.demo.entity.Pedido;
import com.example.demo.entity.Status;
import com.example.demo.model.ResponseCommand;
import com.example.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api")
public class PedidoController {

    private PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping(path = "/pedido")
    public Pedido getPedido(){
        return pedidoService.getPedido();
    }


    @PostMapping(path = "/status")
    public ResponseCommand getStatus(@RequestBody Status status) {
        return pedidoService.setNewStatus(status);
    }
}
