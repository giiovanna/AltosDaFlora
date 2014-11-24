package br.com.giovanna.trabalhoFinalGiovannaFranco.modelo;

import java.util.Date;
import java.util.List;

public class Entrada {
    private int id;
    private Date dataChegada;
    private Date dataSaida;
    private Acomodacao acomodacao;
    private Hospede hospede;
    private Funcionario funcionario;
    private List<Acompanhante> acompanhantes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Acomodacao getAcomodacao() {
        return acomodacao;
    }

    public void setAcomodacao(Acomodacao acomodacao) {
        this.acomodacao = acomodacao;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Acompanhante> getAcompanhantes() {
        return acompanhantes;
    }

    public void setAcompanhantes(List<Acompanhante> acompanhantes) {
        this.acompanhantes = acompanhantes;
    }

    @Override
    public String toString() {
        return "Entrada " + id + " - " + hospede;
    }
}
