package br.com.giovanna.trabalhoFinalGiovannaFranco.controle;

import br.com.giovanna.trabalhoFinalGiovannaFranco.DAO.DAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.fabrica.Conexao;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.CategoriaItem;
import java.sql.*;
import java.util.*;

public class CategoriaItemDAO implements DAO<CategoriaItem> {

    @Override
    public int inserir(CategoriaItem ct) {
        String sql = "INSERT INTO categoria (descricao) VALUES (?);";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, ct.getDescricao());
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
    public void alterar(CategoriaItem ct) {
        String sql = "UPDATE categoria SET descricao =? WHERE idCategoria = ?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ct.getDescricao());
            ps.setInt(2, ct.getCodCategoria());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM categoria WHERE idCategoria = ?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CategoriaItem> listarTodos() {
        List<CategoriaItem> listaCategorias = null;
        String sql = "SELECT * FROM categoria;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            listaCategorias = new ArrayList<>();

            while (rs.next()) {
                CategoriaItem ct = new CategoriaItem();

                ct.setCodCategoria(rs.getInt("idCategoria"));
                ct.setDescricao(rs.getString("descricao"));

                listaCategorias.add(ct);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return listaCategorias;
    }

    @Override
    public CategoriaItem buscar(int id) {
        CategoriaItem categoria = null;
        String sql = "SELECT * FROM categoria WHERE idCategoria=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    categoria = new CategoriaItem();

                    categoria.setCodCategoria(rs.getInt("idCategoria"));
                    categoria.setDescricao(rs.getString("descricao"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return categoria;
    }
}
