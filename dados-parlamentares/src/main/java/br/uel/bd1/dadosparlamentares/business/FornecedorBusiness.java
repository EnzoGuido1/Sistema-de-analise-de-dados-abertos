package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.Fornecedor;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class FornecedorBusiness extends GenericBusiness<Fornecedor> {
    public FornecedorBusiness(GenericDAO<Fornecedor, ?> dao, Class<Fornecedor> t) {
        super(dao, t);
        this.table = "fornecedor";
    }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(new ParseLong()), //cpf/cnpj
                new Optional(), //razão
        };

        return processors;
    }
}
