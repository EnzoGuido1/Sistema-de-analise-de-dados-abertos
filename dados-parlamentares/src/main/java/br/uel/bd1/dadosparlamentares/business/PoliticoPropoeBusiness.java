package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.PoliticoPropoe;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class PoliticoPropoeBusiness extends GenericBusiness<PoliticoPropoe> {
    public PoliticoPropoeBusiness(GenericDAO<PoliticoPropoe, ?> dao, Class<PoliticoPropoe> t) {
        super(dao, t);
        this.table = "pol_propoe";
    }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(new ParseLong()), //pol_cpf
                new NotNull(new ParseLong()) //pro_id
        };

        return processors;
    }
}
