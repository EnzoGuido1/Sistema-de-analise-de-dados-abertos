package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.Legislatura;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class LegislaturaBusiness extends GenericBusiness<Legislatura> {
    public LegislaturaBusiness(GenericDAO<Legislatura, ?> dao, Class<Legislatura> t) {
        super(dao, t);
        this.table = "legislatura";
    }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new Optional(new ParseInt()), //ano
                new NotNull(new ParseInt()), //num
                new Optional(new ParseDate("dd/MM/yyyy")), //dt_ini
                new Optional(new ParseDate("dd/MM/yyyy")) //dt_fim
        };

        return processors;
    }
}
