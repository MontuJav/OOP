public class ConsultaAhorro extends Consulta{
	private double tasa;
	private boolean aplicoTasa;
	
	public ConsultaAhorro(double saldo, Fecha f, double tasa, boolean aplicoTasa){
		super(saldo,f);
		this.tasa=tasa;
		this.aplicoTasa=aplicoTasa;
	}
	
	public String toString(){
		String mensaje=tipo+"\t"+fecha+"\t"+"saldo="+saldo;
		if(this.aplicoTasa){
			mensaje=mensaje+" (El saldo aumento"+(tasa*100)+"% por el pago de intereses)"; 
		}
		return mensaje;
	}
}