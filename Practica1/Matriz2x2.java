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
		Matriz2x2 m = new Matriz2x2(double a, double b, double c, double d);
		double a = this.a + m.getA();
		return new Matriz2x2 (a + m.a , b, c,d);
		// Matriz2x2 suma = new Matriz2x2( nueva a,2,3,4);
		//return suma;
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
        double a1 = Matriz2x2;
        double b1 = Matriz2x2;
        double c1 = Matriz2x2;
        double d1 = Matriz2x2;
        
        double a2 = Matriz2x2;
        double b2 = Matriz2x2;
        double c2 = Matriz2x2;
        double d2 = Matriz2x2;
        Matriz2x2 m1 = new Matriz2x2(a1, b1, c1, d1);
        Matriz2x2 m2 = new Matriz2x2(a2, b2, c2, d2);
        Matriz2x2 m  = m1.multiplica(m2);
    }

    /**
     * Multiplica la matriz de 2×2 con la constante que recibe como parámetro.
     * @param x La constante con la que hay que multiplicar.
     * @return La multiplicación con la constante <tt>x</tt>.
     */
    public Matriz2x2 multiplica(double x) {
        // Aquí va su código.
      double a=a;
      double b=b;
      double c=c;
      double d=d;
      
      double x=x;
      Matriz2x2 m = new Matriz2x2(a, b, c, d);
      Matriz2x2 mm = m.multiplica(x);
    }

    /**
     * Calcula el determinante de la matriz de 2×2.
     * @return El determinante de la matriz de 2×2.
     */
    public double determinante() {
        // Aquí va su código.
        return a*d c*b;
        double a;
        double b;
        double c;
        double d;

        Matriz2x2 m = new Matriz2x2(a, b, c, d);
        double det = m.determinante();
        
    }

    /**
     * Regresa una cadena con la representación de la matriz.
     * @return una cadena con la representación de la matriz.
     */
    public String toString() {
        // Aquí va su código.
        String s = "( "+a", "+b " )\n", a, b +
        string s = "( "c" , "d" )", c, d ;
    }
}
