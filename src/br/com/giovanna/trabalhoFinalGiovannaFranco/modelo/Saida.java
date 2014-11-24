package br.com.giovanna.trabalhoFinalGiovannaFranco.modelo;

import java.util.Date;

public class Saida {
    private int id;
    private Date data;
    private int numeroDiarias;
    private double totalDiarias;
    private double totalConsumo;
    private Entrada entrada;

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

    public int getNumeroDiarias() {
        return numeroDiarias;
    }

    public void setNumeroDiarias(int numeroDiarias) {
        this.numeroDiarias = numeroDiarias;
    }

    public double getTotalDiarias() {
        return totalDiarias;
    }

    public void setTotalDiarias(double totalDiarias) {
        this.totalDiarias = totalDiarias;
    }

    public double getTotalConsumo() {
        return totalConsumo;
    }

    public void setTotalConsumo(double totalConsumo) {
        this.totalConsumo = totalConsumo;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }
    
    
}
