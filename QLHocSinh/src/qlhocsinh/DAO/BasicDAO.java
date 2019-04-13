/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhocsinh.DAO;

import java.util.List;

/**
 *
 * @author DuoNg_Xt_685
 */
public interface BasicDAO<T> {
    public List<T> getAll();// lấy tất thông tin bảng trong Csdl
    public T getByMa(String ma); // Tìm kiếm 1 đối tượng trong bảng bằng primary key
    public int insert(T t); // insert 1 đối tượng vào bảng
    public boolean update(T t); // update 1 đối tượng vào bảng
    public boolean delete(String ma); // delete 1 đối tượng vào bảng
    
}
