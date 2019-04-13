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
public class HocSinhDTO {

    String malop;
    String mahs;
    String quequan;
    String gioitinh;
    String ngaysinh;
    int sodienthoai;
    String tenhs;

    public HocSinhDTO(String malop, String mahs, String quequan, String gioitinh, String ngaysinh, int sodienthoai, String tenhs) {
        this.malop = malop;
        this.mahs = mahs;
        this.quequan = quequan;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.sodienthoai = sodienthoai;
        this.tenhs = tenhs;
    }

    public HocSinhDTO() {
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getMahs() {
        return mahs;
    }

    public void setMahs(String mahs) {
        this.mahs = mahs;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public int getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(int sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getTenhs() {
        return tenhs;
    }

    public void setTenhs(String tenhs) {
        this.tenhs = tenhs;
    }
}
