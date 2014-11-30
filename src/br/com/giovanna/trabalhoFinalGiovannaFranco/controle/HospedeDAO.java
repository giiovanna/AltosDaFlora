package br.com.giovanna.trabalhoFinalGiovannaFranco.controle;

import br.com.giovanna.trabalhoFinalGiovannaFranco.DAO.DAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.fabrica.Conexao;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Contato;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Endereco;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Hospede;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HospedeDAO implements DAO<Hospede> {

    @Override
    public int inserir(Hospede h) {
        String sql = "INSERT INTO hospede (nome,rg,dataNascimento,idContato,idEndereco)"
                + "VALUES (?,?,?,?,?);";

        EnderecoDAO eDAO = new EnderecoDAO();
        ContatoDAO cDAO = new ContatoDAO();

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            int idE = eDAO.inserir(h.getEndereco());
            int idC = cDAO.inserir(h.getContato());
            ps.setString(1, h.getNome());
            ps.setString(2, h.getRg());
            ps.setDate(3, new Date(h.getDataNasc().getTime()));
            ps.setInt(4, idC);
            ps.setInt(5, idE);

            ps.executeUpdate();
            
            int id = -1;
            
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            }
            
            return id;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void alterar(Hospede h) {
        String sql = "UPDATE hospede SET nome=?,rg=?,dataNascimento=? WHERE idHospede=?;";

        EnderecoDAO eDAO = new EnderecoDAO();
        ContatoDAO cDAO = new ContatoDAO();

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {

            eDAO.alterar(h.getEndereco());
            cDAO.alterar(h.getContato());

            ps.setString(1, h.getNome());
            ps.setString(2, h.getRg());
            ps.setDate(3, new Date(h.getDataNasc().getTime()));
            ps.setInt(4, h.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM hospede WHERE idHospede=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Hospede> listarTodos() {
        List<Hospede> hospedes = null;
        String sql = "SELECT * FROM hospede;";
        
        EnderecoDAO eDAO = new EnderecoDAO();
        ContatoDAO cDAO = new ContatoDAO();
        
        Endereco endereco;
        Contato contato;
        
        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            hospedes = new ArrayList<>();

            while (rs.next()) {
                Hospede hospede = new Hospede();

                hospede.setId(rs.getInt("idHospede"));
                hospede.setNome(rs.getString("nome"));
                hospede.setRg(rs.getString("rg"));
                hospede.setDataNasc(rs.getDate("dataNascimento"));
                
                endereco = eDAO.buscar(rs.getInt("idEndereco"));
                contato = cDAO.buscar(rs.getInt("idContato"));
                
                hospede.setEndereco(endereco);
                hospede.setContato(contato);

                hospedes.add(hospede);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hospedes;
    }

    @Override
    public Hospede buscar(int id) {
        Hospede hospede = null;
        String sql = "SELECT * FROM hospede WHERE idHospede=?;";
        
        EnderecoDAO eDAO = new EnderecoDAO();
        ContatoDAO cDAO = new ContatoDAO();
        
        Endereco endereco;
        Contato contato;
        
        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()){
                ps.setInt(1, id);

                if (rs.next()) {
                    hospede = new Hospede();

                    hospede.setId(rs.getInt("idHospede"));
                    hospede.setNome(rs.getString("nome"));
                    hospede.setRg(rs.getString("rg"));
                    hospede.setDataNasc(rs.getDate("dataNascimento"));

                    endereco = eDAO.buscar(rs.getInt("idEndereco"));
                    contato = cDAO.buscar(rs.getInt("idContato"));

                    hospede.setEndereco(endereco);
                    hospede.setContato(contato);
                }
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hospede;
    }
    
    public List<Hospede> listarAtivos() {
        List<Hospede> hospedes = null;
        String sql = "SELECT * FROM hospede where ativo = 1;";
        
        EnderecoDAO eDAO = new EnderecoDAO();
        ContatoDAO cDAO = new ContatoDAO();
        
        Endereco endereco;
        Contato contato;
        
        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            hospedes = new ArrayList<>();

            while (rs.next()) {
                Hospede hospede = new Hospede();

                hospede.setId(rs.getInt("idHospede"));
                hospede.setNome(rs.getString("nome"));
                hospede.setRg(rs.getString("rg"));
                hospede.setDataNasc(rs.getDate("dataNascimento"));
                
                endereco = eDAO.buscar(rs.getInt("idEndereco"));
                contato = cDAO.buscar(rs.getInt("idContato"));
                
                hospede.setEndereco(endereco);
                hospede.setContato(contato);

                hospedes.add(hospede);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hospedes;
    }

    public void mudarStatus(int nro,int cod){
        String sql = "UPDATE hospede set ativo =? where idHospede =?";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, nro);
            ps.setInt(2, cod);
            ps.executeUpdate();
        
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
