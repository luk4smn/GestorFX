package database;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database{

    public Connection conn;                                             //conecta o BD
    public Statement stm;                                               //prepara e realiza pesquisa no BD
    public ResultSet rs;                                                //armazena o resultado da pesquisa
    private String driver,caminho,usuario,senha;


    private static final Properties config = new Properties();
    private static final String arquivo = "config.ini";

    public void conectar(){                                           //metodo responsável por realizar a conexao cm o BD
        try {
            try {
                config.load(new FileInputStream(arquivo));
                driver = config.getProperty("driver");
                caminho = config.getProperty("caminho");
                usuario = config.getProperty("usuario");
                senha = config.getProperty("senha");
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
            desconectar();
        }
    }

    public void executarSQL(String sql){
        try{
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        }
        catch (SQLException ex) {
            //JOptionPane.showMessageDialog (null, "Erro ao executar função!\n Erro" +ex.getMessage());
        }
    }

    public void desconectar(){
        try {
            conn.close();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERRO AO FECHAR CONEXÃO");
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}