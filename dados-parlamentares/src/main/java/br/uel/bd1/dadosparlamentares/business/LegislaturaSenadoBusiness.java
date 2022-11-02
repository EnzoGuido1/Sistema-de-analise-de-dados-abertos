package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.LegislaturaSenado;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class LegislaturaSenadoBusiness {
    public LegislaturaSenadoBusiness(GenericDAO<LegislaturaSenadoBusiness, ?> dao, Class<LegislaturaSenadoBusiness> t) {
        super(dao, t);
    }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(new ParseInt()), //num
                new Optional() //id
        };

        return processors;
    }
}
