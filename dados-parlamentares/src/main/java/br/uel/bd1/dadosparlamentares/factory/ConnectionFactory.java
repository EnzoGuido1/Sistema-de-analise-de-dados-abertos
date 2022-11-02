package br.uel.bd1.dadosparlamentares.factory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class ConnectionFactory {
    private static ConnectionFactory instance = null;
//    protected static String propertiesPath = ConnectionFactory.class.getResource("conf/jdbc.properties")
//            .getFile();
    private static String server = "postgresql";

    protected ConnectionFactory() {}

    public static ConnectionFactory getInstance() throws IOException {
        if(instance == null) {
//            Properties properties = new Properties();
//            try {
//                InputStream input = new FileInputStream(new File(propertiesPath));
//                properties.load(input);
//                server = properties.getProperty("server");
//            }
//            catch(IOException ex) {
//                System.err.println(ex.getMessage());
//                throw new IOException("Erro ao obter informações do banco de dados.");
//            }
//            if(getServer().equals("postgresql")) {
//                instance = new PgConnectionFactory();
//            }
//            else {
//                throw new RuntimeException("Servidor de banco de dados não suportado.");
//            }
            instance = new PgConnectionFactory();
        }

        return instance;
    }
    
    public static String getServer() {
        return server;
    }

    public abstract Connection getConnection()
            throws IOException, SQLException, ClassNotFoundException;
}