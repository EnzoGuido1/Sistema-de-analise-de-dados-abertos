package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.factory.BusinessFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class FornecedorBusinessTest {
    @Test
    public void insertFromCsv() throws SQLException, IOException, ClassNotFoundException {
        FornecedorBusiness fornecedorBusiness = BusinessFactory.getFornecedorBusiness();
        fornecedorBusiness.insertFromCsv("C:\\Users\\PCMonstro\\Desktop\\Fornecedor.csv");
    }
}
