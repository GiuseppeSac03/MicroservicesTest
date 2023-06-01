package ibm.academy.greetings;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingsController {
   final String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");

   @GetMapping(value = "/hello", produces = "text/plain")
   public String sayHello() {
      return "Hello from Spring Boot! " + new java.util.Date() + " on " + hostname + "\n";
   }

   @GetMapping(value = "/bonjour", produces = "text/plain")
   public String sayBonjour() {
      return "Bonjour de Spring Boot! " + new java.util.Date() + " sur " + hostname + "\n";
   }

   @GetMapping(value = "/hola", produces = "text/plain")
   public String sayHola() {
      return "Hola de Spring Boot! " + new java.util.Date() + " en " + hostname + "\n";
   }

   @GetMapping(value = "/ciao", produces = "text/plain")
   public String sayCiao() {
      return "Ciao da Spring Boot! " + new java.util.Date() + " su " + hostname + "\n";
   }
}