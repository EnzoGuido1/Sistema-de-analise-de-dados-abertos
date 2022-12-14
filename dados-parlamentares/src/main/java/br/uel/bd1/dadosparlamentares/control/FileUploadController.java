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

@Named
@RequestScoped
public class FileUploadController {
    @Inject
    @ManagedProperty(value = "#{insercaoController.classToUpload}")
    private String prop;
    private String aClass;

    public void upload(FileUploadEvent event) {
        System.out.println(aClass);
        try {
            GenericBusiness<?> business = BusinessFactory.getBusinessByClass(aClass);
            business.insertFromCsv(event.getFile().getInputStream());
        }
        catch(Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new
                    FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO",
                    "Não foi possível completar inserção."));

            e.printStackTrace();
        }

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Sucesso! ",
                        event.getFile().getFileName() + " foi inserido."));
    }
    @PostConstruct
    public void init() {
        aClass = prop;
    }
}
