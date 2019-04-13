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
import qlhocsinh.DTO.HocSinhDTO;

/**
 *
 * @author DuoNg_Xt_685
 */
public class HocSinhDAO implements BasicDAO<HocSinhDTO>{

    @Override
    public List<HocSinhDTO> getAll() {
        List<HocSinhDTO> list = null;
        String sql = "SELECT*FROM tblhocsinh";
        ResultSet resultSet = ConnectionDAO.executeQuery(sql);
        if (resultSet == null) {
            System.out.println("Lỗi, getAll_HocSinh");
        } else {
            list = new ArrayList<HocSinhDTO>();

            
            try {
                while (resultSet.next()) {
                    HocSinhDTO hs = new HocSinhDTO();
                    hs.setGioitinh(resultSet.getString("gioitinh"));
                    hs.setMahs(resultSet.getString("mahs"));
                    hs.setMalop(resultSet.getString("malop"));
                    hs.setNgaysinh(resultSet.getString("ngaysinh"));
                    hs.setQuequan(resultSet.getString("quequan"));
                    hs.setSodienthoai(resultSet.getInt("sodienthoai"));
                    hs.setTenhs(resultSet.getString("tenhs"));
                    list.add(hs);

                }
            } catch (SQLException ex) {
                Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        }
        return list;
    }

    @Override
    public HocSinhDTO getByMa(String mahs) {
        String sql="select*from tblhocsinh where tblhocsinh.mahs = '"+mahs+"'";
        HocSinhDTO hs = new HocSinhDTO();
        ResultSet resultSet = ConnectionDAO.executeQuery(sql);
        if(resultSet==null)
        {
            System.out.println("Lỗi, getByMa_MaHS");
        }
        else
        {

            try {
                while(resultSet.next())
                {
                    hs.setGioitinh(resultSet.getString("gioitinh"));
                    hs.setMahs(resultSet.getString("mahs"));
                    hs.setMalop(resultSet.getString("malop"));
                    hs.setNgaysinh(resultSet.getString("ngaysinh"));
                    hs.setQuequan(resultSet.getString("quequan"));
                    hs.setSodienthoai(resultSet.getInt("sodienthoai"));
                    hs.setTenhs(resultSet.getString("tenhs"));
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return hs;
    }
    public HocSinhDTO getByMaLop(String malop) {
        String sql="select*from tblhocsinh where tblhocsinh.malop = '"+malop+"'";
        HocSinhDTO hs = new HocSinhDTO();
        ResultSet resultSet = ConnectionDAO.executeQuery(sql);
        if(resultSet==null)
        {
            System.out.println("Lỗi, getByMa_MaLop");
        }
        else
        {

            try {
                while(resultSet.next())
                {
                    hs.setGioitinh(resultSet.getString("gioitinh"));
                    hs.setMahs(resultSet.getString("mahs"));
                    hs.setMalop(resultSet.getString("malop"));
                    hs.setNgaysinh(resultSet.getString("ngaysinh"));
                    hs.setQuequan(resultSet.getString("quequan"));
                    hs.setSodienthoai(resultSet.getInt("sodienthoai"));
                    hs.setTenhs(resultSet.getString("tenhs"));
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return hs;
    }

    @Override
    public int insert(HocSinhDTO t) {
        int rs = 0;
        String sql="insert into tblhocsinh(gioitinh,mahs,malop,ngaysinh,quequan,sodienthoai,tenhs) values(N'"+t.getGioitinh()+"','"+t.getMahs()+"',"
                + "'"+t.getMalop()+"','"+t.getNgaysinh()+"',N'"+t.getQuequan()+"',"+t.getSodienthoai()+",N'"+t.getTenhs()+"')";
        
        rs =ConnectionDAO.executeNonQuery(sql);
        return rs;
    }

    @Override
    public boolean update(HocSinhDTO t) {
        int rs = 0;
        String sql="update tblhocsinh set giotinh=N'"+t.getGioitinh()+"',malop='"+t.getMalop()+"',ngaysinh='"+t.getNgaysinh()+"',"
                + "quequan=N'"+t.getQuequan()+"',sodienthoai="+t.getSodienthoai()+",tenhs=N'"+t.getTenhs()+"' where tblhocsinh.mahs='"+t.getMahs()+"')";
        
        rs =ConnectionDAO.executeNonQuery(sql);
        return rs==0;
    }

    @Override
    public boolean delete(String ma) {
        int rs = 0;
        String sql="delete from tblhocsinh where tblhocsinh.mahs='"+ma+"'";
        
        rs =ConnectionDAO.executeNonQuery(sql);
        return rs==0;
    }
    
}
