package br.uel.bd1.dadosparlamentares.factory;

import br.uel.bd1.dadosparlamentares.business.*;
import br.uel.bd1.dadosparlamentares.model.*;
import java.io.IOException;
import java.sql.SQLException;

public class BusinessFactory {
    public static GenericBusiness<?> getBusinessByClass(String aClass)
            throws SQLException, IOException, ClassNotFoundException {
        GenericBusiness<?> b = null;

        if(aClass.compareTo("Bloco") == 0) {
            b = new BlocoBusiness(DAOFactory.getInstance().getBlocoDAO(), Bloco.class);
        }
        else if(aClass.compareTo("Deputado") == 0) {
            b = new DeputadoBusiness(DAOFactory.getInstance().getDeputadoDAO(), Deputado.class);
        }
        else if(aClass.compareTo("Despesa") == 0) {
            b = new DespesaBusiness(DAOFactory.getInstance().getDespesaDAO(), Despesa.class);
        }
        else if(aClass.compareTo("DespesaPartido") == 0) {
            b = new DespesaPartidoBusiness(DAOFactory.getInstance().getDespesaPartidoDAO(), DespesaPartido.class);
        }
        else if(aClass.compareTo("DespesaPolitico") == 0) {
            b = new DespesaPoliticoBusiness(DAOFactory.getInstance().getDespesaPoliticoDAO(), DespesaPolitico.class);
        }
        else if(aClass.compareTo("Fornecedor") == 0) {
            b = new FornecedorBusiness(DAOFactory.getInstance().getFornecedorDAO(), Fornecedor.class);
        }
        else if(aClass.compareTo("Legislatura") == 0) {
            b = new LegislaturaBusiness(DAOFactory.getInstance().getLegislaturaDAO(), Legislatura.class);
        }
        else if(aClass.compareTo("LegislaturaCamara") == 0) {
            b = new LegislaturaCamaraBusiness(DAOFactory.getInstance().getLegislaturaCamaraDAO(), LegislaturaCamara.class);
        }
        else if(aClass.compareTo("LegislaturaSenado") == 0) {
            b = new LegislaturaSenadoBusiness(DAOFactory.getInstance().getLegislaturaSenadoDAO(), LegislaturaSenado.class);
        }
        else if(aClass.compareTo("Partido") == 0) {
            b = new PartidoBusiness(DAOFactory.getInstance().getPartidoDAO(), Partido.class);
        }
        else if(aClass.compareTo("Politico") == 0) {
            b = new PoliticoBusiness(DAOFactory.getInstance().getPoliticoDAO(), Politico.class);
        }
        else if(aClass.compareTo("PoliticoPropoe") == 0) {
            b = new PoliticoPropoeBusiness(DAOFactory.getInstance().getPoliticoPropoeDAO(), PoliticoPropoe.class);
        }
        else if(aClass.compareTo("PoliticoVota") == 0) {
            b = new PoliticoVotaBusiness(DAOFactory.getInstance().getPoliticoVotaDAO(), PoliticoVota.class);
        }
        else if(aClass.compareTo("Proposicao") == 0) {
            b = new ProposicaoBusiness(DAOFactory.getInstance().getProposicaoDAO(), Proposicao.class);
        }
        else if(aClass.compareTo("Senador") == 0) {
            b = new SenadorBusiness(DAOFactory.getInstance().getSenadorDAO(), Senador.class);
        }
        else if(aClass.compareTo("Votacao") == 0) {
            b = new VotacaoBusiness(DAOFactory.getInstance().getVotacaoDAO(), Votacao.class);
        }

        return b;
    }
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
