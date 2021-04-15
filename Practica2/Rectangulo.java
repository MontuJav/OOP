public class Rectangulo {
        // Atributo con acceso privado
        private Punto A;//Inf izq
        private Punto B;//Sup der
        private String nombre;
		
        // Constructor: inicializa objetos
        public Rectangulo(){
           A=new Punto(-1,-1);
		   B=new Punto(1,1);
		   nombre="R";
        }
		
		public Rectangulo(String nombre, Punto A, Punto B){
		 if((A.getX()>B.getX())||(A.getY()>B.getY())){System.out.println("Error");}
		 this.nombre=nombre;
		 this.A=A;
		 this.B=B;
		}
		
		public Rectangulo(String nombre){
		 this.nombre=nombre;
		 A=new Punto(-1,-1);
		 B=new Punto(1,1);
		}
		
		public Rectangulo(Punto A, Punto B){
			nombre="R";
			this.A=A;
			this.B=B;
		}
		public Rectangulo(Rectangulo R){
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
		public void equals(Rectangulo R){
			this.nombre=R.nombre;
			this.setA(R.getA());
			this.setB(R.getB());
		}
		//union
		public Rectangulo union(Rectangulo R){
			Rectangulo R1=new Rectangulo();
			//Determinando B
			if(this.B.Abajo(R.B)){R1.B.setY(R.B.getY());}
			else{R1.B.setY(this.B.getY());}
			if(this.B.Izquierda(R.B)){R1.B.setX(R.B.getX());}
			else{R1.B.setX(this.B.getX());}
			
			//Determinando A
			if(this.A.Abajo(R.A)){R1.A.setY(this.A.getY());}
			else{R1.A.setY(R.A.getY());}
			if(this.A.Izquierda(R.A)){R1.A.setX(this.A.getX());}
			else{R1.A.setX(R.A.getX());}
			return R1;
		}
		//true si un punto esta dentro del rectangulo
		public boolean dentro(Punto P){
			boolean verdad=A.Izquierda(P)&&P.Izquierda(B)&&P.Abajo(B)&&A.Abajo(P);
			return verdad;
		}
		//Nos dice cuantos de los ptos. que mandamos estan adentro del rectangulo invocador
		public int PtosDentro(Punto p1, Punto p2, Punto p3, Punto p4){
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
			if(this.dentro(p4)){
				counter++;
			}
			return counter;
		}
		//interseccion
		public Rectangulo interseccion(Rectangulo R){
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
			Punto D1=new Punto(R.A.getX(),R.B.getY());
			int PtosAden=this.PtosDentro(A1,B1,C1,D1);
			if(PtosAden==0){
				R1.A.mover(0,0);
				R1.B.mover(0,0);
			}
			else if(PtosAden==4){
				R1.A.equals(A1);
				R1.B.equals(B1);
			}
			else if(PtosAden==2){
				if(this.dentro(A1)){
					R1.A.equals(A1);
					if(this.dentro(C1)){
						R1.B.setX(C1.getX());
						R1.B.setY(this.B.getY());
					}
					else if(this.dentro(D1)){
						R1.B.setY(B1.getY());
						R1.B.setX(this.B.getX());
					}
					else{
						System.out.println("Ocurrio un error al encontrar la interseccion entre los rectangulos");
					}
				}
				else if(this.dentro(B1)){
					R1.B.equals(B1);
					if(this.dentro(C1)){
						R1.A.setY(C1.getY());
						R1.A.setX(this.A.getX());
					}
					else if(this.dentro(D1)){
						R1.A.setX(A1.getX());
						R1.A.setY(this.A.getY());
					}
					else{
						System.out.println("Ocurrio un error al encontrar la interseccion entre los rectangulos");
					}
				}
				else{
					System.out.println("Ocurrio un error al encontrar la interseccion entre los rectangulos");
				}
			}
			else if(PtosAden==1){
				if(this.dentro(B1)){
					R1.A.equals(this.A);
					R1.B.equals(B1);
				}
				else if(this.dentro(A1)){
					R1.A.equals(A1);
					R1.B.equals(this.B);
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
    
