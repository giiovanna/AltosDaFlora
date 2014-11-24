package br.com.giovanna.trabalhoFinalGiovannaFranco.controle;

import br.com.giovanna.trabalhoFinalGiovannaFranco.DAO.DAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.fabrica.Conexao;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.CategoriaItem;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Consumo;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.ItemConsumo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemConsumoDAO implements DAO<ItemConsumo> {

    @Override
    public int inserir(ItemConsumo ic) {
        String sql = "INSERT INTO itemconsumo (descricao,quantidade,valorUnitario,idCategoria,idConsumo) VALUES (?,?,?,?,?);";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, ic.getDescricao());
            ps.setInt(2, ic.getQuantidade());
            ps.setDouble(3, ic.getValorUnitario());
            ps.setInt(4, ic.getCategoria().getCodCategoria());
            ps.setInt(5, ic.getConsumo().getId());

            ps.executeUpdate();

            int id = -1;

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            }

            return id;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void alterar(ItemConsumo ic) {
        String sql = "UPDATE itemconsumo SET descricao=?,quantidade=?,valorUnitario=?,idCategoria=?,idConsumo=? WHERE idItemConsumo=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, ic.getDescricao());
            ps.setInt(2, ic.getQuantidade());
            ps.setDouble(3, ic.getValorUnitario());
            ps.setInt(4, ic.getCategoria().getCodCategoria());
            ps.setInt(5, ic.getConsumo().getId());
            ps.setInt(6, ic.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM itemconsumo WHERE idItemConsumo=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ItemConsumo> listarTodos() {
        return null;
    }

    @Override
    public ItemConsumo buscar(int id) {
        ItemConsumo itemConsumo = null;
        String sql = "SELECT * FROM itemconsumo WHERE idconsumo;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                Consumo c;
                CategoriaItem ci;

                if (rs.next()) {
                    itemConsumo = new ItemConsumo();
                    itemConsumo.setId(rs.getInt("idItemConsumo"));

                    ci = new CategoriaItemDAO().buscar(rs.getInt("idcategoria"));
                    itemConsumo.setCategoria(ci);

                    c = new ConsumoDAO().buscar(rs.getInt("idconsumo"));
                    itemConsumo.setConsumo(null);

                    itemConsumo.setQuantidade(rs.getInt("quantidade"));
                    itemConsumo.setValorUnitario(rs.getDouble("valorUnitario"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemConsumo;
    }

    public List<ItemConsumo> getItensConsumo(int idConsumo) {
        List<ItemConsumo> itensConsumo = null;
        String sql = "SELECT * FROM itemconsumo WHERE idconsumo=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idConsumo);

            try (ResultSet rs = ps.executeQuery()) {
                itensConsumo = new ArrayList<>();
                Consumo c;
                CategoriaItem ci;
                while (rs.next()) {
                    ItemConsumo item = new ItemConsumo();
                    item.setId(rs.getInt("idItemConsumo"));

                    ci = new CategoriaItemDAO().buscar(rs.getInt("idcategoria"));
                    item.setCategoria(ci);

                    c = new ConsumoDAO().buscar(rs.getInt("idconsumo"));
                    item.setConsumo(null);

                    item.setQuantidade(rs.getInt("quantidade"));
                    item.setValorUnitario(rs.getDouble("valorUnitario"));

                    itensConsumo.add(item);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return itensConsumo;
    }
}
