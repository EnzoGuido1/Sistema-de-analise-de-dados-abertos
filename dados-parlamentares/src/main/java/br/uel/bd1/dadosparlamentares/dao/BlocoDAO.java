package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.model.Bloco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlocoDAO extends GenericDAO<Bloco, Long> {
    public BlocoDAO(Connection connection) {
        super(connection);
    }
    @Override
    public List<Bloco> selectAll() throws SQLException {
        ResultSet result;
        ArrayList<Bloco> entities = new ArrayList<Bloco>();
        String query = "SELECT * FROM bloco ORDER BY num_leg";

        PreparedStatement ps = connection.prepareStatement(query);
        result = ps.executeQuery();

        while(result.next() ) {
            Bloco b = new Bloco();
            b.setPar_sigla(result.getString("par_sigla"));
            b.setId(result.getLong("id"));
            b.setNum_leg(result.getLong("num_leg"));

            entities.add(b);
        }
        result.close();
        ps.close();

        return entities;
    }
    @Override
    public Bloco selectByPrimaryKey(Long primaryKey) throws SQLException {
        ResultSet result;
        Bloco b = new Bloco();
        String query = "SELECT * FROM bloco WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, primaryKey);
        result = ps.executeQuery();

        if(result.next() == false)
            return null;

        b.setPar_sigla(result.getString("par_sigla"));
        b.setId(result.getLong("id"));
        b.setNum_leg(result.getLong("num_leg"));

        result.close();
        ps.close();

        return b;
    }
    @Override
    public void insert(Bloco b) throws SQLException {
        String query = "INSERT INTO bloco (id, par_sigla, num_leg) VALUES (?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, b.getId());
        ps.setString(2, b.getPar_sigla());
        ps.setLong(3, b.getNum_leg());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void update(Bloco b) throws SQLException {
        String query = "UPDATE bloco SET par_sigla = ?, num_leg = ? WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, b.getPar_sigla());
        ps.setLong(2, b.getNum_leg());
        ps.setLong(3, b.getId());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void delete(Long primaryKey) throws SQLException {
        String query = "DELETE FROM bloco WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, primaryKey);

        ps.executeUpdate();
        ps.close();
    }
}
