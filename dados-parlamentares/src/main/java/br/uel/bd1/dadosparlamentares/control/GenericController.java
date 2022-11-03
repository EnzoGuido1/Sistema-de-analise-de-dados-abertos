package br.uel.bd1.dadosparlamentares.control;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;

public abstract class GenericController<T> implements Serializable {
    protected static final long serialVersionUID = 1L;
    protected List<T> queryBuf;

    public List<T> getQueryBuf() {
        return queryBuf;
    }

    public void setQueryBuf(List<T> queryBuf) {
        this.queryBuf = queryBuf;
    }
}