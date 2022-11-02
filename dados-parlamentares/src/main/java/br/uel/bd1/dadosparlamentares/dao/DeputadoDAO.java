package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.model.Deputado;
import br.uel.bd1.dadosparlamentares.model.Politico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeputadoDAO extends GenericDAO<Deputado, Long> {
    public DeputadoDAO(Connection connection) {
        super(connection);
    }
    @Override
    public List<Deputado> selectAll() throws SQLException {
        ResultSet result;
        ArrayList<Deputado> entities = new ArrayList<Deputado>();
        String query = "SELECT * FROM deputado ORDER BY cpf_id";

        PreparedStatement ps = connection.prepareStatement(query);
        result = ps.executeQuery();

        while(result.next() ) {
            Deputado d = new Deputado();
            d.setCpf_id(result.getLong("cpf_id"));
            d.setLeg_cam_num(result.getLong("leg_cam_num"));

            entities.add(d);
        }
        result.close();
        ps.close();

        return entities;
    }
    @Override
    public Deputado selectByPrimaryKey(Long primaryKey) throws SQLException {
        ResultSet result;
        Deputado d = new Deputado();
        String query = "SELECT * FROM deputado WHERE cpf_id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, primaryKey);
        result = ps.executeQuery();

        if(result.next() == false)
            return null;

        d.setCpf_id(result.getLong("cpf_id"));
        d.setLeg_cam_num(result.getLong("leg_cam_num"));

        result.close();
        ps.close();

        return d;
    }
    @Override
    public void insert(Deputado d) throws SQLException{
        String query = "INSERT INTO deputado (cpf_id, leg_cam_num) VALUES (?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, d.getCpf_id());
        ps.setLong(2, d.getLeg_cam_num());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void update(Deputado d) throws SQLException {
        String query = "UPDATE deputado SET leg_cam_num = ? WHERE cpf_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, d.getLeg_cam_num());
        ps.setLong(2, d.getCpf_id());
        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void delete(Long primaryKey) throws SQLException {
        String query = "DELETE FROM deputado WHERE cpf_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, primaryKey);
        ps.executeUpdate();
        ps.close();
    }
}
