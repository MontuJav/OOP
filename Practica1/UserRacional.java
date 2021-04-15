
/*
    Práctica1 -  Calculadora de Numeros Racionales 
    Godinez Montero Esmeralda 
    Montufar Perez Javier 
    2CM5 POO 12/11/2020
*/
package practica1nb;
import java.util.Scanner;

public class UserRacional {
    public static void main(String[] args){
      
       Scanner entrada = new Scanner(System.in);
       int op;     
       System.out.println("\n1. Calculadora");
       System.out.println("2. Ir a Quiz");
       System.out.println("3. Salir \n");
      
       System.out.print("Digite la opción: "); 
       op = entrada.nextInt();
      
        switch(op){
            case 1: 
            {
                Calculadora nueva = new Calculadora();
                nueva.setVisible(true);
               
            } break;
            case 2:
            {
                OpRandom nueva = new OpRandom();
                nueva.setVisible(true);
                
            } break;
            
            case 3:
            {
                System.exit(0);
            }
           
        }
     
        
        
    }
                  
}
    



