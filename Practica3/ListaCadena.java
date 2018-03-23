package mx.unam.ciencias.icc;

/**
 * <p>Clase para listas doblemente ligadas de cadenas.</p>
 *
 * <p>Las listas nos permiten agregar elementos al inicio o final de la lista,
 * eliminar elementos de la lista, comprobar si un elemento está o no en la
 * lista, y otras operaciones básicas.</p>
 *
 * <p>Las listas tienen un iterador para poder recorrerlas.</p>
 */
public class ListaCadena {

    /* Clase Nodo privada para uso interno de la clase ListaCadena. */
    private class Nodo {
        public String elemento;
        public Nodo anterior;
        public Nodo siguiente;

        public Nodo(String elemento) {
            this.elemento = elemento;
        }
    }

    /* Primer elemento de la lista. */
    private Nodo cabeza;
    /* Último elemento de la lista. */
    private Nodo rabo;
    /* Nodo iterador. */
    private Nodo iterador;
    /* Número de elementos en la lista. */
    private int longitud;

    /**
     * Regresa la longitud de la lista.
     * @return la longitud de la lista, el número de elementos que contiene.
     */
    public int getLongitud() {
        // Aquí va su código
	return longitud;
    }

    /**
     * Nos dice si la lista es vacía.
     * @return <code>true</code> si la lista es vacía, <code>false</code> en
     *         otro caso.
     */
    public boolean esVacia() {
        // Aquí va su código.
	return (cabeza==null)&&(rabo==null);
    }

    /**
     * Agrega un elemento al final de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último. Después de llamar este
     * método, el iterador apunta a la cabeza de la lista.
     * @param elemento el elemento a agregar.
     */
    public void agregaFinal(String elemento) {
        // Aquí va su código.
	Nodo nodo = new Nodo(elemento);
	if (rabo==null&&cabeza==null){
	    cabeza = rabo = nodo;
	} else {
	    nodo.anterior = rabo;
	    rabo.siguiente = nodo;
	    rabo = nodo;
	}
		iterador=cabeza;
		longitud++;
	    
    }

    /**
     * Agrega un elemento al inicio de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último. Después de llamar este
     * método, el iterador apunta a la cabeza de la lista.
     * @param elemento el elemento a agregar.
     */
    public void agregaInicio(String elemento) {
        // Aquí va su código.
		Nodo nodo = new Nodo(elemento);
		if ((rabo==null)&&(cabeza==null)){
	    cabeza = rabo = nodo;
	} else {
	    nodo.siguiente = cabeza;
	    cabeza.anterior = nodo;
	    cabeza = nodo;
	}
		iterador=cabeza;
		longitud++;
	    
    }

    /**
     * Elimina un elemento de la lista. Si el elemento no está contenido en la
     * lista, el método no la modifica. Si un elemento de la lista es
     * modificado, el iterador se mueve al primer elemento.
     * @param elemento el elemento a eliminar.
     * 
     */
     
         private Nodo buscaNodo(String s, Nodo n) {
				Nodo nodo = n;
				if(nodo==null)
				return null;
				if (nodo.elemento.equals(s))
				return nodo;
				return  buscaNodo(s,nodo.siguiente);
				
			}
    public void elimina(String elemento) {
	if(cabeza==null&&rabo==null){
	    return;
	}
	
	Nodo n = buscaNodo(elemento, cabeza);
	if(cabeza.equals(rabo)&&n.elemento.equals(elemento)){
	cabeza = rabo = null;
	longitud--;
	iterador=cabeza;
	} else if (n.equals(cabeza)&&(!n.equals(rabo))){
	    cabeza=cabeza.siguiente;
	    cabeza.anterior=null;
	    longitud--;
	    iterador=cabeza;
	}
	else if (n.equals(rabo)&&(!n.equals(cabeza))){
	    rabo=rabo.anterior;
	    rabo.siguiente=null;
	    longitud--;
	    iterador=cabeza;
	}
	else {
	    n.siguiente.anterior=n.anterior;
	    n.anterior.siguiente=n.siguiente;
	iterador=cabeza;
	    longitud--;	
	}
	
}
    

    /**
     * Elimina el primer elemento de la lista y lo regresa.
     * @return el primer elemento de la lista antes de eliminarlo, o
     *         <code>null</code> si la lista está vacía.
     */
   
		
    public String eliminaPrimero() {
        // Aquí va su código.
	if(cabeza==null&&rabo==null)
	return null;
	if(cabeza.equals(rabo)){
	    longitud--;
	    String s = cabeza.elemento;
	    cabeza=null;
	    rabo=null;
	    return s;
	}
	String s = cabeza.elemento;
	cabeza=cabeza.siguiente;
	cabeza.anterior=null;
	longitud--;
	return s;
    }


    /**
     * Elimina el último elemento de la lista y lo regresa.
     * @return el último elemento de la lista antes de eliminarlo, o
     *         <code>null</code> si la lista está vacía.
     */
    public String eliminaUltimo() {
        // Aquí va su código.
	if(cabeza==null&&rabo==null)
	return null;
	if (cabeza.equals(rabo)){
	    String s = cabeza.elemento;
	    cabeza=rabo=null;
	    longitud--;
	    return s;
	}
	String s = rabo.elemento;
	rabo=rabo.anterior;
	rabo.siguiente=null;
	longitud--;
	return s;
    }

