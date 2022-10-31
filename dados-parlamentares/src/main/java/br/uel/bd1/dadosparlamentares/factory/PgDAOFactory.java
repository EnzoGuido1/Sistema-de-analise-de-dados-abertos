package br.uel.bd1.dadosparlamentares.factory;

import br.uel.bd1.dadosparlamentares.dao.PoliticoDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class PgDAOFactory extends DAOFactory {
    private Connection connection;

    public PgDAOFactory(Connection connection) {
        this.connection = connection;
    }
    @Override
    public PoliticoDAO getPoliticoDAO(){
        return new PoliticoDAO(connection);
    }
}

