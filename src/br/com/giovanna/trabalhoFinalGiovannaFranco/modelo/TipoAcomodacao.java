package br.com.giovanna.trabalhoFinalGiovannaFranco.modelo;

public class TipoAcomodacao {
    private int id;
    private String descricao;
    private int qtdeAcomodacoes;
    private double precoDiaria;
    private int nroAdulto;
    private int nroCrianca;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdeAcomodacoes() {
        return qtdeAcomodacoes;
    }

    public void setQtdeAcomodacoes(int qtdeAcomodacoes) {
        this.qtdeAcomodacoes = qtdeAcomodacoes;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public int getNroAdulto() {
        return nroAdulto;
    }

    public void setNroAdulto(int nroAdulto) {
        this.nroAdulto = nroAdulto;
    }

    public int getNroCrianca() {
        return nroCrianca;
    }

    public void setNroCrianca(int nroCrianca) {
        this.nroCrianca = nroCrianca;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
    
    
}