    /**
     * Nos dice si un elemento está en la lista. El iterador no se mueve.
     * @param elemento el elemento que queremos saber si está en la lista.
     * @return <tt>true</tt> si <tt>elemento</tt> está en la lista,
     *         <tt>false</tt> en otro caso.
     */
    public boolean contiene(String elemento) {
        // Aquí va su código.
	Nodo n= buscaNodo(elemento,cabeza);
	if (n==null)
		return false;
	
	 return true;
	}
 
    /**
     * Regresa la reversa de la lista.
     * @return una nueva lista que es la reversa la que manda llamar el método.
     */
    public ListaCadena reversa() {
        // Aquí va su código.
	ListaCadena r= new ListaCadena();
	Nodo t = cabeza;
	while(t!=null){
	    r.agregaInicio(t.elemento);
		t=t.siguiente;
	}
	return r;
    }

    /**
     * Regresa una copia de la lista. La copia tiene los mismos elementos que la
     * lista que manda llamar el método, en el mismo orden.
     * @return una copiad de la lista.
     */
    public ListaCadena copia() {
        // Aquí va su código.
       
	
	ListaCadena m = new ListaCadena();
	Nodo f=cabeza;
	while(f!=null){
		m.agregaFinal(f.elemento);
	    f=f.siguiente;
	}
	return m;
}

    /**
     * Limpia la lista de elementos. El llamar este método es equivalente a
     * eliminar todos los elementos de la lista.
     */
    public void limpia() {
        // Aquí va su código.
	cabeza=null;
	    rabo=null;
	    longitud=0;
    }

    /**
     * Regresa el primer elemento de la lista.
     * @return el primer elemento de la lista, o <code>null</code> si la lista
     *         es vacía.
     */
    public String getPrimero() {
        // Aquí va su código.
	if(cabeza==null&&rabo==null)
	return null;
	return cabeza.elemento;
    }

    /**
     * Regresa el último elemento de la lista.
     * @return el primer elemento de la lista, o <code>null</code> si la lista
     *         es vacía.
     */
    public String getUltimo() {
        // Aquí va su código.
	if(rabo==null)
	    return null;
	return rabo.elemento;
    }

    /**
     * Regresa el <em>i</em>-ésimo elemento de la lista. Si el índice es menor
     * que cero o mayor o igual que el número de elementos de la lista, el
     * método regresa <tt>null</tt>.
     * @param i el índice del elemento que queremos.
     * @return el <em>i</em>-ésimo elemento de la lista, si <em>i</em> es mayor
     *         o igual que cero y menor que el número de elementos en la lista;
     *         <tt>null</tt> en otro caso.
     */
    public String get(int i) {
        // Aquí va su código.
	if(cabeza==null)
	    return null;
	
	int j=0;
	Nodo n=cabeza;
	while(n!=null){
	    if(j==i)
		return n.elemento;
	    n=n.siguiente;
	    j++;
	}
	return null;
    }

    /**
     * Regresa el índice del elemento recibido en la lista.
     * @param elemento el elemento del que se busca el índice.
     * @return el índice del elemento recibido en la lista, o -1 si el elemento
     *         no está contenido en la lista.
     */
    public int indiceDe(String elemento) {
        // Aquí va su código.
	Nodo n =cabeza;
	int i=0;
	while(n!=null){
	    if(elemento.equals(n.elemento))
		return i;
	    n=n.siguiente;
	    i++;
	}
	return -1;
    }

    /**
     * Regresa una representación en cadena de la lista.
     * @return una representación en cadena de la lista.
     */
    public String toString() {
        // Aquí va su código.
        String s = "[";
		Nodo n = cabeza;
		if(n==null)
				return s+"]";
        for (int i = 0; i < longitud-1; i++){
            s += String.format("%s, ",n.elemento );
	    n=n.siguiente;
	    }
        s += String.format("%s]", n.elemento);
        return s;
    }

    /**
     * Mueve el iterador de la lista a su primer elemento.
     */
    public void primero() {
        // Aquí va su código.
	iterador=cabeza;
    }

    /**
     * Mueve el iterador de la lista a su último elemento.
     */
    public void ultimo() {
        // Aquí va su código.
	iterador=rabo;
    }

    /**
     * Mueve el iterador al siguiente elemento.
     */
    public void siguiente() {
        // Aquí va su código.
	iterador=iterador.siguiente;
    }

    /**
     * Mueve el iterador al elemento anterior.
     */
    public void anterior() {
        // Aquí va su código.
	iterador= iterador.anterior;
       
    }

    /**
     * Regresa el elemento al que el iterador apunta.
     * @return el elemento al que el iterador apunta, o <tt>null</tt> si el
     *         iterador es inválido.
     */
    public String get() {
        // Aquí va su código.
	return iterador.elemento;
    }

    /**
     * Nos dice si el iterador es válido.
     * @return <tt>true</tt> si el iterador es válido; <tt>false</tt> en otro
     *         caso.
     */
    public boolean iteradorValido() {
        // Aquí va su código.
	return iterador != null;
    }
}
