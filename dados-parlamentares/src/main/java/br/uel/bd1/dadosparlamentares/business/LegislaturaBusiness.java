package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.Fornecedor;
import br.uel.bd1.dadosparlamentares.model.Legislatura;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class LegislaturaBusiness extends GenericBusiness<Legislatura> {
    public LegislaturaBusiness(GenericDAO<Legislatura, ?> dao, Class<Legislatura> t) {
        super(dao, t);
    }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new Optional(new ParseInt()), //ano
                new NotNull(new ParseInt()), //id
                new Optional(new ParseDate("dd/MM/YYYY")), //dt_ini
                new Optional(new ParseDate("dd/MM/YYYY")) //dt_fim
        };

        return processors;
    }
}
