package br.uel.bd1.dadosparlamentares.control;

import br.uel.bd1.dadosparlamentares.factory.DAOFactory;
import br.uel.bd1.dadosparlamentares.model.PoliticoVota;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class PoliticoVotaController extends GenericController<PoliticoVota> {
    @PostConstruct
    public void init() {
        try {
            queryBuf = DAOFactory.getInstance().getPoliticoVotaDAO().selectAll();
        }
        catch(Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new
                    FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO",
                    "Não foi possível carregar conteúdo do banco."));
        }
    }
}