package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.cellprocessor.Optional;

public class PartidoBusiness {
    public PartidoBusiness(GenericDAO<PartidoBusiness, ?> dao, Class<PartidoBusiness> t) {
        super(dao, t);
    }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(), //sigla
                new Optional(), //nome
                new Optional(new ParseInt()), //numero
                new Optional(new ParseLong()) //cnpj
        };

        return processors;
    }
}
}
