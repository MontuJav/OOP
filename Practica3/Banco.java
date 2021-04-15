import java.util.*;
public class Banco {               
         public static void main(String [ ] args){
			 
				//NOTA favor de quitar los comentarios al cuadrante que se requiera revisar y comentar el resto.
		  Fecha Hoy = new Fecha(12,12,2020);
		  ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		  
		  Cuenta c0 = new CtaAhorros(10000,10);
		  Cuenta c1 = new CtaCheques(256070,0);
		  Cuenta c2 = new CtaCredito(13245,100);
		  Cuenta c3 = new CtaCheques(765,20);
		  Cuenta c4 = new CtaAhorros(9000,20);
		  Cuenta c5 = new CtaAhorros(2300,10);
		  Cuenta c6 = new CtaCredito(25000,12);
		  
		  cuentas.add(c0);
		  cuentas.add(c1);
		  cuentas.add(c2);
		  cuentas.add(c3);
		  cuentas.add(c4);
		  cuentas.add(c5);
		  
		  Cliente C1=new Cliente("QUIJOTE",cuentas,"QX400");
		  Hoy.AvanzarTiempo(11,1,0);
		  
		  C1.depositar(1,1200, Hoy);
		  C1.retirar(2,1100, Hoy);
		  System.out.println("saldo cuenta 3:"+C1.consultar(3,Hoy));
		  C1.depositar(4,600, Hoy);
		  
		  //C1.reportarEdosCtas();
		  
		 }
}