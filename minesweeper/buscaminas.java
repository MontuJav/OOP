import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//Buscamina hereda de JFrame entonces buscamina es un JFrame
class buscaminas extends JFrame implements ActionListener {
	//	Atributos
	JButton botones [][];
	int matrizMinas [][];
    //	Cajas de texto
    JTextField txtMinas=new JTextField(3);
    JTextField txtTiempo=new JTextField(3);
    //	Etiquetas
    JLabel lMinas=new JLabel("Minas restantes:");
    JLabel lTiempo=new JLabel("Tiempo transcurrido:");
    
	//	Imagenes de minas
	ImageIcon imagenesMinas []=new ImageIcon [12];
	//	Dimensión
	int dim=10;
	int totalMinas=20;
	int casillas=dim*dim-totalMinas;
	
	//	Clase del tiempo
	Tiempo tp;
	
	buscaminas (){
		botones=new JButton [dim][dim];
		matrizMinas=new int [dim][dim];
		//	Cargar Imágenes
		for(int i=0;i<12;i++)
			imagenesMinas[i]=new ImageIcon(i+".jpg");
                
		//	Panel Superior
		JPanel panelSup=new JPanel();
		panelSup.add(lMinas);
		panelSup.add(txtMinas);
		panelSup.add(lTiempo);
		panelSup.add(txtTiempo);
		add(panelSup,"North");
		txtMinas.setEditable(false);
		txtTiempo.setEditable(false);
		txtMinas.setText(Integer.toString(casillas));
		
		//	Panel de los botones
		JPanel panelMedio=new JPanel(new GridLayout(dim,dim));
		//	Crear y colocar botones
		for(int i=0;i<dim;i++)
			for(int j=0;j<dim;j++)
				{
					//	Crear boton
					botones [i][j]=new JButton();
					//	Colocar en el panel
					panelMedio.add(botones[i][j]);
					//	Action Listener
					botones[i][j].addActionListener(this);
				}
		this.add(panelMedio,"Center");	
		colocarMinas(totalMinas);
        //	Propiedades de la ventana
        
        //	Comenzar Tiempo
        tp= new Tiempo(this);
        tp.start();	
	    setResizable(false);
	    setSize(600,600);
		setVisible(true);
	}
	void colocarMinas(int minas)
	{
		System.out.println("Colocando Minas... \n");
		for(int i=0;i<minas;i++)
		{
		//	Coordenadas
		int x,y=0;
		double x1,y1=0;
		
		/*	Leyenda de matrizMinas
		 *	1 Existe Mina
		 *	0 No existe Mina
		 */
			//Colocar mina aleatoria
			do
			{
                        //	Generar posiciones aleatorias
                         x1=Math.random()*dim;
		 	 y1=Math.random()*dim;
		 	 x=(int)x1;
		 	 y=(int)y1;	
			}
			while(matrizMinas[x][y]!=0);
			matrizMinas[x][y]=1; //	Poner mina
		}
      //	Visualizar Tablero de minas.
	  for(int i=0;i<dim;i++)
	  {
	  	System.out.println("");
	  	for(int j=0;j<dim;j++)
	  		System.out.print(" "+matrizMinas[i][j]);
	  }

	}
	
	public static void main(String []args){ //Esto es un hilo
		new buscaminas(); //No tenemos variable referencia como buscaminas b = new nescaminas(); pues NO ES NECESARIO
		//Clase u objeto anónimo
	}
	
	//SE OPRIME UN BOTON ENTONCES LA OREJA, EL ACTION LISTENER, NOS MANDA AL ACTION PERFORMED
	public void actionPerformed(ActionEvent ae){
		for(int i=0;i<dim;i++)
			for(int j=0;j<dim;j++)
			{
				if(ae.getSource()==botones[i][j] && botones[i][j].getIcon()==null && botones[i][j].getBackground()!=Color.WHITE)
				{
					botones[i][j].setBackground(Color.WHITE);
                                        if(matrizMinas[i][j]==1){
                                        boom();
                                        }
                                        else
                                        {
										pulsarVacio(i,j);
                                        }
				}
			}
	}
	void pulsarVacio(int i, int j)
	{
		//	Al pulsar en una zona vaciá
		casillas--;
        txtMinas.setText(Integer.toString(casillas));
        botones[i][j].setText(Integer.toString(minasCerca(i,j))); //Cuantas Minas cerca
        if(casillas==0)
        			ganar();
	}
	
	void volverEmpezar()
	{
		//	Volver al estado inicial
		for(int i=0;i<dim;i++)
			for(int j=0;j<dim;j++)
			{
				matrizMinas[i][j]=0;
				botones[i][j].setText("");
				botones[i][j].setBackground(null);
				botones[i][j].setIcon(null);
			}
		colocarMinas(totalMinas);
		casillas=dim*dim-totalMinas;
		txtMinas.setText(Integer.toString(casillas));
		tp= new Tiempo(this); //Arrancamos el tiempo
        tp.start();
	}
	
	void ganar()
	{
		//	Al ganar la partida
		tp.stop(); //	parar el tiempo
		//tp.interrupt();
		JOptionPane.showMessageDialog(this,"Has ganado. Tu tiempo es de: "+txtTiempo.getText());
		volverEmpezar();	
	}
	
	void boom()
	{
	//	Al perder la partida
	tp.stop(); //	parar el tiempo
	//tp.interrupt();
	for(int i=0;i<dim;i++)
		for(int j=0;j<dim;j++)
		{
		if(matrizMinas[i][j]==1)
			{
			//	Imagen aleatoria de las minas
			double y1=Math.random()*12;
			int y=(int)y1;	
			botones[i][j].setIcon(imagenesMinas[y]);
			}
		}
		JOptionPane.showMessageDialog(this,"Boom!!! Has perdido.");
		volverEmpezar();
	}
	
	int minasCerca(int x,int y)
	{
			/*	
			 *	x Coordenada filas
			 *	y Coordenada columnas
			 *
			 *	numeroMinas: devuelve el número de minas de la posición
			 */
			 
            int numeroMinas=0;
            for(int i=y-1;i<=y+1;i++){
            	//En horizontal
                if(i>-1 && i<dim){
	                if(matrizMinas[x][i]==1){
	             		numeroMinas++;
	                }
                }
            }
            //	En vertical
                for(int j=x-1;j<=x+1;j++){
	                		if(j>-1 && j<dim)
	                			if(matrizMinas[j][y]==1){
	                			numeroMinas++;
	                			}
	                	}
	        //	En diagonal
	        //	Posición de la esquina superior izquierda
	        int x1=x;
	        int y1=y;
	        x1--;
	        y1--;
	        	for(int i=x1;i<x1+3;i++)
	        		{
	        			if(i>-1 && i<dim && y1>-1 && y1<dim)
	        			 if(matrizMinas[i][y1]==1){
	             		numeroMinas++;
	                	}
	                	y1++;
	        		}
	        //	Posición de la esquina superior derecha
	        x1=x;
	        y1=y;
	        x1--;
	        y1++;
	        	for(int i=x1;i<x1+3;i++)
	        		{
	        			if(i>-1 && i<dim && y1>-1 && y1<dim)
	        			 if(matrizMinas[i][y1]==1){
	             		numeroMinas++;
	                	}
	                	y1--;
	        		}
            return numeroMinas;
	}
}
