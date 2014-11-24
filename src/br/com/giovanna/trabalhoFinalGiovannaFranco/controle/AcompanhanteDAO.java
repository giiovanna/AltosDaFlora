package br.com.giovanna.trabalhoFinalGiovannaFranco.controle;

import br.com.giovanna.trabalhoFinalGiovannaFranco.DAO.DAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.fabrica.Conexao;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Acompanhante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AcompanhanteDAO implements DAO<Acompanhante> {

    @Override
    public int inserir(Acompanhante a) {
        String sql = "INSERT INTO acompanhante (nome,idade) VALUES (?,?);";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, a.getNome());
            ps.setInt(2, a.getIdade());

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
    public void alterar(Acompanhante a) {
        String sql = "UPDATE acompanhante SET nome=?,idade=? WHERE idAcompanhante=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, a.getNome());
            ps.setInt(2, a.getIdade());
            ps.setInt(3, a.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM acompanhante WHERE idAcompanhante=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Acompanhante> getListaEntrada(int idEntrada) {
        List<Acompanhante> acompanhantes = null;
        String sql = "SELECT * FROM acompanhante_entrada WHERE idEntrada=?";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idEntrada);

            try (ResultSet rs = ps.executeQuery()) {
                acompanhantes = new ArrayList<>();

                while (rs.next()) {
                    acompanhantes.add(buscar(rs.getInt("idAcompanhante")));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return acompanhantes;
    }
    
    public List<Acompanhante> getListaReserva(int idReserva) {
        List<Acompanhante> acompanhantes = null;
        String sql = "SELECT * FROM reserva_acompanhante WHERE idEntrada=?";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idReserva);

            try (ResultSet rs = ps.executeQuery()) {
                acompanhantes = new ArrayList<>();

                while (rs.next()) {
                    acompanhantes.add(buscar(rs.getInt("idAcompanhante")));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return acompanhantes;
    }

    @Override
    public Acompanhante buscar(int id) {
        Acompanhante acompanhante = null;
        String sql = "SELECT * FROM acompanhante WHERE idAcompanhante=?";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
              
                if (rs.next()) {
                    acompanhante = new Acompanhante();
                    acompanhante.setIdade(rs.getInt("idade"));
                    acompanhante.setNome(rs.getString("nome"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return acompanhante;
    }
    
    @Override
    public List<Acompanhante> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
