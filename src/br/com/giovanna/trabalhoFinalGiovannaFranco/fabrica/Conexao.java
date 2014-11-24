package br.com.giovanna.trabalhoFinalGiovannaFranco.fabrica;

import java.sql.*;

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
            throw new RuntimeException("[ERRO!] Não foi possível fazer a conexão com o banco de dados.", e);
        }
    }
    
}
