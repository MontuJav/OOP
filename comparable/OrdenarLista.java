import java.util.*;

public class OrdenarLista{
  public static void main(String [ ] args){
   List<Integer> numeros = Arrays.asList(
      10, 7, 1, 8, 0, 4, 2, 6, 3, 5, 9);
    System.out.println("Antes sorting: " + numeros);
    Collections.sort(numeros);
    System.out.println("Despues sorting: " + numeros);
	}
}
