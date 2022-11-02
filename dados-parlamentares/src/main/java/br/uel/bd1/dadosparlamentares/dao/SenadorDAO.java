package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.model.Senador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SenadorDAO extends GenericDAO<Senador, Long> {
    public SenadorDAO(Connection connection) {
        super(connection);
    }
    @Override
    public List<Senador> selectAll() throws SQLException {
        ResultSet result;
        ArrayList<Senador> entities = new ArrayList<Senador>();
        String query = "SELECT * FROM deputado ORDER BY cpf_id";

        PreparedStatement ps = connection.prepareStatement(query);
        result = ps.executeQuery();

        while(result.next() ) {
            Senador d = new Senador();
            d.setCpf_id(result.getLong("cpf_id"));
            d.setNum_leg_sen(result.getLong("num_leg_sen"));

            entities.add(d);
        }
        result.close();
        ps.close();

        return entities;
    }
    @Override
    public Senador selectByPrimaryKey(Long primaryKey) throws SQLException {
        ResultSet result;
        Senador d = new Senador();
        String query = "SELECT * FROM deputado WHERE cpf_id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, primaryKey);
        result = ps.executeQuery();

        if(result.next() == false)
            return null;

        d.setCpf_id(result.getLong("cpf_id"));
        d.setNum_leg_sen(result.getLong("num_leg_sen"));

        result.close();
        ps.close();

        return d;
    }
    @Override
    public void insert(Senador d) throws SQLException{
        String query = "INSERT INTO deputado (cpf_id, leg_sen_num) VALUES (?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, d.getCpf_id());
        ps.setLong(2, d.getNum_leg_sen());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void update(Senador d) throws SQLException {
        String query = "UPDATE deputado SET leg_sen_num = ? WHERE cpf_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, d.getNum_leg_sen());
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
