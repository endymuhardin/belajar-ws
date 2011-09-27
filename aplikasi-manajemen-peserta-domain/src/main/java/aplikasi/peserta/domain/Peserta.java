/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.peserta.domain;

import java.util.Date;

/**
 *
 * @author Student-03
 */
public class Peserta {
    private Integer id;
    private String nomerPeserta;
    private String nama;
    private Date tanggalLahir;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomerPeserta() {
        return nomerPeserta;
    }

    public void setNomerPeserta(String nomerPeserta) {
        this.nomerPeserta = nomerPeserta;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
    
    
}
