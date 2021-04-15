import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class OrdenarFechas{
  public static void main(String [ ] args) throws ParseException {
   DateFormat dateFormat = new     
   SimpleDateFormat("yyyy-mm-dd");
    List<Date> fechas = new ArrayList<Date>(); 
	fechas.add(dateFormat.parse("1968-10-02"));
    fechas.add(dateFormat.parse("1821-09-28"));
    fechas.add(dateFormat.parse("1847-09-14"));
    fechas.add(dateFormat.parse("1938-03-18"));
    fechas.add(dateFormat.parse("2014-09-26"));
	
    System.out.println("Fechas: Antes sorting: ");
    for (Date date : fechas) {
        System.out.println(dateFormat.format(date));
    }
    Collections.sort(fechas);
    System.out.println("Fechas: Despues sorting: ");
    for (Date date : fechas) {
      System.out.println(dateFormat.format(date));
    }    }
}
