package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Jugador.Jugador;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class VentanaJuego extends JFrame {
	
	
	//DEFINICIÓN DE OBJETOS
	
	private JPanel contentPane;
	private JLabel infoJug;//La hago pública y estática para que VentanaPlayer pueda acceder a ella
	private JLabel tablero;
	private Jugador p1;

	
	//CONSTRUCTOR
	
	public VentanaJuego() {
		setTitle("Ventana de juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JLabel INFORMACIÓN DEL JUGADOR
		infoJug = new JLabel();
		infoJug.setHorizontalAlignment(SwingConstants.RIGHT);
		infoJug.setBounds(51, 21, 340, 14);
		contentPane.add(infoJug);
		
		//JLabel IMAGEN DEL TABLERO
		tablero = new JLabel();
		ImageIcon tituloImagen = new ImageIcon(getClass().getResource("/img/mathdice.jpg"));
		tablero.setIcon(tituloImagen);
		tablero.setBounds(51, 55, 340, 110);
		contentPane.add(tablero);
		
	}


	public void setJugador(Jugador p1) {
		this.p1 = p1;
		infoJug.setText("Bienvenido/a al juego "+p1.getNombre());
	}
	
}
