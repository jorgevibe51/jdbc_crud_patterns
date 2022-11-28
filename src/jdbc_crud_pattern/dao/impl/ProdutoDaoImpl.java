/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc_crud_pattern.dao.impl;

import java.util.List;
import jdbc_crud_pattern.beans.Produto;
import jdbc_crud_pattern.config.DBManager;
import jdbc_crud_pattern.dao.ProdutoDAO;
import java.sql.*;
/**
 *
 * @author Jorge
 */
public class ProdutoDaoImpl implements ProdutoDAO{

    @Override
    public void save(Produto bean) {
        try(Connection conn = DBManager.getConnection();
            PreparedStatement pstm = conn.prepareStatement("""
                                                           INSERT INTO produto(nome, valor, datavalidade)
                                                                  VALUES (?, ?, ?)
                                                           """)){
            
            pstm.setString(1, bean.getNome());
            pstm.setDouble(2, bean.getValor());
            pstm.setDate(3, bean.getDataValidade());
            pstm.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Produto> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Produto findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
