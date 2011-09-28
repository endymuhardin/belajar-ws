/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.peserta.jaxws.client.demo;

import aplikasi.peserta.Peserta;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

/**
 *
 * @author Student-03
 */
public class DemoSimpanPeserta {
    public static void main(String[] args) throws DatatypeConfigurationException {
        Peserta p = new Peserta();
        p.setId(100);
        p.setNomerPeserta("AA-12345");
        p.setNama("Mansyur");
        p.setTanggalLahir(DatatypeFactory.newInstance()
                .newXMLGregorianCalendar(new GregorianCalendar(1900, 12, 31)));
        
        try { // Call Web Service Operation
            aplikasi.peserta.ManajemenPesertaWS_Service service = new aplikasi.peserta.ManajemenPesertaWS_Service();
            aplikasi.peserta.ManajemenPesertaWS port = service.getManajemenPesertaWSPort();
            // TODO process result here
            aplikasi.peserta.Peserta result = port.simpan(p);
            System.out.println("Result = "+result);
        } catch (Exception ex) {
        // TODO handle custom exceptions here
        }

    }
}
