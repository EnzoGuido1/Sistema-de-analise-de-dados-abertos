package br.uel.bd1.dadosparlamentares.control;

import br.uel.bd1.dadosparlamentares.dao.relatorios.RelatoriosDAO;
import br.uel.bd1.dadosparlamentares.factory.DAOFactory;
import br.uel.bd1.dadosparlamentares.model.dto.FornecedoresMaisContratadosDTO;
import br.uel.bd1.dadosparlamentares.model.dto.GastoAnualPorPoliticoDTO;
import br.uel.bd1.dadosparlamentares.model.dto.NumPoliticosPorPartidoDTO;
import br.uel.bd1.dadosparlamentares.model.dto.NumProposicoesPorPoliticoDTO;
import br.uel.bd1.dadosparlamentares.util.FormatHandlers;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.primefaces.model.chart.PieChartModel;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Named
@RequestScoped
public class RelatoriosController implements Serializable {
    private PieChartModel numPoliticosPorPartido,
                          numProposicoesPorPolitico,
                          fornecedoresMaisContratados,
                          gastoAnualPorPolitico;

    RelatoriosDAO dao;

    @PostConstruct
    public void init() {
        createNumPoliticosPorPartido();
        createNumProposicoesPorPolitico();
        createFornecedoresMaisContratados();
        createGastoAnualPorPolitico();
    }

    public PieChartModel getNumPoliticosPorPartido() {
        return numPoliticosPorPartido;
    }

    public void setNumPoliticosPorPartido(PieChartModel numPoliticosPorPartido) {
        this.numPoliticosPorPartido = numPoliticosPorPartido;
    }

    public PieChartModel getNumProposicoesPorPolitico() {
        return numProposicoesPorPolitico;
    }

    public void setNumProposicoesPorPolitico(PieChartModel numProposicoesPorPolitico) {
        this.numProposicoesPorPolitico = numProposicoesPorPolitico;
    }

    public PieChartModel getFornecedoresMaisContratados() {
        return fornecedoresMaisContratados;
    }

    public void setFornecedoresMaisContratados(PieChartModel fornecedoresMaisContratados) {
        this.fornecedoresMaisContratados = fornecedoresMaisContratados;
    }

    public PieChartModel getGastoAnualPorPolitico() {
        return gastoAnualPorPolitico;
    }

    public void setGastoAnualPorPolitico(PieChartModel gastoAnualPorPolitico) {
        this.gastoAnualPorPolitico = gastoAnualPorPolitico;
    }

    public void createNumPoliticosPorPartido() {
        try {
            List<NumPoliticosPorPartidoDTO> entities;
            dao = DAOFactory.getInstance().getRelatoriosDAO();
            entities = dao.getNumPoliticosPorPartido(10);
            numPoliticosPorPartido = new PieChartModel();

            for(var e : entities) {
                numPoliticosPorPartido.set(e.getPar_sigla(), e.getNum_politicos());
            }

            numPoliticosPorPartido.setTitle("10 partidos com mais parlamentares");
            numPoliticosPorPartido.setLegendPosition("w");
            numPoliticosPorPartido.setShadow(true);
        }
        catch(SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        finally {

            try {
                dao.closeConnection();
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void createNumProposicoesPorPolitico() {
        try {
            List<NumProposicoesPorPoliticoDTO> entities;
            dao = DAOFactory.getInstance().getRelatoriosDAO();
            entities = dao.getNumProposicoesPorPolitico(10);
            numProposicoesPorPolitico = new PieChartModel();

            for(var e : entities) {
                String legenda = e.getNome() != null
                        ? e.getNome() + " " + e.getSnome() != null ? e.getSnome() : "" + " - " + e.getPar_sigla()
                        : "Não informado";
                numProposicoesPorPolitico.set(legenda, e.getNum_proposicoes());
            }

            numProposicoesPorPolitico.setTitle("10 políticos com mais proposições feitas");
            numProposicoesPorPolitico.setLegendPosition("w");
            numProposicoesPorPolitico.setShadow(true);
        }
        catch(SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        finally {

            try {
                dao.closeConnection();
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void createFornecedoresMaisContratados() {
        try {
            List<FornecedoresMaisContratadosDTO> entities;
            dao = DAOFactory.getInstance().getRelatoriosDAO();
            entities = dao.getFornecedoresMaisContratados(10);
            fornecedoresMaisContratados = new PieChartModel();

            for(var e : entities) {
                fornecedoresMaisContratados.set(FormatHandlers.formatCpfCnpj(e.getFor_cpf_cnpj()),
                        e.getNum_prestacoes());
            }

            fornecedoresMaisContratados.setTitle("10 fornecedores que mais prestaram serviços a parlamentares");
            fornecedoresMaisContratados.setLegendPosition("w");
            fornecedoresMaisContratados.setShadow(true);
        }
        catch(SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        finally {

            try {
                dao.closeConnection();
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void createGastoAnualPorPolitico() {
        try {
            List<GastoAnualPorPoliticoDTO> entities;
            dao = DAOFactory.getInstance().getRelatoriosDAO();
            entities = dao.getGastoAnualPorPolitico(10);
            gastoAnualPorPolitico = new PieChartModel();

            for(var e : entities) {
                String legenda = e.getNome() != null
                        ? e.getNome() + " " + e.getSnome() + " - " + e.getPar_sigla()
                        : "Não informado";

                gastoAnualPorPolitico.set(legenda, e.getGasto_anual());
            }

            gastoAnualPorPolitico.setTitle("10 parlamentares que mais gastaram em 2020");
            gastoAnualPorPolitico.setLegendPosition("w");
            gastoAnualPorPolitico.setShadow(true);
        }
        catch(SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                dao.closeConnection();
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
