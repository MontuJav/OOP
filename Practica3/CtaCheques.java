public class CtaCheques extends Cuenta {
        // Atributo con acceso privado
        private double sobregiro;
		private int id;
		private final static double tasaSobreGiro=0.2;
		
        // Constructor: inicializa objetos
        public CtaCheques(double saldo, double sobre){
		   super("Cuenta de Cheques");
		   this.saldo=saldo;
		   if(sobre>saldo*tasaSobreGiro){sobregiro=0;}
		   else{sobregiro=sobre;}
		}
		
        //Métodos
		//setter´s
		public void setID(int id){
			this.id=id;
		}
		
		//toString
		public String toString(){
			String mensaje=super.getApertura()+" saldo="+saldo+" sobregiro="+sobregiro;
			return mensaje;
		}
		
		//movimientos
		
		//retirar
		public void retirar(double monto, Fecha f){
			//Fecha f = new Fecha();//fecha actual
		      if(monto<=saldo){
				  saldo=saldo-monto;
			  }
			  else{
				  if((monto-saldo)<(saldo*tasaSobreGiro)){
					  sobregiro=monto-saldo;
				      saldo=0;
				  }
				  else{
					System.out.println("No se cuenta con los recursos suficientes para realizar la operacion de retiro.");  
				  }
			  }
			  Movimiento mov = new Retiro(f, monto);
			  movimientos.add(mov);
		}
		
		//depositar
		public void depositar(double monto, Fecha f){
			//Fecha f = new Fecha();//fecha actual
              if(sobregiro>monto){
				  sobregiro=sobregiro-monto;
				  saldo=0;
			  }
			  else if(sobregiro==monto){
				  sobregiro=0;
			  }
			  else{
				  monto=monto-sobregiro;
				  sobregiro=0;
				  saldo=monto+saldo;
			  }
			  Movimiento mov = new Deposito(f, monto);
			  movimientos.add(mov);
        }		
}
    
