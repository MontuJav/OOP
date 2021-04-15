public class Fecha {
        // Atributo con acceso privado
        private int dia;
        private int mes;
        private int anio;
		
        // Constructor: inicializa objetos
        public Fecha(int dia, int mes, int anio){
           this.dia=dia;
           this.mes=mes;
           this.anio=anio;
        }
		
		public Fecha(){
		 dia=1;
		 mes=1;
		 anio=2000;
		}
		
		
        //Métodos
		//getter's
        public int getDia(){
              return dia;
        }
		public int getMes(){
		 return mes;
		}
		public int getAnio(){
		 return anio;
		}
		
		public Fecha obtenerFecha(){
			Fecha date = new Fecha(this.getDia(),this.getMes(), this.getAnio());
			return date;
		}
		//setter´s
		public int setDia(){
              this.dia=dia;
        }
		public int getMes(){
			  this.mes=mes;
		}
		public int getAnio(){
		      this.anio=anio;
		}
		public void establecerFecha(int dia, int mes, int anio){
			this.dia=dia;
			this.mes=mes;
			this.anio=anio;
		}
		//toString
		public String toString(){
			String mensaje="("+dia+"/"+mes+"/"+anio+")";
			return mensaje;
		}
  
}
    
