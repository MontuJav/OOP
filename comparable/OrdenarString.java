import java.util.*;

public class OrdenarString{
  public static void main(String [ ] args){
   List<String> nombres = Arrays.asList(
      "Francesca", "Paolo", "GregorioSamsa", "PedroParamo", "JoseBuendia", "Rocinante",
     "Quijote", "Sancho", "Rebeca", "Ursula", "Aura");
    System.out.println("Antes sorting: " + nombres);
    Collections.sort(nombres);
    System.out.println("Despues sorting: " + nombres);
    }
}
