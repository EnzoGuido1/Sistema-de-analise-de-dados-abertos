package br.uel.bd1.dadosparlamentares.dao.relatorios;

import br.uel.bd1.dadosparlamentares.factory.DAOFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class RelatoriosDAOTest {
    @Test
    public void test() throws IOException, ClassNotFoundException, SQLException {
        RelatoriosDAO dao = DAOFactory.getInstance().getRelatoriosDAO();

        var fornecedoresMaisContratados = dao.getFornecedoresMaisContratados();
        var gastoAnualPorPolitico = dao.getGastoAnualPorPolitico();
        var numPoliticosPorPartido = dao.getNumPoliticosPorPartido();
        var numProposicoesPorPolitico = dao.getNumProposicoesPorPolitico();

        Assertions.assertNotNull(fornecedoresMaisContratados);
        Assertions.assertNotNull(gastoAnualPorPolitico);
        Assertions.assertNotNull(numPoliticosPorPartido);
        Assertions.assertNotNull(numProposicoesPorPolitico);

        try {
            fornecedoresMaisContratados = dao.getFornecedoresMaisContratados(10);
            gastoAnualPorPolitico = dao.getGastoAnualPorPolitico(10);
            numPoliticosPorPartido = dao.getNumPoliticosPorPartido(10);
            numProposicoesPorPolitico = dao.getNumProposicoesPorPolitico(-1);
        }
        catch(IllegalArgumentException e) {
            System.out.println("LIMITE MAIOR QUE ZEROOOO");
        }

        dao.closeConnection();
    }
}
