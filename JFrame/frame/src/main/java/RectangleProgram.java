import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RectangleProgram extends JFrame {
	private static final int ANCHO = 400; //Con 'final' esta variable se vuelve constante
	private static final int ALTO = 300;// Como son estaticas no dependen de ninguna estancia
	
	public RectangleProgram(){
                //Esto metodos los heredamos de JFrame este es el constructor
		setTitle("Area and Perimeter of a Rectangle");
		setSize(ANCHO, ALTO);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //La aplicacion sale cuando la cerramos
	}
	
	public static void main(String []args ){
		//RectangleProgram rectProg = new RectangleProgram();
                RectangleProgram rectProg = new RectangleProgram();
	}
}