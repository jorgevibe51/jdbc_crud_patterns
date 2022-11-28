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
import java.util.LinkedList;
/**
 *
 * @author Jorge
 */
public class ProdutoDaoImpl implements ProdutoDAO{

    @Override
    public void save(Produto bean) {
        try(Connection conn = DBManager.getInstance().getConnection();
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
        List<Produto> produtos = null;
        try (Connection conn = DBManager.getInstance().getConnection();
             Statement stm = conn.createStatement()){
            produtos = new LinkedList<>();
            ResultSet rs = stm.executeQuery("SELECT codigo, nome, valor, datavalidade FROM produto");
            while (rs.next()){
                produtos.add(new Produto(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDate(4)));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return produtos;
    }

    @Override
    public Produto findById(Integer id) {
        Produto produto = null;
        try (Connection conn = DBManager.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement("SELECT codigo, nome, valor, datavalidade  FROM produto WHERE codigo = ?")){
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();
            rs.next();
            produto = new Produto(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDate(4));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }

    @Override
    public void delete(Integer id) {
        try (Connection conn = DBManager.getInstance().getConnection();
             PreparedStatement pstm = conn.prepareStatement("DELETE FROM produto WHERE codigo = ?")){
            pstm.setInt(1, id);
            if (pstm.executeUpdate()==0)
                System.out.println("Err: não encontrado registro para deletar");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
