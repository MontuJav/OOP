public class ConsultaCheques extends Consulta{
	private double sobregiro;
	
	public ConsultaCheques(double saldo, Fecha f, double sobregiro){
		super(saldo,f);
		this.sobregiro=sobregiro;
	}
	
	public String toString(){
		String mensaje=tipo+"\t"+fecha+"\t"+"saldo="+saldo+" sobregiro="+sobregiro;
		return mensaje;
	}
}