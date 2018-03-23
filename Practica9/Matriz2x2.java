package mx.unam.ciencias.icc;

/**
 * <p>Clase para matrices de 2×2.</p>
 *
 * <p>Las matrices de 2×2 pueden sumarse, multiplicarse y sacar su
 * determinante.</p>
 *
 * <p>Las matrices se crean con cuatro dobles a, b, c y d, tales que representan
 * a la matriz:</p>
 *
<pre>
 ⎛ a  b ⎞
 ⎝ c  d ⎠
</pre>
 */
public class Matriz2x2 {

    /* La primera entrada de la matriz. */
    private double a;
    /* La segunda entrada de la matriz. */
    private double b;
    /* La tercera entrada de la matriz. */
    private double c;
    /* La cuarta entrada de la matriz. */
    private double d;


    /**
     * Constructor único. Dado que no proveemos <em>setters</em>, nuestras
     * matrices de 2×2 son <em>inmutables</em>; no podemos cambiar sus valores.
     * @param a la primera entrada de la matriz.
     * @param b la segunda entrada de la matriz.
     * @param c la tercera entrada de la matriz.
     * @param d la cuarta entrada de la matriz.
     */
    public Matriz2x2(double a, double b,
                     double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        // Aquí va su código.
    }

    /**
     * Regresa el elemento <tt>a</tt> de la matriz de 2×2.
     * @return El elemento <tt>a</tt> de la matriz de 2×2.
     */
    public double getA() {
        return a;
		
        
		
    }

    /**
     * Regresa el elemento <tt>b</tt> de la matriz de 2×2.
     * @return El elemento <tt>b</tt> de la matriz de 2×2.
     */
    public double getB() {
        // Aquí va su código.
        return b;
    }

    /**
     * Regresa el elemento <tt>c</tt> de la matriz de 2×2.
     * @return El elemento <tt>c</tt> de la matriz de 2×2.
     */
    public double getC() {
        // Aquí va su código.
        return c;
    }

    /**
     * Regresa el elemento <tt>d</tt> de la matriz de 2×2.
     * @return El elemento <tt>d</tt> de la matriz de 2×2.
     */
    public double getD() {
        // Aquí va su código.
        return d;
    }

    /**
     * Suma la matriz de 2×2 con la matriz de 2×2 que recibe como parámetro.
     * @param m La matriz de 2×2 con la que hay que sumar.
     * @return La suma con la matriz de 2×2 <tt>m</tt>.
     */
    public Matriz2x2 suma(Matriz2x2 m) {
        // Aquí va su código.
        double a=this.a + m.getA();
        double b=this.b + m.getB();
        double c=this.c + m.getC();
        double d=this.d + m.getD();
		Matriz2x2 suma = new Matriz2x2(a,b,c,d);
		return suma;
		//return new matriz2x2(a + m.a,2,,3,4);
    }

    /**
     * Multiplica la matriz de 2×2 con la matriz de 2×2 que recibe como
     * parámetro.
     * @param m La matriz de 2×2 con la que hay que multiplicar.
     * @return La multiplicación con la matriz de 2×2 <tt>m</tt>.
     */
    public Matriz2x2 multiplica(Matriz2x2 m) {
        // Aquí va su código.

        return new Matriz2x2(a*m.a+b*m.c,a*m.b+b*m.d,c*m.a+d*m.c,c*m.b+d*m.d);
        
    }

    /**
     * Multiplica la matriz de 2×2 con la constante que recibe como parámetro.
     * @param x La constante con la que hay que multiplicar.
     * @return La multiplicación con la constante <tt>x</tt>.
     */
    public Matriz2x2 multiplica(double x) {
        // Aquí va su código.
      return new Matriz2x2(x*a,x*b,x*c,x*d);
}
    /**
     * Calcula el determinante de la matriz de 2×2.
     * @return El determinante de la matriz de 2×2.
     */
    public double determinante() {
        // Aquí va su código.

        return a*d-b*c;
    }

	public Matriz2x2 inversa(){
	Matriz2x2 n = new Matriz2x2(a,b,c,d);
	double det = determinante();
	if(det==0)
		throw new IllegalStateException();
	double j=1/(a*d-b*c);
	return new Matriz2x2(j*d,(-1*b)*j,(-1*c)*j,j*a);
	}
	/**public Matriz2x2 potencia (int n){
	if (n<2)
	return new Matriz2x2 (a,b,c,d);
	Matriz2x2 l = new Matriz2x2(a,b,c,d);
	Matriz2x2 z = new Matriz2x2(a,b,c,d);
	for (int j=2;j<=n;j++){
		l=l.multiplica(z);
		
	}
	return l;
}*/
	
	public Matriz2x2 potencia (int i){
		Matriz2x2 m = new Matriz2x2(a,b,c,d);
			if (i<2)
				return m;
				return potencia (i-1).multiplica(m);
			}
    /**
     * Regresa una cadena con la representación de la matriz.
     * @return una cadena con la representación de la matriz.
     */
	private String agregaEspacios(String s, int n) {
		
        String r = s;
        while (r.length() < n)
            r = " " + r;
        return r;
    } 
   @Override public String toString() {
        // Aquí va su código.
       Matriz2x2 m = new Matriz2x2(a, b, c, d);

        String sa = String.format("%2.3f", a);
        String sb = String.format("%2.3f", b);
        String sc = String.format("%2.3f", c);
        String sd = String.format("%2.3f", d);

        int n = Math.max(Math.max(sa.length(), sb.length()),
                         Math.max(sc.length(), sd.length()));

        sa = agregaEspacios(sa, n);
        sb = agregaEspacios(sb, n);
        sc = agregaEspacios(sc, n);
        sd = agregaEspacios(sd, n);

        String s =
            String.format("⎛ %s, %s ⎞\n", sa, sb) +
            String.format("⎝ %s, %s ⎠",   sc, sd);

	return s;
    
	}
	 /**
     * Nos dice si el objeto recibido es una matrix de 2×2 igual a
     * la que manda llamar al método.
     * @param o el objeto con el que se comparará el que manda llamar el método.
     * @return <tt>true</tt> si el objeto o es una matrix de 2×2 igual a la que
     *         manda llamar al método; <tt>false</tt> en otro caso.
     */
     @Override public boolean equals(Object o) {
        // Aquí va su código.
        if (o instanceof Matriz2x2){
		Matriz2x2 m = (Matriz2x2)o;
        if (a==m.a&&b==m.b&&c==m.c&&d==m.d)
				return true;
		return false;
    } return false;
}
}
