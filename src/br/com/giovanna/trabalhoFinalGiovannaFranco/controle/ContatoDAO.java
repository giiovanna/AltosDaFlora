package br.com.giovanna.trabalhoFinalGiovannaFranco.controle;

import br.com.giovanna.trabalhoFinalGiovannaFranco.DAO.DAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.fabrica.Conexao;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Contato;
import java.sql.*;
import java.util.*;

public class ContatoDAO implements DAO<Contato> {
    
    @Override
    public int inserir(Contato c){
        String sql = "INSERT INTO Contato (telResidencial,telComercial,celular,email)"+
                     "VALUES (?,?,?,?);";
        
        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            ps.setString(1,c.getTelResid());
            ps.setString(2,c.getTelCom());
            ps.setString(3,c.getCelular());
            ps.setString(4,c.getEmail());
            
            ps.executeUpdate();
            
            int id = -1;
            
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            }
            
            return id;
           
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void alterar(Contato c){
        String sql = "UPDATE Contato SET telResidencial=?,telComercial=?,"
                + "celular=?,email=? WHERE idContato=?;";
        
        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1,c.getTelResid());
            ps.setString(2,c.getTelCom());
            ps.setString(3,c.getCelular());
            ps.setString(4,c.getEmail());
            ps.setInt(5,c.getCodContato());
            
            ps.executeUpdate();
           
        }catch(SQLException e){
            throw new RuntimeException(e);   
        }
    }
    
    @Override
    public void excluir(int id){
        String sql = "DELETE FROM Contato WHERE idContato=?;";
        
        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public Contato buscar(int id) {
        Contato contato = null;
        String sql = "SELECT * FROM Contato WHERE idContato=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    contato = new Contato();
                    
                    contato.setCodContato(rs.getInt("idContato"));
                    contato.setTelResid(rs.getString("telResidencial"));
                    contato.setTelCom(rs.getString("telComercial"));
                    contato.setCelular(rs.getString("celular"));
                    contato.setEmail(rs.getString("email"));
                }
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return contato;
    }
    
    @Override
    public List<Contato> listarTodos(){
       List<Contato> contatos = null;
       String sql = "SELECT * FROM Contato;";
       
       try (Connection con = new Conexao().criarConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            
            contatos = new ArrayList<>();
           
            while (rs.next()) {
                Contato c = new Contato();
                
                c.setCodContato(rs.getInt("idContato"));
                c.setTelResid(rs.getString("telResidencial"));
                c.setTelCom(rs.getString("telComercial"));
                c.setCelular(rs.getString("celular"));
                c.setEmail(rs.getString("email"));
                
                contatos.add(c);
            }
           
       }catch(SQLException e){
           throw new RuntimeException(e);
       }
       return contatos;
    }
        
}
