package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.*;
import java.sql.SQLException;

public abstract class GenericBusiness<T> {
    protected T bean;
    protected GenericDAO<T, ?> dao;
    private Class<T> beanClass;

    public GenericBusiness(GenericDAO<T, ?> dao, Class<T> t) {
        this.dao = dao;
        this.beanClass = t;
    }

    public void insertFromCsv(String filename) {

        try(ICsvBeanReader beanReader
                    = new CsvBeanReader(new FileReader(filename), CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE)) {

            final String[] headers = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();

            while(true) {
                try {
                    bean = beanReader.read(beanClass, headers, processors);
                    if(bean == null)
                        break;
                    dao.insert(bean);
                }
                catch(SQLException e) {
                    if(e.getSQLState().compareTo("23505") == 0) {
                        try {
                            dao.update(bean);
                        }
                        catch(SQLException f) {
                            f.printStackTrace();
                        }
                    }
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            dao.closeConnection();
        }
    }

    public void insertFromCsv(InputStream fileStream) throws IOException, SQLException {

        ICsvBeanReader beanReader
                = new CsvBeanReader(new InputStreamReader(fileStream), CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);

        final String[] headers = beanReader.getHeader(true);
        final CellProcessor[] processors = getProcessors();

        while(true) {
            try {
                bean = beanReader.read(beanClass, headers, processors);
                if(bean == null)
                    break;
                dao.insert(bean);
            }
            catch(SQLException e) {
                if(e.getSQLState().compareTo("23505") == 0) {
                    dao.update(bean);
                }
            }
        }
        dao.closeConnection();
    }

    protected abstract CellProcessor[] getProcessors();
}
