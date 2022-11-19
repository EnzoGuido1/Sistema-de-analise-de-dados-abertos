package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public abstract class GenericBusiness<T> {
    protected T bean;
    protected GenericDAO<T, ?> dao;
    private Class<T> beanClass;

    public GenericBusiness(GenericDAO<T, ?> dao, Class<T> t) {
        this.dao = dao;
        this.beanClass = t;
    }

    protected void loadProperties() throws IOException, SQLException {
        String path = GenericBusiness.class.getClassLoader().getResource("logs").getPath();
        Properties properties = dao.getConnection().getClientInfo();
        String server = properties.getProperty("database");
        File outputLog = new File(path + File.pathSeparator + server + ".log");
        outputLog.createNewFile();
        FileOutputStream oFile = new FileOutputStream(outputLog);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String text = formatter.format(now) + " - Table " + beanClass.getName() + " was updated.\n";
        oFile.write(text.getBytes());
    }

    public void insertFromCsv(String filename) throws SQLException, IOException {

        loadProperties();

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

        loadProperties();

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
