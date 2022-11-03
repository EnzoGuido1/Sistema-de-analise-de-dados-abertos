package br.uel.bd1.dadosparlamentares.control;

import br.uel.bd1.dadosparlamentares.factory.DAOFactory;
import br.uel.bd1.dadosparlamentares.model.Partido;
import jakarta.annotation.PostConstruct;
import jakarta.faces.FacesException;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import br.uel.bd1.dadosparlamentares.dao.PartidoDAO;

@Named
@ViewScoped
public class PartidoController extends GenericController<Partido> {

    @PostConstruct
    public void init() {
        try {
            this.queryBuf = DAOFactory.getInstance().getPartidoDAO().selectAll();
        }
        catch(Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new
                    FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO",
                    "Não foi possível carregar conteúdo do banco."));
        }
    }
}