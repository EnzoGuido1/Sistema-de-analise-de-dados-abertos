package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.model.Partido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartidoDAO extends GenericDAO<Partido, String> {
    public PartidoDAO(Connection connection) {
        super(connection);
    }
    @Override
    public List<Partido> selectAll() throws SQLException {
        ResultSet result;
        String query = "SELECT * FROM partido";
        ArrayList<Partido> entities = new ArrayList<Partido>();

        PreparedStatement ps = connection.prepareStatement(query);
        result = ps.executeQuery();

        while(result.next() ) {
            Partido p = new Partido();
            p.setSigla(result.getString("sigla"));
            p.setNome(result.getString("nome"));
            p.setNum(result.getShort("num"));
            p.setCnpj(result.getLong("cnpj"));

            entities.add(p);
        }
        result.close();
        ps.close();

        return entities;
    }
    @Override
    public Partido selectByPrimaryKey(String primaryKey) throws SQLException {
        ResultSet result;
        Partido p = new Partido();
        String query = "SELECT * FROM partido WHERE sigla = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, primaryKey);
        result = ps.executeQuery();

        if (result.next()) {
            p.setSigla(result.getString("sigla"));
            p.setNome(result.getString("nome"));
            p.setNum(result.getShort("num"));
            p.setCnpj(result.getLong("cnpj"));
        }
        result.close();
        ps.close();

        return p;
    }
    @Override
    public void insert(Partido p) throws SQLException {
        String query = "INSERT INTO partido (sigla, nome, num, cnpj) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, p.getSigla());
        ps.setString(2, p.getNome());
        ps.setShort(3, p.getNum());
        ps.setLong(4, p.getCnpj());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void update(Partido p) throws SQLException {
        String query = "UPDATE partido SET nome = ?, num = ?, cnpj = ? WHERE sigla = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, p.getNome());
        ps.setShort(2, p.getNum());
        ps.setLong(3, p.getCnpj());
        ps.setString(4, p.getSigla());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void delete(String primaryKey) throws SQLException {
        String query = "DELETE FROM partido WHERE sigla = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, primaryKey);

        ps.executeUpdate();
        ps.close();
    }
}
