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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JTextField;

public class VentanaJuego extends JFrame {
	
	
	//DEFINICI�N DE OBJETOS
	
	private JPanel contentPane;
	private JLabel infoJug;
	private JLabel tablero;
	private Jugador p1;//Definici�n de la clase jugador para poder acceder a sus datos
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
	private JButton sumar;
	private JButton restar;
	private JTextField operaciones;
	private JButton mathdice;
	private JButton repetir;
	private JLabel cartel;
	private String sumatorio_texto="";//Variable para el texto que aparece en el JTextField OPERACIONES
	private int sumatorio=0;//Variable para convertir SUMATORIO_TEXTO en una operaci�n matem�tica
	private JLabel cartel2;
	private boolean edit_num=true;//Variable para dejar introducir n�meros
	private boolean edit_sign=false;//Variable para dejar introducir signos
	private boolean operacion=true;//En true sumar�, en false restar�
	
	
	
	//CONSTRUCTOR
	
	public VentanaJuego() {
		setTitle("Ventana de juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JLabel INFORMACI�N DEL JUGADOR
		infoJug = new JLabel();
		infoJug.setFont(new Font("Tahoma", Font.PLAIN, 14));
		infoJug.setHorizontalAlignment(SwingConstants.CENTER);
		infoJug.setBounds(349, 11, 325, 110);
		contentPane.add(infoJug);
		
		//JLabel IMAGEN DEL TABLERO
		tablero = new JLabel();
		ImageIcon tituloImagen = new ImageIcon(getClass().getResource("/img/mathdice.jpg"));
		tablero.setIcon(tituloImagen);
		tablero.setBounds(10, 11, 340, 110);
		contentPane.add(tablero);
		
		
		//INICIALIZACI�N DE ARRAYS
		
		for(int i=0;i<dado03.length;i++){
			dado03[i]= new ImageIcon(getClass().getResource("/img/dado03_"+(i+1)+".png"));
		}
		
		for(int i=0;i<dado06.length;i++){
			dado06[i]= new ImageIcon(getClass().getResource("/img/dado06_"+(i+1)+".png"));
		}
		
		for(int i=0;i<dado12.length;i++){
			dado12[i]= new ImageIcon(getClass().getResource("/img/dado12_"+(i+1)+".png"));
		}
			
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
		
		//BOT�N SUMAR +
		sumar = new JButton("+");
		sumar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sumar.setBounds(359, 132, 70, 33);
		contentPane.add(sumar);
		
		
		//BOT�N RESTAR -
		restar = new JButton("-");
		restar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		restar.setBounds(604, 132, 70, 33);
		contentPane.add(restar);
			
		//JTEXTAREA TEXTO ENTRE BOTONES
		JTextArea texto_botones = new JTextArea();
		texto_botones.setBackground(UIManager.getColor("Button.background"));
		texto_botones.setEditable(false);
		texto_botones.setFont(new Font("Tahoma", Font.PLAIN, 10));
		texto_botones.setText("Suma con el bot\u00F3n \"+\"\r\nResta con el bot\u00F3n  \"-\"");
		texto_botones.setBounds(462, 132, 107, 33);
		contentPane.add(texto_botones);
		
		//JTEXTFIELD DE OPERACIONES
		operaciones = new JTextField();
		operaciones.setEditable(false);
		operaciones.setHorizontalAlignment(SwingConstants.CENTER);
		operaciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		operaciones.setBounds(359, 176, 315, 33);
		contentPane.add(operaciones);
		operaciones.setColumns(10);
		
		//BOT�N MATHDICE
		mathdice = new JButton("MathDice");
		mathdice.setBounds(359, 220, 157, 23);
		contentPane.add(mathdice);
		
		//BOT�N VOLVER A INTENTAR
		repetir = new JButton("Volver a probar");
		repetir.setBounds(517, 220, 157, 23);
		contentPane.add(repetir);
		
		//JLABEL CARTEL DE RESPUESTA AL JUGADOR
		cartel = new JLabel("");
		cartel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cartel.setHorizontalAlignment(SwingConstants.CENTER);
		cartel.setBounds(359, 254, 315, 122);
		contentPane.add(cartel);
		
		//JLABEL CARTEL DE INFO VOLVER A JUGAR
		cartel2 = new JLabel("Para volver a jugar haz click en \"Volver a probar\"");
		cartel2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cartel2.setHorizontalAlignment(SwingConstants.CENTER);
		cartel2.setBounds(359, 376, 315, 29);
		contentPane.add(cartel2);
		cartel2.setVisible(false);
		
		//LISTENERS DE LOS BOTONES
		labelDado03_01.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if(edit_num==true){
					for(int i=0;i<dado03.length;i++){
						if(dado03[i]==labelDado03_01.getIcon()){
							sumatorio_texto = sumatorio_texto+String.valueOf((i+1));
							operaciones.setText(sumatorio_texto);
							if(operacion==true){
								sumatorio = sumatorio+(i+1);
							}else{
								sumatorio = sumatorio-(i+1);
							}
						}
					}
					labelDado03_01.setIcon(new ImageIcon(VentanaJuego.class.getResource("/img/dado_selec.png")));
					edit_num=false;
					edit_sign=true;
					labelDado03_01.removeMouseListener(this);
				}
			}
		});
		
		labelDado03_02.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if(edit_num==true){
					for(int i=0;i<dado03.length;i++){
						if(dado03[i]==labelDado03_02.getIcon()){
							sumatorio_texto = sumatorio_texto+String.valueOf((i+1));
							operaciones.setText(sumatorio_texto);
							if(operacion==true){
								sumatorio = sumatorio+(i+1);
							}else{
								sumatorio = sumatorio-(i+1);
							}
						}
					}
					labelDado03_02.setIcon(new ImageIcon(VentanaJuego.class.getResource("/img/dado_selec.png")));
					edit_num=false;
					edit_sign=true;
					labelDado03_02.removeMouseListener(this);
				}
			}
		});
		
		labelDado03_03.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if(edit_num==true){
					for(int i=0;i<dado03.length;i++){
						if(dado03[i]==labelDado03_03.getIcon()){
							sumatorio_texto = sumatorio_texto+String.valueOf((i+1));
							operaciones.setText(sumatorio_texto);
							if(operacion==true){
								sumatorio = sumatorio+(i+1);
							}else{
								sumatorio = sumatorio-(i+1);
							}
						}
					}
					labelDado03_03.setIcon(new ImageIcon(VentanaJuego.class.getResource("/img/dado_selec.png")));
					edit_num=false;
					edit_sign=true;
					labelDado03_03.removeMouseListener(this);
				}
			}
		});
		
		labelDado06_01.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if(edit_num==true){
					for(int i=0;i<dado06.length;i++){
						if(dado06[i]==labelDado06_01.getIcon()){
							sumatorio_texto = sumatorio_texto+String.valueOf((i+1));
							operaciones.setText(sumatorio_texto);
							if(operacion==true){
								sumatorio = sumatorio+(i+1);
							}else{
								sumatorio = sumatorio-(i+1);
							}
						}
					}
					labelDado06_01.setIcon(new ImageIcon(VentanaJuego.class.getResource("/img/dado_selec.png")));
					edit_num=false;
					edit_sign=true;
					labelDado06_01.removeMouseListener(this);
				}
			}
		});
		
		labelDado06_02.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if(edit_num==true){
					for(int i=0;i<dado06.length;i++){
						if(dado06[i]==labelDado06_02.getIcon()){
							sumatorio_texto = sumatorio_texto+String.valueOf((i+1));
							operaciones.setText(sumatorio_texto);
							if(operacion==true){
								sumatorio = sumatorio+(i+1);
							}else{
								sumatorio = sumatorio-(i+1);
							}
						}
					}
					labelDado06_02.setIcon(new ImageIcon(VentanaJuego.class.getResource("/img/dado_selec.png")));
					edit_num=false;
					edit_sign=true;
					labelDado06_02.removeMouseListener(this);
				}
			}
		});
		
		sumar.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if(edit_sign==true){
					sumatorio_texto = sumatorio_texto+"+";
					operaciones.setText(sumatorio_texto);
					operacion=true;
					edit_sign=false;
					edit_num=true;
				}
			}
		});
		
		restar.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				if(edit_sign==true){
					sumatorio_texto = sumatorio_texto+"-";
					operaciones.setText(sumatorio_texto);
					operacion=false;
					edit_sign=false;
					edit_num=true;
				}
			}
		});
		
		mathdice.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				if(edit_sign==true && operaciones.getText().length()>2){
					for(int i=0;i<dado12.length;i++){
						if(dado12[i]==labelDado12.getIcon()){					
							if((i+1)==sumatorio){
								cartel.setText("Perfecto");
							}else{
								cartel.setText("Has fallado, "+sumatorio+" no es igual a "+(i+1));
							}
						}
						edit_sign=false;
					}
					cartel2.setVisible(true);
				}
			}
		});
		
		repetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Reinicio el sumatorio, dejo en blanco el JTextField de las operaciones y oculto el cartel de info
				sumatorio_texto="";
				sumatorio=0;
				operaciones.setText(sumatorio_texto);
				cartel.setText("");
				cartel2.setVisible(false);
				
				//Reinicio insertar datos
				edit_num=true;
				edit_sign=false;
				operacion=true;
				
				//Reinicio las tiradas
				labelDado03_01.setIcon(dado03[tirada.nextInt(3)]);
				labelDado03_02.setIcon(dado03[tirada.nextInt(3)]);
				labelDado03_03.setIcon(dado03[tirada.nextInt(3)]);
				labelDado06_01.setIcon(dado06[tirada.nextInt(6)]);
				labelDado06_02.setIcon(dado06[tirada.nextInt(6)]);
				labelDado12.setIcon(dado12[tirada.nextInt(12)]);
				
				//Reinicio los Listeners
				labelDado03_01.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent arg0){
						if(edit_num==true){
							for(int i=0;i<dado03.length;i++){
								if(dado03[i]==labelDado03_01.getIcon()){
									sumatorio_texto = sumatorio_texto+String.valueOf((i+1));
									operaciones.setText(sumatorio_texto);
									if(operacion==true){
										sumatorio = sumatorio+(i+1);
									}else{
										sumatorio = sumatorio-(i+1);
									}
								}
							}
							labelDado03_01.setIcon(new ImageIcon(VentanaJuego.class.getResource("/img/dado_selec.png")));
							edit_num=false;
							edit_sign=true;
							labelDado03_01.removeMouseListener(this);
						}
					}
				});
				
				labelDado03_02.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent arg0){
						if(edit_num==true){
							for(int i=0;i<dado03.length;i++){
								if(dado03[i]==labelDado03_02.getIcon()){
									sumatorio_texto = sumatorio_texto+String.valueOf((i+1));
									operaciones.setText(sumatorio_texto);
									if(operacion==true){
										sumatorio = sumatorio+(i+1);
									}else{
										sumatorio = sumatorio-(i+1);
									}
								}
							}
							labelDado03_02.setIcon(new ImageIcon(VentanaJuego.class.getResource("/img/dado_selec.png")));
							edit_num=false;
							edit_sign=true;
							labelDado03_02.removeMouseListener(this);
						}
					}
				});
				
				labelDado03_03.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent arg0){
						if(edit_num==true){
							for(int i=0;i<dado03.length;i++){
								if(dado03[i]==labelDado03_03.getIcon()){
									sumatorio_texto = sumatorio_texto+String.valueOf((i+1));
									operaciones.setText(sumatorio_texto);
									if(operacion==true){
										sumatorio = sumatorio+(i+1);
									}else{
										sumatorio = sumatorio-(i+1);
									}
								}
							}
							labelDado03_03.setIcon(new ImageIcon(VentanaJuego.class.getResource("/img/dado_selec.png")));
							edit_num=false;
							edit_sign=true;
							labelDado03_03.removeMouseListener(this);
						}
					}
				});
				
				labelDado06_01.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent arg0){
						if(edit_num==true){
							for(int i=0;i<dado06.length;i++){
								if(dado06[i]==labelDado06_01.getIcon()){
									sumatorio_texto = sumatorio_texto+String.valueOf((i+1));
									operaciones.setText(sumatorio_texto);
									if(operacion==true){
										sumatorio = sumatorio+(i+1);
									}else{
										sumatorio = sumatorio-(i+1);
									}
								}
							}
							labelDado06_01.setIcon(new ImageIcon(VentanaJuego.class.getResource("/img/dado_selec.png")));
							edit_num=false;
							edit_sign=true;
							labelDado06_01.removeMouseListener(this);
						}
					}
				});
				
				labelDado06_02.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent arg0){
						if(edit_num==true){
							for(int i=0;i<dado06.length;i++){
								if(dado06[i]==labelDado06_02.getIcon()){
									sumatorio_texto = sumatorio_texto+String.valueOf((i+1));
									operaciones.setText(sumatorio_texto);
									if(operacion==true){
										sumatorio = sumatorio+(i+1);
									}else{
										sumatorio = sumatorio-(i+1);
									}
								}
							}
							labelDado06_02.setIcon(new ImageIcon(VentanaJuego.class.getResource("/img/dado_selec.png")));
							edit_num=false;
							edit_sign=true;
							labelDado06_02.removeMouseListener(this);
						}
					}
				});	
			}
		});
		
	}	
	
	
	//M�TODOS

	//Setter para jugador, por aqu� recibo el objeto jugador y lo enlazo con la clase Jugador a trav�s de esta ventana
	public void setJugador(Jugador p1) {
		this.p1=p1;
		infoJug.setText("Bienvenido/a al juego "+p1.getNombre());	
	}
}
