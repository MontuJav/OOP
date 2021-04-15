// Obtenemos el contenedor de la ventana usando la clase Container
// el contenedor nos permite acceder al area de la ventana.
// Dividimos l�gicamente la ventana en cinco renglones y dos columnas 
// usando la clase GridLayout y pasamos la divisi�n l�gica
// al contenedor mediante el m�todo setLayout de la clase Container 
// Agregamos etiquetas a la ventana usando la clase JLabel
// Agregamos texto a la ventana usando la clase JTextField
// Agregamos un boton para calcular el area y el perimetro mediante la clase JButton
// Usamos la interface ActionListener

import javax.swing.*;
import java.awt.*; // Class Container
import java.awt.event.*;

public class RectangleProgramFour extends JFrame {
	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;
	
	private JLabel lengthL, widthL, areaL, perimeterL;
	private JTextField lengthTF, widthTF, areaTF, perimeterTF;
	private JButton calculateB, exitB;
	
	private CalculateButtonHandler cbHandler;
	private ExitButtonHandler ebHandler;
	
	
	
	
	public RectangleProgramFour(){
		setTitle("Area and Perimeter of a Rectangle");
		
		lengthL= new JLabel("Ingresa la altura: ", SwingConstants.RIGHT);
		widthL = new JLabel("Ingresa el ancho: ", SwingConstants.RIGHT);
		areaL = new JLabel("Area: ", SwingConstants.RIGHT);
		perimeterL = new JLabel("Perimetro: ", SwingConstants.RIGHT);
		
		lengthTF = new JTextField(10);
		widthTF = new JTextField(10);
		areaTF = new JTextField(10);
		perimeterTF = new JTextField(10);
		
		// Boton para calculos
		calculateB = new JButton("Calcular");
		cbHandler = new CalculateButtonHandler(); // La clase CalculateButoonHandler implementa la interface
		calculateB.addActionListener(cbHandler); //Colgamos el handler a su boton correspondiente  
		
		// Boton para salir
		exitB = new JButton("Exit");
		ebHandler = new ExitButtonHandler(); // La clase ExitButoonHandler implementa la interface
		exitB.addActionListener(ebHandler);
		
		
		
		
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(5, 2)); // Cinco renglones y dos columnas
	
		pane.add(lengthL);     // Renglon = 1, Columna = 1
		pane.add(lengthTF);    // Renglon = 1, Columna = 2
		pane.add(widthL);      // Renglon = 2, Columna = 1
		pane.add(widthTF);	   // Renglon = 2, Columna = 2	
		pane.add(areaL);       // Renglon = 3, Columna = 1
		pane.add(areaTF);      // Renglon = 3, Columna = 2
		pane.add(perimeterL);  // Renglon = 4, Columna = 1
		pane.add(perimeterTF); // Renglon = 4, Columna = 2
		pane.add(calculateB);
		pane.add(exitB);
				
	
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
	
	/*private*/ class CalculateButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			double width, length, area, perimeter;
			
			length = Double.parseDouble(lengthTF.getText());
			width = Double.parseDouble(widthTF.getText());
			area = length * width;
			perimeter = 2 * (length + width);
			
			areaTF.setText("" + area);
			perimeterTF.setText("" + perimeter);
		}
	}
	
	private class ExitButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}
		
}