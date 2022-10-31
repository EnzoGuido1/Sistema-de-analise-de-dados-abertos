package br.uel.bd1.dadosparlamentares.dao;

import br.uel.bd1.dadosparlamentares.factory.GenericConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class GenericDAO<T, K> {
    protected Connection connection;

    public GenericDAO() {
        try {
            this.connection = GenericConnectionFactory.getInstance().getConnection();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public abstract List<T> selectAll()                      throws SQLException;
    public abstract T selectByPrimaryKey(K primaryKey)       throws SQLException;
    public abstract void insert(T t)                         throws SQLException;
    public abstract void update(T t)                         throws SQLException;
    public abstract void delete(T t)                         throws SQLException;
    public abstract void closeConnection()                   throws SQLException;
}