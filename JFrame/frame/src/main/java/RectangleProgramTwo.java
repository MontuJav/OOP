// Obtenemos el contenedor de la ventana usando la clase Container
// el contenedor nos permite acceder al area de la ventana.
// Dividimos l�gicamente la ventana en cuatro renglones y una columna 
// usando la clase GridLayout y pasamos la divisi�n l�gica
// al contenedor mediante el m�todo setLayout de la clase Container 
// Agregamos etiquetas a la ventana usando la clase JLabel

import javax.swing.*;
import java.awt.*; // Class Container

public class RectangleProgramTwo extends JFrame {
	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;
	
	private JLabel lengthL, widthL, areaL, perimeterL;
	
	public RectangleProgramTwo(){
		setTitle("Area and Perimeter of a Rectangle");
		
		lengthL= new JLabel("Ingresa la altura: ", SwingConstants.RIGHT);
		widthL = new JLabel("Ingresa el ancho: ", SwingConstants.RIGHT);
		areaL = new JLabel("Area: ", SwingConstants.RIGHT);
		perimeterL = new JLabel("Perimetro: ", SwingConstants.RIGHT);
		
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(4, 1));
		
		pane.add(lengthL);
		pane.add(widthL);		
		pane.add(areaL);
		pane.add(perimeterL);
				
	
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}