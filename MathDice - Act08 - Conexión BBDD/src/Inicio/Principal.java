package Inicio;
import Ventanas.VentanaJuego;
import Ventanas.Registro;
import java.awt.event.ActionListener;

import Modelo.conexionBBDD;

import java.awt.event.ActionEvent;

public class Principal {

	//ENTRADA A LA APLICACIÓN
	public static void main(String[] args) {
		/*
		//Objeto para la conexión con la BBDD
		conexionBBDD conectarBBDD;
		
		//Realizamos el objeto para la conexion con la BBDD
		//Por aquí tenemos que pasarle los datos HOST, BBDD, USER y PASS
		conectarBBDD = new conexionBBDD("localhost", "mathdice", "usermd", "mathdice");
		
		//Comprobamos la conexión de la BBDD con el método connectDB de conexionBBDD.java
		if(conectarBBDD.connectDB()==true){
			System.out.println("Conectado con éxito a la BBDD");
		}else{
			System.out.println("Error en la conexión con la BBDD");
		}
		*/
		
		//Ventanas a utilizar	
		Registro vPlayer = new Registro();
		vPlayer.setVisible(true);
	}
}
