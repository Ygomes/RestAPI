package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class ResponseCommand {

    private String pedido;
    private List<String> status = new ArrayList<>();

    public ResponseCommand(String pedido, List<String> status) {
        this.pedido = pedido;
        this.status = status;
    }

    public ResponseCommand(String pedido) {
        this.pedido = pedido;
    }
    public ResponseCommand() {
    }

    public ResponseCommand(ResponseCommand setNewStatus) {
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResponseCommand{" +
                "pedido='" + pedido + '\'' +
                ", status=" + status +
                '}';
    }
}
