package br.uel.bd1.dadosparlamentares.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

import br.uel.bd1.dadosparlamentares.model.Politico;

public class PoliticoDAO extends GenericDAO<Politico, Long> {
    public PoliticoDAO(Connection connection) {
        super(connection);
    }
    @Override
    public List<Politico> selectAll() throws SQLException {
        ResultSet result;
        ArrayList<Politico> entities = new ArrayList<Politico>();
        String query = "SELECT * FROM politico ORDER BY nome";

        PreparedStatement ps = connection.prepareStatement(query);
        result = ps.executeQuery();

        while(result.next() ) {
            Politico p = new Politico();
            p.setCpf(result.getLong("cpf_id"));
            p.setNome(result.getString("nome"));
            p.setSobrenome(result.getString("snome"));
            p.setSigla(result.getString("par_sigla"));

            entities.add(p);
        }
        result.close();
        ps.close();

        return entities;
    }
    @Override
    public Politico selectByPrimaryKey(Long primaryKey) throws SQLException {
        ResultSet result;
        Politico p = new Politico();
        String query = "SELECT * FROM politico WHERE cpf_id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, primaryKey);
        result = ps.executeQuery();

        if(result.next() == false)
            return null;

        p.setCpf(result.getLong("cpf_id"));
        p.setNome(result.getString("nome"));
        p.setSobrenome(result.getString("snome"));
        p.setSigla(result.getString("par_sigla"));

        result.close();
        ps.close();

        return p;
    }
    @Override
    public void insert(Politico p) throws SQLException {
        String query = "INSERT INTO politico (cpf_id, nome, snome, par_sigla) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, p.getCpf());
        ps.setString(2, p.getNome());
        ps.setString(3, p.getSobrenome());
        ps.setString(4, p.getSigla());

        ps.execute();
        ps.close();
    }
    @Override
    public void update(Politico p) throws SQLException {
        String query = "UPDATE politico SET nome = ?, snome = ?, par_sigla = ? WHERE cpf_id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, p.getNome());
        ps.setString(2, p.getSobrenome());
        ps.setString(3, p.getSigla());
        ps.setLong(4, p.getCpf());

        ps.execute();
        ps.close();
    }
    @Override
    public void delete(Long primaryKey) throws SQLException {
        String query = "DELETE FROM politico WHERE cpf_id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, primaryKey);

        ps.execute();
        ps.close();
    }
}
