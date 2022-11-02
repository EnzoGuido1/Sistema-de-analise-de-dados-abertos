package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.model.Legislatura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LegislaturaDAO extends GenericDAO<Legislatura, Short> {
    public LegislaturaDAO(Connection connection) {
        super(connection);
    }
    @Override
    public List<Legislatura> selectAll() throws SQLException {
        ResultSet result;
        String query = "SELECT * FROM legislatura";
        ArrayList<Legislatura> entities = new ArrayList<Legislatura>();

        PreparedStatement ps = connection.prepareStatement(query);
        result = ps.executeQuery();

        while (result.next()) {
            Legislatura l = new Legislatura();
            l.setNum(result.getShort("num"));
            l.setAno(result.getShort("ano"));
            l.setDt_inicio(result.getDate("dt_inicio"));
            l.setDt_fim(result.getDate("dt_fim"));

            entities.add(l);
        }
        result.close();
        ps.close();

        return entities;
    }
    @Override
    public Legislatura selectByPrimaryKey(Short key) throws SQLException {
        ResultSet result;
        Legislatura l = new Legislatura();
        String query = "SELECT * FROM legislatura WHERE num = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setShort(1, key);
        result = ps.executeQuery();

        if (result.next()) {
            l.setNum(result.getShort("num"));
            l.setAno(result.getShort("ano"));
            l.setDt_inicio(result.getDate("dt_inicio"));
            l.setDt_fim(result.getDate("dt_fim"));
        }
        result.close();
        ps.close();

        return l;
    }
    @Override
    public void insert(Legislatura entity) throws SQLException {
        String query = "INSERT INTO legislatura (num, ano, dt_inicio, dt_fim) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setShort(1, entity.getNum());
        ps.setShort(2, entity.getAno());
        ps.setDate(3, entity.getDt_inicio());
        ps.setDate(4, entity.getDt_fim());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void update(Legislatura entity) throws SQLException {
        String query = "UPDATE legislatura SET ano = ?, dt_inicio = ?, dt_fim = ? WHERE num = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setShort(1, entity.getAno());
        ps.setDate(2, entity.getDt_inicio());
        ps.setDate(3, entity.getDt_fim());
        ps.setShort(4, entity.getNum());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void delete(Short primaryKey) throws SQLException {
        String query = "DELETE FROM legislatura WHERE num = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, primaryKey);

        ps.executeUpdate();
        ps.close();
    }
}
