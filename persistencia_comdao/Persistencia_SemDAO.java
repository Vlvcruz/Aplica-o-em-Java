/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package persistencia_semdao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author vitor
 */
public class Persistencia_SemDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here

        Scanner scan = new Scanner(System.in);

        ProdutoDao pdao = new ProdutoDao();
        Produto p = new Produto();
        

        System.out.println("Ola... Qual acao voce deseja: \n 1- Cadastrar\n 2- Atualizar\n 3- Deletar\n 4- Consultar 1 Id\n 5- Consultar Produtos Cadastrados");
        int decisao = scan.nextInt();

        switch (decisao) {
            case 1: {

                System.out.println("Digite a descriao do produto...");
                clearBuffer(scan);
                p.setDescricao(scan.nextLine());
                System.out.println("Digite o valor do produto...");
                p.setPreco(scan.nextDouble());
                try {
                    pdao.cadastrar(p);
                    System.out.println("Cadastrado com sucesso!");
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            case 2: {

                System.out.println("Digite o Id do produto que deseja ser alterado...");
                clearBuffer(scan);
                p.setId(scan.nextInt());
                System.out.println("Digite a NOVA descricao do produto...");
                clearBuffer(scan);
                p.setDescricao(scan.nextLine());
                System.out.println("Digite o NOVO valor do produto...");
                p.setPreco(scan.nextDouble());
                try {
                    pdao.atualizar(p);
                    System.out.println("Atualizado com sucesso!");
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            case 3: {

                System.out.println("Digite o Id do produto que sera excluido...");
                clearBuffer(scan);
                p.setId(scan.nextInt());
                try {
                    pdao.delete(p);
                    System.out.println("Apagado com sucesso!");
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            case 4: {

                System.out.print("Digite ID: ");
                p.setId(scan.nextInt());
                try {
                    p = pdao.consultarById(p);
                    if (p.getDescricao() != null) {
                        System.out.println("Descricao..: " + p.getDescricao());
                        System.out.println("Preco......: " + p.getPreco());
                        System.out.println("\n");
                    } else {
                        System.out.println("ID nao encontrado.");
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
            }
            default: {
                try {
                    List<Produto> listaproduto = pdao.consultarTodos();

                    for (Produto p1 : listaproduto) {
                        System.out.println("\n ID........: " + p1.getId());
                        System.out.println("Descricao....: " + p1.getDescricao());
                        System.out.println("Preco......: " + p1.getPreco());
                    }
                } catch (SQLException ex) {
                    System.out.println("Erro irmao: " + ex.getMessage());

                }

            }
        }
    }

    public static void clearBuffer(Scanner sc) {
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
    }

}