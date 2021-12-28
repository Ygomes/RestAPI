package com.example.demo.controllers.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido{
    @Id
    private String pedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<Itens> itens = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(String pedido) {
        this.pedido = pedido;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public List<Itens> getItens() {
        return itens;
    }

    public void setItens(List<Itens> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                ", pedido='" + pedido + '\'' +
                ", itens=" + itens +
                '}';
    }
}
