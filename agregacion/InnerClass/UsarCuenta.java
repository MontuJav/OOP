public class UsarCuenta
{
	public static void main(String [] args)
	{
		CuentaDeBanco cuentaCuentos = new CuentaDeBanco();
		
		String s = cuentaCuentos.getSaldo();
		System.out.println("cuentaCuentos:  saldo = " + s);
		//Realizamos depósito
		cuentaCuentos.hacerDeposito("548.37");
		//Revisamos saldo de nuevo
		s = cuentaCuentos.getSaldo();
		System.out.println("cuentaCuentos, despues de un deposito:  saldo = " + s);
		//Realizamos otro  depósito
		cuentaCuentos.hacerDeposito("1000.00");
		//Revisamos saldo de nuevo
		s = cuentaCuentos.getSaldo();
		System.out.println("cuentaCuentos, despues de un segundo deposito:  saldo = " + s);
		//Cerramos la cuenta 
		cuentaCuentos.cerrarCuenta();
		s = cuentaCuentos.getSaldo();
		System.out.println("Cerramos cuentaCuentos:  saldo = " + s);
		/* Si la clase interna es publica podemos hacer objetos de ella:
		CuentaDeBanco nuevaCuenta = new CuentaDeBanco();
		CuentaDeBanco.Efectivo laLana = nuevaCuenta.new Efectivo("5849.32");
		System.out.println("Ahora la nueva lana es: " + laLana.getMonto());
		laLana.agregar("1000.00");
		System.out.println("La lana ha aumentado!! " + laLana.getMonto());
		nuevaCuenta.cerrarCuenta();
		System.out.println("La cuenta se cierra, adios lana!! " + nuevaCuenta.getSaldo());
		*/
	}


}
