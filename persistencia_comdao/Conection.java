/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia_semdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vitor
 */
public class Conection {
    public static Connection conect = null;

    /*QUERY DE CONEXAO COM BANCO DE DADOS*/
    public static void openConnection(){
            String HOST = "localhost";
            int PORT = 3306;
            String USER = "root";
            String PASS = "";
            String DB = "leon";
            String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB;
            if(conect != null){
                return;
            }
            try {
                conect = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("Sucesso");
            } catch (SQLException e) {
                System.out.println("Connection with mysql error");
                System.out.println(e.getSQLState()+ " " + e.getMessage() + " " + e.getErrorCode() + " " + e.getCause());
            }

    }
    public static Connection getConexao(){
        if(conect == null){
            openConnection();
        }
        return conect;
    }
    
}
