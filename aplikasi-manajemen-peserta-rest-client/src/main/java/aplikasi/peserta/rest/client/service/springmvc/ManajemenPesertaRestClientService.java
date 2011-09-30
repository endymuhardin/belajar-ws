/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.peserta.rest.client.service.springmvc;

import aplikasi.peserta.domain.Peserta;
import aplikasi.peserta.service.ManajemenPesertaService;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.CommonsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Student-03
 */
public class ManajemenPesertaRestClientService implements ManajemenPesertaService {

    private static final String HOST = "localhost";
    private static final Integer PORT = 8080;
    private static final String APP_CONTEXT = "/aplikasi-manajemen-peserta-springmvc-0.1.1-SNAPSHOT";
    private static final String urlPesertaById = "http://"+HOST+":"+PORT+APP_CONTEXT+"/rest/peserta/{id}";
    private static final String urlPeserta = "http://"+HOST+":"+PORT+APP_CONTEXT+"/rest/peserta/";
    
    private RestTemplate restTemplate;
    
    public ManajemenPesertaRestClientService() {
        restTemplate = new RestTemplate(new CommonsClientHttpRequestFactory());
    }
    
    @Override
    public void simpan(Peserta p) {
        if(p.getId() == null) { //null artinya object baru
            URI uri = restTemplate.postForLocation(urlPeserta, p);
            System.out.println("Object baru sudah dibuat di : "+uri);
        } else {
            restTemplate.put(urlPesertaById, p, p.getId());
        }
    }

    @Override
    public Peserta findPesertaById(Integer id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        
        Peserta p = restTemplate.getForObject(urlPesertaById, Peserta.class, params);
        return p;
    }

    @Override
    public Peserta findPesertaByNomerPeserta(String no) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Peserta> findSemuaPeserta(Integer start, Integer rows) {
        HttpHeaders headers = new HttpHeaders();
        headers.set( "Accept", "application/json" );
        ResponseEntity<List> response = restTemplate.exchange(
                urlPeserta, 
                HttpMethod.GET, 
                new HttpEntity<String>(headers), 
                List.class);
        
        List<Peserta> hasil = new ArrayList<Peserta>();
        
        List responseBody = response.getBody();
        for (Object r : responseBody) {
            Map<String, Object> content = (Map<String, Object>) r;
            Peserta p = new Peserta();
            p.setId((Integer)content.get("id"));
            p.setNomerPeserta((String)content.get("nomerPeserta"));
            p.setNama((String)content.get("nama"));
            p.setTanggalLahir(new Date((Long) content.get("tanggalLahir")));
            hasil.add(p);
        }
        return hasil;
    }

    @Override
    public Long countSemuaPeserta() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Peserta> findPesertaByNama(String nama) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Long countPesertaByNama(String nama) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
