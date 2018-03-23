package mx.unam.ciencias.icc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase abstracta para servidores de bases de datos genéricas.
 */
public abstract class ServidorBaseDeDatos<T extends Registro> {

    /* La base de datos. */
    private BaseDeDatos<T> bdd;
    /* El servidor de enchufes. */
    private ServerSocket servidor;
    /* El enchufe. */
    private Socket enchufe;
    /* El puerto. */
    private int puerto;
    /* El archivo donde cargar/guardar la base de datos. */
    private String archivo;
    /* Lista con los hilos del servidor. */
    private Lista<HiloServidor<T>> clientes;
    /* Contador para identificadores de hilos. */
    private int siguienteId;
    /* Bandera de continuación. */
    private Boolean terminado;
    /* Bitácora. */
    private Bitacora log;

    /**
     * Crea un nuevo servidor usando el archivo recibido para poblar la base de
     * datos.
     * @param puerto el puerto dónde escuchar por conexiones.
     * @param archivo el archivo en el disco del cual cargar/guardar la base de
     *                datos. Puede ser <code>null</code>, en cuyo caso se usará
     *                el nombre por omisión <code>base-de-datos.bd</code>.
     * @throws IOException si ocurre un error de entrada o salida.
     */
    public ServidorBaseDeDatos(int puerto, String archivo)
        throws IOException {
			servidor = new ServerSocket(puerto);
			this.archivo = archivo;
			clientes = new Lista<HiloServidor<T>>();
			terminado = false;
			siguienteId = 0;
			log = Bitacora.getInstancia();
			bdd = creaBaseDeDatos();
        // Aquí va su código.
    }

    /**
     * Carga la base de datos del disco duro.
     */
    public void carga() {
		try{
			log.printf("Cargando base de datos %s.\n", archivo);
			BufferedReader in = 
				new BufferedReader(
					new InputStreamReader(
						new FileInputStream(archivo)));
			bdd.carga(in);
			in.close();
			log.printf("Bse de datos cargada exitosamente de %s.\n", archivo);
		}catch (IOException ioe){
			log.printf("Ocurrió un error al tratar de crgar %s.\n", archivo);
			log.println("La base de datos estara inicialmente vacia.");
		}
        // Aquí va su código.
    }

    /**
     * Guarda la base de datos en el disco duro.
     */
    public void guarda() {
		try {
			log.printf("guardando base de datos de %s\n", archivo);
            FileOutputStream fileOut = new FileOutputStream(archivo);
            OutputStreamWriter osOut = new OutputStreamWriter(fileOut);
            BufferedWriter out = new BufferedWriter(osOut);
            bdd.guarda(out);
            out.close();
        } catch (IOException ioe) {
            System.out.printf("No pude guardar en el archivo %s\n",
                              archivo);
	}
        // Aquí va su código.
    }

    /**
     * Comienza a escuchar por conexiones de clientes.
     */
    public void sirve() {
		log.printf("Escuchando en el puerto: %d.\n", puerto);
		terminado = false;
		while(!terminado){
			try{
				enchufe = servidor.accept();
				HiloServidor<T>hilo;
				hilo = new HiloServidor<T>(this, bdd, enchufe, ++siguienteId);
				hilo.start();
				synchronized (clientes){
					clientes.agregaFinal(hilo);
				}
			}catch (IOException ioe){
				if(!terminado)
				log.println("Error al recibir una conexión..");
			}
        // Aquí va su código.
    }
}

    /**
     * Deja de tomar en cuenta a uno de los clientes.
     * @param hilo el hilo de ejecución que maneja al cliente.
     */
    public void clienteDesconectado(HiloServidor<T> hilo) {
		synchronized(clientes){
			clientes.elimina(hilo);
		}
        // Aquí va su código.
    }

    /**
     * Detiene al servidor.
     */
    public void termina() {
		log.printf("Desconectando clientes...\n");
		for(HiloServidor<T>hilo : clientes)
		hilo.desconecta();
		clientes.limpia();
		log.printf("Deteniendo servidor...\n");
		synchronized (servidor) {terminado = true;}
		try{
		synchronized(servidor){servidor.close();}
	}catch(IOException ioe){
	}
        // Aquí va su código.
    }

    /**
     * Regresa una lista con todos los hilos de servidor.
     * @return una lista con todos los hilos de servidor.
     */
    public Lista<HiloServidor<T>> getHilos() {
		return clientes;
        // Aquí va su código.
    }

    /**
     * Crea la base de datos concreta.
     * @return la base de datos concreta.
     */
    protected abstract BaseDeDatos<T> creaBaseDeDatos();

    /**
     * Regresa una copia de la lista de registros en el servidor,
     * primordialmente para poder realizar pruebas.
     * @return una copia de la lista de registros en el servidor.
     */
    public Lista<T> getRegistros() {
		return bdd.getRegistros();
        // Aquí va su código.
    }

    /**
     * Nos dice si el servidor ha terminado.
     * @return <code>true</code> si el servidor ha terminado, <code>false</code>
     *         en otro caso.
     */
    public boolean isTerminado() {
		return terminado;
        // Aquí va su código.
    }
}
