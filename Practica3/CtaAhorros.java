public class CtaAhorros extends Cuenta implements Impuestos {
        // Atributo con acceso privado
        private double tasa;
		private int id;
		
        // Constructor: inicializa objetos
        public CtaAhorros(double saldo, double tasa){
		   super("Cuenta de Ahorros");
		   this.saldo=saldo; //OJO
		   this.tasa=tasa;
		}
	
		//setter´s
		public void setSaldo(double saldo){
              this.saldo=saldo;
        }
		
		public void setID(int id){
			this.id=id;
		}
		//toString
		public String toString(){
			String mensaje=super.getApertura()+" saldo="+saldo+" tasa= "+tasa;
			return mensaje;
		}
		
		//Movimientos
		//consultar
		 public double consultar(Fecha f){
			//Fecha fechaActual=new Fecha();//fecha actual
			Fecha fechaAp=this.getApertura();
			if(fechaAp.esMayor(f)==1){
				System.out.println("Hay un error con las fechas de apertura o la fecha actual.");
			}
			else{
				int meses=f.pasoMes(fechaAp);
				double saldoSuma=((double)(meses))*tasa;
				saldo+=saldoSuma;
				if(saldoSuma>0){
					Movimiento mov = new ConsultaAhorro(saldo, f, tasa, true);
					movimientos.add(mov);
				}
				else{
					Movimiento mov = new ConsultaAhorro(saldo, f, tasa, false);
					movimientos.add(mov);
				}
			}
			return saldo;	
        }
		
		//pago de impuestos
		public void pagarImpuestos(Fecha f){
			Fecha fechaAp=this.getApertura();
			for(int i = f.pasoMes(fechaAp); i>0; i--){
				this.pagarISRmensual();
			}
			for(int j = (int)f.pasoMes(fechaAp)/12; j>0; j--){
				this.pagarISRanual();
			}	
		}
		
		public void pagarISRmensual(){
			if(saldo>10000){
				saldo=saldo-(saldo*ISRm);
			}
		}
		
		public void pagarISRanual(){
			if(saldo>50000){
				saldo=saldo-(saldo*ISRa);
			}
		}
  
}
    
