package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.model.Votacao;
import org.postgresql.util.PGTimestamp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VotacaoDAO extends GenericDAO<Votacao, String> {
    public VotacaoDAO(Connection connection) {
        super(connection);
    }
    @Override
    public List<Votacao> selectAll() throws SQLException {
        ResultSet result;
        String query = "SELECT * FROM votacao";
        ArrayList<Votacao> entities = new ArrayList<Votacao>();

        PreparedStatement ps = connection.prepareStatement(query);
        result = ps.executeQuery();
        while(result.next() ){
            Votacao v = new Votacao();
            v.setId(result.getString("id"));
            v.setDescricao(result.getString("descricao"));
            v.setOrgao(result.getString("orgao"));
            v.setAprovacao(result.getBoolean("aprovacao"));
            v.setVotos_s(result.getShort("votos_s"));
            v.setVotos_n(result.getShort("votos_n"));
            v.setDt_dia(result.getDate("dt_dia"));
            v.setDt_hora(result.getTimestamp("dt_hora"));
        }
        result.close();
        ps.close();

        return entities;
    }
    @Override
    public Votacao selectByPrimaryKey(String primaryKey) throws SQLException {
        ResultSet result;
        String query = "SELECT * FROM votacao WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, primaryKey);
        result = ps.executeQuery();

        Votacao v = new Votacao();
        if (result.next()) {
            v.setId(result.getString("id"));
            v.setDescricao(result.getString("descricao"));
            v.setOrgao(result.getString("orgao"));
            v.setAprovacao(result.getBoolean("aprovacao"));
            v.setVotos_s(result.getShort("votos_s"));
            v.setVotos_n(result.getShort("votos_n"));
            v.setDt_dia(result.getDate("dt_dia"));
            v.setDt_hora(result.getTimestamp("dt_hora"));
        }
        result.close();
        ps.close();

        return v;
    }
    @Override
    public void insert(Votacao v) throws SQLException {
        String query = "INSERT INTO votacao (id, descricao, orgao, aprovacao, votos_s, votos_n, dt_dia, dt_hora) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, v.getId());
        ps.setString(2, v.getDescricao());
        ps.setString(3, v.getOrgao());
        ps.setBoolean(4, v.getAprovacao());
        ps.setShort(5, v.getVotos_s());
        ps.setShort(6, v.getVotos_n());
        ps.setDate(7, v.getDt_dia());
        ps.setTimestamp(8, v.getDt_hora());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void update(Votacao v) throws SQLException {
        String query = "UPDATE votacao SET descricao = ?, orgao = ?, aprovacao = ?, votos_s = ?, votos_n = ?, dt_dia = ?, dt_hora = ? WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, v.getDescricao());
        ps.setString(2, v.getOrgao());
        ps.setBoolean(3, v.getAprovacao());
        ps.setShort(4, v.getVotos_s());
        ps.setShort(5, v.getVotos_n());
        ps.setDate(6, v.getDt_dia());
        ps.setTimestamp(7, v.getDt_hora());
        ps.setString(8, v.getId());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void delete(String primaryKey) throws SQLException {
        String query = "DELETE FROM votacao WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, primaryKey);

        ps.executeUpdate();
        ps.close();
    }
}
