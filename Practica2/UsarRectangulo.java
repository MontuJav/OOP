/*
    Práctica2 -  Agregacion de clases, herencia, interfaces
    Montufar Perez Javier 
    2CM5 POO 15/01/2020
*/
public class UsarFecha {               
         public static void main(String [ ] args){
			 
				//NOTA favor de quitar los comentarios al cuadrante que se requiera revisar y comentar el resto.
				
		  Fecha f1 = new Fecha(20,3,2020);
		  Fecha f2 = new Fecha();
		  Fecha f3 = f1.obtenerFecha();
		  System.out.println("La fecha f1 es: "+f1);
		  System.out.println("La fecha por defecto es: "+f2);
		  f2.establecerFecha(12,12,2020);
		  System.ouy.println("La fecha por establecida es: "+f2);
		  System.ouy.println("La fecha f3: "+f3);
          } 
}