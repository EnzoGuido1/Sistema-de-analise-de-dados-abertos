package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.model.LegislaturaSenado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LegislaturaSenadoDAO extends GenericDAO<LegislaturaSenado, Short> {
    public LegislaturaSenadoDAO(Connection connection) {
        super(connection);
    }
    @Override
    public List<LegislaturaSenado> selectAll() throws SQLException {
        ResultSet result;
        String query = "SELECT * FROM legislatura";
        ArrayList<LegislaturaSenado> entities = new ArrayList<LegislaturaSenado>();

        PreparedStatement ps = connection.prepareStatement(query);
        result = ps.executeQuery();

        while (result.next()) {
            LegislaturaSenado l = new LegislaturaSenado();
            l.setNum(result.getShort("num"));
            entities.add(l);
        }
        result.close();
        ps.close();

        return entities;
    }
    @Override
    public LegislaturaSenado selectByPrimaryKey(Short key) throws SQLException {
        String query = "SELECT * FROM legislatura WHERE num = ?";
        ResultSet result;
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setShort(1, key);
        result = ps.executeQuery();


        LegislaturaSenado l = new LegislaturaSenado();
        if (result.next()) {
            l.setNum(result.getShort("num"));
        }
        result.close();
        ps.close();

        return l;
    }
    @Override
    public void insert(LegislaturaSenado entity) throws SQLException {
        String query = "INSERT INTO legislatura (num) VALUES (?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setShort(1, entity.getNum());
        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void update(LegislaturaSenado entity) throws SQLException {}
    @Override
    public void delete(Short primaryKey) throws SQLException {
        String query = "DELETE FROM legislatura WHERE num = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setShort(1, primaryKey);
        ps.executeUpdate();
        ps.close();
    }
}
