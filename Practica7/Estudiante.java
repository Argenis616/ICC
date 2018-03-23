package mx.unam.ciencias.icc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Clase para representar estudiantes. Un estudiante tiene nombre,
 * número de cuenta, promedio y edad. La clase implementa {@link
 * Registro}, por lo que puede cargarse y guardarse utilizando
 * objetos de las clases {@link BufferedReader} y {@link
 * BufferedWriter} como entrada y salida respectivamente.
 */
public class Estudiante implements Registro {

    /* Nombre del estudiante. */
    private String nombre;
    /* Número de cuenta. */
    private int cuenta;
    /* Pormedio del estudiante. */
    private double promedio;
    /* Edad del estudiante.*/
    private int edad;

    /**
     * Construye un estudiante con todas sus propiedades.
     * @param nombre el nombre del estudiante.
     * @param cuenta el número de cuenta del estudiante.
     * @param promedio el promedio del estudiante.
     * @param edad la edad del estudiante.
     */
    public Estudiante(String nombre,
                      int    cuenta,
                      double promedio,
                      int    edad) {
						  this.nombre = nombre;
						  this.cuenta=cuenta;
						  this.promedio= promedio;
						  this.edad =edad;
        // Aquí va su código.
    }

    /**
     * Regresa el nombre del estudiante.
     * @return el nombre del estudiante.
     */
    public String getNombre() {
		return nombre;
        // Aquí va su código.
    }

    /**
     * Define el nombre del estudiante.
     * @param nombre el nuevo nombre del estudiante.
     */
    public void setNombre(String nombre) {
		this.nombre = nombre;
		
        // Aquí va su código.
    }

    /**
     * Regresa el número de cuenta del estudiante.
     * @return el número de cuenta del estudiante.
     */
    public int getCuenta() {
		return cuenta;
        // Aquí va su código.
    }

    /**
     * Define el número cuenta del estudiante.
     * @param cuenta el nuevo número de cuena del estudiante.
     */
    public void setCuenta(int cuenta) {
		this.cuenta= cuenta;
        // Aquí va su código.
    }

    /**
     * Regresa el promedio del estudiante.
     * @return el promedio del estudiante.
     */
    public double getPromedio() {
		return promedio;
        // Aquí va su código.
    }

    /**
     * Define el promedio del estudiante.
     * @param promedio el nuevo promedio del estudiante.
     */
    public void setPromedio(double promedio) {
		this.promedio = promedio;
        // Aquí va su código.
    }

    /**
     * Regresa la edad del estudiante.
     * @return la edad del estudiante.
     */
    public int getEdad() {
		return edad;
        // Aquí va su código.
    }

    /**
     * Define la edad del estudiante.
     * @param edad la nueva edad del estudiante.
     */
    public void setEdad(int edad) {
		this.edad = edad;
        // Aquí va su código.
    }

    /**
     * Nos dice si el objeto recibido es un estudiante igual al que
     * manda llamar el método.
     * @param o el objeto con el que el estudiante se comparará.
     * @return <tt>true</tt> si el objeto o es un estudiante con las
     *         mismas propiedades que el objeto que manda llamar al
     *         método, <tt>false</tt> en otro caso.
     */
    @Override public boolean equals(Object o) {
        // Aquí va su código. 
        if(o instanceof Estudiante){
			Estudiante estudiante = (Estudiante) o;
			if(estudiante.nombre.equals(nombre)&&
			estudiante.cuenta==cuenta&&
			Double.compare(promedio,estudiante.promedio)==0
			&&estudiante.edad==edad)
			return true;
			return false;
		} return false;
    }

    /**
     * Regresa una representación en cadena del estudiante.
     * @return una representación en cadena del estudiante.
     */
    @Override public String toString() {
        // Aquí va su código.
        String cadena = String.format("Nombre   : %s\n" +
                                      "Cuenta   : %d\n" +
                                      "Promedio : %2.2f\n" +
                                      "Edad     : %d",
                                      nombre, cuenta, promedio, edad);
        return cadena;
    }

    /**
     * Guarda al estudiante en la salida recibida.
     * @param out la salida dónde hay que guardar al estudiante.
     * @throws IOException si un error de entrada/salida ocurre.
     */
    @Override public void guarda(BufferedWriter out) throws IOException {
		String s = String.format("%s\t%d\t%2.2f\t%d\n",
                                     nombre, cuenta, promedio, edad);
		out.write(s);
        // Aquí va su código.
    }

    /**
     * Carga al estudiante de la entrada recibida.
     * @param in la entrada de dónde hay que cargar al estudiante.
     * @return <tt>true</tt> si el método carga un estudiante
     *         válido, <tt>false</tt> en otro caso.
     * @throws IOException si un error de entrada/salida ocurre.
     */
    @Override public boolean carga(BufferedReader in) throws IOException {
        // Aquí va su código.
        String linea = in.readLine();
        if(linea==null)
        return false;
        linea = linea.trim();
        if(linea.equals(""))
        return false;
        String[] partes = linea.split("\t");
        if(partes.length!=4)
        throw new IOException("se terminaron los valores");
        nombre = partes[0];
        try {
			cuenta = Integer.parseInt(partes[1]);
			promedio = Double.parseDouble(partes[2]);
			edad = Integer.parseInt(partes[3]);
		}catch (NumberFormatException nfe){
			throw new IOException("ya no hagas mas");
		}
		return true;
        /**String r = in.readLine();
        if (r != null)verificar que r no sea null)
        * this.atributo= var[rugon];
        * verifico que los atributos (var[]seanvalidos
        * return true 
        * else
        return false;
        * string -> index of(char)substring(int),
        * subtring(int);	
        */
    }
}
