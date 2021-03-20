EJERCICIO 1

Ejercicio 1.
Implementá la clase Grupo, la cual representa al grupo de Trabajos Prácticos y sus
integrantes. Para eso, la clase tendrá un atributo nombre (String) para guardar el nombre
del grupo y otro atributo llamado integrantes (colección de Strings), donde cada elemento
será el nombre de un integrante de tu grupo de trabajos prácticos. Debe cumplir con el
siguiente diseño (explotar/implementar los métodos que se mencionan a continuación):
● public Grupo(String nombre) Es el constructor. Debe inicializar correctamente
los atributos de la clase.
● public String getNombre() Devuelve
el nombre del grupo.
● private void setNombre(String nombre) Setea el nombre del
grupo a partir del parámetro recibido.
● public int getCantidadIntegrantes() Devuelve la cantidad
actual de integrantes del grupo.
● public void agregarIntegrante(String nombreIntegrante) Agrega al grupo el nombre
de un nuevo integrante, siempre y cuando éste no haya sido cargado con anterioridad.
Cuando ya exista, no debe volver a agregarlo.
● private int obtenerPosicionIntegrante(String nombreIntegrante) Devuelve la posición
en el grupo del integrante cuyo nombre se ha recibido por parámetro. En caso de no
encontrarlo devolverá -1.
● public String obtenerIntegrante(int posicion) Recibe un valor entero que representa la
posición del integrante en la lista (entero igual o mayor que 1) y devuelve el integrante
guardado en (posicion - 1) dentro de la colección de integrantes. Si el integrante no
existe se debe devolver null.
● public String buscarIntegrante(String nombre) Busca al integrante del grupo cuyo
nombre coincida con el parámetro de entrada. En caso de que haya coincidencia, lo
devuelve; caso contrario, el método devolverá null.
● public String removerIntegrante(String nombreIntegrante) Remueve de la colección
de integrantes a aquel cuyo nombre coincide con el nombre recibido como parámetro.
Si lo encontró, luego de removerlo debe devolverlo con return, y si no debe devolver
null.
● private void mostrarIntegrantes() Muestra por consola la cantidad de integrantes y
los nombres de cada uno de ellos.
● public void mostrar() Muestra por consola el nombre del grupo, la cantidad de
integrantes y el nombre de cada uno de ellos.
● public void vaciar() Elimina todos los elementos de la lista
de integrantes

package ej1;
import java.util.ArrayList;

public class Group {
	private String nombre;
	private ArrayList<String> integrantes;
	
	public Group(String nombre) {
		this.nombre = nombre;
		this.integrantes = new ArrayList<String>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCantidadIntegrantes() {
		return this.integrantes.size();
	}
	
	private boolean estaIntegranteEnLista(String nombre) {
		int posicion = this.obtenerPosicionIntegrante(nombre);
		boolean resultado;
		if(posicion < 0) {
			resultado = false;
		} else {
			resultado = true;
		}
		return resultado;
	}
	
	public void agregarIntegrante(String nombreIntegrante) {
		int posicion = this.obtenerPosicionIntegrante(nombreIntegrante);
		if(this.estaIntegranteEnLista(nombreIntegrante)) {
			this.integrantes.add(nombreIntegrante);
		}
	}
	
	private int obtenerPosicionIntegrante(String nombre) {
		int posicion = -1;
		int index = 0;
		while (posicion == -1 || index < this.integrantes.size()) {
            String integrante_actual = this.integrantes.get(index);
            if(integrante_actual == nombre) {
            	posicion = index;
            }
        }  
		return posicion;
	}
	
	public String obtenerIntegrante(int posicion) {
		String integrante;
		if (posicion >= this.integrantes.size() || posicion < 0) {
			integrante = null;
		} else {
			integrante = this.integrantes.get(posicion - 1); 
		}
		return integrante;
	}
	
	public String buscarIntegrante(String nombre) {
		String integrante;
		int posicion = this.obtenerPosicionIntegrante(nombre);
		if(this.estaIntegranteEnLista(nombre)) {
			integrante = null;
		} else {
			integrante = this.integrantes.get(posicion); 
		}
		return integrante;
	}
	
	public String removerIntegrante(String nombre) {
		String integrante;
		int posicion = this.obtenerPosicionIntegrante(nombre);
		if(this.estaIntegranteEnLista(nombre)) {
			integrante = null;
		} else {
			integrante = this.integrantes.get(posicion); 
			this.integrantes.remove(posicion);
		}
		return integrante;
	}
	
	private void mostrarIntegrantes() {
		System.out.println("Cantidad de integrantes: " +
				this.integrantes.size());
		for (String integrante : this.integrantes) 
		{ 
			System.out.println("Nombre: " + integrante);
		}
	}
	
	public void mostrar() {
		this.mostrarIntegrantes();
	}
	
	public void vaciar() {
		this.integrantes = new ArrayList<String>();
	}
	
}


package ej2;

public class Atleta {
	String nombre;
	String especialidad;
	float segundos;
	
	
	public Atleta(String nombre,
			String especialidad, float segundos) {
		this.nombre = nombre;
		this.especialidad = especialidad;
		this.segundos = segundos;
	}
	
