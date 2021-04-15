public class Triangulo {
        // Atributo con acceso privado
        private Punto A;//Inf izq
        private Punto B;//Sup der
        private String nombre;
		
        // Constructor: inicializa objetos
        public Triangulo(){
           A=new Punto(-1,-1);
		   B=new Punto(1,1);
		   nombre="T";
        }
		
		public Triangulo(String nombre, Punto A, Punto B){
		 if((A.getX()>B.getX())||(A.getY()>B.getY())){System.out.println("Error");}
		 this.nombre=nombre;
		 this.A=A;
		 this.B=B;
		}
		
		public Triangulo(String nombre){
		 this.nombre=nombre;
		 A=new Punto(-1,-1);
		 B=new Punto(1,1);
		}
		
		public Triangulo(Punto A, Punto B){
			nombre="R";
			this.A=A;
			this.B=B;
		}
		public Triangulo(Triangulo R){
			this.nombre=R.nombre;
			A=R.A;
			B=R.B;
		}
		
        //Métodos
		//getter's
        public Punto getA(){
         return A;
        }
		public Punto getB(){
		 return B;
		}
		public String nombre(){
		 return nombre;
		}
		//setter´s
		public void setA(Punto A){this.A.equals(A);}
		public void setB(Punto B){this.B.equals(B);}
		public void setNombre(String name){nombre=name;}
		//toString
		public String toString(){
			String mensaje=nombre + "[" + A.toString() + "," + B.toString() + "]";
			return mensaje;
		}
		//equals
		public void equals(Triangulo R){
			this.nombre=R.nombre;
			this.setA(R.getA());
			this.setB(R.getB());
		}
		//altura
		public double altura(){
			Punto C = new Punto("C",this.B.getX(),this.A.getY());
			double x = A.distancia(C);
			double y = B.distancia(C);
			double z = A.distancia(B);
			return y*(x/z);
		}
		//true si un punto esta dentro del rectangulo
		public boolean dentro(Punto P){
			boolean verdad1=A.Izquierda(P)&&P.Izquierda(B)&&P.Abajo(B)&&A.Abajo(P);
			double heigh=this.altura();
			boolean verdad2=(P.distancia(A)<heigh)&&(P.distancia(B)<heigh)&&(P.distancia(C)<heigh);
			return verdad1&&verdad2;
		}
		//Nos dice cuantos de los ptos. que mandamos estan adentro del rectangulo invocador
		public int PtosDentro(Punto p1, Punto p2, Punto p3){
			int counter=0;
			if(this.dentro(p1)){
				counter++;
			}
			if(this.dentro(p2)){
				counter++;
			}
			if(this.dentro(p3)){
				counter++;
			}
			return counter;
		}
		//interseccion
		public Triangulo interseccion(Rectangulo R){
			Rectangulo R1=new Rectangulo();
			if(R.comparar(this)>0){
				Rectangulo aux=new Rectangulo();
				aux.equals(R);
				R.equals(this);
				this.equals(aux);
			}
			Punto A1=new Punto(R.A);
			Punto B1=new Punto(R.B);
			Punto C1=new Punto(R.B.getX(),R.A.getY());
			int PtosAden=this.PtosDentro(A1,B1,C1);
			if(PtosAden==0){
				R1.A.mover(0,0);
				R1.B.mover(0,0);
			}
			else if(PtosAden==3){
				R1.A.equals(A1);
				R1.B.equals(B1);
			}
			else if(PtosAden==1){
				if(this.dentro(B1)){
					R1.B.equals(B1);
					R1.A.setX();
				}
				else if(this.dentro(A1)){
					R1.A.equals(A1);
					R1.B.setY(this.A.getY());
				}
				else if(this.dentro(C1)){
					R1.A.setX(this.A.getX());
					R1.A.setY(A1.getY());
					
					R1.B.setX(B1.getX());
					R1.B.setY(this.B.getY());
				}
				else if(this.dentro(D1)){
					R1.A.setX(A1.getX());
					R1.A.setY(this.A.getY());
					
					R1.B.setX(this.B.getX());
					R1.B.setY(B1.getY());
				}
				else{
					System.out.println("Ocurrio un error al encontrar la interseccion entre los rectangulos");
				}
			}
			else{
				System.out.println("Ocurrio un error al encontrar la interseccion entre los rectangulos");
			}
			return R1;
		}
		//area
		public int area(){
			return Math.abs((B.getX()-A.getX())*(B.getY()-A.getY()));
		}
		//comparar
		public int comparar(Rectangulo R){
			int mayor=0;
			if(this.area()>R.area()){return 1;}
			else if(R.area()==this.area()){return 0;}
			else{return -1;}
		}
		//mover
		public void moverRect(Punto H, Punto J){
			this.setA(H);
			this.setB(J);
		}
		//cuadrante
		public int cuadRect(){
			Punto P=new Punto(A.getX(),B.getY());
			return P.cuadrante();
		}    
}