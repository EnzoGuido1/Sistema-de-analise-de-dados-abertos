package br.uel.bd1.dadosparlamentares.factory;

import br.uel.bd1.dadosparlamentares.dao.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAOFactory implements AutoCloseable {
    protected Connection connection;

    public static DAOFactory getInstance()
            throws ClassNotFoundException, IOException, SQLException {
        Connection connection = GenericConnectionFactory.getInstance().getConnection();
        DAOFactory factory;

        if(GenericConnectionFactory.getServer().equals("postgresql")) {
            factory = new PgDAOFactory(connection);
        }
        else {
            throw new RuntimeException("Servidor de banco de dados não suportado.");
        }

        return factory;
    }

    public void beginTransaction() throws SQLException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

            throw new SQLException("Erro ao abrir transação.");
        }
    }

    public void commitTransaction() throws SQLException {
        try {
            connection.commit();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

            throw new SQLException("Erro ao finalizar transação.");
        }
    }

    public void rollbackTransaction() throws SQLException {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

            throw new SQLException("Erro ao executar transação.");
        }
    }

    public void endTransaction() throws SQLException {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

            throw new SQLException("Erro ao finalizar transação.");
        }
    }

    public void closeConnection() throws SQLException {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

            throw new SQLException("Erro ao fechar conexão ao banco de dados.");
        }
    }
    @Override
    public void close() throws SQLException {
        closeConnection();
    }

    public abstract BlocoDAO getBlocoDAO();
    public abstract DeputadoDAO getDeputadoDAO();
    public abstract DespesaDAO getDespesaDAO();
    public abstract DespesaPartidoDAO getDespesaPartidoDAO();
    public abstract DespesaPoliticoDAO getDespesaPoliticoDAO();
    public abstract FornecedorDAO getFornecedorDAO();
    public abstract LegislaturaDAO getLegislaturaDAO();
    public abstract LegislaturaCamaraDAO getLegislaturaCamaraDAO();
    public abstract LegislaturaSenadoDAO getLegislaturaSenadoDAO();
    public abstract PartidoDAO getPartidoDAO();

    public abstract PoliticoDAO getPoliticoDAO();
    public abstract PoliticoPropoeDAO getPoliticoPropoeDAO();
    public abstract PoliticoVotaDAO getPoliticoVotaDAO();
    public abstract ProposicaoDAO getProposicaoDAO();
    public abstract SenadorDAO getSenadorDAO();
    public abstract VotacaoDAO getVotacaoDAO();
}