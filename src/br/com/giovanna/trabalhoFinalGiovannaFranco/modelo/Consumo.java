package br.com.giovanna.trabalhoFinalGiovannaFranco.modelo;

import java.util.Date;
import java.util.List;

public class Consumo {
    private int id;
    private Date data;
    private double valor;
    private Entrada entrada;
    private List<ItemConsumo> itens;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public List<ItemConsumo> getItens() {
        return itens;
    }

    public void setItens(List<ItemConsumo> itens) {
        this.itens = itens;
    }
    
}
