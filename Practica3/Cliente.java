import java.util.*;
public class Cliente{
        // Atributo con acceso privado
        private String nombre;
	private ArrayList<Cuenta> cuentas;
	private int numCta;
	private String numCuenta;
	private Fecha fechaRegistro;
		
        // Constructor: inicializa objetos
        public Cliente(String nom){
		   nombre=nom;
		   numCta=0;
		   numCuenta="INCONG";
		   fechaRegistro=new Fecha();
           cuentas = new ArrayList<Cuenta>();		   
		}
		
		public Cliente(String nom, ArrayList<Cuenta> ctas, String numCuenta){
			int id_ahorr=0;
			int id_chec=0;
			int id_cred=0;
			nombre=nom;
			int aux=0;
		    for(int i=0; i<ctas.size();i++){
				aux++;
				Cuenta actual = new Cuenta(ctas.get(i));
				cuentas.add(actual);
				if(actual instanceof CtaAhorros){
					CtaAhorros a=(CtaAhorros)actual;
					a.setID(id_ahorr);
					id_ahorr++;
				}
				else if(actual instanceof CtaCheques){
					CtaCheques a=(CtaCheques)actual;
					a.setID(id_chec);
					id_chec++;
				}
				else{
					CtaCredito a=new CtaCredito(ctas.get(i));
					a.setID(id_cred);
					id_cred++;
				}
			}this.numCta=aux;
			this.numCuenta=numCuenta;
		    fechaRegistro=new Fecha();//ojo
		}
		
        //Operaciones
		public void agregarCuenta(Cuenta cta){
			int id_ahorr=this.getNumIDA();
			int id_chec=this.getNumIDQ();
			int id_cred=this.getNumIDC();
			
			if(cta instanceof CtaAhorros){
				    CtaAhorros a=(CtaAhorros)cta;
					a.setID(id_ahorr+1);
			}
			else if(cta instanceof CtaCheques){
				    CtaCheques a=(CtaCheques)cta;
					a.setID(id_chec+1);
			}
			else{
				    CtaCredito a=(CtaCredito)cta;
					a.setID(id_cred+1);
			}
			this.cuentas.add(cta);
		}
		
		//numero de id de ahorro
		public int getNumIDA(){
			int contador=0;
			for(Cuenta c:this.cuentas){
				if(c instanceof CtaAhorros){contador++;}
			}
			return contador;
		}
		
		//numero de id de cheques
		public int getNumIDQ(){
			int contador=0;
			for(Cuenta c:this.cuentas){
				if(c instanceof CtaCheques){contador++;}
			}
			return contador;
		}
		
		//numero de id de credito
		public int getNumIDC(){
			int contador=0;
			for(Cuenta c:this.cuentas){
				if(c instanceof CtaCredito){contador++;}
			}
			return contador;
		}
		
		public Cuenta obtenerCuenta(int index){
			Cuenta c = new Cuenta("INDEF");
			if(index>cuentas.size()){
				System.out.println("No existe esa cuenta.");
			}
			else{
				c = this.cuentas.get(index);
			}
		    return c;
        }
		
		//toString
		public String toString(){
			String mensaje="Nombre del Cliente: "+nombre+"\nNumero de cuenta: "+numCta+"\nApertura: "+fechaRegistro;
			return mensaje;
		}
		
		public Cuenta getCuenta(int index){
			if(index<cuentas.size()){
				Cuenta cta=this.cuentas.get(index);
				return cta;	
			}
			else{
				return new Cuenta("INDEF");
			}
		}
		
		public void depositar(int index, double monto, Fecha f){
			if(index<cuentas.size()){
				Cuenta cta=this.cuentas.get(index);
				cta.depositar(monto,f);
			}
		}
		
		public double consultar(int index, Fecha f){
			double sal=0;
			if(index<cuentas.size()){
				Cuenta cta=this.cuentas.get(index);
				sal = cta.consultar(f);
			}
			return sal;
		}
		
		public void retirar(int index,double monto, Fecha f){
			if(index<cuentas.size()){
				Cuenta cta=this.cuentas.get(index);
				cta.retirar(monto,f);
			}
		}
		
		//reporte
		/*
		public void reportarEdosCtas(){
			System.out.println(this);
			
			for(Iterador <Cuenta> it=this.cuentas.iterator(); it.hasNext()){
				Cuenta cta = new Cuenta(it.next());
				System.out.println(cta.getNom()+" id="+cta.getID());
				
			}
		}
		*/
}
    
