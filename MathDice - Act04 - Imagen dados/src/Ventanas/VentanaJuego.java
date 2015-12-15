package Ventanas;

import Jugador.Jugador;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaJuego extends JFrame {
	
	
	//DEFINICIÓN DE OBJETOS
	
	private JPanel contentPane;
	private JLabel infoJug;//La hago pública y estática para que VentanaPlayer pueda acceder a ella
	private JLabel tablero;
	private Jugador p1;
	private ImageIcon[] dado03 = new ImageIcon[3];
	private ImageIcon[] dado06 = new ImageIcon[6];
	private ImageIcon[] dado12 = new ImageIcon[12];
	private Random tirada = new Random();
	private JLabel labelDado03_01;
	private JLabel labelDado03_02;
	private JLabel labelDado03_03;
	private JLabel labelDado06_01;
	private JLabel labelDado06_02;
	private JLabel labelDado12;
	private JButton tirar;
	
	
	//CONSTRUCTOR
	
	public VentanaJuego() {
		setTitle("Ventana de juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JLabel INFORMACIÓN DEL JUGADOR
		infoJug = new JLabel();
		infoJug.setHorizontalAlignment(SwingConstants.RIGHT);
		infoJug.setBounds(10, 11, 340, 14);
		contentPane.add(infoJug);
		
		//JLabel IMAGEN DEL TABLERO
		tablero = new JLabel();
		ImageIcon tituloImagen = new ImageIcon(getClass().getResource("/img/mathdice.jpg"));
		tablero.setIcon(tituloImagen);
		tablero.setBounds(10, 32, 340, 110);
		contentPane.add(tablero);
		
		
		//INICIALIZACIÓN DE ARRAYS
		
		dado03[0]= new ImageIcon(getClass().getResource("/img/dado03_01.png"));
		dado03[1]= new ImageIcon(getClass().getResource("/img/dado03_02.png"));
		dado03[2]= new ImageIcon(getClass().getResource("/img/dado03_03.png"));
		
		dado06[0]= new ImageIcon(getClass().getResource("/img/dado06_01.png"));
		dado06[1]= new ImageIcon(getClass().getResource("/img/dado06_02.png"));
		dado06[2]= new ImageIcon(getClass().getResource("/img/dado06_03.png"));
		dado06[3]= new ImageIcon(getClass().getResource("/img/dado06_04.png"));
		dado06[4]= new ImageIcon(getClass().getResource("/img/dado06_05.png"));
		dado06[5]= new ImageIcon(getClass().getResource("/img/dado06_06.png"));
		
		dado12[0]= new ImageIcon(getClass().getResource("/img/dado12_01.png"));
		dado12[1]= new ImageIcon(getClass().getResource("/img/dado12_02.png"));
		dado12[2]= new ImageIcon(getClass().getResource("/img/dado12_03.png"));
		dado12[3]= new ImageIcon(getClass().getResource("/img/dado12_04.png"));
		dado12[4]= new ImageIcon(getClass().getResource("/img/dado12_05.png"));
		dado12[5]= new ImageIcon(getClass().getResource("/img/dado12_06.png"));
		dado12[6]= new ImageIcon(getClass().getResource("/img/dado12_07.png"));
		dado12[7]= new ImageIcon(getClass().getResource("/img/dado12_08.png"));
		dado12[8]= new ImageIcon(getClass().getResource("/img/dado12_09.png"));
		dado12[9]= new ImageIcon(getClass().getResource("/img/dado12_10.png"));
		dado12[10]= new ImageIcon(getClass().getResource("/img/dado12_11.png"));
		dado12[11]= new ImageIcon(getClass().getResource("/img/dado12_12.png"));
			
		//DADOS
		
		labelDado03_01 = new JLabel("");
		labelDado03_01.setBounds(39, 153, 80, 80);
		contentPane.add(labelDado03_01);
		labelDado03_01.setIcon(dado03[tirada.nextInt(3)]);
		
		labelDado03_02 = new JLabel("");
		labelDado03_02.setBounds(139, 153, 80, 80);
		contentPane.add(labelDado03_02);
		labelDado03_02.setIcon(dado03[tirada.nextInt(3)]);
		
		labelDado03_03 = new JLabel("");
		labelDado03_03.setBounds(239, 153, 80, 80);
		contentPane.add(labelDado03_03);
		labelDado03_03.setIcon(dado03[tirada.nextInt(3)]);
		
		labelDado06_01 = new JLabel("");
		labelDado06_01.setBounds(39, 239, 80, 80);
		contentPane.add(labelDado06_01);
		labelDado06_01.setIcon(dado06[tirada.nextInt(6)]);
		
		labelDado06_02 = new JLabel("");
		labelDado06_02.setBounds(139, 239, 80, 80);
		contentPane.add(labelDado06_02);
		labelDado06_02.setIcon(dado06[tirada.nextInt(6)]);
		
		labelDado12 = new JLabel("");
		labelDado12.setBounds(39, 325, 80, 80);
		contentPane.add(labelDado12);
		labelDado12.setIcon(dado12[tirada.nextInt(12)]);
		
		
		//BOTON VOLVER A TIRAR
		
		tirar = new JButton();
		tirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				labelDado03_01.setIcon(dado03[tirada.nextInt(3)]);
				labelDado03_02.setIcon(dado03[tirada.nextInt(3)]);
				labelDado03_03.setIcon(dado03[tirada.nextInt(3)]);
				labelDado06_01.setIcon(dado06[tirada.nextInt(6)]);
				labelDado06_02.setIcon(dado06[tirada.nextInt(6)]);
				labelDado12.setIcon(dado12[tirada.nextInt(12)]);
			}
		});
		tirar.setIcon(new ImageIcon(VentanaJuego.class.getResource("/img/dados.png")));
		tirar.setBounds(239, 325, 80, 80);
		contentPane.add(tirar);
		
	}	
	
	
	//MÉTODOS


	public void setJugador(Jugador p1) {
		this.p1=p1;
		infoJug.setText("Bienvenido/a al juego "+p1.getNombre());
		
	}
}
