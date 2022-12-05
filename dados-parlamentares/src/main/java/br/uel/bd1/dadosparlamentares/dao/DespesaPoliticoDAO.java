package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.model.DespesaPolitico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DespesaPoliticoDAO extends GenericDAO<DespesaPolitico, Long> {
    public DespesaPoliticoDAO(Connection connection) {
        super(connection);
    }
    @Override
    public List<DespesaPolitico> selectAll() throws SQLException {
        ResultSet result;
        ArrayList<DespesaPolitico> entities = new ArrayList<DespesaPolitico>();
        String query = "SELECT * FROM despesa_pol ORDER BY documento";

        PreparedStatement ps = connection.prepareStatement(query);
        result = ps.executeQuery();

        while(result.next() ) {
            DespesaPolitico d = new DespesaPolitico();
            d.setDocumento(result.getLong("documento"));
            d.setPol_cpf_id(result.getLong("pol_cpf_id"));

            entities.add(d);
        }
        result.close();
        ps.close();

        return entities;
    }
    @Override
    public DespesaPolitico selectByPrimaryKey(Long documento) throws SQLException {
        ResultSet result;
        DespesaPolitico d = new DespesaPolitico();
        String query = "SELECT * FROM despesa_pol WHERE documento = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, documento);
        result = ps.executeQuery();

        if(result.next() ) {
            d.setDocumento(result.getLong("documento"));
            d.setPol_cpf_id(result.getLong("pol_cpf_id"));
        }
        result.close();
        ps.close();

        return d;
    }
    @Override
    public void insert(DespesaPolitico entity) throws SQLException {
        String query = "INSERT INTO despesa_pol (documento, pol_cpf_id) VALUES (?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, entity.getDocumento());
        if(entity.getPol_cpf_id() != null) {
            ps.setLong(2, entity.getPol_cpf_id());
        } else {
            ps.setNull(2, Types.BIGINT);
        }

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void update(DespesaPolitico entity) throws SQLException {
        String query = "UPDATE despesa_pol SET pol_cpf_id = ? WHERE documento = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        if(entity.getPol_cpf_id() != null) {
            ps.setLong(1, entity.getPol_cpf_id());
        } else {
            ps.setNull(1, Types.BIGINT);
        }
        ps.setLong(2, entity.getDocumento());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void delete(Long documento) throws SQLException {
        String query = "DELETE FROM despesa_pol WHERE documento = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, documento);

        ps.executeUpdate();
        ps.close();
    }
}
