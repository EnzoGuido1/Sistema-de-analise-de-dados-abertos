package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.factory.BusinessFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class ProposicaoBusinessTest {
    @Test
    public void insertFromCsv() throws SQLException, IOException, ClassNotFoundException {
        ProposicaoBusiness proposicaoBusiness = BusinessFactory.getProposicaoBusiness();
        proposicaoBusiness.insertFromCsv("/home/matheuspvr/Proposicao.csv");
    }
}
