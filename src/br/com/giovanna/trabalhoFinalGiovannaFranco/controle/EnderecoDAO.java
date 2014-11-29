package br.com.giovanna.trabalhoFinalGiovannaFranco.controle;

import br.com.giovanna.trabalhoFinalGiovannaFranco.DAO.DAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.fabrica.Conexao;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EnderecoDAO implements DAO<Endereco> {

    @Override
    public int inserir(Endereco e) {
        String sql = "INSERT INTO endereco (logradouro,bairro,numero,cidade,uf,cep)"+
                     "VALUES (?,?,?,?,?,?);";
        
        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            ps.setString(1, e.getLogradouro());
            ps.setString(2, e.getBairro());
            ps.setInt(3, e.getNumero());
            ps.setString(4, e.getCidade());
            ps.setString(5, e.getUf());
            ps.setString(6, e.getCEP());
            
            ps.executeUpdate();
            
            int id = -1;
            
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            }
            
            return id;
           
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void alterar(Endereco e) {
        String sql = "UPDATE endereco SET logradouro=?,bairro=?,numero=?,cidade=?,uf=?,cep=? WHERE idEndereco=?;";
        
        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, e.getLogradouro());
            ps.setString(2, e.getBairro());
            ps.setInt(3, e.getNumero());
            ps.setString(4, e.getCidade());
            ps.setString(5, e.getUf());
            ps.setString(6, e.getCEP());
            ps.setInt(7, e.getId());
            
            ps.executeUpdate();
           
        }catch(SQLException ex){
            throw new RuntimeException(ex);   
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM endereco WHERE idEndereco=?;";
        
        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Endereco> listarTodos() {
       List<Endereco> enderecos = null;
       String sql = "SELECT * FROM endereco;";
       
       try (Connection con = new Conexao().criarConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            
            enderecos = new ArrayList<>();
           
            while (rs.next()) {
                Endereco endereco = new Endereco();
                
                endereco.setId(rs.getInt("idEndereco"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setUf(rs.getString("uf"));
                endereco.setCEP(rs.getString("cep"));
                
                enderecos.add(endereco);
            }
           
       }catch(SQLException e){
           throw new RuntimeException(e);
       }
       return enderecos;
    }

    @Override
    public Endereco buscar(int id) {
        Endereco endereco = null;
        String sql = "SELECT * FROM endereco WHERE idEndereco=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    endereco = new Endereco();
                    
                    endereco.setId(rs.getInt("idEndereco"));
                    endereco.setBairro(rs.getString("bairro"));
                    endereco.setLogradouro(rs.getString("logradouro"));
                    endereco.setNumero(rs.getInt("numero"));
                    endereco.setCidade(rs.getString("cidade"));
                    endereco.setUf(rs.getString("uf"));
                    endereco.setCEP(rs.getString("cep"));
                }
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return endereco;
    }
    
}
