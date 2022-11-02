package br.uel.bd1.dadosparlamentares.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class PgConnectionFactoryTest {
    @Test
    public void getConnection() throws IOException, SQLException, ClassNotFoundException {
        PgConnectionFactory factory = (PgConnectionFactory) ConnectionFactory.getInstance();
//        factory.readProperties();

        Assertions.assertNotNull(factory.getConnection());
    }
}