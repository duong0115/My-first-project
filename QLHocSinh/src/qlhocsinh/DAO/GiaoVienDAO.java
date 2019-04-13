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
import qlhocsinh.DTO.GiaoVienDTO;

/**
 *
 * @author DuoNg_Xt_685
 */
public class GiaoVienDAO implements BasicDAO<GiaoVienDTO> {

    @Override
    public List<GiaoVienDTO> getAll() {
        List<GiaoVienDTO> list = null;
        String sql = "SELECT*FROM tblgiaovien";
        ResultSet resultSet = ConnectionDAO.executeQuery(sql);
        if (resultSet == null) {
            System.out.println("Lỗi, getAll_GiaoVien");
        } else {
            list = new ArrayList<GiaoVienDTO>();

            try {
                while (resultSet.next()) {
                    GiaoVienDTO gv = new GiaoVienDTO();
                    gv.setTengv(resultSet.getString("tengv"));
                    gv.setMagv(resultSet.getString("magv"));
                    gv.setMalop(resultSet.getString("malop"));
                    gv.setPass(resultSet.getString("pass"));
                    list.add(gv);

                }
            } catch (SQLException ex) {
                Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return list;
    }

    @Override
    public GiaoVienDTO getByMa(String magv) {
        String sql="select*from tblgiaovien where tblgiaovien.magv = '"+magv+"'";
        GiaoVienDTO gv = new GiaoVienDTO();
        ResultSet resultSet = ConnectionDAO.executeQuery(sql);
        if(resultSet==null)
        {
            System.out.println("Lỗi, getByMa_MaGV");
        }
        else
        {

            try {
                while(resultSet.next())
                {
                    gv.setTengv(resultSet.getString("tengv"));
                    gv.setMagv(resultSet.getString("magv"));
                    gv.setMalop(resultSet.getString("malop"));
                    gv.setPass(resultSet.getString("pass"));
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return gv;
    }
    
    public GiaoVienDTO getByMaLop(String malop) {
        String sql="select*from tblgiaovien where tblgiaovien.malop = '"+malop+"'";
        GiaoVienDTO gv = new GiaoVienDTO();
        ResultSet resultSet = ConnectionDAO.executeQuery(sql);
        if(resultSet==null)
        {
            System.out.println("Lỗi, getByMa_MaGV");
        }
        else
        {

            try {
                while(resultSet.next())
                {
                    gv.setTengv(resultSet.getString("tengv"));
                    gv.setMagv(resultSet.getString("magv"));
                    gv.setMalop(resultSet.getString("malop"));
                    gv.setPass(resultSet.getString("pass"));
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return gv;
    }

    @Override
    public int insert(GiaoVienDTO t) {
        int rs = 0;
        String sql="insert into tblgiaovien(tengv,magv,malop) values(N'"+t.getTengv()+"','"+t.getMagv()+"','"+t.getMalop()+"')";
        rs =ConnectionDAO.executeNonQuery(sql);
        return rs;
    }

    @Override
    public boolean update(GiaoVienDTO t) {
        int rs = 0;
        String sql="update tblgiaovien set tengv=N'"+t.getTengv()+"',malop='"+t.getMalop()+"',pass='"+t.getPass()+"')";
        rs =ConnectionDAO.executeNonQuery(sql);
        return rs==0;
    }

    @Override
    public boolean delete(String magv) {int rs = 0;
        String sql="delete from tblgiaovien where tblgiaovien.magv='"+magv+"'";
        rs =ConnectionDAO.executeNonQuery(sql);
        return rs==0;
    }

}
