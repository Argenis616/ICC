package mx.unam.ciencias.icc;

/**
 * Clase para ordenar y buscar en arreglos genéricos.
 */
public class Arreglos {
	public static<T extends Comparable<T>>
	void intercambia(T[] a, int i, int h){
		T t=a[h];
		a[h]=a[i];
		a[i]=t;
	}

    /**
     * Ordena el arreglo recibido usando SelectionSort.
     * @param <T> el tipo del arreglo.
     * @param a un arreglo cuyos elementos son comparables.
     */
    public static <T extends Comparable<T>>
    void selectionSort(T[] a) {
		int l=a.length;
		int r;
		int s;
		for (int i=0; i<l-1; i++){
			int min=i;
			for(int j=i+1; j<l; j++){
				if(a[j].compareTo(a[min])<0)
				min = j;
			}
			intercambia(a,i,min);
		}
		// Aquí va su código.
    }

    /**
     * Ordena el arreglo recibido usando QickSort.
     * @param <T> el tipo del arreglo.
     * @param a un arreglo cuyos elementos son comparables.
     */
     public static <T extends Comparable<T>>
    void quickSort(T[]a) {
		quick(a, 0, (a.length-1));
	}
    public static <T extends Comparable<T>>
    void quick(T[] a, int ini, int fin) {
		if((fin-ini)<1)
		return;
		int i =ini+1, j=fin;
		while (i<j)
		if (a[i].compareTo(a[ini])>0 && a[j].compareTo(a[ini])<=0)
		intercambia(a,i++,j--);
		else if (a[i].compareTo(a[ini])<=0)
		i++;
		else j--;
		if (a[i].compareTo(a[ini])>0)
		i--;
		intercambia(a,i,ini);
		quick(a, ini, i-1);
		quick(a, i+1, fin);
        // Aquí va su código.
    }

    /**
     * Hace una búsqueda binaria del elemento en el arreglo. Regresa
     * el índice del elemento en el arreglo, o -1 si no se
     * encuentra.
     * @param <T> el tipo del arreglo.
     * @param a el arreglo dónde buscar.
     * @param e el elemento a buscar.
     * @return el índice del elemento en el arreglo, o -1 si no se
     * encuentra.
     */
    public static <T extends Comparable<T>>
    int busquedaBinaria(T[] a, T e) {
		int i=0,g=a.length-1;
		int lugar;
		while (i<=g){
			lugar=(i+g)/2;
			if((a[lugar].compareTo(e)==0))
			return lugar;
			if(a[lugar].compareTo(e)<0)
			i=lugar+1;
			if(a[lugar].compareTo(e)>0)
			g=lugar-1;
		}
		return-1;
		
        // Aquí va su código.
    }
}
