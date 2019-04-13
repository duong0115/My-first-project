/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhocsinh.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import qlhocsinh.DTO.AdminDTO;

/**
 *
 * @author DuoNg_Xt_685
 */
public class AdminDAO implements BasicDAO<AdminDTO>{

    @Override
    public List<AdminDTO> getAll() {
        List<AdminDTO> list = null;
        String sql= "SELECT*FROM tbladmin";
        ResultSet resultSet = ConnectionDAO.executeQuery(sql);
        if(resultSet==null)
        {
            System.out.println("Lỗi, getAll_Admin");
        }
        else
        {
            list= new ArrayList<AdminDTO>();
            try {
                while(resultSet.next())
                {
                    AdminDTO ad= new AdminDTO();
                    ad.setUsername(resultSet.getString("username"));
                    ad.setPass(resultSet.getString("pass"));
                    ad.setLv(resultSet.getInt("lv"));
                    list.add(ad);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public AdminDTO getByMa( String username) {
        String sql="select*from tbladmin where tbladmin.username = '"+username+"'";
        AdminDTO ad = new AdminDTO();
        ResultSet resultSet = ConnectionDAO.executeQuery(sql);
        if(resultSet==null)
        {
            System.out.println("Lỗi, getByMa_Admin");
        }
        else
        {
            try {
                while(resultSet.next())
                {
                    ad.setUsername(resultSet.getString("username"));
                    ad.setPass(resultSet.getString("pass"));
                    ad.setLv(resultSet.getInt("lv"));  
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ad;
    }

    @Override
    public int insert(AdminDTO t) {
        int rs = 0;
        String sql="insert into tbladmin(username,lv) values('"+t.getUsername()+"',"+t.getLv()+"),";
        rs =ConnectionDAO.executeNonQuery(sql);
        return rs;
    }

    @Override
    public boolean update(AdminDTO t) {
        int rs= 0;
        String sql="update tbladmin set pass='"+t.getPass()+"',lv="+t.getLv()+" where tbladmin.username='"+t.getUsername()+"'";
        rs = ConnectionDAO.executeNonQuery(sql);
        return rs==0;
    }

    @Override
    public boolean delete(String username) {
        int rs=0;
        String sql="delete from tbladmin where tbladmin.username ='"+username+"'";
        rs= ConnectionDAO.executeNonQuery(sql);
        return rs==0;
    }
    
}
