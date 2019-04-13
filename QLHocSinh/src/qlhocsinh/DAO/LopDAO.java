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
import qlhocsinh.DTO.LopDTO;

/**
 *
 * @author DuoNg_Xt_685
 */
public class LopDAO implements BasicDAO<LopDTO> {

    @Override
    public List<LopDTO> getAll() {
        List<LopDTO> list = null;
        String sql = "SELECT*FROM tbllop";
        ResultSet resultSet = ConnectionDAO.executeQuery(sql);
        if (resultSet == null) {
            System.out.println("Lỗi, getAll_Lop");
        } else {
            list = new ArrayList<LopDTO>();
            try {
                while (resultSet.next()) {
                    LopDTO lop = new LopDTO();
                    lop.setMalop(resultSet.getString("malop"));
                    lop.setTenlop(resultSet.getString("tenlop"));
                    list.add(lop);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public LopDTO getByMa(String ma) {
        String sql = "select*from tbllop where tbllop.malop = '" + ma + "'";
        LopDTO lop = new LopDTO();
        ResultSet resultSet = ConnectionDAO.executeQuery(sql);
        if (resultSet == null) {
            System.out.println("Lỗi, getByMa_MaLop");
        } else {
            try {
                while (resultSet.next()) {
                    lop.setMalop(resultSet.getString("malop"));
                    lop.setTenlop(resultSet.getString("tenlop"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return lop;
    }

    @Override
    public int insert(LopDTO t) {
        int rs = 0;
        String sql = "insert into tbllop(tenlop,malop) values(N'" + t.getTenlop() + "','" + t.getMalop() + "')";
        rs = ConnectionDAO.executeNonQuery(sql);
        return rs;
    }

    @Override
    public boolean update(LopDTO t) {
        int rs = 0;
        String sql = "update tbllop set tenlop=N'" + t.getTenlop() + "' where tbllop.malop='" + t.getMalop() + "'";
        rs = ConnectionDAO.executeNonQuery(sql);
        return rs==0;
    }

    @Override
    public boolean delete(String malop) {
        int rs = 0;
        String sql = "delete from tbllop where tbllop.malop='"+malop+"'";
        rs = ConnectionDAO.executeNonQuery(sql);
        return rs==0;
    }

}
