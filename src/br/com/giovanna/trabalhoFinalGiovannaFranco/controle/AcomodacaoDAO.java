package br.com.giovanna.trabalhoFinalGiovannaFranco.controle;

import br.com.giovanna.trabalhoFinalGiovannaFranco.DAO.DAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.fabrica.Conexao;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Acomodacao;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.TipoAcomodacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AcomodacaoDAO implements DAO<Acomodacao> {

    @Override
    public int inserir(Acomodacao a) {
        String sql = "INSERT INTO acomodacao (nroAcomodacao,andar,idTipoAcomodacao) VALUES (?,?,?);";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, a.getNumero());
            ps.setInt(2, a.getAndar());
            ps.setInt(3, a.getTipoAcomodacao().getId());

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
    public void alterar(Acomodacao a) {
        String sql = "UPDATE acomodacao SET nroAcomodacao=?,andar=?,idTipoAcomodacao=? WHERE idAcomodacao=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, a.getNumero());
            ps.setInt(2, a.getAndar());
            ps.setInt(3, a.getTipoAcomodacao().getId());
            ps.setInt(4, a.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM acomodacao WHERE idAcomodacao=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Acomodacao> listarTodos() {
        List<Acomodacao> acomodacoes = null;
        String sql = "SELECT * FROM acomodacao;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            acomodacoes = new ArrayList<>();
            TipoAcomodacao tipoAcomodacao;

            while (rs.next()) {
                Acomodacao acomodacao = new Acomodacao();

                acomodacao.setId(rs.getInt("idAcomodacao"));
                acomodacao.setAndar(rs.getInt("andar"));
                acomodacao.setNumero(rs.getInt("nroAcomodacao"));

                tipoAcomodacao = new TipoAcomodacaoDAO().buscar(rs.getInt("idTipoAcomodacao"));
                acomodacao.setTipoAcomodacao(tipoAcomodacao);

                acomodacoes.add(acomodacao);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return acomodacoes;
    }

    @Override
    public Acomodacao buscar(int id) {
        Acomodacao acomodacao = null;
        String sql = "SELECT * FROM acomodacao WHERE idAcomodacao=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    acomodacao = new Acomodacao();
                    TipoAcomodacao tipoAcomodacao;
                    acomodacao.setId(rs.getInt("idAcomodacao"));
                    acomodacao.setAndar(rs.getInt("andar"));
                    acomodacao.setNumero(rs.getInt("nroAcomodacao"));

                    tipoAcomodacao = new TipoAcomodacaoDAO().buscar(rs.getInt("idTipoAcomodacao"));
                    acomodacao.setTipoAcomodacao(tipoAcomodacao);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return acomodacao;
    }
    
     public List<Acomodacao> buscarPorTipoAcomodacao(int codTipo) {
        List<Acomodacao> acomodacoes = null;
        String sql = "SELECT * FROM acomodacao where idTipoAcomodacao =?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            ps.setInt(1, codTipo);
            acomodacoes = new ArrayList<>();
            TipoAcomodacao tipoAcomodacao;

            while (rs.next()) {
                Acomodacao acomodacao = new Acomodacao();

                acomodacao.setId(rs.getInt("idAcomodacao"));
                acomodacao.setAndar(rs.getInt("andar"));
                acomodacao.setNumero(rs.getInt("nroAcomodacao"));

                tipoAcomodacao = new TipoAcomodacaoDAO().buscar(rs.getInt("idTipoAcomodacao"));
                acomodacao.setTipoAcomodacao(tipoAcomodacao);

                acomodacoes.add(acomodacao);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return acomodacoes;
    }
}
