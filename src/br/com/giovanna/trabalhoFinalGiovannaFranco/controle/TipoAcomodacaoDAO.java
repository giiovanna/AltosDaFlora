package br.com.giovanna.trabalhoFinalGiovannaFranco.controle;

import br.com.giovanna.trabalhoFinalGiovannaFranco.DAO.DAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.fabrica.Conexao;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.TipoAcomodacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipoAcomodacaoDAO implements DAO<TipoAcomodacao> {

    @Override
    public int inserir(TipoAcomodacao ta) {
        String sql = "INSERT INTO tipoacomodacao (descricao,qtdeAcomodacoes,precoDiaria,nroDeAdulto,nroDeCrianca) VALUES (?,?,?,?,?);";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, ta.getDescricao());
            ps.setInt(2, ta.getQtdeAcomodacoes());
            ps.setDouble(3, ta.getPrecoDiaria());
            ps.setInt(4, ta.getNroAdulto());
            ps.setInt(5, ta.getNroCrianca());

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
    public void alterar(TipoAcomodacao ta) {
        String sql = "UPDATE tipoacomodacao SET descricao=?,qtdeAcomodacoes=?,precoDiaria=?,nroDeAdulto=?,nroDeCrianca=? WHERE idTipoAcomodacao=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, ta.getDescricao());
            ps.setInt(2, ta.getQtdeAcomodacoes());
            ps.setDouble(3, ta.getPrecoDiaria());
            ps.setInt(4, ta.getNroAdulto());
            ps.setInt(5, ta.getNroCrianca());
            ps.setInt(6, ta.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM tipoacomodacao WHERE idTipoAcomodacao=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TipoAcomodacao> listarTodos() {
        List<TipoAcomodacao> tipos = null;
        String sql = "SELECT * FROM tipoacomodacao;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            tipos = new ArrayList<>();

            while (rs.next()) {
                TipoAcomodacao ta = new TipoAcomodacao();

                ta.setId(rs.getInt("idTipoAcomodacao"));
                ta.setDescricao(rs.getString("descricao"));
                ta.setNroAdulto(rs.getInt("nroDeAdulto"));
                ta.setNroCrianca(rs.getInt("nroDeCrianca"));
                ta.setPrecoDiaria(rs.getDouble("precoDiaria"));
                ta.setQtdeAcomodacoes(rs.getInt("qtdeAcomodacoes"));

                tipos.add(ta);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tipos;
    }

    @Override
    public TipoAcomodacao buscar(int id) {
        TipoAcomodacao ta = null;
        String sql = "SELECT * FROM tipoacomodacao WHERE idTipoAcomodacao=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ta = new TipoAcomodacao();

                    ta.setId(rs.getInt("idTipoAcomodacao"));
                    ta.setDescricao(rs.getString("descricao"));
                    ta.setNroAdulto(rs.getInt("nroDeAdulto"));
                    ta.setNroCrianca(rs.getInt("nroDeCrianca"));
                    ta.setPrecoDiaria(rs.getDouble("precoDiaria"));
                    ta.setQtdeAcomodacoes(rs.getInt("qtdeAcomodacoes"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ta;
    }

}
