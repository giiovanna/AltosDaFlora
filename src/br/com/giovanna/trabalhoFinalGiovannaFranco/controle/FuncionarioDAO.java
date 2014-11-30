package br.com.giovanna.trabalhoFinalGiovannaFranco.controle;

import br.com.giovanna.trabalhoFinalGiovannaFranco.DAO.DAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.fabrica.Conexao;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Funcionario;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDAO implements DAO<Funcionario> {

    @Override
    public int inserir(Funcionario f) {
        String sql = "INSERT INTO funcionario (nomeAcesso,senhaAcesso,nome,nivelAcesso) VALUES (?,?,?,?);";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, f.getNomeAcesso());
            ps.setString(2, criptografarSenha(f.getSenhaAcesso()));
            ps.setString(3, f.getNome());
            ps.setInt(4, f.getNivelAcesso());

            ps.executeUpdate();

            int id = -1;

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            }

            return id;

        } catch (SQLException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void alterar(Funcionario f) {
        String sql = "UPDATE funcionario SET nomeAcesso=?,senhaAcesso=?,nome=?,nivelAcesso=? WHERE idFuncionario=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, f.getNomeAcesso());
            ps.setString(2, criptografarSenha(f.getSenhaAcesso()));
            ps.setString(3, f.getNome());
            ps.setInt(4, f.getNivelAcesso());
            ps.setInt(5, f.getId());

            ps.executeUpdate();

        } catch (SQLException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "UPDATE funcionario SET ativo = 0 WHERE idFuncionario=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Funcionario> listarTodos() {
        List<Funcionario> funcionarios = null;
        String sql = "SELECT * FROM funcionario WHERE ativo = 1;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            funcionarios = new ArrayList<>();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setId(rs.getInt("idFuncionario"));
                funcionario.setNivelAcesso(rs.getInt("nivelAcesso"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setNomeAcesso(rs.getString("nomeAcesso"));
                funcionario.setSenhaAcesso(rs.getString("senhaAcesso"));

                funcionarios.add(funcionario);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return funcionarios;
    }

    @Override
    public Funcionario buscar(int id) {
        Funcionario funcionario = null;
        String sql = "SELECT * FROM funcionario WHERE idFuncionario=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    funcionario = new Funcionario();

                    funcionario.setId(rs.getInt("idFuncionario"));
                    funcionario.setNivelAcesso(rs.getInt("nivelAcesso"));
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setNomeAcesso(rs.getString("nomeAcesso"));
                    funcionario.setSenhaAcesso(rs.getString("senhaAcesso"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return funcionario;
    }

    public Funcionario buscar(String nome) {
        Funcionario funcionario = null;
        String sql = "SELECT * FROM funcionario WHERE nomeAcesso=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nome);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    funcionario = new Funcionario();

                    funcionario.setId(rs.getInt("idFuncionario"));
                    funcionario.setNivelAcesso(rs.getInt("nivelAcesso"));
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setNomeAcesso(rs.getString("nomeAcesso"));
                    funcionario.setSenhaAcesso(rs.getString("senhaAcesso"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return funcionario;
    }

    private String criptografarSenha(String senhaLimpa) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senhaLimpa.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }

        return hexString.toString();
    }

    public boolean comparaSenha(Funcionario f, String senhaLimpa) {
        String senha;
        
        if (f == null) {
            return false;
        }
        
        try {
            senha = criptografarSenha(senhaLimpa);
            return senha.equals(f.getSenhaAcesso());
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
