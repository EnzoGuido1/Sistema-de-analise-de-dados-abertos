package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.model.DespesaPartido;
import br.uel.bd1.dadosparlamentares.util.CombinedKey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DespesaPartidoDAO extends GenericDAO<DespesaPartido, CombinedKey<Long, Long>> {
    public DespesaPartidoDAO(Connection connection) {
        super(connection);
    }
    @Override
    public List<DespesaPartido> selectAll() throws SQLException {
        ResultSet result;
        ArrayList<DespesaPartido> entities = new ArrayList<DespesaPartido>();
        String query = "SELECT * FROM despesa_par ORDER BY documento";

        PreparedStatement ps = connection.prepareStatement(query);
        result = ps.executeQuery();

        while(result.next() ) {
            DespesaPartido d = new DespesaPartido();
            d.setDocumento(result.getLong("documento"));
            d.setPar_sigla(result.getString("par_sigla"));
            d.setFor_cpf_cnpj(result.getLong("for_cpf_cnpj"));
            entities.add(d);
        }
        result.close();
        ps.close();

        return entities;
    }
    @Override
    public DespesaPartido selectByPrimaryKey(CombinedKey<Long, Long> key) throws SQLException {
        ResultSet result;
        DespesaPartido d = new DespesaPartido();
        String query = "SELECT * FROM despesa_par WHERE documento = ? AND for_cpf_cpnj = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, key.getFirst());
        ps.setLong(2, key.getSecond());
        result = ps.executeQuery();

        if(result.next() ) {
            d.setDocumento(result.getLong("documento"));
            d.setPar_sigla(result.getString("par_sigla"));
            d.setFor_cpf_cnpj(result.getLong("for_cpf_cnpj"));
        }
        result.close();
        ps.close();

        return d;
    }
    @Override
    public void insert(DespesaPartido entity) throws SQLException {
        String query = "INSERT INTO despesa_par (documento, par_sigla, for_cpf_cnpj) VALUES (?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, entity.getDocumento());
        ps.setString(2, entity.getPar_sigla());
        ps.setLong(3, entity.getFor_cpf_cnpj());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void update(DespesaPartido entity) throws SQLException {
        String query = "UPDATE despesa_par SET par_sigla = ? WHERE documento = ? and for_cpf_cnpj = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, entity.getPar_sigla());
        ps.setLong(2, entity.getDocumento());
        ps.setLong(3, entity.getFor_cpf_cnpj());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void delete(CombinedKey<Long, Long> primaryKey) throws SQLException {
        String query = "DELETE FROM despesa_par WHERE documento = ? and for_cpf_cnpj = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, primaryKey.getFirst());
        ps.setLong(2, primaryKey.getSecond());

        ps.executeUpdate();
        ps.close();
    }
}
