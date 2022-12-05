package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.Politico;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrMinMax;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class PoliticoBusiness extends GenericBusiness<Politico> {
    public PoliticoBusiness(GenericDAO<Politico, ?> dao, Class<Politico> t) {
        super(dao, t);
        this.table = "politico";
    }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(new StrMinMax(0, 6)),       // sigla
                new NotNull(new ParseLong()),           // cpf_id
                new Optional(),                         // nome
                new Optional()                          // sobrenome
        };

        return processors;
    }
}
