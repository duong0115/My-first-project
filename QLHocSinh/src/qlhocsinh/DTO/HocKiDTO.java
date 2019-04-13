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
public class HocKiDTO {
    String tenhocki;
    String mahocki;
    String nam;

    public String getTenhocki() {
        return tenhocki;
    }

    public void setTenhocki(String tenhocki) {
        this.tenhocki = tenhocki;
    }

    public String getMahocki() {
        return mahocki;
    }

    public void setMahocki(String mahocki) {
        this.mahocki = mahocki;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public HocKiDTO(String tenhocki, String mahocki, String nam) {
        this.tenhocki = tenhocki;
        this.mahocki = mahocki;
        this.nam = nam;
    }

    public HocKiDTO() {
    }
}
