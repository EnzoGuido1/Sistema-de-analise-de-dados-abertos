package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.model.Proposicao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProposicaoDAO extends GenericDAO<Proposicao, Long> {
    public ProposicaoDAO(Connection connection) {
        super(connection);
    }
    @Override
    public List<Proposicao> selectAll() throws SQLException {
        ResultSet result;
        String query = "SELECT * FROM proposicao";
        ArrayList<Proposicao> entities = new ArrayList<Proposicao>();

        PreparedStatement ps = connection.prepareStatement(query);
        result = ps.executeQuery();
        while(result.next() ) {
            Proposicao p = new Proposicao();
            p.setId(result.getLong("id"));
            p.setDescricao(result.getString("descricao"));
            p.setEmenta(result.getString("ementa"));
            p.setData(result.getDate("data"));

            entities.add(p);
        }
        result.close();
        ps.close();

        return entities;
    }
    @Override
    public Proposicao selectByPrimaryKey(Long primaryKey) throws SQLException {
        ResultSet result;
        Proposicao p = new Proposicao();
        String query = "SELECT * FROM proposicao WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, primaryKey);
        result = ps.executeQuery();

        if (result.next()) {
            p.setId(result.getLong("id"));
            p.setDescricao(result.getString("descricao"));
            p.setEmenta(result.getString("ementa"));
            p.setData(result.getDate("data"));
        }
        result.close();
        ps.close();

        return p;
    }
    @Override
    public void insert(Proposicao p) throws SQLException {
        String query = "INSERT INTO proposicao (id, descricao, ementa, data) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, p.getId());
        ps.setString(2, p.getDescricao());
        ps.setString(3, p.getEmenta());
        ps.setDate(4, p.getData());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void update(Proposicao p) throws SQLException {
        String query = "UPDATE proposicao SET descricao = ?, ementa = ?, data = ? WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, p.getDescricao());
        ps.setString(2, p.getEmenta());
        ps.setDate(3, p.getData());
        ps.setLong(4, p.getId());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void delete(Long primaryKey) throws SQLException {
        String query = "DELETE FROM proposicao WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, primaryKey);

        ps.executeUpdate();
        ps.close();
    }
}
