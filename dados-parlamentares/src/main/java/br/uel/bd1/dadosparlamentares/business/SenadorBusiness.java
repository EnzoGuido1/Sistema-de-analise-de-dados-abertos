package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.Senador;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class SenadorBusiness extends GenericBusiness<Senador> {
    public SenadorBusiness(GenericDAO<Senador, ?> dao, Class<Senador> t) { super(dao, t); }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(new ParseLong()), //id
                new Optional(new ParseLong()) //leg_sen_num
        };

        return processors;
    }
}
