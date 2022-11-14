package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.LegislaturaCamara;
import br.uel.bd1.dadosparlamentares.model.Senador;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class LegislaturaCamaraBusiness extends GenericBusiness<LegislaturaCamara> {
    public LegislaturaCamaraBusiness(GenericDAO<LegislaturaCamara, ?> dao, Class<LegislaturaCamara> t) { super(dao, t); }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(new ParseInt()), //num
        };

        return processors;
    }
}
