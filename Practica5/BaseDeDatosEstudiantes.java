package mx.unam.ciencias.icc;

/**
 * Clase para bases de datos de estudiantes.
 */
public class BaseDeDatosEstudiantes extends BaseDeDatos {

    /**
     * Crea un estudiante en blanco.
     * @return un estudiante en blanco.
     */
    @Override protected Registro creaRegistro() {
        // Aquí va su código.
       
        return new Estudiante(null,0,0,0);
        
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
    @Override public Lista buscaRegistros(String campo, String texto) {
        // Aquí va su código.
        registros.primero();
		Lista lista = new Lista();
			Estudiante estudiante;
			String s="";
		while(registros.iteradorValido()) {
        estudiante = (Estudiante)registros.get();
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
        registros.siguiente();
    }
    return lista;
    }
}
