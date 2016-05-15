package Ventanas;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Jugador.Jugador;
import Modelo.conexionBBDD;
import Modelo.usuarioBBDD;

import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Login extends JFrame {

//DECLARACIÓN DE VARIABLES***************************************************************************************VARIABLES
	
	//Elementos visibles de la ventana
	private JPanel contentPane;
	private JButton btn_entrar;
	private JButton btn_reg;
	private JComboBox listaUsers;
	private JComboBox listaServidor;
	private JLabel imgCabecera;
	private JLabel labelServ;
	private JLabel labelUser;
	
	//Ventanas con las que trabajamos
	private Login refVenLogin;
	private Registro vReg;
	private VentanaMenu vMenu;
	
	//Objetos para manejar la BBDD
	private conexionBBDD bbdd;
	private conexionBBDD bbdd2;
	private conexionBBDD conexionSeleccionada;
	private usuarioBBDD userbbdd;
	private Jugador usuarioSeleccionado;
	
//FIN DECLARACIÓN VARIABLES--------------------------------------------------------------------------------------VARIABLES
	
//CONSTRUCTOR**************************************************************************************************CONSTRUCTOR
	
	public Login() {
		
		//Referencias
		refVenLogin=this;
		
		//Objeto Player
		//player = new Jugador();
		
		//Objeto conexionBBDD
		//Enviamos a la conexion de BBDD los datos para acceder a ella
		bbdd = new conexionBBDD("Localhost", "localhost", "mathdice", "usermd", "mathdice");
		bbdd2 = new conexionBBDD("Localhost v2", "", "mathdice", "usermd", "");
		
		//Ponemos por defecto como seleccionada la conexion del objeto bbdd
		//También utilizamos este objeto para pasar la opción seleccionada del ComboBox al Botón
		conexionSeleccionada = bbdd;
		
		//JFrame
		setTitle("MathDice - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 267);
		
		//JPanel - GridBagLayout
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		//JLabel - Imagen cabecera
		imgCabecera = new JLabel("");
		ImageIcon tituloImagen = new ImageIcon(getClass().getResource("/img/mathdice.jpg"));
		imgCabecera.setIcon(tituloImagen);
		GridBagConstraints gbc_imgCabecera = new GridBagConstraints();
		gbc_imgCabecera.gridwidth = 2;
		gbc_imgCabecera.weighty = 0.6;
		gbc_imgCabecera.weightx = 1.0;
		gbc_imgCabecera.insets = new Insets(0, 0, 5, 5);
		gbc_imgCabecera.gridx = 0;
		gbc_imgCabecera.gridy = 0;
		contentPane.add(imgCabecera, gbc_imgCabecera);
		
		//JLabel servidor
		labelServ = new JLabel("Elige el Servidor donde guardar los datos:");
		GridBagConstraints gbc_labelServ = new GridBagConstraints();
		gbc_labelServ.anchor = GridBagConstraints.WEST;
		gbc_labelServ .gridwidth = 2;
		gbc_labelServ .weighty = 0.1;
		gbc_labelServ .weightx = 1.0;
		gbc_labelServ .insets = new Insets(0, 0, 5, 5);
		gbc_labelServ .gridx = 0;
		gbc_labelServ .gridy = 1;
		contentPane.add(labelServ, gbc_labelServ );
		
		//JComboBox - Lista de Servidores
		listaServidor = new JComboBox();		
		GridBagConstraints gbc_listaServidor = new GridBagConstraints();
		gbc_listaServidor.weightx = 1.0;
		gbc_listaServidor.weighty = 0.1;
		gbc_listaServidor.gridwidth = 2;
		gbc_listaServidor.insets = new Insets(0, 0, 5, 0);
		gbc_listaServidor.fill = GridBagConstraints.HORIZONTAL;
		gbc_listaServidor.gridx = 0;
		gbc_listaServidor.gridy = 2;
		contentPane.add(listaServidor, gbc_listaServidor);
		listaServidor.addItem(bbdd);
		listaServidor.addItem(bbdd2);
		listaServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conexionSeleccionada = (conexionBBDD)listaServidor.getSelectedItem();
				rellenarCombo();	//Rellenamos el JComboBox según la conexión seleccionada
			}
		});
		
		//JLabel usuario
		labelUser = new JLabel("Elige el usuario registrado para jugar:");
		GridBagConstraints gbc_labelUser = new GridBagConstraints();
		gbc_labelUser.anchor = GridBagConstraints.WEST;
		gbc_labelUser .gridwidth = 2;
		gbc_labelUser .weighty = 0.1;
		gbc_labelUser .weightx = 1.0;
		gbc_labelUser .insets = new Insets(0, 0, 5, 5);
		gbc_labelUser .gridx = 0;
		gbc_labelUser .gridy = 3;
		contentPane.add(labelUser, gbc_labelUser );
		
		//JComboBox - Lista de usuarios
		listaUsers = new JComboBox();
		GridBagConstraints gbc_listaUsers = new GridBagConstraints();
		gbc_listaUsers.weightx = 1.0;
		gbc_listaUsers.weighty = 0.1;
		gbc_listaUsers.gridwidth = 2;
		gbc_listaUsers.insets = new Insets(0, 0, 5, 0);
		gbc_listaUsers.fill = GridBagConstraints.HORIZONTAL;
		gbc_listaUsers.gridx = 0;
		gbc_listaUsers.gridy = 4;
		contentPane.add(listaUsers, gbc_listaUsers);
		rellenarCombo();	//Rellenamos el JComboBox según la conexión seleccionada
		listaUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//El try-catch es para evitar el error al guardar el usuarioSeleccionado,
				//Ya que el primer item he puesto un String y no un obj Jugador
				try{
				usuarioSeleccionado = (Jugador)listaUsers.getSelectedItem();
				}catch(Exception e){
					System.out.println("No hay seleccionado ningún usuario");
				}
				System.out.println("Usuario seleccionado: "+usuarioSeleccionado);
			}
		});
				
		//JButton
		btn_entrar = new JButton("ACCEDER");
		GridBagConstraints gbc_btn_entrar = new GridBagConstraints();
		gbc_btn_entrar.anchor = GridBagConstraints.EAST;
		gbc_btn_entrar.weightx = 0.5;
		gbc_btn_entrar.weighty = 0.1;
		gbc_btn_entrar.insets = new Insets(0, 0, 0, 5);
		gbc_btn_entrar.gridx = 0;
		gbc_btn_entrar.gridy = 5;
		contentPane.add(btn_entrar, gbc_btn_entrar);
		btn_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vMenu = new VentanaMenu();
				vMenu.setJugador(usuarioSeleccionado);	
				vMenu.setVisible(true);			//Hago visible la VentanaMenu
				refVenLogin.setVisible(false);	//Hago invisible esta ventana
										
			}
		});
		
		//JButton
		btn_reg = new JButton("REGISTRARSE");
		GridBagConstraints gbc_btn_reg = new GridBagConstraints();
		gbc_btn_reg.anchor = GridBagConstraints.WEST;
		gbc_btn_reg.weighty = 0.1;
		gbc_btn_reg.weightx = 0.5;
		gbc_btn_reg.gridx = 1;
		gbc_btn_reg.gridy = 5;
		contentPane.add(btn_reg, gbc_btn_reg);
		btn_reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vReg = new Registro(conexionSeleccionada);
				vReg.setVisible(true);			//Hago visible la Ventana Registro
				refVenLogin.setVisible(false);	//Hago invisible esta ventana
										
			}
		});
						
	}
//FIN CONSTRUCTOR----------------------------------------------------------------------------------------------CONSTRUCTOR
	
	public void rellenarCombo(){
		
		//Comprobamos que la conexion es correcta
		if(conexionSeleccionada.connectDB()==true){
			
			System.out.println("Login: Conectado con éxito a la BBDD: "+conexionSeleccionada);
			listaUsers.setEnabled(true);	//Habilitamos el JComboBox
			
			//Objeto usuario BBDD
			//Por aquí le pasamos la conexión al usuarioBBDD
			userbbdd = new usuarioBBDD(bbdd.getConexion()); 
			
			//Rellenamos el JComboBox con los usuarios
			listaUsers.addItem("---- Selecciona un usuario ----");
			userbbdd.setUsuariosJCombo(listaUsers);
			
		}else{
			System.out.println("Login: Error en la conexión con la BBDD: "+conexionSeleccionada);
			listaUsers.setEnabled(false);	//Deshabilitamos el JComboBox
			listaUsers.removeAllItems();	//Quitamos los ítems para evitar duplicidades
		}
		
	}
}
