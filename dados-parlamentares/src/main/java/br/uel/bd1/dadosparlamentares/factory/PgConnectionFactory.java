package br.uel.bd1.sistemadadosparlamentares.factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PgConnectionFactory extends ConnectionFactory {
    private String host,
                   port,
                   name,
                   user,
                   password;

    public PgConnectionFactory() {}

    public void readProperties() throws IOException {
        Properties properties = new Properties();

        try {
            InputStream input = this.getClass().getClassLoader().getResourceAsStream(propertiesPath);
            properties.load(input);

            host = properties.getProperty("host");
            port = properties.getProperty("port");
            name = properties.getProperty("name");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        }
        catch(IOException ex) {
            System.err.println(ex.getMessage());
            throw new IOException("Erro ao obter informações do banco de dados.");
        }
    }

    @Override
    public Connection getConnection() throws IOException, SQLException, ClassNotFoundException {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            readProperties();
            String url = "jdbc:postgresql://" + host + ":" + port + "/" + name;

            connection = DriverManager.getConnection(url, user, password);
        }
        catch(ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            throw new ClassNotFoundException("Erro de conexão ao banco de dados.");
        }
        catch(SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException("Erro de conexão ao banco de dados.");
        }
        return connection;
    }
}

