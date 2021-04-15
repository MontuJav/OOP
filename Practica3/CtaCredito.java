public class CtaCredito extends Cuenta {
        // Atributo con acceso privado
        private double tasa;
		private int id;
		private double deficit;
		
        // Constructor: inicializa objetos
        public CtaCredito(double saldo, double deficit){
		   super("Cuenta de Credito");
		   this.saldo=saldo;
		   this.deficit=deficit;
		   this.tasa=0.1; //elejimos la tasa
		}
		
		public CtaCredito(Cuenta c){
		   super("Cuenta de Credito");
		   this.saldo=c.saldo;
		   this.deficit=0;
		   this.tasa=0.1; //elejimos la tasa
		}
		
		//setter´s

		public void setID(int id){
			this.id=id;
		}
		
		//toString
		public String toString(){
			String mensaje=super.getApertura()+" saldo="+saldo+" deficit="+deficit;
			return mensaje;
		}
		
        //movimientos
		
		//retirar
		public void retirar(double monto, Fecha f){
			//Fecha f = new Fecha();
			  this.sumaInteres(f);
		      if(monto<=saldo){
				  saldo=saldo-monto;
			  }
			  else{
				  deficit=monto-saldo;
				  saldo=0;
			  }
			  Movimiento mov = new Retiro(f, monto);
			  movimientos.add(mov);
		}
		
		//depositar
		public void depositar(double monto, Fecha f){
			//Fecha f = new Fecha();
			  this.sumaInteres(f);
              if(deficit>monto){
				  deficit=deficit-monto;
				  saldo=0;
			  }
			  else if(deficit==monto){
				  deficit=0;
			  }
			  else{
				  monto=monto-deficit;
				  deficit=0;
				  saldo=monto+saldo;
			  }
			  Movimiento mov = new Deposito(f, monto);
			  movimientos.add(mov);
        }
		
		//suma interes
		public void sumaInteres(Fecha fechaOp){
			Fecha fechaAp=this.getApertura();
			int meses=fechaAp.pasoMes(fechaOp);
			double deficitSuma=((double)(meses))*tasa;
			deficit+=deficitSuma;
		}
}
    
