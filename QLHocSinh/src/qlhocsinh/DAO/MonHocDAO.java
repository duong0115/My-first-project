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
import qlhocsinh.DTO.MonHocDTO;

/**
 *
 * @author DuoNg_Xt_685
 */
public class MonHocDAO implements BasicDAO<MonHocDTO> {

    @Override
    public List<MonHocDTO> getAll() {
        List<MonHocDTO> list = null;
        String sql = "SELECT*FROM tblmonhoc";
        ResultSet resultSet = ConnectionDAO.executeQuery(sql);
        if (resultSet == null) {
            System.out.println("Lỗi, getAll_Lop");
        } else {
            list = new ArrayList<MonHocDTO>();

            try {
                while (resultSet.next()) {
                    MonHocDTO mon = new MonHocDTO();
                    mon.setMahocki(resultSet.getString("mahocki"));
                    mon.setMalop(resultSet.getString("malop"));
                    mon.setMamon(resultSet.getString("mamon"));
                    mon.setTenmon(resultSet.getString("tenmon"));
                    list.add(mon);
                }
            } catch (SQLException ex) {
                Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return list;
    }

    @Override
    public MonHocDTO getByMa(String ma) {
        String sql = "select*from tblmonhoc where tblmonhoc.mamon = '" + ma + "'";
        MonHocDTO mon = new MonHocDTO();
        ResultSet resultSet = ConnectionDAO.executeQuery(sql);
        if (resultSet == null) {
            System.out.println("Lỗi, getByMa_MaLop");
        } else {
            try {
                while (resultSet.next()) {
                    mon.setMahocki(resultSet.getString("mahocki"));
                    mon.setMalop(resultSet.getString("malop"));
                    mon.setMamon(resultSet.getString("mamon"));
                    mon.setTenmon(resultSet.getString("tenmon"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return mon;
    }
    public MonHocDTO getByMaLop(String malop) {
        String sql = "select*from tblmonhoc where tblmonhoc.malop = '" + malop + "'";
        MonHocDTO mon = new MonHocDTO();
        ResultSet resultSet = ConnectionDAO.executeQuery(sql);
        if (resultSet == null) {
            System.out.println("Lỗi, getByMa_MaLop");
        } else {
            try {
                while (resultSet.next()) {
                    mon.setMahocki(resultSet.getString("mahocki"));
                    mon.setMalop(resultSet.getString("malop"));
                    mon.setMamon(resultSet.getString("mamon"));
                    mon.setTenmon(resultSet.getString("tenmon"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return mon;
    }
    public MonHocDTO getByMaHocKi(String mahocki) {
        String sql = "select*from tblmonhoc where tblmonhoc.mahocki = '" + mahocki + "'";
        MonHocDTO mon = new MonHocDTO();
        ResultSet resultSet = ConnectionDAO.executeQuery(sql);
        if (resultSet == null) {
            System.out.println("Lỗi, getByMa_MaLop");
        } else {
            try {
                while (resultSet.next()) {
                    mon.setMahocki(resultSet.getString("mahocki"));
                    mon.setMalop(resultSet.getString("malop"));
                    mon.setMamon(resultSet.getString("mamon"));
                    mon.setTenmon(resultSet.getString("tenmon"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return mon;
    }

    @Override
    public int insert(MonHocDTO t) {
        int rs = 0;
        String sql = "insert into tblmonhoc(mahocki,malop,mamon,tenmon) values('"+t.getMahocki()+"','"+t.getMalop()+"','"+t.getMamon()+"',N'"+t.getTenmon()+"')";
        rs = ConnectionDAO.executeNonQuery(sql);
        return rs;
    }

    @Override
    public boolean update(MonHocDTO t) {
        int rs = 0;
        String sql = "update tblmonhoc set mahocki='"+t.getMahocki()+"',malop='"+t.getMalop()+"',mamon='"+t.getMamon()+"',tenmon=N'"+t.getTenmon()+"'";
        rs = ConnectionDAO.executeNonQuery(sql);
        return rs==0;
    }

    @Override
    public boolean delete(String mamon) {
        int rs = 0;
        String sql = "delete from tblmonhoc where tblmonhoc.mamon='"+mamon+"'";
        rs = ConnectionDAO.executeNonQuery(sql);
        return rs==0;
    }

}
