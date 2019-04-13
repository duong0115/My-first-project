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
public class LopDTO {

    String malop;
    String tenlop;

    public LopDTO() {
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public LopDTO(String malop, String tenlop) {
        this.malop = malop;
        this.tenlop = tenlop;
    }
}
