package br.uel.bd1.dadosparlamentares.factory;

import br.uel.bd1.dadosparlamentares.business.PoliticoBusiness;
import br.uel.bd1.dadosparlamentares.model.Politico;

import java.io.IOException;
import java.sql.SQLException;

public class BusinessFactory {
    public static PoliticoBusiness getPoliticoBusiness()
            throws SQLException, IOException, ClassNotFoundException {
        return new PoliticoBusiness(DAOFactory.getInstance().getPoliticoDAO(),
                Politico.class);
    }
}
