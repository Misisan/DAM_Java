package Jugador;
//DEFINICIÓN DE CLASE
public class Jugador { //Definimos una class nueva llamada Jugador

	//PROPIEDADES de la clase
	private String nombre;
	private String apellidos;
	private int edad;
	private int puntos;
	private boolean flag=false;
	private String contestacion;
	
	//CONSTRUCTOR de la clase
	public Jugador() {
	}

	
	//MÉTODOS
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		if (nombre.length()==0){
			flag=true;
		}
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
		if (apellidos.length()==0){
			flag=true;
		}
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if(edad<0){
			this.edad=0;
			flag=true;
		}else{
			this.edad = edad;
		}
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}


	public boolean getFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	public String getContestacion() {
		return "Error. Falta introducir datos.";
		/*if(!flag){
			return "El jugador/a "+nombre+" "+apellidos+" de "+edad+" años ha sido creado con éxito.";
		}else{
			return "Error. Falta introducir datos.";
		}*/
	}


	public void setContestacion(String contestacion) {
		this.contestacion = contestacion;
	}
	
}