package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import br.uel.bd1.dadosparlamentares.model.Politico;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;

public abstract class GenericBusiness<T> {
    protected T bean;
    protected GenericDAO<T, ?> dao;
    private Class<T> beanClass;

    public GenericBusiness(GenericDAO<T, ?> dao) {
        this.dao = dao;
    }

    public void insertFromCsv(String filename) {
        try(ICsvBeanReader beanReader
                    = new CsvBeanReader(new FileReader(filename), CsvPreference.STANDARD_PREFERENCE)) {

            final String[] headers = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();

            while( (bean = beanReader.read(beanClass, headers, processors) ) != null) {
                dao.insert(bean);
            }
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract CellProcessor[] getProcessors();
}
