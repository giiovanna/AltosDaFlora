package br.com.giovanna.trabalhoFinalGiovannaFranco.modelo;

public class Contato {
    private int codContato;
    private String telResid;
    private String telCom;
    private String celular;
    private String email;

    public int getCodContato() {
        return codContato;
    }

    public void setCodContato(int codContato) {
        this.codContato = codContato;
    }
    
    public String getTelResid() {
        return telResid;
    }

    public void setTelResid(String telResid) {
        this.telResid = telResid;
    }

    public String getTelCom() {
        return telCom;
    }

    public void setTelCom(String telCom) {
        this.telCom = telCom;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
