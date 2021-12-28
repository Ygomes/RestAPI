package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Itens{
    @JsonIgnore
    @SequenceGenerator(
            name = "itens_sequence",
            sequenceName = "itens_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "itens_sequence")
    @Id
    private Long id;
    private String descricao;
    private Integer precoUnitario;
    private Integer qtd;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public Itens() {

    }

    public Itens(String descricao, Integer precoUnitario, Integer qtd, Pedido pedido) {
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.qtd = qtd;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Integer precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Itens(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Itens{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", precoUnitario=" + precoUnitario +
                ", qtd=" + qtd +
                ", pedido=" + pedido +
                '}';
    }
}
