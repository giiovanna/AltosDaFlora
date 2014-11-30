package br.com.giovanna.trabalhoFinalGiovannaFranco.controle;

import br.com.giovanna.trabalhoFinalGiovannaFranco.DAO.DAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.fabrica.Conexao;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Entrada;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Saida;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SaidaDAO implements DAO<Saida> {

    @Override
    public int inserir(Saida s) {
        String sql = "INSERT INTO saida (data,numeroDiarias,totalDiarias,totalConsumo,idEntrada,tipoPagamento) VALUES (?,?,?,?,?,?);";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setDate(1, new Date(s.getData().getTime()));
            ps.setInt(2, s.getNumeroDiarias());
            ps.setDouble(3, s.getTotalDiarias());
            ps.setDouble(4, s.getTotalConsumo());
            ps.setInt(5, s.getEntrada().getId());
            ps.setString(6,s.getTipoPagamento());

            ps.executeUpdate();

            int id = -1;

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            }
            new EntradaDAO().excluir(s.getEntrada().getId());
            s.getEntrada().getAcomodacao().setDisponivel(true);
            new AcomodacaoDAO().alterar(s.getEntrada().getAcomodacao());
            
            return id;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void alterar(Saida s) {
        String sql = "UPDATE saida SET data=?,numeroDiarias=?,totalDiarias=?,totalConsumo=?,idEntrada=?,tipoPagamento=? WHERE idSaida=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setDate(1, new Date(s.getData().getTime()));
            ps.setInt(2, s.getNumeroDiarias());
            ps.setDouble(3, s.getTotalDiarias());
            ps.setDouble(4, s.getTotalConsumo());
            ps.setInt(5, s.getEntrada().getId());
            ps.setString(6,s.getTipoPagamento());
            ps.setInt(7, s.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM saida WHERE idSaida=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Saida> listarTodos() {
        List<Saida> saidas = null;
        String sql = "SELECT * FROM saida;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            saidas = new ArrayList<>();
            Entrada e;

            while (rs.next()) {
                Saida saida = new Saida();

                saida.setId(rs.getInt("idSaida"));
                saida.setNumeroDiarias(rs.getInt("numeroDiarias"));
                saida.setTotalConsumo(rs.getInt("totalConsumo"));
                saida.setTotalDiarias(rs.getInt("totalDiarias"));
                saida.setData(new java.util.Date(rs.getDate("data").getTime()));

                e = new EntradaDAO().buscar(rs.getInt("idEntrada"));
                saida.setEntrada(e);

                saidas.add(saida);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return saidas;
    }

    @Override
    public Saida buscar(int id) {
        Saida saida = null;
        String sql = "SELECT * FROM acomodacao WHERE idAcomodacao=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    saida = new Saida();
                    Entrada e;
                    saida.setId(rs.getInt("idSaida"));
                    saida.setNumeroDiarias(rs.getInt("numeroDiarias"));
                    saida.setTotalConsumo(rs.getInt("totalConsumo"));
                    saida.setTotalDiarias(rs.getInt("totalDiarias"));
                    saida.setData(new java.util.Date(rs.getDate("data").getTime()));
                    saida.setTipoPagamento(rs.getString("tipoPagamento"));

                    e = new EntradaDAO().buscar(rs.getInt("idEntrada"));
                    saida.setEntrada(e);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return saida;
    }

}
