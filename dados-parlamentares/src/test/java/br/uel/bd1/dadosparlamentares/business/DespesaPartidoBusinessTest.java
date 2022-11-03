package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.factory.BusinessFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class DespesaPartidoBusinessTest {
    @Test
    public void insertFromCsv() throws SQLException, IOException, ClassNotFoundException {
        DespesaPartidoBusiness despesaPartidoBusiness = BusinessFactory.getDespesaPartidoBusiness();
        despesaPartidoBusiness.insertFromCsv("C:\\Users\\PCMonstro\\Desktop\\DespesaPartido.csv");
    }
}
