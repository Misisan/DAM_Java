package Inicio;
import Ventanas.VentanaJuego;
import Ventanas.Registro;
import java.awt.event.ActionListener;

import Modelo.conexionBBDD;

import java.awt.event.ActionEvent;

public class Principal {

	//ENTRADA A LA APLICACI�N
	public static void main(String[] args) {
		/*
		//Objeto para la conexi�n con la BBDD
		conexionBBDD conectarBBDD;
		
		//Realizamos el objeto para la conexion con la BBDD
		//Por aqu� tenemos que pasarle los datos HOST, BBDD, USER y PASS
		conectarBBDD = new conexionBBDD("localhost", "mathdice", "usermd", "mathdice");
		
		//Comprobamos la conexi�n de la BBDD con el m�todo connectDB de conexionBBDD.java
		if(conectarBBDD.connectDB()==true){
			System.out.println("Conectado con �xito a la BBDD");
		}else{
			System.out.println("Error en la conexi�n con la BBDD");
		}
		*/
		
		//Ventanas a utilizar	
		Registro vPlayer = new Registro();
		vPlayer.setVisible(true);
	}
}
