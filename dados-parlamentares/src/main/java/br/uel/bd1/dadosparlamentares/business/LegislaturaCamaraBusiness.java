package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.LegislaturaCamara;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class LegislaturaCamaraBusiness {
    public LegislaturaCamaraBusiness(GenericDAO<LegislaturaCamaraBusiness, ?> dao, Class<LegislaturaCamaraBusiness> t) {
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
