package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Jugador.Jugador;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMenu extends JFrame {

//DEFINICIÓN DE OBJETOS*********************************************************************************DEFINICIÓN OBJETOS
	private JPanel contentPane;
	private JMenuBar menu_barra;
	private JMenu menu_opc1; 
	private JMenuItem menu_item1_1;
	private JMenuItem menu_item1_2;
	private Jugador p1;
		
	//Identificadores para las ventanas del CardLayout
	final static String VENTANA_JUEGO = "Juego en curso";
	final static String VENTANA_PERFIL = "Perfil del jugador";
	
	//Ventanas para el CardLayout
	VentanaJuego juego = new VentanaJuego();	//Aprovecho este objeto VentanaJuego para enviar el objeto de la info del jugador
	VentanaPerfil perfil = new VentanaPerfil();	//Aprovecho este objeto VentanaJuego para enviar el objeto de la info del jugador
//FIN DEFINICIÓN OBJETOS--------------------------------------------------------------------------------DEFINICIÓN OBJETOS
	
//CONSTRUCTOR**************************************************************************************************CONSTRUCTOR
	public VentanaMenu() {
		
		//JFrame
		/*setTitle("MATH DICE - \u00A1a jugar! - By M.A. Sime\u00F3n for 1\u00BADAM");*/
		setTitle("MATH DICE - \u00A1a jugar!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 480);
		
		//Layout - CardLayout
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//Añadimos ventanas al CardLayout
		contentPane.add(juego, VENTANA_JUEGO);
		contentPane.add(perfil, VENTANA_PERFIL);
		
		//Menú
		menu_barra = new JMenuBar();
		setJMenuBar(menu_barra);
		
			menu_opc1 = new JMenu("Ventanas");
			menu_barra.add(menu_opc1);
			
				menu_opc1.addSeparator();
				menu_opc1.addSeparator();
			
				menu_item1_1 = new JMenuItem("Juego en curso");
				menu_opc1.add(menu_item1_1);
				menu_item1_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						CardLayout card = (CardLayout)(contentPane.getLayout());
						card.show(contentPane, VENTANA_JUEGO);
					}
				});
				
				menu_item1_2 = new JMenuItem("Perfil del jugador");
				menu_opc1.add(menu_item1_2);
				menu_item1_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						CardLayout card = (CardLayout)(contentPane.getLayout());
						card.show(contentPane, VENTANA_PERFIL);
					}
				});
				
				menu_opc1.addSeparator();
				menu_opc1.addSeparator();
		
		
	}
//FIN CONSTRUCTOR----------------------------------------------------------------------------------------------CONSTRUCTOR
	
//MÉTODOS**********************************************************************************************************MÉTODOS
	
	public void setJugador(Jugador p1) {
		//Recibo el objeto jugador del login
		this.p1=p1;
		//Reenvío el objeto jugador a los 2 JPanels que lo necesitan
		juego.setJugador(p1);
		perfil.setJugador(p1);
	}
	
//FIN MÉTODOS------------------------------------------------------------------------------------------------------MÉTODOS
}
