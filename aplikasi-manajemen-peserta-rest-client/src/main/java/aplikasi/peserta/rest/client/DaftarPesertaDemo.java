/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.peserta.rest.client;

import aplikasi.peserta.domain.Peserta;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.client.CommonsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Student-03
 */
public class DaftarPesertaDemo {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate(new CommonsClientHttpRequestFactory());
        
        String url = "http://localhost:8080/aplikasi-manajemen-peserta-springmvc-0.1.1-SNAPSHOT/rest/peserta/{id}";
        Integer id = 0;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        
        
        Peserta p = restTemplate.getForObject(url, Peserta.class, params);
        System.out.println("Nama : "+p.getNama());
    }
}
