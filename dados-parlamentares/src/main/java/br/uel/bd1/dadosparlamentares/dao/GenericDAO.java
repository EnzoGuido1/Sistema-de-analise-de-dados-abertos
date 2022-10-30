package br.uel.bd1.dadosparlamentares.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
    public List<T> selectAll()                      throws SQLException;
    public <U> T selectByPrimaryKey(U primaryKey)   throws SQLException;
    public void insert(T t)                         throws SQLException;
    public void update(T t)                         throws SQLException;
    public void delete(T t)                         throws SQLException;
}