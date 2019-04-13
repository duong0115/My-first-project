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
import qlhocsinh.DTO.DiemDTO;

/**
 *
 * @author DuoNg_Xt_685
 */
public class DiemDAO implements BasicDAO<DiemDTO>{

    @Override
    public List<DiemDTO> getAll() {
        List<DiemDTO> list = null;
        String sql= "SELECT*FROM tbldiem";
        ResultSet resultSet = ConnectionDAO.executeQuery(sql);
        if(resultSet==null)
        {
            System.out.println("Lỗi, getAll_Diem");
        }
        else
        {
            list = new ArrayList<DiemDTO>();
   
            try {
                while(resultSet.next())
                {
                    DiemDTO diem= new DiemDTO();
                    diem.setDiem(resultSet.getInt("diem"));
                    diem.setMahs(resultSet.getString("mahs"));
                    diem.setMamon(resultSet.getString("mamon"));
                    list.add(diem);
                    
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return list;
    }

    @Override
    public DiemDTO getByMa(String mahs) {
        String sql="select*from tbldiem where tbldiem.mahs = '"+mahs+"'";
        DiemDTO diem = new DiemDTO();
        ResultSet resultSet = ConnectionDAO.executeQuery(sql);
        if(resultSet==null)
        {
            System.out.println("Lỗi, getByMa_Mahs");
        }
        else
        {
            try {
                while(resultSet.next())
                {
                    diem.setDiem(resultSet.getInt("diem"));
                    diem.setMahs(resultSet.getString("mahs"));
                    diem.setMamon(resultSet.getString("mamon"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return diem;
    }
    public DiemDTO getByMaMon(String mamon) {
        String sql="select*from tbldiem where tbldiem.mamon = '"+mamon+"'";
        DiemDTO diem = new DiemDTO();
        ResultSet resultSet = ConnectionDAO.executeQuery(sql);
        if(resultSet==null)
        {
            System.out.println("Lỗi, getByMa_MaMon");
        }
        else
        {
            try {
                while(resultSet.next())
                {
                    diem.setDiem(resultSet.getInt("diem"));
                    diem.setMahs(resultSet.getString("mahs"));
                    diem.setMamon(resultSet.getString("mamon"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return diem;
    }

    @Override
    public int insert(DiemDTO t) {
        int rs = 0;
        String sql="insert into tbldiem (diem,mahs,mamon) values("+t.getDiem()+",'"+t.getMahs()+"','"+t.getMamon()+"')";
        rs =ConnectionDAO.executeNonQuery(sql);
        return rs;
    }

    @Override
    public boolean update(DiemDTO t) {
        int rs = 0;
        String sql="update tbldiem set diem="+t.getDiem()+" where tbldiem.mahs='"+t.getMahs()+"' and tbldiem.mamon='"+t.getMamon()+"'";
        rs =ConnectionDAO.executeNonQuery(sql);
        return rs==0;
    }

    @Override
    public boolean delete(String mahs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean delete(String mahs,String mamon) {
        int rs = 0;
        String sql="delete from tbldiem where tbldiem.mahs='"+mahs+"' and tbldiem.mamon='"+mamon+"'";
        rs =ConnectionDAO.executeNonQuery(sql);
        return rs==0;
    }
    
}
