package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.Proposicao;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.Optional;

public class ProposicaoBusiness extends GenericBusiness<Proposicao> {
    public ProposicaoBusiness(GenericDAO<Proposicao, ?> dao, Class<Proposicao> t) {
        super(dao, t);
    }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(new ParseLong()), //id
                new Optional(), //descrição
                new Optional(), //ementa
                new Optional(new ParseDate("yyyy-MM-dd")), //data
        };

        return processors;
    }
}