/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhocsinh.DTO;

/**
 *
 * @author DuoNg_Xt_685
 */
public class AdminDTO {
    String username;
    String pass;
    int lv;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getLv() {
        return lv;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public AdminDTO(String username, String pass, int lv) {
        this.username = username;
        this.pass = pass;
        this.lv = lv;
    }

    public AdminDTO() {
    }
    
}
