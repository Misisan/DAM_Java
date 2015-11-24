import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {
	
	//VARIABLES
	private JPanel contentPane;

	//ENTRADA A LA APLICACIÓN
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	//CONSTRUCTOR - CONFIGURACIÓN
	
	public Principal() {
		
		//Propiedades de la ventana Jframe
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		//Creamos los nuevos objetos de clase "Jugador"
		Jugador jugador1= new Jugador();
			//Definimos las propiedades/variables de la clase para este objeto
			jugador1.nombre="Lola";
			jugador1.apellidos="Rodríguez López";
			jugador1.edad=26;
			jugador1.puntos=15;
			
			//Sacamos en la consola un texto que incluyen las variables definidas anteriormente
			System.out.println("La jugadora "+jugador1.nombre+" "+jugador1.apellidos+" de "+jugador1.edad+" años tiene actualmente "+jugador1.puntos+" puntos.");

			//Creamos los nuevos objetos de clase "Jugador"
			Jugador jugador2= new Jugador();
				//Definimos las propiedades/variables de la clase para este objeto
				jugador2.nombre="Manuel";
				jugador2.apellidos="Pelaez Martínez";
				jugador2.edad=33;
				jugador2.puntos=9;
				
				//Sacamos en la consola un texto que incluyen las variables definidas anteriormente
				System.out.println("El jugador "+jugador2.nombre+" "+jugador2.apellidos+" de "+jugador2.edad+" años tiene actualmente "+jugador2.puntos+" puntos.");
		
	}


}
