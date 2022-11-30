package br.uel.bd1.dadosparlamentares.business;

import br.uel.bd1.dadosparlamentares.dao.GenericDAO;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCsvConstraintViolationException;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class GenericBusiness<T> {
    protected T bean;
    protected GenericDAO<T, ?> dao;
    protected String table;
    private Class<T> beanClass;

    public GenericBusiness(GenericDAO<T, ?> dao, Class<T> t) {
        this.dao = dao;
        this.beanClass = t;
    }

    protected void writeToLog(String desc)
            throws IOException, SQLException, ClassNotFoundException, URISyntaxException {
        URI path = this.getClass().getClassLoader().getResource("logs/" +
                dao.getConnection().getCatalog() + ".log").toURI();
        OutputStream writer = new FileOutputStream(new File(path), true);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String text = "[" + formatter.format(now) + "] " + desc + "\n";
        writer.write(text.getBytes());
    }

    public void insertFromCsv(String filename) {
        try(ICsvBeanReader beanReader
                    = new CsvBeanReader(new FileReader(filename), CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE)) {

            final String[] headers = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();
            int insertionCounter = 0,
                updateCounter = 0;

            while(true) {
                try {
                    bean = beanReader.read(beanClass, headers, processors);
                    if(bean == null)
                        break;
                    dao.insert(bean);
                    ++insertionCounter;
                }
                catch(SQLException e) {
                    if(e.getSQLState().compareTo("23505") == 0) {
                        try {
                            dao.update(bean);
                            ++updateCounter;
                        }
                        catch(SQLException f) {
                            f.printStackTrace();
                        }
                    }
                }
                catch(SuperCsvConstraintViolationException e) {
                    e.printStackTrace();
                }
            }
            if(insertionCounter > 0) {
                writeToLog(insertionCounter + " inserções em " + table + "\n");
            }
            if(updateCounter > 0) {
                writeToLog(updateCounter + " atualizações em " + table + "\n");
            }
        }
        catch(SQLException | IOException | ClassNotFoundException | URISyntaxException e) {
            e.printStackTrace();
        }
        finally {
            dao.closeConnection();
        }
    }

    public void insertFromCsv(InputStream fileStream) {
        try(ICsvBeanReader beanReader = new CsvBeanReader(new InputStreamReader(fileStream),
                CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE)) {

            final String[] headers = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();
            int insertionCounter = 0,
                    updateCounter = 0;

            while (true) {
                try {
                    bean = beanReader.read(beanClass, headers, processors);
                    if (bean == null)
                        break;
                    dao.insert(bean);
                    ++insertionCounter;
                } catch (SQLException e) {
                    if (e.getSQLState().compareTo("23505") == 0) {
                        try {
                            dao.update(bean);
                            ++updateCounter;
                        } catch (SQLException f) {
                            f.printStackTrace();
                        }
                    }
                }
                if(insertionCounter > 0) {
                    writeToLog(insertionCounter + " inserções em " + table);
                }
                if(updateCounter > 0) {
                    writeToLog(updateCounter + " atualizações em " + table);
                }
            }
        }
        catch(SQLException | IOException | ClassNotFoundException | URISyntaxException e) {
            e.printStackTrace();
        }
        finally {
            dao.closeConnection();
        }
    }

    protected abstract CellProcessor[] getProcessors();
}
