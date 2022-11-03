package br.uel.bd1.dadosparlamentares.factory;

import br.uel.bd1.dadosparlamentares.business.*;
import br.uel.bd1.dadosparlamentares.model.*;
import java.io.IOException;
import java.sql.SQLException;

public class BusinessFactory {
    public static GenericBusiness<?> getBusinessByClass(Class<?> aClass)
            throws SQLException, IOException, ClassNotFoundException {
        GenericBusiness<?> b = null;

        if(aClass.equals(Bloco.class)) {
            b = new BlocoBusiness(DAOFactory.getInstance().getBlocoDAO(), Bloco.class);
        }
        else if(aClass.equals(Deputado.class)) {
            b = new DeputadoBusiness(DAOFactory.getInstance().getDeputadoDAO(), Deputado.class);
        }
        else if(aClass.equals(Despesa.class)) {
            b = new DespesaBusiness(DAOFactory.getInstance().getDespesaDAO(), Despesa.class);
        }
        else if(aClass.equals(DespesaPartido.class)) {
            b = new DespesaPartidoBusiness(DAOFactory.getInstance().getDespesaPartidoDAO(), DespesaPartido.class);
        }
        else if(aClass.equals(DespesaPolitico.class)) {
            b = new DespesaPoliticoBusiness(DAOFactory.getInstance().getDespesaPoliticoDAO(), DespesaPolitico.class);
        }
        else if(aClass.equals(Fornecedor.class)) {
            b = new FornecedorBusiness(DAOFactory.getInstance().getFornecedorDAO(), Fornecedor.class);
        }
        else if(aClass.equals(Legislatura.class)) {
            b = new LegislaturaBusiness(DAOFactory.getInstance().getLegislaturaDAO(), Legislatura.class);
        }
        else if(aClass.equals(LegislaturaCamara.class)) {
            b = new LegislaturaCamaraBusiness(DAOFactory.getInstance().getLegislaturaCamaraDAO(), LegislaturaCamara.class);
        }
        else if(aClass.equals(LegislaturaSenado.class)) {
            b = new LegislaturaSenadoBusiness(DAOFactory.getInstance().getLegislaturaSenadoDAO(), LegislaturaSenado.class);
        }
        else if(aClass.equals(Partido.class)) {
            b = new PartidoBusiness(DAOFactory.getInstance().getPartidoDAO(), Partido.class);
        }
        else if(aClass.equals(Politico.class)) {
            b = new PoliticoBusiness(DAOFactory.getInstance().getPoliticoDAO(), Politico.class);
        }
        else if(aClass.equals(PoliticoPropoe.class)) {
            b = new PoliticoPropoeBusiness(DAOFactory.getInstance().getPoliticoPropoeDAO(), PoliticoPropoe.class);
        }
        else if(aClass.equals(PoliticoVota.class)) {
            b = new PoliticoVotaBusiness(DAOFactory.getInstance().getPoliticoVotaDAO(), PoliticoVota.class);
        }
        else if(aClass.equals(Proposicao.class)) {
            b = new ProposicaoBusiness(DAOFactory.getInstance().getProposicaoDAO(), Proposicao.class);
        }
        else if(aClass.equals(Senador.class)) {
            b = new SenadorBusiness(DAOFactory.getInstance().getSenadorDAO(), Senador.class);
        }
        else if(aClass.equals(Votacao.class)) {
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
