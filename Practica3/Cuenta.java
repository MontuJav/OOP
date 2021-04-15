import java.util.*;
public class Cuenta {
        // Atributo con acceso privado
        protected double saldo;
        private Fecha apertura;
		private String nom;
		protected ArrayList<Movimiento> movimientos;
		
        // Constructor: inicializa objetos
        public Cuenta(String nom){
		   this.nom=nom;
		   apertura=new Fecha();
		   movimientos = new ArrayList<Movimiento>();
		}
		
		public Cuenta(Cuenta c){
			apertura=new Fecha();
			this.saldo=c.saldo;
			this.nom=c.nom;
			movimientos = new ArrayList<Movimiento>();
		}
		
		public Cuenta(String nom, Fecha fechaApertura){
		   this.nom=nom;
		   apertura=fechaApertura;
		   movimientos = new ArrayList<Movimiento>();
		}
		
        //Métodos
		//getter's
		public Fecha getApertura(){
		      return apertura;
		}
		public String getNom(){
			return nom;
		}
		
		//setter´s
		public void setSaldo(double saldo){
              this.saldo=saldo;
        }
		
		public void setApertura(Fecha f){
			this.apertura.establecerFecha(f);
		}
		
		//toString
		public String toString(){
			String mensaje=apertura+" saldo="+saldo;
			return mensaje;
		}
		/*
		public String PrintMov(){
			String mensaje;
			for(Iterador <Movimiento> it=this.movimientos.iterator(); it.hasNext()){
				Movimiento mov = new Movimiento(it.next());
				System.out.println(cta.getNom()+" id="+cta.getID());
				
			}
		}*/
		
		//Movimientos
		
		//consultar
		public double consultar(Fecha f){
			  //Fecha f = new Fecha();//fecha del movimiento
			  Movimiento mov = new Consulta(saldo, f);
			  movimientos.add(mov);
              return saldo;
        }
		
		//Depositar
		public void depositar(double monto, Fecha f){
			//Fecha f = new Fecha();//fecha del movimiento
			Movimiento mov = new Deposito(f, monto);
			movimientos.add(mov);
			this.saldo+=monto;
		}
		//Retirar
		public void retirar(double monto, Fecha f){
			//Fecha f = new Fecha();//fecha del movimiento
			Movimiento mov = new Retiro(f, monto);
			movimientos.add(mov);
			this.saldo-=monto;
		}
  
}
    
