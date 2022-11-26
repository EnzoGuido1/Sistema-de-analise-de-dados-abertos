package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.LegislaturaSenado;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class LegislaturaSenadoBusiness extends GenericBusiness<LegislaturaSenado> {
    public LegislaturaSenadoBusiness(GenericDAO<LegislaturaSenado, ?> dao, Class<LegislaturaSenado> t) {
        super(dao, t);
        this.table = "leg_senado";
    }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(new ParseInt()), //num
        };

        return processors;
    }
}
