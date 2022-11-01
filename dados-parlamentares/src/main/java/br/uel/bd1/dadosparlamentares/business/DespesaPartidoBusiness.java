package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.Despesa;
import br.uel.bd1.dadosparlamentares.model.DespesaPartido;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class DespesaPartidoBusiness extends GenericBusiness<DespesaPartido> {
    public DespesaPartidoBusiness(GenericDAO<DespesaPartido, ?> dao, Class<DespesaPartido> t) {
        super(dao, t);
    }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(new ParseLong()),
                new NotNull(new ParseLong()),
                new NotNull()

        };

        return processors;
    }
}
