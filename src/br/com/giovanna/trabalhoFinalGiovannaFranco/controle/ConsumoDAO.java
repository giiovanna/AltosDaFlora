package br.com.giovanna.trabalhoFinalGiovannaFranco.controle;

import br.com.giovanna.trabalhoFinalGiovannaFranco.DAO.DAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.fabrica.Conexao;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Consumo;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Entrada;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.ItemConsumo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsumoDAO implements DAO<Consumo> {

    @Override
    public int inserir(Consumo c) {
        String sql = "INSERT INTO consumo (data,valor,idEntrada) VALUES (?,?,?);";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setDate(1, new Date(c.getData().getTime()));
            ps.setDouble(2, c.getValor());
            ps.setInt(3, c.getEntrada().getId());

            ps.executeUpdate();

            int id = -1;

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            }

            c.setId(id); // adiciona o id ao objeto consumo inserido
            for (ItemConsumo item : c.getItens()) {
                item.setConsumo(c);
                new ItemConsumoDAO().inserir(item);
            }

            return id;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void alterar(Consumo c) {
        String sql = "UPDATE consumo SET data=?,valor=?,idEntrada=? WHERE idConsumo=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setDate(1, new Date(c.getData().getTime()));
            ps.setDouble(2, c.getValor());
            ps.setInt(3, c.getEntrada().getId());
            ps.setInt(4, c.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM consumo WHERE idConsumo=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Consumo> listarTodos() {
        List<Consumo> consumos = null;
        String sql = "SELECT * FROM consumo;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            consumos = new ArrayList<>();
            Entrada e;

            while (rs.next()) {
                Consumo consumo = new Consumo();
                consumo.setId(rs.getInt("idConsumo"));
                consumo.setData(new java.util.Date(rs.getDate("data").getTime()));

                e = new EntradaDAO().buscar(rs.getInt("idEntrada"));
                consumo.setEntrada(e);

                consumo.setItens(new ItemConsumoDAO().getItensConsumo(rs.getInt("idConsumo")));
                consumo.setValor(rs.getDouble("valor"));

                consumos.add(consumo);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return consumos;
    }

    @Override
    public Consumo buscar(int id) {
        Consumo consumo = null;
        String sql = "SELECT * FROM consumo WHERE idConsumo=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                Entrada e;

                if (rs.next()) {
                    consumo = new Consumo();
                    consumo.setId(rs.getInt("idConsumo"));
                    consumo.setData(new java.util.Date(rs.getDate("data").getTime()));

                    e = new EntradaDAO().buscar(rs.getInt("idEntrada"));
                    consumo.setEntrada(e);

                    consumo.setItens(new ItemConsumoDAO().getItensConsumo(rs.getInt("idConsumo")));
                    consumo.setValor(rs.getDouble("valor"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return consumo;
    }

    public double getValorConsumoEntrada(int idEntrada) {
        double valorConsumo = 0;
        String sql = "SELECT SUM(valor) AS total FROM consumo WHERE idEntrada=?";
        
        try (Connection con = new Conexao().criarConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
        
            ps.setInt(1, idEntrada);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next())
                    valorConsumo = rs.getDouble("total");
            }
            
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        
        return valorConsumo;
    }
}
