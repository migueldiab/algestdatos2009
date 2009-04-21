/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package obligatorio_1.lib.math;

/**
 *
 * @author Administrator
 */
public class Algebra {

  public static int[] apareo(int[] v1, int[] v2) {
    int v[] = new int[v1.length+v2.length];
    for (int i=0; i<v1.length; i++) {
      v[i] = v1[i];
    }
    for (int i=0; i<v2.length; i++) {
      v[i+v1.length] = v2[i];
    }
   return v;
  }
  public static int minimo(int v[]) throws Exception {
    // pre - v no debe ser vacio
    if (v.length<1) throw new Exception("minimo incalculable");
    
    return v[posDelMinimo(v)];
  }

  public static int posDelMinimo(int[] v) {
    // pre - v no debe ser vacio
    assert(v.length>0);
    
    int posMenor = 0;
    for (int i=0; i<v.length; i++) {
      if (v[i]<v[posMenor]) {
        posMenor = i;
      }
    }
    return posMenor;
  }

  public static int menorDe5(int v[]) throws Exception {
    // pre - v debe tener solo 5 elementos
    if (v.length!=5) throw new Exception("no existen 5 elementos");
    return minimo(v);
  }

  public static boolean estaOrdenado(int[] v, int desde, int hasta) {
      for (int i=desde+1;i<hasta;i++) {
        if (v[i-1] > v[i]) {
          return false;
        }
      }
      return true;
  }

  public static boolean estanIntercambiados(int i, int ii, int j, int jj) {
      return (i==jj && j==ii);
  }

  public static int[] intercambio(int[] v, int i, int j) {
    // pre
    int ii=v[i];
    int jj=v[j];
    int aux = v[i];
    v[i]=v[j];
    v[j]=aux;
    assert(estanIntercambiados(v[i],ii,v[j],jj));
    return v;
  }

  public static void muestro(int[] v, int desde, int hasta) {
    for (int i=desde;i<=hasta;i++) {
        System.out.println(v[i]);
    }
  }

  public static int[] ordenarAsc(int[] v) {
    return ordeno(v, 0, v.length-1);
  }
  public static int[] ordeno(int[] v, int desde, int hasta) {
    assert(desde<=hasta);
    // pre desde y hasta pertenecen al rango de v

    for(int ultimo=hasta; ultimo>=desde; ultimo--) {
        v = intercambio(v, ultimo, posicionDelMayor(v,desde,ultimo));

    }

    assert(estaOrdenado(v,desde,hasta));
    //pos contiene los mismos datos

    return v;
  }

  public static int posicionDelMayor(int[] v, int desde, int hasta) {
    assert(desde<=hasta);
    // pre desde y hasta pertenecen al rango de v

    int pos=desde;
    for (int i=desde+1;i<=hasta;i++) {
        if (v[i]>v[pos]) pos=i;
    }
    return pos;

    // pos retorna la posición del mayor entre desde y hasta
  }

}
