package mx.unam.ciencias.icc;

import java.io.IOException;

/**
 * Clase para servidores de bases de datos de estudiantes.
 */
public class ServidorBaseDeDatosEstudiantes
    extends ServidorBaseDeDatos<Estudiante> {

    /**
     * Construye un servidor de base de datos de estudiantes.
     * @param puerto el puerto dónde escuchar por conexiones.
     * @param archivo el archivo en el disco del cual cargar/guardar la base de
     *                datos.
     * @throws IOException si ocurre un error de entrada o salida.
     */
    public ServidorBaseDeDatosEstudiantes(int puerto, String archivo)
        throws IOException {
			super(puerto,archivo);
        // Aquí va su código.
    }

    /**
     * Crea una base de datos de estudiantes.
     * @return una base de datos de estudiantes.
     */
    @Override protected BaseDeDatos<Estudiante> creaBaseDeDatos() {
		return new BaseDeDatosEstudiantes();
        // Aquí va su código.
    }
}
