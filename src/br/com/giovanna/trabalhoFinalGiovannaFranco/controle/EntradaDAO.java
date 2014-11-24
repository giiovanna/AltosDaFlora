package br.com.giovanna.trabalhoFinalGiovannaFranco.controle;

import br.com.giovanna.trabalhoFinalGiovannaFranco.DAO.DAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.fabrica.Conexao;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Acomodacao;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Acompanhante;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Entrada;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Funcionario;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Hospede;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EntradaDAO implements DAO<Entrada> {

    @Override
    public int inserir(Entrada e) {
        String sql = "INSERT INTO entrada (dataChegada,dataSaida,idAcomodacao,idHospede,idFuncionario) VALUES (?,?,?,?,?);";
        int idEntrada = -1;
        
        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setDate(1, new Date(e.getDataChegada().getTime()));
            ps.setDate(2, new Date(e.getDataSaida().getTime()));
            ps.setInt(3, e.getAcomodacao().getId());
            ps.setInt(4, e.getHospede().getId());
            ps.setInt(5, e.getFuncionario().getId());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    idEntrada = rs.getInt(1);
                }
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        // INSERE ACOMPANHANTES DA ENTRADA PREVIAMENTE CADASTRADA
        sql = "INSERT INTO acompanhante_entrada (idAcompanhante,idEntrada) VALUES(?,?)";
        
        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            for (Acompanhante a : e.getAcompanhantes()) {
                ps.setInt(1, new AcompanhanteDAO().inserir(a));
                ps.setInt(2, idEntrada);
                ps.addBatch();
            }
            ps.executeBatch();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        return idEntrada;
    }

    @Override
    public void alterar(Entrada e) {
        String sql = "UPDATE entrada SET dataChegada=?,dataSaida=?,idAcomodacao=?,idHospede=?,idFuncionario=? WHERE idEntrada=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setDate(1, new Date(e.getDataChegada().getTime()));
            ps.setDate(2, new Date(e.getDataSaida().getTime()));
            ps.setInt(3, e.getAcomodacao().getId());
            ps.setInt(4, e.getHospede().getId());
            ps.setInt(5, e.getFuncionario().getId());
            ps.setInt(6, e.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM entrada WHERE idEntrada=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Entrada> listarTodos() {
        List<Entrada> entradas = null;
        String sql = "SELECT * FROM entrada;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            entradas = new ArrayList<>();
            Hospede h;
            Acomodacao a;
            Funcionario f;

            while (rs.next()) {
                Entrada entrada = new Entrada();

                entrada.setId(rs.getInt("idEntrada"));
                entrada.setDataChegada(new java.util.Date(rs.getDate("dataChegada").getTime()));
                entrada.setDataSaida(new java.util.Date(rs.getDate("dataSaida").getTime()));

                entrada.setAcompanhantes(new AcompanhanteDAO().getListaEntrada(rs.getInt("idEntrada")));

                a = new AcomodacaoDAO().buscar(rs.getInt("idAcomodacao"));
                entrada.setAcomodacao(a);
                
                f = new FuncionarioDAO().buscar(rs.getInt("idFuncionario"));
                entrada.setFuncionario(f);

                h = new HospedeDAO().buscar(rs.getInt("idHospede"));
                entrada.setHospede(h);

                entradas.add(entrada);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entradas;
    }

    @Override
    public Entrada buscar(int id) {
        Entrada entrada = null;
        String sql = "SELECT * FROM entrada;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            Hospede h;
            Acomodacao a;
            Funcionario f;

            while (rs.next()) {
                entrada = new Entrada();

                entrada.setId(rs.getInt("idEntrada"));
                entrada.setDataChegada(new java.util.Date(rs.getDate("dataChegada").getTime()));
                entrada.setDataSaida(new java.util.Date(rs.getDate("dataSaida").getTime()));

                entrada.setAcompanhantes(new AcompanhanteDAO().getListaEntrada(rs.getInt("idEntrada")));

                f = new FuncionarioDAO().buscar(rs.getInt("id"));
                entrada.setFuncionario(f);

                h = new HospedeDAO().buscar(rs.getInt("id"));
                entrada.setHospede(h);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entrada;
    }

}
