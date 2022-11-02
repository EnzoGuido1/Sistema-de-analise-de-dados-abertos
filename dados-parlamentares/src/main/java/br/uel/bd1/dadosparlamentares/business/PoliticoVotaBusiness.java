package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.PoliticoVota;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseBool;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class PoliticoVotaBusiness extends GenericBusiness<PoliticoVota> {
    public PoliticoVotaBusiness(GenericDAO<PoliticoVota, ?> dao, Class<PoliticoVota> t) {
        super(dao, t);
    }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(), //id_votação
                new NotNull(new ParseLong()), //cpf_pol
                new Optional(new ParseBool()) //voto
        };

        return processors;
    }
}
