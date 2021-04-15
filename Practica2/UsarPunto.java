/*
    Práctica2 -  Agregacion de clases 
    Montufar Perez Javier 
    2CM5 POO 15/01/2020
*/
public class UsarPunto {               
         public static void main(String [ ] args){
                 Punto O = new Punto();
                 Punto A = new Punto("A",1,-2);
				 Punto E = new Punto("E",3,4);
				 O.mover(-2,3);
				 System.out.println("La distancia entre "+ A +" y "+ O +" es:"+ A.distancia(O));
				 System.out.println("El punto E es:"+E);
				 System.out.println("El cuadrante de O es: "+ O.cuadrante());			 
         } 
}