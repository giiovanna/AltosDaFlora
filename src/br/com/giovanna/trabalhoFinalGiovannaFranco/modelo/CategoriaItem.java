package br.com.giovanna.trabalhoFinalGiovannaFranco.modelo;

public class CategoriaItem {
    private int id;
    private String descricao;
    
    public int getCodCategoria() {
        return id;
    }

    public void setCodCategoria(int codCategoria) {
        this.id = codCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
