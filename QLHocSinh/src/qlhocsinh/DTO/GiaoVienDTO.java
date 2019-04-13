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
public class GiaoVienDTO {

    String tengv;
    String magv;
    String pass;
    String malop;

    public GiaoVienDTO(String tengv, String magv, String pass, String malop) {
        this.tengv = tengv;
        this.magv = magv;
        this.pass = pass;
        this.malop = malop;
    }

    public GiaoVienDTO() {
    }

    public String getTengv() {
        return tengv;
    }

    public void setTengv(String tengv) {
        this.tengv = tengv;
    }

    public String getMagv() {
        return magv;
    }

    public void setMagv(String magv) {
        this.magv = magv;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

}
