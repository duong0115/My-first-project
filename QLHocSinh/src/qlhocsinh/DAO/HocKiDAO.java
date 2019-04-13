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
import qlhocsinh.DTO.HocKiDTO;

/**
 *
 * @author DuoNg_Xt_685
 */
public class HocKiDAO implements BasicDAO<HocKiDTO>{

    @Override
    public List<HocKiDTO> getAll() {
        List<HocKiDTO> list = null;
        String sql = "SELECT*FROM tblhocki";
        ResultSet resultSet = ConnectionDAO.executeQuery(sql);
        if (resultSet == null) {
            System.out.println("Lỗi, getAll_HocSinh");
        } else {
            list = new ArrayList<HocKiDTO>();

            try {
                while (resultSet.next()) {
                    HocKiDTO hk = new HocKiDTO();
                    hk.setMahocki(resultSet.getString("mahocki"));
                    hk.setNam(resultSet.getString("nam"));
                    hk.setTenhocki(resultSet.getString("tenhocki"));
                    list.add(hk);

                }
            } catch (SQLException ex) {
                Logger.getLogger(HocKiDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            

        }
        return list;
    }

    @Override
    public HocKiDTO getByMa(String mahocki) {
        String sql="select*from tblgiaovien where tblgiaovien.malop = '"+mahocki+"'";
        HocKiDTO hk = new HocKiDTO();
        ResultSet resultSet = ConnectionDAO.executeQuery(sql);
        if(resultSet==null)
        {
            System.out.println("Lỗi, getByMa_MaHocKi");
        }
        else
        {

            try {
                while(resultSet.next())
                {
                    hk.setMahocki(resultSet.getString("mahocki"));
                    hk.setNam(resultSet.getString("nam"));
                    hk.setTenhocki(resultSet.getString("tenhocki"));
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return hk;
    }

    @Override
    public int insert(HocKiDTO t) {
        int rs = 0;
        String sql="insert into tblhocki(mahocki,nam,tenhocki) values('"+t.getMahocki()+"','"+t.getNam()+"',N'"+t.getTenhocki()+"')";
        
        rs =ConnectionDAO.executeNonQuery(sql);
        return rs;
    }

    @Override
    public boolean update(HocKiDTO t) {
        int rs = 0;
        String sql="update tblhocsinh settblhocki set nam='"+t.getNam()+"',tenhocki=N'"+t.getTenhocki()+"' where tblhocki.mahocki='"+t.getMahocki()+"'";
        
        rs =ConnectionDAO.executeNonQuery(sql);
        return rs==0;
    }

    @Override
    public boolean delete(String mahocki) {
        int rs = 0;
        String sql="delete from tblhocki where tblhocki.mahocki='"+mahocki+"'";
        
        rs =ConnectionDAO.executeNonQuery(sql);
        return rs==0;
    }
    
}
