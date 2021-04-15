/*
    Práctica2 -  Agregacion de clases, herencia, interfaces
    Montufar Perez Javier 
    2CM5 POO 15/01/2020
*/
public class UsarFecha {               
         public static void main(String [ ] args){
			 
				//NOTA favor de quitar los comentarios al cuadrante que se requiera revisar y comentar el resto.
				
		  Fecha f1 = new Fecha(30,5,2020);
		  Fecha f2 = new Fecha();
		  f2.establecerFecha(1,3,2020);
		  
		  if(f1.esMayor(f2)==-1){
			  System.out.println(f1+" es menor "+"a"+f2);
		  }
		  else if(f1.esMayor(f2)==0){
			  System.out.println(f1+" es igual "+"a"+f2);
		  }
          else if(f1.esMayor(f2)==1){
			  System.out.println(f1+" es mayor "+"a"+f2);
		  }
		  
		  System.out.println("De "+f1+" a "+f2+" transcurren "+ f1.pasoMes(f2)+" meses");
		 }
}