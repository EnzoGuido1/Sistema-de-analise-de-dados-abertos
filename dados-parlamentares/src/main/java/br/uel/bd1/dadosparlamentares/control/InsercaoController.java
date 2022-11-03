package br.uel.bd1.dadosparlamentares.control;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class InsercaoController implements Serializable {
    private static final long serialVersionUID = 1L;

    private Class<?> classToUpload;
    @Named
//    @Produces
    private String teste;

    public Class<?> getClassToUpload() {
        return classToUpload;
    }

    public void setClassToUpload(Class<?> classToUpload) {
        this.classToUpload = classToUpload;
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }
//    @PostConstruct
//    public void init() {
//        teste = "Teste";
//    }
}
