package br.com.giovanna.trabalhoFinalGiovannaFranco.modelo;

import java.util.Date;
import java.util.List;

public class Reserva {
    private int id;
    private Date dataChegada;
    private Date dataSaida;
    private double taxaMulta;
    private TipoAcomodacao tipoacomodacao;
    private Hospede hospede;
    private Funcionario funcionario;
    private List<Acompanhante> acompanhantes;
    private boolean ativa;

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

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

    public double getTaxaMulta() {
        return taxaMulta;
    }

    public void setTaxaMulta(double taxaMulta) {
        this.taxaMulta = taxaMulta;
    }

    public TipoAcomodacao getTipoAcomodacao() {
        return tipoacomodacao;
    }

    public void setTipoAcomodacao(TipoAcomodacao tipoacomodacao) {
        this.tipoacomodacao = tipoacomodacao;
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

    
    
}
