package lib.math;

import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Administrator
 */
public class Algebra {

  public static int[][] cuadradoLatino(int lado) throws Exception {
    int[][] cuadradoLatino;
    int retry = 0;
    boolean esValido = false;
    do {
      cuadradoLatino = new int[lado][lado];
      boolean timeout = false;
      for (int i=0;i<lado;i++) {
        for (int j=0;j<lado;j++) {
          long start = System.currentTimeMillis();
          long elapsedTimeMillis = 0;
          do {
            cuadradoLatino = crearCuadradoLatino(cuadradoLatino, i, j);
            esValido = validarCuadradoLatino(cuadradoLatino);
            elapsedTimeMillis = System.currentTimeMillis()-start;
            if (elapsedTimeMillis>2) timeout = true;
          } while (!esValido && !timeout);
        }
      }
      if (timeout && retry>3000) throw new Exception("Timeout");
      retry++;
    } while (!esValido);
    return cuadradoLatino;
  }

  public static int[] miMax(int[] v1, int desde, int hasta) throws AssertionError {
    // MiMax basado en Dividir para Conquistar
    assert (v1.length>desde) : "Desde es mayor que largo de vector";
    assert (v1.length>hasta) : "Hasta es mayor que largo de vector";
    int[] miMax = new int[2];
    if (desde==hasta) {
      miMax[0] = v1[desde];
      miMax[1] = v1[desde];
    }
    else if (desde==(hasta-1)) {
      miMax[0] = (v1[desde]<v1[hasta])?v1[desde]:v1[hasta];
      miMax[1] = (v1[desde]>v1[hasta])?v1[desde]:v1[hasta];
    }
    else {
      int medio = (desde+hasta)/2;
      int[] tempMax1 = miMax(v1, desde,medio);
      int[] tempMax2 = miMax(v1, medio+1, hasta);
      miMax[0] = (tempMax1[0]<tempMax2[0])?tempMax1[0]:tempMax2[0];
      miMax[1] = (tempMax1[1]>tempMax2[1])?tempMax1[1]:tempMax2[1];
    }
    return miMax;
  }
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

  private static int[][] crearCuadradoLatino(int[][] cuadradoLatino, int i, int j) {
    int temp = (new Random()).nextInt(cuadradoLatino[0].length);
    temp++;
    cuadradoLatino[i][j] = temp;
    return cuadradoLatino;
  }

  private static boolean validarCuadradoLatino(int[][] cuadradoLatino) {
    boolean esValido = true;
    for (int i=0;i<cuadradoLatino[0].length;i++) {
      for (int j=0;j<cuadradoLatino[0].length;j++) {        
        for (int x=0;x<cuadradoLatino[0].length;x++) {
          if (cuadradoLatino[i][j]!=0) {
            if (x!=i) {
              if (cuadradoLatino[x][j]==cuadradoLatino[i][j]) {
                esValido = false;
              }
            }
            if (x!=j) {
              if (cuadradoLatino[i][x]==cuadradoLatino[i][j]) {
                esValido = false;
              }
            }
          }
        }
      }
    }
    return esValido;
  }


}
