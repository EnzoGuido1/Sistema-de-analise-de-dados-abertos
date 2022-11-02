package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.business.CombinedKey;
import br.uel.bd1.dadosparlamentares.model.DespesaPartido;

import java.sql.Connection;

public class DespesaPartidoDAO extends GenericDAO<DespesaPartido, CombinedKey<Long, Long>> {
    public DespesaPartidoDAO(Connection connection) {
        super(connection);
    }
    @Override
    public List<DespesaPartido> selectAll() throws SQLException {
        ResultSet result;
        ArrayList<DespesaPartido> entities = new ArrayList<DespesaPartido>();
        String query = "SELECT * FROM despesa_partido ORDER BY documento";

        PreparedStatement ps = connection.prepareStatement(query);
        result = ps.executeQuery();

        while(result.next() ) {
            DespesaPartido d = new DespesaPartido();
            d.setDocumento(result.getLong("documento"));
            d.setPar_sigla(result.getString("par_sigla"));
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
    public DespesaPartido selectByPrimaryKey(CombinedKey<Long, Long> key) throws SQLException {
        ResultSet result;
        DespesaPartido d = new DespesaPartido();
        String query = "SELECT * FROM despesa_partido WHERE documento = ? AND par_sigla = ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, key.getFirst());
        ps.setLong(2, key.getSecond());
        result = ps.executeQuery();

        if(result.next() ) {
            d.setDocumento(result.getLong("documento"));
            d.setPar_sigla(result.getString("par_sigla"));
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
    public void insert(DespesaPartido entity) throws SQLException {
        String query = "INSERT INTO despesa_partido (documento, par_sigla, valor, data, tipo, detalhamento) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, entity.getDocumento());
        ps.setString(2, entity.getPar_sigla());
        ps.setString(3, entity.getValor());
        ps.setDate(4, entity.getData());
        ps.setString(5
}
