package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.Deputado;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class DeputadoBusiness extends GenericBusiness<Deputado> {
    public DeputadoBusiness(GenericDAO<Deputado, ?> dao, Class<Deputado> t) {
        super(dao, t);
        this.table = "deputado";
    }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(new ParseLong()),
                new NotNull(new ParseLong())
        };

        return processors;
    }
}
