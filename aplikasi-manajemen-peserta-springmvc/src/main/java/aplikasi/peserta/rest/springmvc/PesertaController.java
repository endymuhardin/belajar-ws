/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.peserta.rest.springmvc;

import aplikasi.peserta.domain.Peserta;
import aplikasi.peserta.service.ManajemenPesertaService;
import aplikasi.peserta.service.impl.dummy.ManajemenPesertaServiceDummy;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Student-03
 */
@Controller
@RequestMapping("/peserta")
public class PesertaController {
    static ManajemenPesertaService service = new ManajemenPesertaServiceDummy();
    
    
    public PesertaController(){
        Peserta p = new Peserta();
        p.setNomerPeserta("ABC-123");
        p.setNama("Endy Muhardin");
        p.setTanggalLahir(new Date());
        service.simpan(p);
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    @ResponseBody
    public List<Peserta> semuaPeserta(){
        Integer start = 0; 
        Integer rows = 10;
        return service.findSemuaPeserta(start, rows);
    }
}
