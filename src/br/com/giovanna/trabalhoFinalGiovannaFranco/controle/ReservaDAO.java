package br.com.giovanna.trabalhoFinalGiovannaFranco.controle;

import br.com.giovanna.trabalhoFinalGiovannaFranco.DAO.DAO;
import br.com.giovanna.trabalhoFinalGiovannaFranco.fabrica.Conexao;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Acompanhante;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Funcionario;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Hospede;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.Reserva;
import br.com.giovanna.trabalhoFinalGiovannaFranco.modelo.TipoAcomodacao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO implements DAO<Reserva> {

    @Override
    public int inserir(Reserva r) {
        String sql = "INSERT INTO RESERVA (dataChegada,dataSaida,taxaMulta,idTipoAcomodacao,idHospede,idFuncionario) VALUES (?,?,?,?,?,?);";
        int idReserva = -1;
        
        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setDate(1, new Date(r.getDataChegada().getTime()));
            ps.setDate(2, new Date(r.getDataSaida().getTime()));
            ps.setDouble(3,r.getTaxaMulta());
            ps.setInt(4, r.getTipoAcomodacao().getId());
            ps.setInt(5, r.getHospede().getId());
            ps.setInt(6, r.getFuncionario().getId());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    idReserva = rs.getInt(1);
                }
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        // INSERE ACOMPANHANTES DA RESERVA 
        sql = "INSERT INTO reserva_acompanhante (idAcompanhante,idReserva) VALUES(?,?)";
        
        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            for (Acompanhante a : r.getAcompanhantes()) {
                ps.setInt(1, new AcompanhanteDAO().inserir(a));
                ps.setInt(2, idReserva);
                ps.addBatch();
            }
            ps.executeBatch();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        return idReserva;
    }

    @Override
    public void alterar(Reserva r) {
        String sql = "UPDATE reserva SET dataChegada=?,dataSaida=?,taxaMulta =?,idTipoAcomodacao=?,idHospede=?,idFuncionario=? WHERE idReserva=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setDate(1, new Date(r.getDataChegada().getTime()));
            ps.setDate(2, new Date(r.getDataSaida().getTime()));
            ps.setDouble(3, r.getTaxaMulta());
            ps.setInt(4, r.getTipoAcomodacao().getId());
            ps.setInt(5, r.getHospede().getId());
            ps.setInt(6, r.getFuncionario().getId());
            ps.setInt(7, r.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Reserva> listarTodos() {
        List<Reserva> reservas = null;
        String sql = "SELECT * FROM reserva;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            reservas = new ArrayList<>();
            Hospede h;
            TipoAcomodacao ta;
            Funcionario f;

            while (rs.next()) {
                Reserva r = new Reserva();

                r.setId(rs.getInt("idReserva"));
                r.setDataChegada(new java.util.Date(rs.getDate("dataChegada").getTime()));
                r.setDataSaida(new java.util.Date(rs.getDate("dataSaida").getTime()));
                r.setTaxaMulta(Double.parseDouble("taxaMulta"));
                r.setAcompanhantes(new AcompanhanteDAO().getListaReserva(rs.getInt("idReserva")));

                ta = new TipoAcomodacaoDAO().buscar(rs.getInt("idTipoAcomodacao"));
                r.setTipoAcomodacao(ta);
                
                f = new FuncionarioDAO().buscar(rs.getInt("idFuncionario"));
                r.setFuncionario(f);

                h = new HospedeDAO().buscar(rs.getInt("idHospede"));
                r.setHospede(h);

                reservas.add(r);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reservas;
    }
    
    @Override
    public void excluir(int id) {
        String sql = "UPDATE reserva SET ativa = 0 WHERE idReserva=?;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

     @Override
    public Reserva buscar(int id) {
        Reserva reserva = null;
        String sql = "SELECT * FROM reserva;";

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            Hospede h;
            TipoAcomodacao ta;
            Funcionario f;

            while (rs.next()) {
                reserva = new Reserva();

                reserva.setId(rs.getInt("idEntrada"));
                reserva.setDataChegada(new java.util.Date(rs.getDate("dataChegada").getTime()));
                reserva.setDataSaida(new java.util.Date(rs.getDate("dataSaida").getTime()));
                reserva.setTaxaMulta(rs.getInt("taxaMulta"));

                reserva.setAcompanhantes(new AcompanhanteDAO().getListaReserva(rs.getInt("idReserva")));

                f = new FuncionarioDAO().buscar(rs.getInt("idFuncionario"));
                reserva.setFuncionario(f);

                h = new HospedeDAO().buscar(rs.getInt("idHospede"));
                reserva.setHospede(h);
                
                ta = new TipoAcomodacaoDAO().buscar(rs.getInt("idTipoAcomodacao"));
                reserva.setTipoAcomodacao(ta);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reserva;
    }
    
     public Reserva buscarPorNome(String nome) {
        Reserva reserva = null;
        String sql = "select r.idReserva,r.dataChegada,r.dataSaida,r.taxaMulta,r.idTipoAcomodacao,r.idFuncionario,r.ativa,r.idHospede from reserva as r, hospede as h where r.idHospede = h.idHospede and h.nome = ? and r.ativa = 1;"; 

        try (Connection con = new Conexao().criarConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nome);
            
            try(ResultSet rs  = ps.executeQuery()){
                

                Hospede h;
                TipoAcomodacao ta;
                Funcionario f;

                if (rs.next()) {

                    reserva = new Reserva();

                    reserva.setId(rs.getInt("idReserva"));
                    reserva.setDataChegada(new java.util.Date(rs.getDate("dataChegada").getTime()));
                    reserva.setDataSaida(new java.util.Date(rs.getDate("dataSaida").getTime()));
                    reserva.setTaxaMulta(rs.getInt("taxaMulta"));
                    reserva.setAcompanhantes(new AcompanhanteDAO().getListaReserva(rs.getInt("idReserva")));

                    f = new FuncionarioDAO().buscar(rs.getInt("idFuncionario"));
                    reserva.setFuncionario(f);

                    h = new HospedeDAO().buscar(rs.getInt("idHospede"));
                    reserva.setHospede(h);

                    ta = new TipoAcomodacaoDAO().buscar(rs.getInt("idTipoAcomodacao"));
                    reserva.setTipoAcomodacao(ta);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reserva;
    }
}
