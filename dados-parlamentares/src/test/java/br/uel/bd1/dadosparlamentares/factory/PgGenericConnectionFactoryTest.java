package br.uel.bd1.dadosparlamentares.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

public class PgGenericConnectionFactoryTest {
    @Test
    public void getConnection() throws IOException, SQLException, ClassNotFoundException {
        PgConnectionFactory factory = (PgConnectionFactory) PgConnectionFactory.getInstance();
//        factory.readProperties();

        Assertions.assertNotNull(factory.getConnection());
    }
}