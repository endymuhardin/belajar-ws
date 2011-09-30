/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.peserta.rest.client;

import aplikasi.peserta.domain.Peserta;
import aplikasi.peserta.rest.client.service.springmvc.ManajemenPesertaRestClientService;
import aplikasi.peserta.service.ManajemenPesertaService;
import java.util.List;

/**
 *
 * @author Student-03
 */
public class DaftarPesertaDemo {
    public static void main(String[] args) {
        ManajemenPesertaService service = new ManajemenPesertaRestClientService();
        Peserta p = service.findPesertaById(0);
        System.out.println("Nama : "+p.getNama());
        
        List<Peserta> semua = service.findSemuaPeserta(0, 100);
        for (Peserta peserta : semua) {
            System.out.println("Id Peserta : "+peserta.getId());
            System.out.println("Nomer Peserta : "+peserta.getNomerPeserta());
            System.out.println("Nama Peserta : "+peserta.getNama());
            System.out.println("Tanggal Lahir : "+peserta.getTanggalLahir());
        }
    }
}
