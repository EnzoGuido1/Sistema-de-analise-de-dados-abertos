package br.uel.bd1.dadosparlamentares.factory;

import br.uel.bd1.dadosparlamentares.business.*;
import br.uel.bd1.dadosparlamentares.model.*;
import java.io.IOException;
import java.sql.SQLException;

public class BusinessFactory {
    public static BlocoBusiness getBlocoBusiness()
            throws SQLException, IOException, ClassNotFoundException {
        return new BlocoBusiness(DAOFactory.getInstance().getBlocoDAO(), Bloco.class);
    }
    public static DeputadoBusiness getDeputadoBusiness()
            throws SQLException, IOException, ClassNotFoundException {
        return new DeputadoBusiness(DAOFactory.getInstance().getDeputadoDAO(), Deputado.class);
    }
    public static DespesaBusiness getDespesaBusiness()
            throws SQLException, IOException, ClassNotFoundException {
        return new DespesaBusiness(DAOFactory.getInstance().getDespesaDAO(), Despesa.class);
    }
    public static DespesaPartidoBusiness getDespesaPartidoBusiness()
            throws SQLException, IOException, ClassNotFoundException {
        return new DespesaPartidoBusiness(DAOFactory.getInstance().getDespesaPartidoDAO(), DespesaPartido.class);
    }
    public static DespesaPoliticoBusiness getDespesaPoliticoBusiness()
            throws SQLException, IOException, ClassNotFoundException {
        return new DespesaPoliticoBusiness(DAOFactory.getInstance().getDespesaPoliticoDAO(), DespesaPolitico.class);
    }
    public static FornecedorBusiness getFornecedorBusiness()
            throws SQLException, IOException, ClassNotFoundException {
        return new FornecedorBusiness(DAOFactory.getInstance().getFornecedorDAO(), Fornecedor.class);
    }
    public static LegislaturaBusiness getLegislaturaBusiness()
            throws SQLException, IOException, ClassNotFoundException {
        return new LegislaturaBusiness(DAOFactory.getInstance().getLegislaturaDAO(), Legislatura.class);
    }
    public static LegislaturaCamaraBusiness getLegislaturaCamaraBusiness()
            throws SQLException, IOException, ClassNotFoundException {
        return new LegislaturaCamaraBusiness(DAOFactory.getInstance().getLegislaturaCamaraDAO(), LegislaturaCamara.class);
    }
    public static LegislaturaSenadoBusiness getLegislaturaSenadoBusiness()
            throws SQLException, IOException, ClassNotFoundException {
        return new LegislaturaSenadoBusiness(DAOFactory.getInstance().getLegislaturaSenadoDAO(), LegislaturaSenado.class);
    }
    public static PartidoBusiness getPartidoBusiness()
            throws SQLException, IOException, ClassNotFoundException {
        return new PartidoBusiness(DAOFactory.getInstance().getPartidoDAO(), Partido.class);
    }
    public static PoliticoBusiness getPoliticoBusiness()
            throws SQLException, IOException, ClassNotFoundException {
        return new PoliticoBusiness(DAOFactory.getInstance().getPoliticoDAO(), Politico.class);
    }
    public static PoliticoPropoeBusiness getPoliticoPropoeBusiness()
            throws SQLException, IOException, ClassNotFoundException {
        return new PoliticoPropoeBusiness(DAOFactory.getInstance().getPoliticoPropoeDAO(), PoliticoPropoe.class);
    }
    public static PoliticoVotaBusiness getPoliticoVotaBusiness()
            throws SQLException, IOException, ClassNotFoundException {
        return new PoliticoVotaBusiness(DAOFactory.getInstance().getPoliticoVotaDAO(), PoliticoVota.class);
    }
    public static ProposicaoBusiness getProposicaoBusiness()
            throws SQLException, IOException, ClassNotFoundException {
        return new ProposicaoBusiness(DAOFactory.getInstance().getProposicaoDAO(), Proposicao.class);
    }
    public static SenadorBusiness getSenadorBusiness()
            throws SQLException, IOException, ClassNotFoundException {
        return new SenadorBusiness(DAOFactory.getInstance().getSenadorDAO(), Senador.class);
    }
    public static VotacaoBusiness getVotacaoBusiness()
            throws SQLException, IOException, ClassNotFoundException {
        return new VotacaoBusiness(DAOFactory.getInstance().getVotacaoDAO(), Votacao.class);
    }
}
