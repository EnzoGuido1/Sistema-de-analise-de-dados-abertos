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

    public PgConnectionFactory() {}

//    public void readProperties() throws IOException {
//        Properties properties = new Properties();
//
//        try {
//            InputStream input = this.getClass().getClassLoader().getResourceAsStream(propertiesPath);
//            properties.load(input);
//
//            host = properties.getProperty("host");
//            port = properties.getProperty("port");
//            database = properties.getProperty("database");
//            user = properties.getProperty("user");
//            password = properties.getProperty("password");
//        }
//        catch(IOException ex) {
//            System.err.println(ex.getMessage());
//            throw new IOException("Erro ao obter informações do banco de dados.");
//        }
//    }

    @Override
    public Connection getConnection() throws IOException, SQLException, ClassNotFoundException {
        Connection connection = null;

        host = "25.60.189.91";
        port = "5432";
        database = "dados_parlamentares";
        user = "postgres";
        password = "pg12345";

        try {
            Class.forName("org.postgresql.Driver");
//            readProperties();
            String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;

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

