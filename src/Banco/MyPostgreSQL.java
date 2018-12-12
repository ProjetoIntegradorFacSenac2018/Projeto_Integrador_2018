/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author Aluno
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MyPostgreSQL {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public MyPostgreSQL() {
        connection = null;
    }

    public boolean conecta() {
        connection = null;
// verifica se drive JDBC está acessível
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            String msg = "Driver JDBC PostgreSQL não foi encontrado.\n"
                    + e.getMessage();
            JOptionPane.showMessageDialog(null, msg,
                    "Conectar com BD", JOptionPane.ERROR_MESSAGE);
            return false;
        }
// string de conexão com banco de dados “agende simples”
        String conexao = "jdbc:postgresql://localhost:5432/db_integrador";
        try {
// conecta com BD usando usuário “postgres” e senha “root”
            connection = DriverManager.getConnection(conexao, "postgres", "aluno");
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            String msg = "Não foi possível conectar com Banco de Dados!\n"
                    + e.getMessage();
            JOptionPane.showMessageDialog(null, msg,
                    "Conectar com BD", JOptionPane.ERROR_MESSAGE);
            connection = null;
            return false;
        }
        return true;
    }

    public void encerra() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                String msg = "Erro no encerramento da conexão com BD.\n"
                        + e.getMessage();
                JOptionPane.showMessageDialog(null, msg,
                        "Conectar com BD", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}


