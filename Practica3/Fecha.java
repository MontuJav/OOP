import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
        // Atributo con acceso privado
        private int dia;
        private int mes;
        private int anio;
		
        // Constructor: inicializa objetos
        public Fecha(int dia, int mes, int anio){
		   if(dia>0 && dia<31){this.dia=dia;}
		   else{this.dia=1;}
		   if(mes>0 && mes<13){this.mes=mes;}
		   else{this.mes=1;}
		   if(anio>2000 && anio<2022){this.anio=anio;}
		   else{this.anio=2021;}
		}
		public Fecha(){
		 Fecha f = new Fecha(10,10,2022);
		}
		public Fecha(Fecha f){
			this.dia=f.dia;
			this.mes=f.mes;
			this.anio=f.anio;
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
		public void setDia(){
              this.dia=dia;
        }
		public void setMes(){
			  this.mes=mes;
		}
		public void setAnio(){
		      this.anio=anio;
		}
		public void establecerFecha(int dia, int mes, int anio){
			this.dia=dia;
			this.mes=mes;
			this.anio=anio;
		}
		public Fecha establecerFecha(Fecha f){
			this.dia=f.dia;
			this.mes=f.mes;
			this.anio=f.anio;
			return this;
		}
		//toString
		public String toString(){
			String mensaje="("+dia+"/"+mes+"/"+anio+")";
			return mensaje;
		}
		//comparar
		//regresa 1 si el invocante es mayor que la fecha enviada, 0 si son iguales
		//regresa -1 si el invocante es menor que la fecha enviada.
		public int esMayor(Fecha f){
			if(anio>f.anio){
				return 1;
			}
			else if(anio<f.anio){
				return -1;
			}
			else{
				if(mes>f.mes){
					return 1;
				}
				else if(mes<f.mes){
					return -1;
				}
				else{
					if(dia>f.dia){
						return 1;
					}
					else if(dia<f.dia){
						return -1;
					}
					else{
						return 0;
					}
				}
			}
		}
		//regresa meses transcurridos desde pasado
		public int pasoMes(Fecha pasado){
		  int salida=1;
		  if(pasado.esMayor(this)==1){
			  int difAnio=pasado.anio-anio;
		      int difMes=pasado.mes-mes;
		      int difDias=pasado.dia-dia;
			  int Diftotal=difDias+(difMes*30)+(difAnio*365);
			  salida=((int)(Diftotal/30));
		  }
		  
		  else{
			  int difAnio=anio-pasado.anio;
			  int difMes=mes-pasado.mes;
			  int difDias=dia-pasado.dia;
			  System.out.println("dif dias:"+difDias);
			  int Diftotal=difDias+(difMes*30)+(difAnio*365);
			  salida=-1*((int)(Diftotal/30));
		 } 
		 return salida;
		}
		
		public void AvanzarTiempo(int dias, int meses, int anios){
			if(dias>0 && dias<31){this.dia=this.dia+dias;}
			if(meses>0 && mes<13){this.mes=this.mes+mes;}
		    if(anios>0){this.anio=this.anio+anios;}
		}
}

/*
public void hoy(){
        Calendar fecha = new GregorianCalendar(); 
        this.dia =  fecha.get(Calendar.DATE);
        this.mes =  fecha.get(Calendar.MONTH)+1; //Los meses empiezan en 0 
        this.anio =  fecha.get(Calendar.YEAR);
    }*/
    
