package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionBBDD {
	
	// Conector para el driver de la BBDD
	static final String CONTROLADOR_MYSQL= "com.mysql.jdbc.Driver";


	//Variables para los datos de la BBDD
	private String host;
	private String bbdd;
	private String user;
	private String pass;
	private String url;
	private String alias;
	
	//Objeto para poder interactuar con la BBDD
	private Connection conexion = null;

//CONSTRUCTOR**************************************************************************************************CONSTRUCTOR
	//Recibe la información de la ventana Principal
	public conexionBBDD(String alias, String HOST,String BBDD,String USER,String PASS) {
		this.host=HOST;
		this.bbdd=BBDD;
		this.user=USER;
		this.pass=PASS;
		this.alias=alias;
	}
//FIN CONSTRUCTOR----------------------------------------------------------------------------------------------CONSTRUCTOR

//MÉTODOS**********************************************************************************************************MÉTODOS
	
	//Método privado para cargar el controlador
	public boolean connectDB(){
		try{
			//Cargar el controlador MYSQL para poder conectar con la BBDD
			Class.forName(CONTROLADOR_MYSQL);
			
			//Conectar a la BBDD
			conexion = DriverManager.getConnection("jdbc:mysql://"+this.host+"/"+this.bbdd, this.user, this.pass);
			System.out.println("Conexion OK con "+this.alias);
		}catch( SQLException excepcionSQL ){ //Cath para la conexión a la BBDD
			//Imprimir en pantalla el error
			excepcionSQL.printStackTrace();
			return false;
		}catch( ClassNotFoundException noEncontroClase){ //Catch para el controlador
			noEncontroClase.printStackTrace();
			return false;
		}
		return true;
	}
	
	//Método getter para que las otras class pillen la conexión
	public Connection getConexion(){
		return conexion;
	}
	
	public String toString(){
		return alias;
	}
	
//FIN MÉTODOS------------------------------------------------------------------------------------------------------MÉTODOS
}
