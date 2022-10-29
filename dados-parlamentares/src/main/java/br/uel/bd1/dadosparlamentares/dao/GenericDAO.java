package br.uel.bd1.sistemadadosparlamentares.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
    public List<T> selectAll() throws SQLException;
    public <U> T selectByPrimaryKey(U pk) throws SQLException;
    public void insert(T t) throws SQLException;
    public void update(T t) throws SQLException;
    public void delete(T t) throws SQLException;
}