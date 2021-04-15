public class Deposito extends Movimiento{
	private double monto;
	
	public Deposito(Fecha f, double monto){
		super(f);
		this.monto=monto;
		tipo="Deposito";
	}
	
	public String toString(){
		String mensaje=tipo+"\t"+fecha+"\t"+"monto="+monto;
		return mensaje;
	}
	
	public void establecerTipo(){
		tipo="Deposito";
	}
}