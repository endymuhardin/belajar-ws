/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.peserta;

import aplikasi.peserta.domain.Peserta;
import aplikasi.peserta.service.ManajemenPesertaService;
import aplikasi.peserta.service.impl.dummy.ManajemenPesertaServiceDummy;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Student-03
 */
@WebService(serviceName = "ManajemenPesertaWS")
public class ManajemenPesertaWS {

    ManajemenPesertaService service = new ManajemenPesertaServiceDummy();
    
    
    
    /** This is a sample web service operation */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findPesertaByNomerPeserta")
    public Peserta findPesertaByNomerPeserta(@WebParam(name = "nomerPeserta")
    String nomerPeserta) {
        //TODO write your implementation code here:
        return service.findPesrtaByNomerPeserta(nomerPeserta);
    }
}
