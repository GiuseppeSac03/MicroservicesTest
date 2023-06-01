package ibm.academy.persona;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PersonaController {

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping(value = "/persona", produces = "text/plain")
    public String persona() {

        String url = "http://nome:8080/nome";
        ResponseEntity<String> nomeRes = restTemplate.getForEntity(url, String.class);

        url = "http://cognome:8080/cognome";
        ResponseEntity<String> cognomeRes = restTemplate.getForEntity(url, String.class);

        return nomeRes.getBody() + " " + cognomeRes.getBody();
    }
}