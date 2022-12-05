package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.model.PoliticoVota;
import br.uel.bd1.dadosparlamentares.util.CombinedKey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PoliticoVotaDAO extends GenericDAO<PoliticoVota, CombinedKey<String, Long>> {
    public PoliticoVotaDAO(Connection connection) {
        super(connection);
    }
    @Override
    public List<PoliticoVota> selectAll() throws SQLException {
        ResultSet result;
        String query = "SELECT * FROM pol_vota";
        ArrayList<PoliticoVota> entities = new ArrayList<PoliticoVota>();

        PreparedStatement ps = connection.prepareStatement(query);
        result = ps.executeQuery();
        while(result.next()) {
            PoliticoVota pv = new PoliticoVota();
            pv.setVot_id(result.getString("vot_id"));
            pv.setPol_cpf_id(result.getLong("pol_cpf_id"));

            entities.add(pv);
        }
        result.close();
        ps.close();

        return entities;
    }
    @Override
    public PoliticoVota selectByPrimaryKey(CombinedKey<String, Long> primaryKey) throws SQLException {
        ResultSet result;
        String query = "SELECT * FROM pol_vota WHERE vot_id = ? AND pol_cpf_id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, primaryKey.getFirst());
        ps.setLong(2, primaryKey.getSecond());
        result = ps.executeQuery();

        PoliticoVota pv = new PoliticoVota();
        if(result.next()) {
            pv.setVot_id(result.getString("vot_id"));
            pv.setPol_cpf_id(result.getLong("pol_cpf_id"));
        }
        result.close();
        ps.close();

        return pv;
    }
    @Override
    public void insert(PoliticoVota pv) throws SQLException {
        String query = "INSERT INTO pol_vota (vot_id, pol_cpf_id) VALUES (?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, pv.getVot_id());
        ps.setLong(2, pv.getPol_cpf_id());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void update(PoliticoVota pv) throws SQLException {}
    @Override
    public void delete(CombinedKey<String, Long> primaryKey) throws SQLException {
        String query = "DELETE FROM pol_vota WHERE vot_id = ? AND pol_cpf_id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, primaryKey.getFirst());
        ps.setLong(2, primaryKey.getSecond());

        ps.executeUpdate();
        ps.close();
    }
}