package br.com.giovanna.trabalhoFinalGiovannaFranco.modelo;

public class Acomodacao {
    private int id;
    private int numero;
    private int andar;
    private TipoAcomodacao tipoAcomodacao;
    private boolean disponivel;

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public TipoAcomodacao getTipoAcomodacao() {
        return tipoAcomodacao;
    }

    public void setTipoAcomodacao(TipoAcomodacao tipoAcomodacao) {
        this.tipoAcomodacao = tipoAcomodacao;
    }

    @Override
    public String toString() {
        return "Quarto "+numero +" - Andar"+andar ;
    }
    
    
}
