package Ventanas;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Jugador.Jugador;

public class VentanaPerfil extends JPanel {
	
//DEFINICIÓN DE OBJETOS*********************************************************************************DEFINICIÓN OBJETOS
	
	private JLabel labelNombre;
	private JLabel labelApellido1;
	private JLabel labelApellido2;
	private JLabel labelEdad;
	private JTextField textoNombre;
	private JTextField textoApellido1;
	private JTextField textoApellido2;
	private JTextField textoEdad;
	private JLabel labelFoto;
	private Jugador player1;

//FIN DEFINICIÓN OBJETOS--------------------------------------------------------------------------------DEFINICIÓN OBJETOS

//CONSTRUCTOR**************************************************************************************************CONSTRUCTOR
	
	public VentanaPerfil() {
		
		//Propiedades del Layout
		setLayout(null);
		
		//Etiquetas y Cuadros de texto
		labelNombre = new JLabel("NOMBRE:");
		labelNombre.setBounds(180, 45, 69, 14);
		add(labelNombre);
		
		textoNombre = new JTextField();
		textoNombre.setEditable(false);
		textoNombre.setBounds(282, 42, 168, 20);
		add(textoNombre);
		textoNombre.setColumns(10);
		
		labelApellido1 = new JLabel("1\u00BA APELLIDO:");
		labelApellido1.setBounds(180, 73, 92, 14);
		add(labelApellido1);
		
		textoApellido1 = new JTextField();
		textoApellido1.setEditable(false);
		textoApellido1.setColumns(10);
		textoApellido1.setBounds(282, 70, 168, 20);
		add(textoApellido1);
		
		labelApellido2 = new JLabel("2\u00BA APELLIDO:");
		labelApellido2.setBounds(180, 104, 92, 14);
		add(labelApellido2);
		
		textoApellido2 = new JTextField();
		textoApellido2.setEditable(false);
		textoApellido2.setColumns(10);
		textoApellido2.setBounds(282, 101, 168, 20);
		add(textoApellido2);
		
		labelEdad = new JLabel("EDAD:");
		labelEdad.setBounds(180, 135, 46, 14);
		add(labelEdad);
		
		textoEdad = new JTextField();
		textoEdad.setEditable(false);
		textoEdad.setColumns(10);
		textoEdad.setBounds(282, 132, 168, 20);
		add(textoEdad);
		
		//JLabel para la foto
		labelFoto = new JLabel();
		ImageIcon fotoPerfil = new ImageIcon(getClass().getResource("/img/cabeza.png"));
		labelFoto.setIcon(fotoPerfil);
		labelFoto.setBounds(10, 11, 150, 159);
		add(labelFoto);
				
	}
	
//FIN CONSTRUCTOR----------------------------------------------------------------------------------------------CONSTRUCTOR

//MÉTODOS**********************************************************************************************************MÉTODOS
	
	public void setJugador(Jugador player1) {
		this.player1=player1;
		textoNombre.setText(player1.getNombre());
		textoApellido1.setText(player1.getApellido1());
		textoApellido1.setText(player1.getApellido2());
		textoEdad.setText(String.valueOf(player1.getEdad()));
				
		if(player1.getFoto()!= null){
			labelFoto.setIcon(player1.getFoto());
		}
	}

//FIN MÉTODOS------------------------------------------------------------------------------------------------------MÉTODOS
}
