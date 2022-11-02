package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.model.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO extends GenericDAO<Fornecedor, Long> {
    public FornecedorDAO(Connection connection) {
        super(connection);
    }
    @Override
    public List<Fornecedor> selectAll() throws SQLException {
        ResultSet result;
        ArrayList<Fornecedor> entities = new ArrayList<Fornecedor>();
        String query = "SELECT * FROM fornecedor ORDER BY razao_social";

        PreparedStatement ps = connection.prepareStatement(query);
        result = ps.executeQuery();

        while(result.next() ) {
            Fornecedor f = new Fornecedor();
            f.setCpf_cnpj(result.getLong("cpf_cnpj"));
            f.setRazao_social(result.getString("razao_social"));

            entities.add(f);
        }
        result.close();
        ps.close();

        return entities;
    }
    @Override
    public Fornecedor selectByPrimaryKey(Long primaryKey) throws SQLException {
        ResultSet result;
        Fornecedor f = new Fornecedor();
        String query = "SELECT * FROM fornecedor WHERE cpf_cnpj = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, primaryKey);
        result = ps.executeQuery();

        if (result.next() == false)
            return null;

        f.setCpf_cnpj(result.getLong("cpf_cnpj"));
        f.setRazao_social(result.getString("razao_social"));

        result.close();
        ps.close();

        return f;
    }
    @Override
    public void insert(Fornecedor f) throws SQLException {
        String query = "INSERT INTO fornecedor (cpf_cnpj, razao_social) VALUES (?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, f.getCpf_cnpj());
        ps.setString(2, f.getRazao_social());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void update(Fornecedor f) throws SQLException {
        String query = "UPDATE fornecedor SET razao_social = ? WHERE cpf_cnpj = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, f.getRazao_social());
        ps.setLong(2, f.getCpf_cnpj());

        ps.executeUpdate();
        ps.close();
    }
    @Override
    public void delete(Long primaryKey) throws SQLException {
        String query = "DELETE FROM fornecedor WHERE cpf_cnpj = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, primaryKey);

        ps.executeUpdate();
        ps.close();
    }
}
