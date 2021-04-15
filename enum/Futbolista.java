/* 
Un tipo de dato enumerado (o Enum) es una clase "especial" (tanto en Java como en otros lenguajes) que limitan 
la creación de objetos  a los especificados explícitamente en la implementación de la clase. 
La única limitación que tienen los enumerados respecto a una clase normal es que si tiene constructor, este debe 
de ser privado para que no se puedan crear nuevos objetos (pero sí podemos crear instancias sin el operador new).
Veamos el siguiente ejemplo, acerca del tema del futbol; la forma más inmediata de declarar un tipo Enum es la siguiente:
*/

 enum Demarcacion
{
//ordinal 0    1           2             3
    PORTERO, DEFENSA, CENTROCAMPISTA, DELANTERO //estamos dando los objectos de una clase
	//si hay un constructor ahi es privado, las instancias se crean sin usar new.
}

/*
Un tipo enumerado en Java es una clase que hereda de la clase "Enum(java.lang.Enum)". 
EN nuestro ejemplo anterior, los objetos de la clase enum Demarcacion solo pueden ser los definidos en ella: PORTERO, DEFENSA, 
CENTROCAMPISTA, y DELANTERO).  
En la clase usuaria veremos algunos de los métodos más utilizados de los tipos enumerados, entre ellos, los heredados
de su clase base.

Veamos ahora otro ejemplo de enum que ilustra el uso de constructores y metodos en una clase tipo enumerado. 
La declaración del constructor es tipo private debido a que se limita la creación de objetos a los especificados en la clase:

*/

 enum Equipo
{
	//instancias de nuestra clase equipo, enumerado
	BARCA("FC Barcelona",1), REAL_MADRID("Real Madrid",2),    //BARCA = BARÇA
	SEVILLA("Sevilla FC",4), VILLAREAL("Villareal",7); 
	
	private String nombreClub;
	private int puestoLiga;
	//Declaracion private del constructor
	//este se aplica directamente a las estancias que estan arriba
	private Equipo (String nombreClub, int puestoLiga){
		this.nombreClub = nombreClub;
		this.puestoLiga = puestoLiga;
	}

	public String getNombreClub() {
		return nombreClub;
	}

	public int getPuestoLiga() {
		return puestoLiga;
	}	
	
}

/*
Como se ve BARÇA, REAL_MADRID, etc. son el nombre del enumerado (u objetos de la clase Equipo) que tendrán como atributos 
el "nombreClub" y "puestoLiga". Como se ve, en la clase definimos un constructor que es privado (es decir que solo es visible 
dentro de la clase Equipo) y solo definimos los métodos "getters". Para trabajar con los atributos de estos enumerados se hace de
 la misma manera que con cualquier otro objeto; se instancia un objeto (sin usar el operador new)y se accede a los atributos con 
 los métodos "getter". 
 */


/*
El siguiente ejemplo utiiza los dos enumerados anteriores (Demarcación y Equipo). Vamos a crear 
 algunos objetos de la clase Futbolista, que representarán a los jugadores de la selección española de fútbol que ganaron el mundial de 
 fútbol de Sudáfrica en el año 2010. Esta clase va a caracterizar a los futbolistas por su nombre, su dorsal (número), la demarcación en la que 
 juegan y el club de fútbol al que pertenecen.
*/

public class Futbolista 
{

	private int dorsal; //numero de la playera
	private String Nombre;
	private Demarcacion demarcacion; //tipo enum
	private Equipo equipo; //tipo enum

	public Futbolista() {
	}

	//OJO SIMPLEMENTE HACEMOS LAS ASIGNACIONES
	public Futbolista(String nombre, int dorsal, Demarcacion demarcacion, Equipo equipo) {
		this.dorsal = dorsal;
		Nombre = nombre;
		this.demarcacion = demarcacion;
		this.equipo = equipo;
	}

	// Metodos getter y setter .....
	

	@Override
	public String toString() {
		return this.dorsal + " - " + this.Nombre + " - "
				+ this.demarcacion.name() + " - " + this.equipo.getNombreClub(); //OJO EL METODO NAME() regresa la constante como esta declarado en enum
	}


