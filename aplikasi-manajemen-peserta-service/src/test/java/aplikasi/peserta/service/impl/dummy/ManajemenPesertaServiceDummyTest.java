/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.peserta.service.impl.dummy;

import aplikasi.peserta.domain.Peserta;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Student-03
 */
public class ManajemenPesertaServiceDummyTest {
    
    

    @Test
    public void testSimpan() {
        System.out.println("simpan");
        Peserta p = new Peserta();
        ManajemenPesertaServiceDummy instance = new ManajemenPesertaServiceDummy();
        instance.simpan(p);
        assertNotNull(p.getId());
        
        assertTrue(instance.countSemuaPeserta() == 1);
    }

}
