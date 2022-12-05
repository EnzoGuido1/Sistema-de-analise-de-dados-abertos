package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.factory.BusinessFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class VotacaoBusinessTest {
    @Test
    public void insertFromCsv() throws SQLException, IOException, ClassNotFoundException {
        VotacaoBusiness votacaoBusiness = BusinessFactory.getVotacaoBusiness();
        votacaoBusiness.insertFromCsv("/home/matheuspvr/Votacao.csv");
    }
}
