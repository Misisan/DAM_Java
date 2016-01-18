package Inicio;
import Ventanas.VentanaJuego;
import Ventanas.VentanaPlayer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {


	//ENTRADA A LA APLICACIÓN
	
	public static void main(String[] args) {
		
		//Ventanas a utilizar
			
		VentanaPlayer vPlayer = new VentanaPlayer();
		vPlayer.setVisible(true);
	}
}
