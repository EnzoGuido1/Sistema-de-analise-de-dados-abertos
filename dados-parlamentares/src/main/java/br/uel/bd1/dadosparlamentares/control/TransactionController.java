package br.uel.bd1.dadosparlamentares.control;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class TransactionController implements Serializable {
    Class<?> currentClass;

    public String upload(Class<?> currentClass) {
        this.currentClass = currentClass;
        return "upload.xhtml?faces-redirect=true";
    }
}