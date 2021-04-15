public class ConsultaCredito extends Consulta{
	private double sobregiro;
	private boolean aplicoInteres;
	private double tasa;
	
	public ConsultaCredito(double saldo, Fecha f, double deficit, boolean aplicoInteres, double tasa){
		super(saldo,f);
		this.deficit=deficit;
		this.aplicoInteres=aplicoInteres;
		this.tasa = tasa;
	}
	
	public String toString(){
		String mensaje=tipo+"\t"+fecha+"\t"+"saldo="+saldo+" deficit="+deficit;
		if(aplicoInteres){
			mensaje=mensaje+"("+(tasa*100)+"% de interes fue aplicado)";
		}
		return mensaje;
	}
}