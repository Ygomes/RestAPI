package com.example.demo.entity;

public class Status {
    public String status;
    public Integer itensAprovados;
    public Integer valorAprovado;
    public String pedido;

    public Status() {
    }

    public Status(String status, Integer itensAprovados, Integer valorAprovado, String pedido) {
        this.status = status;
        this.itensAprovados = itensAprovados;
        this.valorAprovado = valorAprovado;
        this.pedido = pedido;
    }

    public Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getItensAprovados() {
        return itensAprovados;
    }

    public void setItensAprovados(Integer itensAprovados) {
        this.itensAprovados = itensAprovados;
    }

    public Integer getValorAprovado() {
        return valorAprovado;
    }

    public void setValorAprovado(Integer valorAprovado) {
        this.valorAprovado = valorAprovado;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Status{" +
                "status='" + status + '\'' +
                ", itensAprovados=" + itensAprovados +
                ", valorAprovado=" + valorAprovado +
                ", pedido='" + pedido + '\'' +
                '}';
    }
}

