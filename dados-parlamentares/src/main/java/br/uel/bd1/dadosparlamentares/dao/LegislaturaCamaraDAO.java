package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.model.LegislaturaCamara;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LegislaturaCamaraDAO extends GenericDAO<LegislaturaCamara, Short> {
    public LegislaturaCamaraDAO(Connection connection) {
        super(connection);
    }
    @Override
    public List<LegislaturaCamara> selectAll() throws SQLException {
        ResultSet result;
        String query = "SELECT * FROM leg_camara";
        ArrayList<LegislaturaCamara> entities = new ArrayList<LegislaturaCamara>();

        PreparedStatement ps = connection.prepareStatement(query);
        result = ps.executeQuery();

        while (result.next()) {
            LegislaturaCamara l = new LegislaturaCamara();
            l.setNum(result.getShort("num"));
            entities.add(l);
        }
        result.close();
        ps.close();

        return entities;
    }
    @Override
    public LegislaturaCamara selectByPrimaryKey(Short key) throws SQLException {
        String query = "SELECT * FROM leg_camara WHERE num = ?";
        ResultSet result;
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setShort(1, key);
        result = ps.executeQuery();


        LegislaturaCamara l = new LegislaturaCamara();
        if (result.next()) {
            l.setNum(result.getShort("num"));
        }
        result.close();
        ps.close();

        return l;
    }
    @Override
    public void insert(LegislaturaCamara entity) throws SQLException {
        String query = "INSERT INTO leg_camara (num) VALUES (?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setShort(1, entity.getNum());
        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void update(LegislaturaCamara entity) throws SQLException {}
    @Override
    public void delete(Short primaryKey) throws SQLException {
        String query = "DELETE FROM leg_camara WHERE num = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setShort(1, primaryKey);
        ps.executeUpdate();
        ps.close();
    }
}
