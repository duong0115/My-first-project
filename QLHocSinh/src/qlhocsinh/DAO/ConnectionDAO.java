/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhocsinh.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DuoNg_Xt_685
 */
public class ConnectionDAO {
    public static Connection getConnection()
    {
        String url="jdbc:mysql://localhost:3306/qlhs?useSSL=false";
        String username="root";
        String password="duongmicki6855";
        Connection con= null;
        
        try {
            
            System.out.println("ket noi thanh cong CSDL");
            con= DriverManager.getConnection(url, username, password);
            return con;
        } catch (SQLException ex) {
            System.out.println("Ket noi that bai CSDL");
            Logger.getLogger(ConnectionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static ResultSet executeQuery(String sql)
    {
        ResultSet resultSet=null;
        Statement statement=null;
        try {
            statement = getConnection().createStatement();
            resultSet= statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(resultSet!=null)
            {

                try {
                   resultSet.close();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement !=null)
            {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(getConnection() !=null)
            {
                try {
                    getConnection().close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
    public static int executeNonQuery(String sql)
    {
        Statement statement=null;
        try {
             statement= getConnection().createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(getConnection() !=null)
            {
                try {
                    getConnection().close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement!=null)
            {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectionDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }
}
