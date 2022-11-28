/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jdbc_crud_pattern.dao;

import java.util.List;

/**
 *
 * @author Jorge
 */
public interface JdbcDAO<T, U> {
    
    void save(T bean);
    
    List<T> findAll();
    
    T findById(U id);
    
    void update(T bean);
    
    void delete(U id);
    
}
