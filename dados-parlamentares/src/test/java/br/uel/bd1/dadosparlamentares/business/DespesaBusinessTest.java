package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.factory.BusinessFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class DespesaBusinessTest {
    @Test
    public void insertFromCsv() throws SQLException, IOException, ClassNotFoundException {
        DespesaBusiness despesaBusiness = BusinessFactory.getDespesaBusiness();
        despesaBusiness.insertFromCsv("/home/matheuspvr/Despesas.csv");
    }
}
