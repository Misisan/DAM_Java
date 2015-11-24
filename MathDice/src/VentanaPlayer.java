import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class VentanaPlayer extends JFrame {// Indicamos que VentanaPlayer hereda los atributos de JFrame
	
	//DEFINICIÓN OBJETOS
	
	private JPanel Panel;
	private JLabel etiqNombre;
	private JTextField textNombre;
	private JLabel etiqApellidos;
	private JTextField textApellidos;
	private JLabel etiqEdad;
	private JTextField textEdad;
	private JTextField textConsola;
	private JButton botonCrear;
	private Jugador player;
	
	// CONSTRUCTOR
	
	public VentanaPlayer() {
		//Propiedades de la ventana Jframe
				setTitle("MATH DICE - Crea a tu jugador");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 450, 228);
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
				textNombre.setBounds(79, 8, 345, 20);
				Panel.add(textNombre);
				textNombre.setColumns(10);
				
				//Etiqueta APELLIDOS
				etiqApellidos = new JLabel("APELLIDOS:");
				etiqApellidos.setBounds(10, 39, 69, 14);
				Panel.add(etiqApellidos);
				
				//Texto APELLIDOS
				textApellidos = new JTextField();
				textApellidos.setColumns(10);
				textApellidos.setBounds(79, 36, 345, 20);
				Panel.add(textApellidos);
				
				//Etiqueta EDAD
				etiqEdad = new JLabel("EDAD:");
				etiqEdad.setBounds(10, 70, 69, 14);
				Panel.add(etiqEdad);
				
				//Texto EDAD
				textEdad = new JTextField();
				textEdad.setColumns(2);
				textEdad.setBounds(79, 67, 35, 20);
				Panel.add(textEdad);
				
				//Texto CONSOLA
				textConsola = new JTextField();
				textConsola.setEditable(false);
				textConsola.setHorizontalAlignment(SwingConstants.CENTER);
				textConsola.setBounds(10, 132, 414, 49);
				Panel.add(textConsola);
				textConsola.setColumns(10);
				

				//Botón CREAR JUGADOR
				botonCrear = new JButton("CREAR JUGADOR");
				botonCrear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						player.setNombre(textNombre.getText());					// Guardar el texto de "textNombre" en el "nombre" de la clase jugador
						player.setApellidos(textApellidos.getText());			// Guardar el texto de "textApellidos" en el "apellidos" de la clase jugador
						
						/* Cuando el JTextField de "edad" está en blanco y conviertes ese String vacío a Integer
						 * con Integer.valueOf() da un error por que debe tener un valor para hacer la conversión.
						 * Para solucionar eso en el "if" que hay a continuación le condiciono para que me escriba
						 * un "-1" cuando el campo "edad" está vacío y en la clase jugador hago para que me condicione
						 * a "0" la edad mínima y con cualquier número menor que "0" hace saltar la bandera que me
						 * detecta que falta algún campo por completar.
						 */
						
						if(textEdad.getText().length()==0){
							player.setEdad(-1);
						}else{
							player.setEdad(Integer.valueOf(textEdad.getText()));
						}

						textConsola.setText(player.getContestacion());
						
						player.setFlag(0);
					}
				});
				botonCrear.setBounds(10, 98, 414, 23);
				Panel.add(botonCrear);
				
				//Objeto Player
				player = new Jugador();
								

	}
}
