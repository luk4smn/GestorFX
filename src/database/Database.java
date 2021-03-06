package database;

import javafx.application.Platform;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database{

    public Connection conn;                                              //conecta o BD
    public Statement  stm;                                               //prepara e realiza pesquisa no BD
    public ResultSet  rs;                                                //armazena o resultado da pesquisa
    private String driver,caminho,usuario,senha;

    private static final Properties config  = new Properties();

    private static final String     arquivo = "config.ini";

    public void connect(){                                              //metodo responsável por realizar a conexao cm o BD
        try {
            try {

                config.load(new FileInputStream(arquivo));
                driver  = config.getProperty("driver");
                caminho = config.getProperty("caminho");
                usuario = config.getProperty("usuario");
                senha   = config.getProperty("senha");
            }
            catch (IOException ex) {

                JOptionPane.showMessageDialog(null,"ARQUIVO DE CONFIGURAÇÃO NÃO ENCONTRADO \n" +ex);
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }

            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(caminho, usuario, senha);
        }
        catch (SQLException| ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null,"ERRO DE CONEXÃO \n" +ex);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            disconnect();
        }
    }

    public void executeSQL(String sql){
        try{
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog (null, "QUERY ERROR!\n " +ex.getMessage());
        }
    }

    public final void killDatabaseTasks() {
        this.connect();
        this.executeSQL("select count(*) from pg_stat_activity");
        this.executeSQL("select pid,query,state from pg_stat_activity where state like 'idle'");
        this.executeSQL("select pg_terminate_backend(pid) from pg_stat_activity where state='idle' and pid <> pg_backend_pid()");
        this.executeSQL("select pid,query,state from pg_stat_activity where state like 'idle'");
        this.disconnect();
        Platform.exit();
    }

    public void disconnect(){
        try {
            conn.close();
        }
        catch (SQLException ex) {

            JOptionPane.showMessageDialog(null,"ERRO AO FECHAR CONEXÃO");
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}