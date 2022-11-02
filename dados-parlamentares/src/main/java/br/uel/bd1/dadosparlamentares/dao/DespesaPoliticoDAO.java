package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.util.CombinedKey;
import br.uel.bd1.dadosparlamentares.model.DespesaPolitico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DespesaPoliticoDAO extends GenericDAO<DespesaPolitico, CombinedKey<Long, Long>> {
    public DespesaPoliticoDAO(Connection connection) {
        super(connection);
    }
    @Override
    public List<DespesaPolitico> selectAll() throws SQLException {
        ResultSet result;
        ArrayList<DespesaPolitico> entities = new ArrayList<DespesaPolitico>();
        String query = "SELECT * FROM despesa_politico ORDER BY documento";

        PreparedStatement ps = connection.prepareStatement(query);
        result = ps.executeQuery();

        while(result.next() ) {
            DespesaPolitico d = new DespesaPolitico();
            d.setDocumento(result.getLong("documento"));
            d.setFor_cpf_cnpj(result.getLong("for_cpf_cnpj"));
            d.setPol_cpf_id(result.getLong("pol_cpf_id"));

            entities.add(d);
        }
        result.close();
        ps.close();

        return entities;
    }
    @Override
    public DespesaPolitico selectByPrimaryKey(CombinedKey<Long, Long> key) throws SQLException {
        ResultSet result;
        DespesaPolitico d = new DespesaPolitico();
        String query = "SELECT * FROM despesa_politico WHERE documento = ? AND for_cpf_cnpj = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, key.getFirst());
        ps.setLong(2, key.getSecond());
        result = ps.executeQuery();

        if(result.next() ) {
            d.setDocumento(result.getLong("documento"));
            d.setFor_cpf_cnpj(result.getLong("for_cpf_cnpj"));
            d.setPol_cpf_id(result.getLong("pol_cpf_id"));
        }
        result.close();
        ps.close();

        return d;
    }
    @Override
    public void insert(DespesaPolitico entity) throws SQLException {
        String query = "INSERT INTO despesa_politico (documento, for_cpf_cnpj, pol_cpf_id) VALUES (?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, entity.getDocumento());
        ps.setLong(2, entity.getFor_cpf_cnpj());
        ps.setLong(3, entity.getPol_cpf_id());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void update(DespesaPolitico entity) throws SQLException {
        String query = "UPDATE despesa_politico SET pol_cpf_id = ? WHERE documento = ? and for_cpf_cnpj = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, entity.getPol_cpf_id());
        ps.setLong(2, entity.getDocumento());
        ps.setLong(3, entity.getFor_cpf_cnpj());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void delete(CombinedKey<Long, Long> primaryKey) throws SQLException {
        String query = "DELETE FROM despesa_politico WHERE documento = ? and for_cpf_cnpj = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, primaryKey.getFirst());
        ps.setLong(2, primaryKey.getSecond());

        ps.executeUpdate();
        ps.close();
    }
}
