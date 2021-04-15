
package practica1nb;

public class Racional {
    //Atributos de un numero Racional
    private int numerador;
    private int denominador;
    //Setters y getters

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }
    
     //Constructores
    public Racional(){
        numerador = 1;
        denominador = 1;
    }
    
    public Racional(int n, int d){
        numerador = n;
        if(d==0)
            denominador =1; //En capsulamiento nos aseguramos que no sea 0
        else 
            denominador= d; 
    }

    //Métodos
    public void establecer(int numerador, int denominador){
        //this se refiere a un objeto de la clase
        this.numerador= numerador;
        if(denominador==0)
            this.denominador=1;
        else
            this.denominador= denominador;     
    }
    
    public void imprimir(){
        System.out.println("["+numerador+","+denominador+"]");
    }  
    //Suma 
     public Racional sumaRacional(Racional x, Racional y){
        this.denominador = x.denominador * y.denominador;
        this.numerador = (x.numerador*y.denominador) +(x.denominador*y.numerador);
        return this;
  
    }
    //Resta                        //Minuendo y sustraendo 
    public Racional restaRacional(Racional x, Racional y){ 
        this.denominador = x.denominador * y.denominador;
        this.numerador = (x.numerador*y.denominador)-(x.denominador*y.numerador);
        return this;
    } 
    //Multiplicación 
     public Racional multRacional(Racional x, Racional y){
        this.numerador = x.numerador * y.numerador;
        this.denominador = x.denominador * y.denominador;
        return this;
    }
    //Division 
    public Racional divRacional(Racional x, Racional y){
        this.numerador = x.numerador * y.denominador;
        this.denominador = x.denominador * y. numerador;
        return this;
    }

   
    public Racional simpRacional(){
        //MCD Algoritmo de Euclides 
        int q,r=1,a=numerador,b=denominador;
        r=a%b;
        while(r!=0){
            a=b;
            b=r;
            r=a%b;
            q=a/b;
        }
        this.numerador = numerador/b; 
        this.denominador = denominador/b; 
        return this;
    }

    public Racional RacionalAleatorio(){
        numerador= (int) (Math.random() * 9); //Numero del 0 al 9 randoms 
        denominador= (int) (Math.random() * 9) + 1; //Numero del 1 al 9 randoms 
        return this;
    }

    public boolean equalsRacional(Racional y){
        return ((this.numerador==y.getNumerador()) && (this.denominador==y.getDenominador()));
    }
    
   
    
}
