/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia_semdao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author vitor
 */
public class ProdutoDao {
    
    /*QUERY PARA CONSULTAR TODOS PRODUTOS DO BD - INICIO */
    
    public List<Produto> consultarTodos() throws SQLException, ClassNotFoundException {
        Connection con = Conection.getConexao();
        PreparedStatement comando = con.prepareStatement("SELECT * FROM produtos WHERE 1");
        ResultSet rs = comando.executeQuery();

        List<Produto> listaprod = new ArrayList<Produto>();

        while (rs.next()) {
            Produto prod = new Produto();
            prod.setId(rs.getInt("id"));
            prod.setDescricao(rs.getString("descricao"));
            prod.setPreco(rs.getDouble("Preco"));
            listaprod.add(prod);
        }
        return listaprod;
    }
    /*QUERY PARA CONSULTAR TODOS PRODUTOS DO BD - FIM */
    
    /* QUERY PARA CONSULTAR 1 ID - INICIO */
    
    public Produto consultarById(Produto prod) throws ClassNotFoundException, SQLException {
        Connection con = Conection.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from produtos where id = ?");
        comando.setInt(1, prod.getId());
        // Armazena resultados da query
        ResultSet rs = comando.executeQuery();
        // Cria objeto produto
        Produto p = new Produto();
        //Atribui os valores no objeto produto
        if (rs.next()) {
            p.setId(rs.getInt("id"));
            p.setDescricao(rs.getString("descricao"));
            p.setPreco(rs.getDouble("preco"));
        }
        // Devolve o objeto Produto
        return p;
    }
    /* QUERY PARA CONSULTAR 1 ID - FIM */

    /*QUERY PARA CADASTRAR UM PRODUTO - INICIO*/
    
    public void cadastrar(Produto pro) throws SQLException, ClassNotFoundException{
        Connection con = Conection.getConexao();
        PreparedStatement comando = con.prepareStatement("Insert into produtos (descricao,preco)values(?,?)");

        comando.setString(1, pro.getDescricao());
        comando.setDouble(2, pro.getPreco());
        comando.execute();
        con.close();
    }
    /*QUERY PARA CADASTRAR UM PRODUTO - FIM*/
    
    /*QUERY PARA DELETAR UM PRODUTO - INICIO*/

    
    public void delete(Produto pro) throws SQLException, ClassNotFoundException{
        Connection con = Conection.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from produtos where id = ?");
        comando.setInt(1, pro.getId());
        comando.execute();
        con.close();

    }
    /*QUERY PARA CADASTRAR UM PRODUTO - FIM*/
    
    /*QUERY PARA ATUALIZAR UM PRODUTO - INICIO*/

    public void atualizar(Produto pro) throws SQLException, ClassNotFoundException{
        Connection con = Conection.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE produtos SET descricao = (?), preco = (?) WHERE id = (?)");
        comando.setString(1, pro.getDescricao());
        comando.setDouble(2, pro.getPreco());
        comando.setInt(3, pro.getId());
        comando.execute();
        con.close();

    }
    /*QUERY PARA CADASTRAR UM PRODUTO - FIM*/

 void atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
