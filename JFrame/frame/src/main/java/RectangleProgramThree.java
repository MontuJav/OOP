// Obtenemos el contenedor de la ventana usando la clase Container
// el contenedor nos permite acceder al area de la ventana.
// Dividimos l�gicamente la ventana en cuatro renglones y dos columnas 
// usando la clase GridLayout y pasamos la divisi�n l�gica
// al contenedor mediante el m�todo setLayout de la clase Container 
// Agregamos etiquetas a la ventana usando la clase JLabel
// Agregamos texto a la ventana usando la clase JTextField

import javax.swing.*;
import java.awt.*; // Class Container

public class RectangleProgramThree extends JFrame {
	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;
	
	private JLabel lengthL, widthL, areaL, perimeterL;
	private JTextField lengthTF, widthTF, areaTF, perimeterTF;
	
	
	public RectangleProgramThree(){
		setTitle("Area and Perimeter of a Rectangle");
		
		lengthL= new JLabel("Ingresa la altura: ", SwingConstants.RIGHT);
		widthL = new JLabel("Ingresa el ancho: ", SwingConstants.RIGHT);
		areaL = new JLabel("Area: ", SwingConstants.RIGHT);
		perimeterL = new JLabel("Perimetro: ", SwingConstants.RIGHT);
		
		lengthTF = new JTextField(10);
		widthTF = new JTextField(10);
		areaTF = new JTextField(10);
		perimeterTF = new JTextField(10);
		
		
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(4, 2)); // Cuatro renglones y dos columnas
	
		pane.add(lengthL);     // Renglon = 1, Columna = 1
		pane.add(lengthTF);    // Renglon = 1, Columna = 2
		pane.add(widthL);      // Renglon = 2, Columna = 1
		pane.add(widthTF);	   // Renglon = 2, Columna = 2	
		pane.add(areaL);       // Renglon = 3, Columna = 1
		pane.add(areaTF);      // Renglon = 3, Columna = 2
		pane.add(perimeterL);  // Renglon = 4, Columna = 1
		pane.add(perimeterTF); // Renglon = 4, Columna = 2
				
	
		/* Otro orden
		pane.add(lengthL);
		pane.add(widthL);
		pane.add(areaL);
		pane.add(perimeterL);
		pane.add(lengthTF);
		pane.add(widthTF);
		pane.add(areaTF);
		pane.add(perimeterTF);
		*/
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
}