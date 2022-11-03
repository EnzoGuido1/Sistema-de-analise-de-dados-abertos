package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.factory.BusinessFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class DeputadoBusinessTest {
    @Test
    public void insertFromCsv() throws SQLException, IOException, ClassNotFoundException {
        DeputadoBusiness deputadoBusiness = BusinessFactory.getDeputadoBusiness();
//        deputadoBusiness.insertFromCsv("/home/matheuspvr/Deputado.csv");
    }
}
