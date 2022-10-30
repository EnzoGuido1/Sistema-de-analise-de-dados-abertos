package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.Politico;
import br.uel.bd1.dadosparlamentares.model.PoliticoPropoe;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrRegEx;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PoliticoBusiness extends GenericBusiness<Politico> {
    public PoliticoBusiness(GenericDAO<Politico, ?> dao) {
        super(dao);
    }
    @Override
    protected CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(new ParseLong()),
                new NotNull(),
                new NotNull(),
                new Optional()
        };
        return processors;
    }
//    Politico bean;
//
//    public void insertFromCsv(String filename) {
//        try(ICsvBeanReader beanReader
//                    = new CsvBeanReader(new FileReader(filename), CsvPreference.STANDARD_PREFERENCE)) {
//
//            final String[] headers = beanReader.getHeader(true);
//            final CellProcessor[] processors = getProcessors();
//
//            while ((bean = beanReader.read(bean.getClass(), headers, processors)) != null) {
//                System.out.println(bean);
//            }
//        }
//        catch(Exception e) {
//            throw new RuntimeException(e);
//        }

//    }
}
