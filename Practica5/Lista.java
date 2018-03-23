package mx.unam.ciencias.icc;

import java.util.NoSuchElementException;

/**
 * <p>Clase para listas doblemente ligadas.</p>
 *
 * <p>Las listas nos permiten agregar elementos al inicio o final de la lista,
 * eliminar elementos de la lista, comprobar si un elemento está o no en la
 * lista, y otras operaciones básicas.</p>
 *
 * <p>Las listas tienen un iterador para poder recorrerlas, y no aceptan a
 * <code>null</code> como elemento.</p>
 */
public class Lista {

    /* Clase Nodo privada para uso interno de la clase Lista. */
    private class Nodo {
        public Object elemento;
        public Nodo anterior;
        public Nodo siguiente;

        public Nodo(Object elemento) {
            // Aquí va su código.
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
        // Aquí va su código.
        return longitud;
    }

    /**
     * Nos dice si la lista es vacía.
     * @return <code>true</code> si la lista es vacía, <code>false</code> en
     *         otro caso.
     */
    public boolean esVacia() {
        // Aquí va su código.
        if(cabeza== null)
	return true;
	else {
	return false;
	}
        
    }

    /**
     * Agrega un elemento al final de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último. Después de llamar este
     * método, el iterador apunta a la cabeza de la lista.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaFinal(Object elemento) {
        // Aquí va su código.
         Nodo nodo = new Nodo(elemento);
         if (elemento == null)//
         throw new IllegalArgumentException();//
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
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaInicio(Object elemento) {
        // Aquí va su código.
        //Nodo nodo = new Nodo(elemento);
        if (elemento == null)//
        throw new IllegalArgumentException();//
        Nodo nodo = new Nodo(elemento);
		if ((rabo==null)&&(cabeza==null)){
	    cabeza = rabo = nodo;
	}
	 else {
	    nodo.siguiente = cabeza;
	    cabeza.anterior = nodo;
	    cabeza = nodo;
	}
		iterador=cabeza;
		longitud++;
    }
	private Nodo buscaNodo(Object elemento, Nodo n) {
				Nodo nodo = n;
				if(nodo==null)
				return null;
				if (nodo.elemento.equals(elemento))
				return nodo;
				return  buscaNodo(elemento,nodo.siguiente);
				
			}
    /**
     * Elimina un elemento de la lista. Si el elemento no está contenido en la
     * lista, el método no la modifica. Si un elemento de la lista es
     * modificado, el iterador se mueve al primer elemento.
     * @param elemento el elemento a eliminar.
     */
    public void elimina(Object elemento) {
        // Aquí va su código.
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
     * @return el primer elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public Object eliminaPrimero() {
        // Aquí va su código.
        if(cabeza==null&&rabo==null)
	throw new NoSuchElementException();//return null;
	if(cabeza.equals(rabo)){
	    longitud--;
	    Object s = cabeza.elemento;
	    cabeza=null;
	    rabo=null;
	    return s;
	}
	Object s = cabeza.elemento;
	cabeza=cabeza.siguiente;
	cabeza.anterior=null;
	longitud--;
	return s;
    }

    /**
     * Elimina el último elemento de la lista y lo regresa.
     * @return el último elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public Object eliminaUltimo() {
        // Aquí va su código.
    if(cabeza==null&&rabo==null)
	throw new NoSuchElementException(); //return null;
	if (cabeza.equals(rabo)){
	    Object s = cabeza.elemento;
	    cabeza=rabo=null;
	    longitud--;
	    return s;
	}
	Object s = rabo.elemento;
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
    public boolean contiene(Object elemento) {
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
    public Lista reversa() {
        // Aquí va su código.
        Lista r= new Lista();
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
    public Lista copia() {
        // Aquí va su código.
        Lista m = new Lista();
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
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public Object getPrimero() {
        // Aquí va su código.
        if(cabeza==null&&rabo==null)
	throw new NoSuchElementException();//return null;
	return cabeza.elemento;
    }

    /**
     * Regresa el último elemento de la lista.
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public Object getUltimo() {
        // Aquí va su código.
        if(rabo==null)
	    throw new NoSuchElementException(); //return null;
	return rabo.elemento;
    }

    /**
     * Regresa el <em>i</em>-ésimo elemento de la lista.
     * @param i el índice del elemento que queremos.
     * @return el <em>i</em>-ésimo elemento de la lista.
     * @throws ExcepcionIndiceInvalido si <em>i</em> es menor que cero o mayor o
     *         igual que el número de elementos en la lista.
     */
    public Object get(int i) {
        // Aquí va su código.
        if(i < 0 || i>=longitud)
        throw new ExcepcionIndiceInvalido();
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
     * @return el índice del elemento recibido en la lista, o -1 si
     *         el elemento no está contenido en la lista.
     */
    public int indiceDe(Object elemento) {
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
    @Override public String toString() {
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
        // Aquí va su código.o;
        iterador = cabeza;
    }

    /**
     * Mueve el iterador de la lista a su último elemento.
     */
    public void ultimo() {
        // Aquí va su código.
        iterador = rabo;
    }

    /**
     * Mueve el iterador al elemento siguiente.
     * @throws NoSuchElementException si no hay elemento siguiente.
     */
    public void siguiente() {
        // Aquí va su código.
        
        if (rabo==null)
        throw new NoSuchElementException();
        iterador = iterador.siguiente;
    }

    /**
     * Mueve el iterador al elemento anterior.
     * @throws NoSuchElementException si no hay elemento anterior.
     */
    public void anterior() {
        // Aquí va su código.
        
        if (cabeza == null)
        throw new NoSuchElementException();
        iterador = iterador.anterior;
    }

    /**
     * Regresa el elemento al que el iterador apunta.
     * @return el elemento al que el iterador apunta.
     * @throws NoSuchElementException si el iterador es inválido.
     */
    public Object get() {
        // Aquí va su código.
        if (!iteradorValido())
        throw new NoSuchElementException();
        return iterador.elemento;
    }

    /**
     * Nos dice si el iterador es válido.
     * @return <tt>true</tt> si el iterador es válido; <tt>false</tt> en otro
     *         caso.
     */
    public boolean iteradorValido() {
        // Aquí va su código.
        return iterador !=null;
    }

    /**
     * Nos dice si la lista es igual al objeto recibido.
     * @param o el objeto con el que hay que comparar.
     * @return <tt>true</tt> si la lista es igual al objeto recibido;
     *         <tt>false</tt> en otro caso.
     */
    @Override public boolean equals(Object o) {
        // Aquí va su código.
        if(!(o instanceof Lista))
			return false;
		Lista a = (Lista)o;
		Nodo c = cabeza;
		Nodo b = a.cabeza;
		
		if(c==null&&b==null){
		return true;
	}
		if(longitud==a.longitud){
			 while (c!=rabo) {
					if(c.elemento.equals(b.elemento)){
				c = c.siguiente;
				b = b.siguiente;
				}else if(!(c.elemento.equals(b.elemento))){
				return false;
			}
				if(c==rabo&&c.elemento.equals(b.elemento))
					return true;
    }
}return false;
	}
}
