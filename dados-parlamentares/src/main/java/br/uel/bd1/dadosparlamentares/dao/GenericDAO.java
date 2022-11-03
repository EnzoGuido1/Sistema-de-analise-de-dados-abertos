package br.uel.bd1.dadosparlamentares.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class GenericDAO<T, K> {
    protected Connection connection;

    protected GenericDAO(Connection connection) {
        try {
            this.connection = connection;
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract List<T> selectAll()                      throws SQLException;
    public abstract T selectByPrimaryKey(K primaryKey)       throws SQLException;
    public abstract void insert(T t)                         throws SQLException;
    public abstract void update(T t)                         throws SQLException;
    public abstract void delete(K primaryKey)                throws SQLException;
}