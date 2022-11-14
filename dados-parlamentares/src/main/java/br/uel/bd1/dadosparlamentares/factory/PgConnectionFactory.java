package br.uel.bd1.dadosparlamentares.factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PgConnectionFactory extends ConnectionFactory {
    private String host,
                   port,
                   database,
                   user,
                   password;

    @Override
    public Connection getConnection() throws IOException, SQLException, ClassNotFoundException {
        Connection connection = null;

//        host = "25.60.189.91";
//        port = "5432";
//        database = "dados_parlamentares";
//        user = "postgres";
//        password = "pg12345";
        Class.forName("org.postgresql.Driver");
        loadProperties();
        String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;

        connection = DriverManager.getConnection(url, user, password);

        return connection;
    }

    @Override
    protected void loadProperties() throws IOException {
        Properties properties = new Properties();
        InputStream input = this.getClass().getClassLoader().getResourceAsStream(propertiesPath);
        properties.load(input);

        host = properties.getProperty("host");
        port = properties.getProperty("port");
        database = properties.getProperty("database");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
    }
}

