package br.uel.bd1.dadosparlamentares.factory;

import br.uel.bd1.dadosparlamentares.dao.*;
import java.sql.Connection;

public class PgDAOFactory extends DAOFactory {
    private Connection connection;

    public PgDAOFactory(Connection connection) {
        this.connection = connection;
    }
    @Override
    public BlocoDAO getBlocoDAO() { return new BlocoDAO(connection); }
    @Override
    public DeputadoDAO getDeputadoDAO() { return new DeputadoDAO(connection); }
    @Override
    public DespesaDAO getDespesaDAO() { return new DespesaDAO(connection); }
    @Override
    public DespesaPartidoDAO getDespesaPartidoDAO() { return new DespesaPartidoDAO(connection); }
    @Override
    public DespesaPoliticoDAO getDespesaPoliticoDAO() { return new DespesaPoliticoDAO(connection); }
    @Override
    public FornecedorDAO getFornecedorDAO() { return new FornecedorDAO(connection); }
    @Override
    public LegislaturaDAO getLegislaturaDAO() { return new LegislaturaDAO(connection); }
    @Override
    public LegislaturaCamaraDAO getLegislaturaCamaraDAO() { return new LegislaturaCamaraDAO(connection); }
    @Override
    public LegislaturaSenadoDAO getLegislaturaSenadoDAO() { return new LegislaturaSenadoDAO(connection); }
    @Override
    public PartidoDAO getPartidoDAO() { return new PartidoDAO(connection); }
    @Override
    public PoliticoDAO getPoliticoDAO(){
        return new PoliticoDAO(connection);
    }
    @Override
    public PoliticoPropoeDAO getPoliticoPropoeDAO() { return new PoliticoPropoeDAO(connection); }
    @Override
    public PoliticoVotaDAO getPoliticoVotaDAO() { return new PoliticoVotaDAO(connection); }
    @Override
    public ProposicaoDAO getProposicaoDAO() { return new ProposicaoDAO(connection); }
    @Override
    public SenadorDAO getSenadorDAO() { return new SenadorDAO(connection); }
    @Override
    public VotacaoDAO getVotacaoDAO() { return new VotacaoDAO(connection); }
}

