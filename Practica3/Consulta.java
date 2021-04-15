public class Consulta extends Movimiento{
	protected double saldo;
	
	public Consulta(double saldo, Fecha f){
		super(f);
		this.saldo=saldo;
		tipo="Consulta";
	}
	public String toString(){
		String mensaje=tipo+"\t"+fecha+"\t"+"saldo="+saldo;
		return mensaje;
	}
	public void establecerTipo(){
		this.tipo="Consulta";
	}

}