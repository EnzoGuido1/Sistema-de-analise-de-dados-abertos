package br.uel.bd1.dadosparlamentares.factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public abstract class ConnectionFactory {
    protected static final String propertiesPath = "conf/jdbc.properties";
    private static ConnectionFactory instance = null;
    private static String server;

    public static ConnectionFactory getInstance() throws IOException, ClassNotFoundException {
        if(instance == null) {
            Properties properties = new Properties();

            Class.forName("org.postgresql.Driver");
            InputStream input = ConnectionFactory.class.getClassLoader()
                    .getResourceAsStream(propertiesPath);
            properties.load(input);

            server = properties.getProperty("server");

            if(getServer().equals("postgresql")) {
                instance = new PgConnectionFactory();
            }
            else {
                throw new RuntimeException("Servidor de banco de dados não suportado.");
            }
            instance = new PgConnectionFactory();
        }

        return instance;
    }
    
    public static String getServer() {
        return server;
    }

    public abstract Connection getConnection()
            throws IOException, SQLException, ClassNotFoundException;

    protected abstract void loadProperties() throws IOException;
}