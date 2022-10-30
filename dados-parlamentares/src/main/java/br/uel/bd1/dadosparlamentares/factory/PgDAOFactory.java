package br.uel.bd1.dadosparlamentares.factory;

import br.uel.bd1.dadosparlamentares.dao.PoliticoDAO;

import java.sql.Connection;

public class PgDAOFactory extends GenericDAOFactory {
    public PgDAOFactory(Connection connection) {
        this.connection = connection;
    }
    @Override
    public PoliticoDAO getPoliticoDAO(){
        return new PoliticoDAO();
    }
}

