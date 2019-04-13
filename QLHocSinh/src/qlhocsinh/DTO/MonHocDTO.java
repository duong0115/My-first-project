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
public class MonHocDTO {

    String tenmon;
    String malop;
    String mamon;
    String mahocki;

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    public String getMahocki() {
        return mahocki;
    }

    public void setMahocki(String mahocki) {
        this.mahocki = mahocki;
    }

    public MonHocDTO() {
    }

    public MonHocDTO(String tenmon, String malop, String mamon, String mahocki) {
        this.tenmon = tenmon;
        this.malop = malop;
        this.mamon = mamon;
        this.mahocki = mahocki;
    }

}
