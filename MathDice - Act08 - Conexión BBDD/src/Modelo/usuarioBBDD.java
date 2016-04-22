package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class usuarioBBDD {

//DECLARACI�N DE VARIABLES***************************************************************************************VARIABLES
	
	//Datos de la tabla de la BBDD
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	
//FIN DECLARACI�N VARIABLES--------------------------------------------------------------------------------------VARIABLES

//DEFINICI�N DE OBJETOS**********************************************************************************DEFINICI�N OBJETOS
	
	//Conexion con BBDD
	private Connection conexion;
	private Statement orden = null;
	
//FIN DEFINICI�N OBJETOS--------------------------------------------------------------------------------DEFINICI�N OBJETOS	
	
//CONSTRUCTOR**************************************************************************************************CONSTRUCTOR
	
	//Recibimos la conexi�n de conexionBBDD a trav�s del objeto de la class Registro
	public usuarioBBDD(Connection conexBBDDviaRegistro) {
		
		//Enlazamos nuestra CONEXION con la que hemos recibido a trav�s del constructor
		this.conexion=conexBBDDviaRegistro;
	}
	
//FIN CONSTRUCTOR----------------------------------------------------------------------------------------------CONSTRUCTOR
	
//M�TODOS**********************************************************************************************************M�TODOS
	
	//M�todo para insertar usuarios en la BBDD
	public void insertUsuario(String nombre, String apellido1, String apellido2, int edad){
		
		try {
			
			orden = conexion.createStatement();
			String comandoSQL = "insert into usuarios (nombre, apellido1, apellido2, edad) values ('"+nombre+"', '"+apellido1+"', '"+apellido2+"', "+edad+")";
			
			orden.executeUpdate(comandoSQL);
			System.out.println("Usuario registrado con �xito");
			
		} catch (SQLException e) {	//Error en la consulta
			e.printStackTrace();
		} catch (Exception e2) {	//Cualquier otro error
			e2.printStackTrace();
		} finally {					//Cerramos
			
			//Si hay una instrucci�n SQL cierra la conexi�n
			try{
				if(orden != null){conexion.close();}
			}catch(SQLException e3){}
			
			//Si hay alg�n tipo de conexi�n cierrala
			try{
				if(conexion != null){conexion.close();}
			}catch(SQLException e4){ //Sino saca el error
				e4.printStackTrace();
			}
			
		}
	}
	
//FIN M�TODOS------------------------------------------------------------------------------------------------------M�TODOS
}
