package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.Partido;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class PartidoBusiness extends GenericBusiness<Partido> {
    public PartidoBusiness(GenericDAO<Partido, ?> dao, Class<Partido> t) {
        super(dao, t);
        this.table = "partido";
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
