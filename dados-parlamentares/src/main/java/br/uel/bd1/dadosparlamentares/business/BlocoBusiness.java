package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.Bloco;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class BlocoBusiness extends GenericBusiness<Bloco> {
    public BlocoBusiness(GenericDAO<Bloco, ?> dao, Class<Bloco> t) {
        super(dao, t);
    }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
            new NotNull(new ParseLong()),
            new NotNull(),
            new NotNull(new ParseLong())
        };

        return processors;
    }
}
