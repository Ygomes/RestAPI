package com.example.demo.service;

import com.example.demo.controllers.entity.Pedido;
import com.example.demo.controllers.entity.Status;
import com.example.demo.model.ResponseCommand;
import com.example.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido getPedido(){
        Optional<Pedido> option = pedidoRepository.findById("123456");
        if (option.isPresent())
            return option.get();
        return null;
    }

    public ResponseCommand setNewStatus(Status status) {
       Optional<Pedido> statusByPedido = pedidoRepository.findById(status.getPedido());
        ResponseCommand responseCommand = new ResponseCommand("123456");
        if (statusByPedido.isPresent()) {
            if (status.getStatus().equals("APROVADO")) {
                if (status.getValorAprovado() == 20 && status.getItensAprovados() == 3) {
                    responseCommand.getStatus().add("APROVADO");
                }
                if (status.getValorAprovado() > 20) {
                    responseCommand.getStatus().add("APROVADO_VALOR_A_MAIOR");
                } else if (status.getValorAprovado() < 20) {
                    responseCommand.getStatus().add("APROVADO_VALOR_A_MENOR");
                }
                if (status.getItensAprovados() > 3) {
                    responseCommand.getStatus().add("APROVADO_QTD_A_MAIOR");
                } else if (status.getItensAprovados() < 3) {
                    responseCommand.getStatus().add("APROVADO_QTD_A_MENOR");
                }
            }
            else {
                responseCommand.getStatus().add("REPROVADO");
            }
        }
        else {
            responseCommand.getStatus().add("CODIGO_PEDIDO_INVALIDO");
        }
        return responseCommand;
    }
}
