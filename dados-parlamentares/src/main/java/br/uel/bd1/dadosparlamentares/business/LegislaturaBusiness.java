package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.Legislatura;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class LegislaturaBusiness {
    public LegislaturaBusiness(GenericDAO<Legislatura, ?> dao, Class<Legislatura> t) {
        super(dao, t);
    }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(new ParseLong()), //id
                new Optional(new ParseInt()), //ano
                new Optional(new ParseDate("yyyy-MM-ddTHH:mm:ss")), //dt_ini
                new Optional(new ParseDate("yyyy-MM-ddTHH:mm:ss")) //dt_fim
        };

        return processors;
    }
}
