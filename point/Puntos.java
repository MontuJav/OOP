
class Point{

    private int x;
	private int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Point(){
		this(1,1);//invoca al constructor de arriba y llama a ese por el numero y tipo de par�metros
	}
	
	public void mover(int nx, int ny){
		x = nx;
		y = ny;
	}
	
	
    //Redifinicionon (overriden) de equals para la clase Point
    @Override
	public boolean equals(Object Ob){// Object esta arriba y a Point se le pone esa mascara
		if(Ob instanceof Point){ //Verificamos que Ob sea un objeto de Point
                    Point P = (Point) Ob;  //Downcasting
                    //instanceof baja le quita la mascara para ver si es tipo Poin
			if(this.x==P.x && this.y == P.y)
				return true;
		}
		return false;
	}
	
	
	
	//Redefinicion de toString
    @Override
	public String toString(){
		return "[X=" + x + ", " + "Y=" + y + "]";
	}
	
	
}

//Solo esta clase es publica y las demas no son visibles fuera de este archivo
public class Puntos{//clase principal por tener el main y porque esta utiliza a la clase point
	public static void main(String [] args){
                //Definicion de objetos de la clase point
		Point A = new Point();
		Point B = new Point(-8, 10);
		
		//Invocamos al metodo equals de la clase Object
		boolean r = A.equals(B);
		//Desplegamos el valor de r
		System.out.println("A.equals(B):  " + r);
		// Ahora modificamos el valor del objeto B para que sea igual que el objeto A, e invocamos a equals
		B.mover(1,1);
		r = A.equals(B);
		System.out.println("A.equals(B):  " + r);
		// El método equals no compara el contenido de los objetos, compara las referencias de los objetos
		
		
		//Ahora imprimimos la representacion de toString de la clase Object
		System.out.println("Metodo toString de la clase Object para A:  "+ A.toString()); //Si no redefinimos nosotros usa el de mama: El toString default pone @HEXhh con la direcci�n de memoria
		System.out.println("Metodo toString de la clase Object para B:  "+ B);//Como B necesita char y no le ponemos, el compilador lo llama de forma automatica
		
		
		/*
		//Ahora usamos nuestra definición de toString para la clase Point
		System.out.println("Nuestra definicióndel método toString para A: " + A.toString()); 
		System.out.println("Método toString de la clase Object para B:  "+ B);
		*/
		
		System.out.println("El valor hash para A es: " + A.hashCode()); //Hash code devuelve un entero para hacer un hash map  
		System.out.println("El valor hash para B es: " + B.hashCode());
		
		if(A==B)
                    System.out.println("A==B: true");
                else
                    System.out.println("A==B: false");
	}
}