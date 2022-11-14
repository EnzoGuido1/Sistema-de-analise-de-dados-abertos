package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.util.CombinedKey;
import br.uel.bd1.dadosparlamentares.model.PoliticoPropoe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PoliticoPropoeDAO extends GenericDAO<PoliticoPropoe, CombinedKey<Long, Long>> {
    public PoliticoPropoeDAO(Connection connection) {
        super(connection);
    }
    @Override
    public List<PoliticoPropoe> selectAll() throws SQLException {
        ResultSet result;
        String query = "SELECT * FROM pol_propoe";
        ArrayList<PoliticoPropoe> entities = new ArrayList<PoliticoPropoe>();

        PreparedStatement ps = connection.prepareStatement(query);
        result = ps.executeQuery();
        while(result.next()) {
            PoliticoPropoe pp = new PoliticoPropoe();
            pp.setProp_id(result.getLong("prop_id"));
            pp.setPol_cpf_id(result.getLong("pol_cpf_id"));

            entities.add(pp);
        }
        result.close();
        ps.close();

        return entities;
    }
    @Override
    public PoliticoPropoe selectByPrimaryKey(CombinedKey<Long, Long> primaryKey) throws SQLException {
        ResultSet result;
        String query = "SELECT * FROM pol_propoe WHERE prop_id = ? AND pol_cpf_id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, primaryKey.getFirst());
        ps.setLong(2, primaryKey.getSecond());
        result = ps.executeQuery();

        PoliticoPropoe pp = new PoliticoPropoe();
        if(result.next()) {
            pp.setProp_id(result.getLong("prop_id"));
            pp.setPol_cpf_id(result.getLong("pol_cpf_id"));
        }
        result.close();
        ps.close();

        return pp;
    }
    @Override
    public void insert(PoliticoPropoe pp) throws SQLException {
        String query = "INSERT INTO pol_propoe (prop_id, pol_cpf_id) VALUES (?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, pp.getProp_id());
        ps.setLong(2, pp.getPol_cpf_id());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void update(PoliticoPropoe pp ) throws SQLException {}
    @Override
    public void delete(CombinedKey<Long, Long> primaryKey) throws SQLException {
        String query = "DELETE FROM pol_propoe WHERE prop_id = ? AND pol_cpf_id = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, primaryKey.getFirst());
        ps.setLong(2, primaryKey.getSecond());

        ps.executeUpdate();
        ps.close();
    }
}
