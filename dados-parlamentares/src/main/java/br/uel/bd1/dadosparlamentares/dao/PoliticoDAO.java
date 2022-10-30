package br.uel.bd1.dadosparlamentares.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

import br.uel.bd1.dadosparlamentares.model.Politico;

public class PoliticoDAO extends GenericDAO<Politico, Long> {
    public PoliticoDAO() {
        super();
    }
    @Override
    public List<Politico> selectAll() throws SQLException {
        ResultSet result;
        ArrayList<Politico> entities = new ArrayList<Politico>();
        String query = "SELECT * FROM politico ORDER BY nome";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            result = ps.executeQuery();

            while(result.next() ) {
                Politico p = new Politico();
                p.setCpf(result.getLong("cpf"));
                p.setNome(result.getString("nome"));
                p.setSobrenome(result.getString("snome"));
                p.setSigla(result.getString("par_sigla"));

                entities.add(p);
            }
            result.close();
            ps.close();
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            }
            catch(SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return entities;
    }
    @Override
    public Politico selectByPrimaryKey(Long primaryKey) throws SQLException {
        ResultSet result;
        Politico p = new Politico();
        String query = "SELECT * FROM politico WHERE cpf = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, primaryKey);
            result = ps.executeQuery();

            if(result.next() == false)
                return null;

            p.setCpf(result.getLong("cpf"));
            p.setNome(result.getString("nome"));
            p.setSobrenome(result.getString("snome"));
            p.setSigla(result.getString("par_sigla"));

            result.close();
            ps.close();
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            }
            catch(SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return p;
    }
    @Override
    public void insert(Politico p) {
        String query = "INSERT INTO politico (cpf, nome, snome, par_sigla) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, p.getCpf());
            ps.setString(2, p.getNome());
            ps.setString(3, p.getSobrenome());
            ps.setString(4, p.getSigla());

            ps.execute();
            ps.close();
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            }
            catch(SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void update(Politico p) {
        String query = "UPDATE politico SET cpf = ?, nome = ?, snome = ?, par_sigla = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, p.getCpf());
            ps.setString(2, p.getNome());
            ps.setString(3, p.getSobrenome());
            ps.setString(4, p.getSigla());

            ps.execute();
            ps.close();
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            }
            catch(SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void delete(Politico p) {
        String query = "DELETE FROM politico WHERE cpf = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, p.getCpf());

            ps.execute();
            ps.close();
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            }
            catch(SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
