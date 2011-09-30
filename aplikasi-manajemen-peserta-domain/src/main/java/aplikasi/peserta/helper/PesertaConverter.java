/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.peserta.helper;

import aplikasi.peserta.domain.Peserta;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Student-03
 */
public class PesertaConverter {
    public static Peserta fromMap(Map<String, Object> content){
        Peserta p = new Peserta();
        p.setId((Integer)content.get("id"));
        p.setNomerPeserta((String)content.get("nomerPeserta"));
        p.setNama((String)content.get("nama"));
        p.setTanggalLahir(new Date((Long) content.get("tanggalLahir")));
        return p;
    }
}
