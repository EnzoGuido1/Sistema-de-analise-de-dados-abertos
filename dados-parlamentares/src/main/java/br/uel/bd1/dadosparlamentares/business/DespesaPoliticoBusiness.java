package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.DespesaPolitico;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class DespesaPoliticoBusiness extends GenericBusiness<DespesaPolitico> {
    public DespesaPoliticoBusiness(GenericDAO<DespesaPolitico, ?> dao, Class<DespesaPolitico> t) {
        super(dao, t);
        this.table = "despesa_pol";
    }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(new ParseLong()),
                new Optional(new ParseLong())
        };

        return processors;
    }
}