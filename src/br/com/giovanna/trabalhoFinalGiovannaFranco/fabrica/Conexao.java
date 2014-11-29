package br.com.giovanna.trabalhoFinalGiovannaFranco.fabrica;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {
    
    public Connection criarConexao(){
        Connection con = null;
        
        String url = "jdbc:mysql://localhost:3306/hotelaltosdaflora";
        String usuario = "root";
        String senha ="root";
        
        try{
            con = DriverManager.getConnection(url, usuario, senha);
            return con;
             
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a conexão com o banco de dados! =>" + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("[ERRO!] Não foi possível fazer a conexão com o banco de dados.", e);
        }
    }
    
}
