public class Retiro extends Movimiento{
	private double monto;
	
	public Retiro(Fecha f, double monto){
		super(f);
		this.monto=monto;
		tipo="Retiro";
	}
	
	public String toString(){
		String mensaje=tipo+"\t"+fecha+"\t"+"monto="+monto;
		return mensaje;
	}
	
	public void establecerTipo(){
		tipo="Retiro";
	}
}