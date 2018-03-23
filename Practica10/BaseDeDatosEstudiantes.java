package mx.unam.ciencias.icc;

/**
 * Clase para bases de datos de estudiantes.
 */
public class BaseDeDatosEstudiantes extends BaseDeDatos<Estudiante> {

    /**
     * Crea un estudiante en blanco.
     * @return un estudiante en blanco.
     */
    @Override public Estudiante creaRegistro() {
		return new Estudiante(null,0,0,0);
        // Aquí va su código.
    }

    /**
     * Busca estudiantes por un campo específico.
     * @param campo el campo del registro por el cuál buscar; puede ser
     *              <ul>
     *               <li><tt>"nombre"</tt></li>
     *               <li><tt>"cuenta"</tt></li>
     *               <li><tt>"promedio"</tt></li>
     *               <li><tt>"edad"</tt></li>
     *              </ul>
     * @param texto el texto a buscar.
     * @return una lista con los estudiantes tales que en el campo especificado
     *         contienen el texto recibido.
     * @throws IllegalArgumentException si el campo no es ninguno de los
     *         especificados arriba.
     */
    @Override public Lista<Estudiante> buscaRegistros(String campo, String texto) {
		Lista<Estudiante> lista = new Lista<Estudiante>();
			String s="";
			for (Estudiante estudiante: registros){
        switch(campo) {
            case "nombre":
                if(estudiante.getNombre().contains(texto))
                lista.agregaFinal(estudiante);
                break;
            case "cuenta":
                s = String.valueOf(estudiante.getCuenta());
                if(s.contains(texto))
                lista.agregaFinal(estudiante);
                break;
            case "promedio" :
                s = String.valueOf(estudiante.getPromedio());
                if(s.contains(texto))
                lista.agregaFinal(estudiante);
                break;
            case "edad":
                s = String.valueOf(estudiante.getEdad());
                if(s.contains(texto))
                lista.agregaFinal(estudiante);
                break;
            default:
                throw new IllegalArgumentException();
        }
	}
    return lista;
        // Aquí va su código.
    }
}