	public String getEspecialidad() {
		return especialidad;
	}
	
	public float getSegundos() {
		return this.segundos;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}




Ejercicio 2.
Para los Juegos Olímpicos de la Juventud nos pidieron un programa con el cual podamos
calcular quién fue el ganador de una carrera. Para eso ingresaremos un atleta y los
segundos que ha empleado (con decimales) para recorrer la distancia de una especialidad
determinada. Se debe tener en cuenta que puede haber más de un ganador (sus tiempos
empleados fueron los mismos).


Ejercicio 3.
Modificá el ejercicio anterior para que en vez de indicar solamente quién fue el ganador
obtenga cuál fue la terna ganadora. Debe tener en cuenta q



EJERCICIO 2


package ej2;

import java.util.ArrayList;
import java.util.Comparator;

public class JuegoOlimpico {
	private ArrayList<Atleta> atletas;
	
	public JuegoOlimpico () {
		this.atletas = new ArrayList<Atleta>();
	}
	
	public void agregarAtleta(String nombre,
			String especialidad, float segundos) {
		Atleta atleta = new Atleta(nombre,
				especialidad, segundos);
		this.atletas.add(atleta);
	}

	private ArrayList<Atleta> getAtletasDeEspecialidad(String especialidad) {
		ArrayList<Atleta> atletas = new ArrayList<Atleta>();
		for(Atleta atleta : this.atletas) {
			if(atleta.getEspecialidad().equals(especialidad)) {
				atletas.add(atleta);
			}
		}
		return atletas;
	}
	
	public ArrayList<Atleta> obtenerTerna(String especialidad) {
		ArrayList<Atleta> atletasDeEspecialidad = this.getAtletasDeEspecialidad(especialidad);
		atletasDeEspecialidad.sort(
				Comparator.comparing(Atleta::getSegundos)
		);
		ArrayList<Atleta> terna = new ArrayList<Atleta>();
		boolean tengoTerna = false;
		int index = 0;
		int posicion = 0;
		while(!tengoTerna || (index +1) == atletasDeEspecialidad.size()) {
			Atleta atleta = atletasDeEspecialidad.get(index);
			if(index == 0) {
				posicion = 1;
			} else {
				if(atleta.getSegundos() > 
					atletasDeEspecialidad.get(index).getSegundos()) {
					posicion++;
				}
			}
			if(posicion <= 3) {
				this.imprimirPosicion(atleta, posicion);	
			} else {
				tengoTerna = true;
			}
			index++;
		}
		return terna;
	}
	
	private void imprimirPosicion(Atleta atleta, int posicion) {
		System.out.println("Nombre: " + atleta.getNombre());
		System.out.println("Posicion: " + posicion);
	}
}

