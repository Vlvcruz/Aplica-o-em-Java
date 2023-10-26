/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia_comdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vitor
 */
public class Conection {
    
    /*QUERY DE CONEXAO COM BANCO DE DADOS*/
    public static Connection getConexao()throws ClassNotFoundException, SQLException {
      
            // O método forName carrega e inicia o driver passado por parâmetro
            Class.forName("com.mysql.cj.jdbc.Driver"); //verificar em seu computador
            String URL = "jdbc:mysql://localhost:3306/aula_ioo";  //verificar em seu computador
            String USER = "root"; //verificar em seu computador
            String PASSWORD = ""; //verificar em seu computador
            // Estabelecendo a conexão
            return DriverManager.getConnection(URL, USER, PASSWORD);     

    }
    
}
