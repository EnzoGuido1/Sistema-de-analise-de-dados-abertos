package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class SenadorBusiness {
    public SenadorBusiness(GenericDAO<SenadorBusiness, ?> dao, Class<SenadorBusiness> t) {
        super(dao, t);
    }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(), //id
                new Optional(new ParseInt()) //leg_sen_num
        };

        return processors;
    }
}
}
