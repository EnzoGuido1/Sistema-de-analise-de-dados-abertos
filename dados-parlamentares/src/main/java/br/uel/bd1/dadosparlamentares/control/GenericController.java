package br.uel.bd1.dadosparlamentares.control;

import java.io.Serializable;
import java.util.List;

public abstract class GenericController<T> implements Serializable {
    protected static final long serialVersionUID = 1L;
    protected List<T> queryBuf;
    protected Class<T> ownEntityClass;

    public List<T> getQueryBuf() {
        return queryBuf;
    }

    public void setQueryBuf(List<T> queryBuf) {
        this.queryBuf = queryBuf;
    }

    public Class<T> getOwnEntityClass() {
        return ownEntityClass;
    }

    public void setOwnEntityClass(Class<T> ownEntityClass) {
        this.ownEntityClass = ownEntityClass;
    }
}