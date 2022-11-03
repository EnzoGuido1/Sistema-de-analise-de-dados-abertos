package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.util.CombinedKey;
import br.uel.bd1.dadosparlamentares.model.Despesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DespesaDAO extends GenericDAO<Despesa, CombinedKey<Long, Long>>{
    public DespesaDAO(Connection connection) {
        super(connection);
    }
    @Override
    public List<Despesa> selectAll() throws SQLException {
        ResultSet result;
        ArrayList<Despesa> entities = new ArrayList<Despesa>();
        String query = "SELECT * FROM despesa ORDER BY documento";

        PreparedStatement ps = connection.prepareStatement(query);
        result = ps.executeQuery();

        while(result.next() ) {
            Despesa d = new Despesa();
            d.setDocumento(result.getLong("documento"));
            d.setFor_cpf_cnpj(result.getLong("for_cpf_cnpj"));
            d.setValor(result.getString("valor"));
            d.setData(result.getDate("data"));
            d.setTipo(result.getString("tipo"));
            d.setDetalhamento(result.getString("detalhamento"));

            entities.add(d);
        }
        result.close();
        ps.close();

        return entities;
    }
    @Override
    public Despesa selectByPrimaryKey(CombinedKey<Long, Long> key) throws SQLException {
        ResultSet result;
        Despesa d = new Despesa();
        String query = "SELECT * FROM despesa WHERE documento = ? AND for_cpf_cnpj = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, key.getFirst());
        ps.setLong(2, key.getSecond());
        result = ps.executeQuery();

        if(result.next() ) {
            d.setDocumento(result.getLong("documento"));
            d.setFor_cpf_cnpj(result.getLong("for_cpf_cnpj"));
            d.setValor(result.getString("valor"));
            d.setData(result.getDate("data"));
            d.setTipo(result.getString("tipo"));
            d.setDetalhamento(result.getString("detalhamento"));
        }
        result.close();
        ps.close();

        return d;
    }
    @Override
    public void insert(Despesa d) throws SQLException {
        String query = "INSERT INTO despesa (documento, for_cpf_cnpj, valor, data, tipo, detalhamento) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, d.getDocumento());
        ps.setLong(2, d.getFor_cpf_cnpj());
        ps.setString(3, d.getValor());
        ps.setDate(4, new Date(d.getData().getTime()));
        ps.setString(5, d.getTipo());
        ps.setString(6, d.getDetalhamento());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void update(Despesa d) throws SQLException {
        String query = "UPDATE despesa SET valor = ?, data = ?, tipo = ?, detalhamento = ? WHERE documento = ? and for_cpf_cnpj = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, d.getValor());
        ps.setDate(2, new Date(d.getData().getTime()));
        ps.setString(3, d.getTipo());
        ps.setString(4, d.getDetalhamento());
        ps.setLong(5, d.getDocumento());
        ps.setLong(6, d.getFor_cpf_cnpj());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void delete(CombinedKey<Long, Long> primaryKey) throws SQLException {
        String query = "DELETE FROM despesa WHERE documento = ? AND for_cpf_cnpj = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, primaryKey.getFirst());
        ps.setLong(2, primaryKey.getSecond());

        ps.execute();
        ps.close();
    }
}
