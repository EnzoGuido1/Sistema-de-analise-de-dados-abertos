package br.uel.bd1.dadosparlamentares.control;

import br.uel.bd1.dadosparlamentares.business.GenericBusiness;
import br.uel.bd1.dadosparlamentares.factory.BusinessFactory;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

@Named
@RequestScoped
public class FileUploadController {
    @Inject
    @ManagedProperty(value = "#{insercaoController.teste}")
    private String teste;
    @Inject
    @ManagedProperty(value = "#{insercaoController.classToUpload}")
    private Class<?> prop;

    private Class<?> classToUpload;

    public void upload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        try {
            GenericBusiness<?> business = BusinessFactory.getBusinessByClass(classToUpload);
            business.insertFromCsv(event.getFile().getFileName());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    @PostConstruct
    public void init() {
        classToUpload = prop;
    }
}
