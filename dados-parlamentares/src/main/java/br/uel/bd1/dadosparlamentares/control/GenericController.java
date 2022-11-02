package br.uel.bd1.dadosparlamentares.control;

import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;

public abstract class GenericController<T> implements Serializable {
    @Inject
    protected T bean;
    protected List<T> queryBuf;

    protected static final long serialVersionUID = 1L;

    public T getBean() {
        return bean;
    }

    public void setBean(T bean) {
        this.bean = bean;
    }

    public List<T> getQueryBuf() {
        return queryBuf;
    }

    public void setQueryBuf(List<T> queryBuf) {
        this.queryBuf = queryBuf;
    }
}