package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.factory.BusinessFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class BlocoBusinessTest {
    @Test
    public void insertFromCsv() throws SQLException, IOException, ClassNotFoundException {
        BlocoBusiness blocoBusiness = BusinessFactory.getBlocoBusiness();
        blocoBusiness.insertFromCsv("C:\\Users\\PCMonstro\\Desktop\\Bloco.csv");
    }
}
