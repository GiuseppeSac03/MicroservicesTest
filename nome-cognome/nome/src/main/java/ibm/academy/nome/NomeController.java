package ibm.academy.nome;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NomeController {

   @GetMapping(value = "/nome", produces = "text/plain")
   public String sayNome() {
      return "Francesco";
   }
}