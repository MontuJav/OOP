public abstract class Movimiento{
	protected String tipo;
	protected Fecha fecha;

	public Movimiento(Fecha date){
		this.fecha.establecerFecha(date);
	}
	
	abstract public void establecerTipo();
}
