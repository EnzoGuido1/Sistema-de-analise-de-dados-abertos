package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.*;

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

    public void insertFromCsv(InputStream fileStream) throws IOException {
        File temp = new File("/tmp/temp.csv");
        OutputStream out = new FileOutputStream(temp);
        int read = 0;
        byte[] bytes = new byte[1024];

        while ((read = fileStream.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        fileStream.close();
        out.flush();
        out.close();

        try(ICsvBeanReader beanReader
                    = new CsvBeanReader(new FileReader(temp), CsvPreference.STANDARD_PREFERENCE)) {

            final String[] headers = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();

            while( (bean = beanReader.read(beanClass, headers, processors) ) != null) {
                dao.insert(bean);
            }
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            temp.delete();
        }
    }

    protected abstract CellProcessor[] getProcessors();
}
