package Ventanas;

import Jugador.Jugador;
import Modelo.conexionBBDD;
import Modelo.usuarioBBDD;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class Registro extends JFrame {// Indicamos que VentanaPlayer hereda los atributos de JFrame
	
//DEFINICI�N DE OBJETOS**********************************************************************************DEFINICI�N OBJETOS
	
	private JPanel Panel;
	private JLabel etiqNombre;
	private JTextField textNombre;
	private JLabel etiqApellido1;
	private JTextField textApellido1;
	private JLabel etiqApellido2;
	private JTextField textApellido2;
	private JLabel etiqEdad;
	private JTextField textEdad;
	private JTextField textConsola;
	private JButton botonCrear;
	private Jugador player;			//Definici�n clase Juegador para poder acceder a ella
	private VentanaMenu vMenu;		//Definici�n de VentanaMenu para crearla y visibilizarla
	private Registro refVenPl;		//Definici�n para esta ventana, para poder usar la referencia a ella y ocultarla
	private String error = ""; //Variable intorducida para poder mostrar el error de la BBDD en la ventana de registro
	
	//Definimos las class que manejan la BBDD para poder acceder a ellas
	private conexionBBDD bbdd;
	private usuarioBBDD userbbdd;
	
//FIN DEFINICI�N OBJETOS--------------------------------------------------------------------------------DEFINICI�N OBJETOS
	
//CONSTRUCTOR**************************************************************************************************CONSTRUCTOR
	
	public Registro(conexionBBDD bbdd) {
		
		//Objeto Player
		player = new Jugador();
		
		//Objeto Ventana de Men�
		vMenu = new VentanaMenu();
		
		//Referencias
		refVenPl=this;	//Enlazo el constructor con VentanaPlayer a trav�s de su referencia
		
		//Recibimos la conexi�n a la BBDD desde el Login a trav�s del Constructor
		this.bbdd = bbdd;
		
			//Comprobamos la conexi�n de la BBDD con el m�todo connectDB de conexionBBDD.java
			if(bbdd.connectDB()==true){
				error = "Bienvenido/a";
				System.out.println("Registro: Conectado con �xito a la BBDD");
			}else{
				error = "Error en la conexi�n con la BBDD, si continua sus datos no se registrar�n";
				System.out.println("Registro: Error en la conexi�n con la BBDD");
			}
		
		//Objeto usuarioBBDD
		//Pillamos la conexi�n de la BBDD y se la enviamos a el usuarioBBDD para que pueda utilizarla
		userbbdd = new usuarioBBDD(bbdd.getConexion());
		
		//Propiedades de la ventana Jframe
		setTitle("MATH DICE - Crea a tu jugador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 244);
		Panel = new JPanel();
		Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel);
		Panel.setLayout(null);
		
		// Etiqueta NOMBRE
		etiqNombre = new JLabel("NOMBRE:");
		etiqNombre.setBounds(10, 11, 69, 14);
		Panel.add(etiqNombre);
		
		//Texto NOMBRE
		textNombre = new JTextField();
		textNombre.setBounds(104, 8, 320, 20);
		Panel.add(textNombre);
		textNombre.setColumns(10);
		
		//Etiqueta 1er APELLIDO
		etiqApellido1 = new JLabel("1er APELLIDO:");
		etiqApellido1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		etiqApellido1.setBounds(10, 39, 79, 14);
		Panel.add(etiqApellido1);
		
		//Texto 1er APELLIDO
		textApellido1 = new JTextField();
		textApellido1.setColumns(10);
		textApellido1.setBounds(104, 36, 320, 20);
		Panel.add(textApellido1);
		
		//Etiqueta 2o APELLIDO
		etiqApellido2 = new JLabel("2o APELLIDO:");
		etiqApellido2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		etiqApellido2.setBounds(10, 64, 69, 14);
		Panel.add(etiqApellido2);
		
		//Texto 2o APELLIDO
		textApellido2 = new JTextField();
		textApellido2.setColumns(10);
		textApellido2.setBounds(104, 61, 320, 20);
		Panel.add(textApellido2);
		
		//Etiqueta EDAD
		etiqEdad = new JLabel("EDAD:");
		etiqEdad.setBounds(10, 89, 69, 14);
		Panel.add(etiqEdad);
		
		//Texto EDAD
		textEdad = new JTextField();
		textEdad.setColumns(2);
		textEdad.setBounds(104, 86, 35, 20);
		Panel.add(textEdad);
		
		//Texto CONSOLA
		textConsola = new JTextField();
		textConsola.setEditable(false);
		textConsola.setHorizontalAlignment(SwingConstants.CENTER);
		textConsola.setBounds(10, 148, 414, 49);
		Panel.add(textConsola);
		textConsola.setColumns(10);
		textConsola.setText(error);
		

		//Bot�n CREAR JUGADOR
		botonCrear = new JButton("CREAR JUGADOR");
		botonCrear.setBounds(10, 114, 414, 23);
		Panel.add(botonCrear);
		botonCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player.setNombre(textNombre.getText());
				player.setApellido1(textApellido1.getText());
				player.setApellido2(textApellido2.getText());
				
				if(textEdad.getText().length()==0){
					player.setEdad(-1);
				}else{
					player.setEdad(Integer.valueOf(textEdad.getText()));
				}
				
				if(player.getFlag()==false){
					//Env�o a VentanaMenu el objeto player de class Jugador
					//y ah� ya se reenviar� a su destino final ( VentanaJuego y VentanaPerfil )
					vMenu.setJugador(player);	
					
					//Envio la info del jugador a la BBDD para registrala
					userbbdd.insertUsuario(player.getNombre(), player.getApellido1(), player.getApellido2(), player.getEdad());			
					
					vMenu.setVisible(true);		//Hago visible la VentanaMenu
					refVenPl.setVisible(false);	//Hago invisible pero no cierro esta ventana por si la necesito en un futuro
				}else{
					textConsola.setText(player.getContestacion());
					player.setFlag(false);
				}						
			}
		});
					
	}
	
//FIN CONSTRUCTOR----------------------------------------------------------------------------------------------CONSTRUCTOR
}