    /* 
    Dada esta clase podemos crearnos ya objetos de la clase futbolista, como mostramos a continuación:
    */
    public static void main(String [] args)
	  {
		//Usando el Enum Demarcacion  
		Demarcacion delantero = Demarcacion.DELANTERO;    // Instancia de un enum de la clase Demarcación
		Demarcacion defensa = Demarcacion.DEFENSA;		//OJO NO USAMOS EL NEW
		Demarcacion portero = Demarcacion.PORTERO;
		
		// Devuelve un String con el nombre de la constante (DELANTERO)
		System.out.println("delantero.name(): " + delantero.name());
		// Devuelve un String con el nombre de la constante (DELANTERO)
		System.out.println("delantero.toString()" + delantero.toString());
		// Devuelve un entero con la posición del enum según está declarada (3).
		System.out.println("delantero.ordinal(): " + delantero.ordinal());   //regresa el indice como fue declarada las constantes del enum 
		// Compara el enum con el parámetro según el orden en el que están declarados lo enum
		System.out.println("delantero.compareTo(defensa): " + delantero.compareTo(defensa)); //va a comparar defensa y delantero 3-1=2
		 // Devuelve un array que contiene todos los enum
		System.out.println("Usando el metodo Demarcacion.values(): ");    
		 Demarcacion arr[] = Demarcacion.values(); //pasa toda la informacion que tenemos a un arreglo
  
        // Desplegando el valor del arreglo 
        for (Demarcacion dem : arr) 
        { 
            // Llamando al metodo ordinal() para obtener el indice de demarcacion 
            System.out.println(dem + " at index " + dem.ordinal()); //ordinal nos va diciendo la posicion
        } 

		//Demarcacion delantero = Demarcacion.DELANTERO;
		//Demarcacion defensa = Demarcacion.DEFENSA;
		
		// Devuelve un String con el nombre de la constante
		System.out.println("delantero.name()= "+delantero.name());
		System.out.println("defensa.toString()= "+defensa.toString());
		
		//  Devuelve un entero con la posición de la constante según está declarada.
		System.out.println("delantero.ordinal()= "+delantero.ordinal());
		
		// Compara el enum con el parámetro según el orden en el que están declaradas las constantes. 
		System.out.println("delantero.compareTo(portero)= "+delantero.compareTo(defensa));
		System.out.println("delantero.compareTo(delantero)= "+delantero.compareTo(delantero)); //va a ser cero
		
		// Recorre todas las constantes de la enumeración
		for(Demarcacion d: Demarcacion.values()){ //for each a:b; a es la declaracion, b es una expresion que da resultado un arrgelo o un arreglo
			System.out.print(d.toString()+" - ");
		}
  
  
		// Usando el Enum Equipo
		// Instanciamos el enumerado
		Equipo villare
		al = Equipo.VILLAREAL;
		
		// Devuelve un String con el nombre de la constante
		System.out.println("villareal.name()= "+villareal.name());
		
		// Devuelve el contenido de los atributos
		System.out.println("villareal.getNombreClub()= "+villareal.getNombreClub());
		System.out.println("villareal.getPuestoLiga()= "+villareal.getPuestoLiga());
	
       Futbolista casillas = new Futbolista("Casillas", 1, Demarcacion.PORTERO, Equipo.REAL_MADRID);
       Futbolista capdevila = new Futbolista("Capdevila", 11, Demarcacion.DEFENSA, Equipo.VILLAREAL);
       Futbolista iniesta = new Futbolista("Iniesta", 6, Demarcacion.CENTROCAMPISTA, Equipo.BARCA);  //BARÇA
       Futbolista navas = new Futbolista("Navas", 22, Demarcacion.DELANTERO, Equipo.SEVILLA);

       /* Como vemos la demarcación y el equipo al que pertenecen solo pueden ser los declarados en la clase enumerado. 
          Si llamamos al método "toString()" declarado en la clase Futbolista, podemos imprimir por pantalla los datos de 
          los futbolistas. Dado el siguiente código:
       */
	   System.out.println("\nFutbolistas de la seleccin de Espana Campeon mundial en 2010 en Sudafrica:");
       System.out.println(casillas.toString());
       System.out.println(capdevila.toString());
       System.out.println(iniesta.toString());
       System.out.println(navas.toString());
      }
 }