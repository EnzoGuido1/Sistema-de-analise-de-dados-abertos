package br.uel.bd1.dadosparlamentares.dao.relatorios;

import br.uel.bd1.dadosparlamentares.model.dto.FornecedoresMaisContratadosDTO;
import br.uel.bd1.dadosparlamentares.model.dto.GastoAnualPorPoliticoDTO;
import br.uel.bd1.dadosparlamentares.model.dto.NumPoliticosPorPartidoDTO;
import br.uel.bd1.dadosparlamentares.model.dto.NumProposicoesPorPoliticoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelatoriosDAO {
    private Connection connection;

    public RelatoriosDAO(Connection connection) {
        this.connection = connection;
    }

    public List<NumPoliticosPorPartidoDTO> getNumPoliticosPorPartido() throws SQLException {
        ResultSet results;
        ArrayList<NumPoliticosPorPartidoDTO> entities = new ArrayList<NumPoliticosPorPartidoDTO>();
        final String query =
                "SELECT par_sigla, COUNT(*) AS num_politicos " +
                "FROM politico " +
                "GROUP BY par_sigla " +
                "ORDER BY num_politicos DESC ";

        PreparedStatement ps = connection.prepareStatement(query);
        results = ps.executeQuery();

        while(results.next()) {
            NumPoliticosPorPartidoDTO dto = new NumPoliticosPorPartidoDTO();
            dto.setPar_sigla(results.getString("par_sigla"));
            dto.setNum_politicos(results.getLong("num_politicos"));

            entities.add(dto);
        }
        results.close();
        ps.close();

        return entities;
    }

    public List<FornecedoresMaisContratadosDTO> getFornecedoresMaisContratados() throws SQLException {
        ResultSet results;
        ArrayList<FornecedoresMaisContratadosDTO> entities = new ArrayList<FornecedoresMaisContratadosDTO>();
        final String query =
                "SELECT for_cpf_cnpj, COUNT(*) AS num_prestacoes " +
                "FROM despesa " +
                "GROUP BY for_cpf_cnpj " +
                "ORDER BY num_prestacoes DESC ";

        PreparedStatement ps = connection.prepareStatement(query);
        results = ps.executeQuery();

        while(results.next()) {
            FornecedoresMaisContratadosDTO dto = new FornecedoresMaisContratadosDTO();
            dto.setFor_cpf_cnpj(results.getLong("for_cpf_cnpj"));
            dto.setNum_prestacoes(results.getDouble("num_prestacoes"));

            entities.add(dto);
        }
        results.close();
        ps.close();

        return entities;
    }

    public List<GastoAnualPorPoliticoDTO> getGastoAnualPorPolitico() throws SQLException {
        ResultSet results;
        ArrayList<GastoAnualPorPoliticoDTO> entities = new ArrayList<GastoAnualPorPoliticoDTO>();
        final String query =
                "SELECT pol.nome, pol.snome, pol.par_sigla, SUM(d.valor) AS gasto_anual " +
                "FROM despesa_pol dp LEFT JOIN politico pol " +
                "    ON pol.cpf_id = dp.pol_cpf_id " +
                "    INNER JOIN despesa d " +
                "    ON d.documento = dp.documento " +
                "GROUP BY pol.cpf_id " +
                "ORDER BY gasto_anual DESC ";

        PreparedStatement ps = connection.prepareStatement(query);
        results = ps.executeQuery();

        while(results.next()) {
            GastoAnualPorPoliticoDTO dto = new GastoAnualPorPoliticoDTO();
            dto.setNome(results.getString("nome"));
            dto.setSnome(results.getString("snome"));
            dto.setPar_sigla(results.getString("par_sigla"));
            dto.setGasto_anual(results.getDouble("gasto_anual"));

            entities.add(dto);
        }
        results.close();
        ps.close();

        return entities;
    }

    public List<NumProposicoesPorPoliticoDTO> getNumProposicoesPorPolitico() throws SQLException {
        ResultSet results;
        ArrayList<NumProposicoesPorPoliticoDTO> entities = new ArrayList<NumProposicoesPorPoliticoDTO>();
        final String query =
                "SELECT pol.nome, pol.snome, pol.par_sigla, COUNT(*) AS num_proposicoes " +
                "FROM politico pol INNER JOIN pol_propoe pp " +
                "    ON pol.cpf_id = pp.pol_cpf_id " +
                "GROUP BY pol.cpf_id " +
                "ORDER BY num_proposicoes DESC ";

        PreparedStatement ps = connection.prepareStatement(query);
        results = ps.executeQuery();

        while(results.next()) {
            NumProposicoesPorPoliticoDTO dto = new NumProposicoesPorPoliticoDTO();
            dto.setNome(results.getString("nome"));
            dto.setSnome(results.getString("snome"));
            dto.setPar_sigla(results.getString("par_sigla"));
            dto.setNum_proposicoes(results.getLong("num_proposicoes"));

            entities.add(dto);
        }
        results.close();
        ps.close();

        return entities;
    }

    public List<NumPoliticosPorPartidoDTO> getNumPoliticosPorPartido(long limit)
            throws SQLException, IllegalArgumentException {
        if(limit <= 0) {
            throw new IllegalArgumentException("Limite de linhas deve ser maior do que 0");
        }

        ResultSet results;
        ArrayList<NumPoliticosPorPartidoDTO> entities = new ArrayList<NumPoliticosPorPartidoDTO>();
        final String query =
                "SELECT par_sigla, COUNT(*) AS num_politicos " +
                "FROM politico " +
                "GROUP BY par_sigla " +
                "ORDER BY num_politicos DESC " +
                "LIMIT ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, limit);
        results = ps.executeQuery();

        while(results.next()) {
            NumPoliticosPorPartidoDTO dto = new NumPoliticosPorPartidoDTO();
            dto.setPar_sigla(results.getString("par_sigla"));
            dto.setNum_politicos(results.getLong("num_politicos"));

            entities.add(dto);
        }
        results.close();
        ps.close();

        return entities;
    }

    public List<FornecedoresMaisContratadosDTO> getFornecedoresMaisContratados(long limit)
            throws SQLException, IllegalArgumentException {
        if(limit <= 0) {
            throw new IllegalArgumentException("Limite de linhas deve ser maior do que 0");
        }

        ResultSet results;
        ArrayList<FornecedoresMaisContratadosDTO> entities = new ArrayList<FornecedoresMaisContratadosDTO>();
        final String query =
                "SELECT d.for_cpf_cnpj, SUM(d.valor) AS num_prestacoes " +
                "FROM despesa d " +
                "GROUP BY d.for_cpf_cnpj " +
                "ORDER BY num_prestacoes DESC " +
                "LIMIT ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, limit);
        results = ps.executeQuery();

        while(results.next()) {
            FornecedoresMaisContratadosDTO dto = new FornecedoresMaisContratadosDTO();
            dto.setFor_cpf_cnpj(results.getLong("for_cpf_cnpj"));
            dto.setNum_prestacoes(results.getDouble("num_prestacoes"));

            entities.add(dto);
        }
        results.close();
        ps.close();

        return entities;
    }

    public List<GastoAnualPorPoliticoDTO> getGastoAnualPorPolitico(long limit)
            throws SQLException, IllegalArgumentException {
        if(limit <= 0) {
            throw new IllegalArgumentException("Limite de linhas deve ser maior do que 0");
        }

        ResultSet results;
        ArrayList<GastoAnualPorPoliticoDTO> entities = new ArrayList<GastoAnualPorPoliticoDTO>();
        final String query =
                "SELECT pol.nome, pol.snome, pol.par_sigla, SUM(d.valor) AS gasto_anual " +
                "FROM despesa_pol dp LEFT JOIN politico pol " +
                "    ON pol.cpf_id = dp.pol_cpf_id " +
                "    INNER JOIN despesa d " +
                "    ON d.documento = dp.documento " +
                "GROUP BY pol.cpf_id " +
                "ORDER BY gasto_anual DESC " +
                "LIMIT ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, limit);
        results = ps.executeQuery();

        while(results.next()) {
            GastoAnualPorPoliticoDTO dto = new GastoAnualPorPoliticoDTO();
            dto.setNome(results.getString("nome"));
            dto.setSnome(results.getString("snome"));
            dto.setPar_sigla(results.getString("par_sigla"));
            dto.setGasto_anual(results.getDouble("gasto_anual"));

            entities.add(dto);
        }
        results.close();
        ps.close();

        return entities;
    }

    public List<NumProposicoesPorPoliticoDTO> getNumProposicoesPorPolitico(long limit)
            throws SQLException, IllegalArgumentException {
        if(limit <= 0) {
            throw new IllegalArgumentException("Limite de linhas deve ser maior do que 0");
        }
        
        ResultSet results;
        ArrayList<NumProposicoesPorPoliticoDTO> entities = new ArrayList<NumProposicoesPorPoliticoDTO>();
        final String query =
                "SELECT pol.nome, pol.snome, pol.par_sigla, COUNT(*) AS num_proposicoes " +
                "FROM politico pol INNER JOIN pol_propoe pp " +
                "    ON pol.cpf_id = pp.pol_cpf_id " +
                "GROUP BY pol.cpf_id " +
                "ORDER BY num_proposicoes DESC " +
                "LIMIT ?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, limit);
        results = ps.executeQuery();

        while(results.next()) {
            NumProposicoesPorPoliticoDTO dto = new NumProposicoesPorPoliticoDTO();
            dto.setNome(results.getString("nome"));
            dto.setSnome(results.getString("snome"));
            dto.setPar_sigla(results.getString("par_sigla"));
            dto.setNum_proposicoes(results.getLong("num_proposicoes"));

            entities.add(dto);
        }
        results.close();
        ps.close();

        return entities;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
