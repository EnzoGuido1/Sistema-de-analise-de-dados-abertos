package br.uel.bd1.dadosparlamentares.control;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class InsercaoController implements Serializable {
    private static final long serialVersionUID = 1L;
    @Named
    private String classToUpload;

    public String getClassToUpload() {
        return classToUpload;
    }

    public void setClassToUpload(String classToUpload) {
        this.classToUpload = classToUpload;
    }
}
