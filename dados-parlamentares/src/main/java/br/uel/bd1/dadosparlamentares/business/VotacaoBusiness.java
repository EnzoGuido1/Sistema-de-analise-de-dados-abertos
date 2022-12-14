package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.Votacao;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseBool;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class VotacaoBusiness extends GenericBusiness<Votacao> {
    public VotacaoBusiness(GenericDAO<Votacao, ?> dao, Class<Votacao> t) {
        super(dao, t);
        this.table = "votacao";
    }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(), //id
                new Optional(new ParseDate("dd/MM/yyyy")), //dt_dia
                new Optional(), //orgao
                new Optional(new ParseBool()), //aprovação
                new Optional(new ParseInt()), //votos sim
                new Optional(new ParseInt()), //votos não
                new Optional(), //descrição
        };

        return processors;
    }
}
