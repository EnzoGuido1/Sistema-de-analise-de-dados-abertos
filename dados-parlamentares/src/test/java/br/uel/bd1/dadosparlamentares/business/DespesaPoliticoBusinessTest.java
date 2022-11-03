package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.factory.BusinessFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class DespesaPoliticoBusinessTest {
    @Test
    public void insertFromCsv() throws SQLException, IOException, ClassNotFoundException {
        DespesaPoliticoBusiness despesaPoliticoBusiness = BusinessFactory.getDespesaPoliticoBusiness();
        despesaPoliticoBusiness.insertFromCsv("C:\\Users\\PCMonstro\\Desktop\\DespesaPolitico.csv");
    }
}
