package br.uel.bd1.sistemadadosparlamentares.factory;

import java.sql.Connection;

public class PgDAOFactory extends DAOFactory {
    public PgDAOFactory(Connection connection) {
        this.connection = connection;
    }
//    @Override
//    public UserDAO getUserDAO() {
//        return new PgUserDAO(this.connection);
//    }
}

