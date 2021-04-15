public class Cliente {
		//la clase cliente esta en su propio archivo por eso es publica.
		
        // Atributo con acceso privado
        private String nombre;
        private Cuenta cuenta;
        private String numCta; //esto esta aca porque sirve de id
             
         // Constructor: inicializa objetos de la clase Cliente
         public Cliente(String nombre, String numCta){
                 this.nombre = nombre;
                 this.numCta = numCta;
          }
         //Métodos
         // obtenerNombre: devuelve el  nombre
         public String  obtenerNombre(){
               return nombre;
          }  
          //Métodos
         // obtenerCuenta: devuelve el objeto de la clase Cuenta
         public Cuenta obtenerCuenta(){
               return cuenta;
          }  

        // establecerCuenta: establece el objeto de la clase Cuenta
         public void establecerCuenta(Cuenta cta){
                cuenta = cta;
          }  
        // obtenerNombre: devuelve el  numero de cuenta
         public String  obtenerNumCta(){
               return numCta; //aca devuelve en string
          }
          
          public double consultarCuenta(){
	       		double saldo;
	       		
	       		saldo = cuenta.consultar(); //como consultar es publica podemos llamarlo
	       		return saldo;    
          }  

} // Fin de la clase Cuenta
