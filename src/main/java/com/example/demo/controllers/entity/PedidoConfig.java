package com.example.demo.controllers.entity;

import com.example.demo.repository.PedidoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PedidoConfig {

    @Bean
    CommandLineRunner commandLineRunner(PedidoRepository pedidoRepository){
        return args -> {
        Pedido pedido = new Pedido("123456");
        List<Itens> itens = new ArrayList<>();
        Itens a = new Itens("Item A",10,1, pedido);
        itens.add(a);
        Itens b = new Itens("Item B",5,2, pedido);
        itens.add(b);
        pedido.setItens(itens);
        pedidoRepository.save(pedido);
        };
    }
}
