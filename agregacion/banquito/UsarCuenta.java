public class UsarCuenta {               
         public static void main(String [ ] args){
                 //Creamos el objeto cta1 con el constructor de la clase,
                 // con un saldo inicial de 100.0 pesos
                 Cuenta cta1 = new Cuenta (100.0);
                 //Creamos el objeto cta2 con el constructor de la clase,
                 // con un saldo inicial de 235.60 pesos
                 Cuenta cta2 = new Cuenta (235.60);
                 //
                 Cuenta cta3 = new Cuenta ();
                  //Depositamos 30.5 pesos a cta1
                  cta1.saldo = cta1.saldo + 30.5;
                  //Depositamos 65.83 pesos a cta2
                  cta2.saldo = cta2.saldo + 65.83;
                  //Imprimimos los saldos de ambas cuentas
                  System.out.println("Saldo cta1 = " + cta1.saldo);
                  System.out.println("Saldo cta2 = " + cta2.saldo); 
				  //Retiramos 500 pesos de cta1
                  cta1.saldo = cta1.saldo - 500;
                  //Retiramos 500 pesos de cta2
                  cta2.saldo = cta2.saldo - 500;
                  //Imprimimos los saldos de ambas cuentas
                  System.out.println("Saldo cta1 = " + cta1.saldo);
                  System.out.println("Saldo cta2 = " + cta2.saldo);
                  System.out.println("Saldo cta3 = " + cta3.saldo); 
      } // Fin de método main
} // Fin de la clase
