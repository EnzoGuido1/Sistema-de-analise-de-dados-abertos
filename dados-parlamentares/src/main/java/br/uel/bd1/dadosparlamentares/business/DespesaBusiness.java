package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.Deputado;
import br.uel.bd1.dadosparlamentares.model.Despesa;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class DespesaBusiness extends GenericBusiness<Despesa>{
    public DespesaBusiness(GenericDAO<Despesa, ?> dao, Class<Despesa> t) {
        super(dao, t);
    }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(new ParseLong()),
                new NotNull(new ParseLong()),
                new Optional(new ParseDate("yyyy-MM-ddTHH:mm:ss")),
                new Optional(),
                new Optional(),
                new Optional()

        };

        return processors;
    }
}
