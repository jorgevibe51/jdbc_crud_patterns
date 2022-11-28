/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbc_crud_pattern;

import jdbc_crud_pattern.config.DBManager;
import java.sql.*;
import jdbc_crud_pattern.beans.Produto;
import jdbc_crud_pattern.dao.impl.ProdutoDaoImpl;

/**
 *
 * @author Jorge
 */
public class Jdbc_crud_pattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProdutoDaoImpl dao = new ProdutoDaoImpl();
        try (Connection conn = DBManager.getConnection()){
            
            //salvando um produto
            Produto produto = new Produto(0, "Batata", 7.50, Date.valueOf("2022-10-10"));
            //dao.save(produto);
            
            //listagem dos produtos
            for(Produto prod:dao.findAll()){
                System.out.println(prod);
            }
            
            //busca produto por codigo
            System.out.println("buscar produto por codigo:");
            Produto prod = dao.findById(7);
            System.out.println(prod);
            
            //delete um registro por id
            dao.delete(7);
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
