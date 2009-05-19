/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package obligatorio_2;

import java.util.ArrayList;
import lib.math.Algebra;
import lib.math.Texto;
import lib.utils.Consola;
import lib.utils.I18n;

/**
 *
 * @author Administrator
 */
public class Inicio {


    public static void main(String[] args) {
      MenuPrincipal();
    }

  public static boolean MenuPrincipal() {
    String opcion = "";
    boolean salir = false;
    do {
      Consola.println("Bienvenido");
      ArrayList items = new ArrayList();
      items.add("MiMax");
      items.add("Anagramas");
      items.add("Cuadrado Latino");
      items.add(I18n.SALIR);
      opcion = (String) items.get(Consola.menu(items, I18n.PRINCIPAL));

      if (opcion.equals("MiMax")) miMax();
      if (opcion.equals("Anagramas")) anagramas();
      if (opcion.equals("Cuadrado Latino")) cuadradoLatino();
      if (opcion.equals(I18n.SALIR)) salir=true;
    } while (!salir);
    return salir;
  }

  private static void miMax() {
    String lista1 = Consola.leer("Ingrese la 1ra lista de números separados por coma \",\" : ");
    String listaVec1[] = lista1.split(",");
    Consola.println("La lista contiene "+listaVec1.length+" elementos");
    Integer desde = Consola.leerInt("Ingrese posición desde : ");
    Integer hasta = Consola.leerInt("Ingrese posición hasta : ");

    if (listaVec1 != null) {
      try {
        int v1[] = new int[listaVec1.length];
        for (int i=0; i<listaVec1.length; i++) {
          v1[i] = Integer.parseInt(listaVec1[i]);
        }
        Consola.println("Posición 0 = Míninmo");
        Consola.println("Posición 1 = Máximo");
        try {
          Consola.println(Algebra.miMax(v1, desde, hasta));
        } catch (AssertionError ae) {
          Consola.println("Error! - "+ae.toString());
        }
        
      } catch (NumberFormatException e) {
        Consola.println("Error! - "+e.toString());
      }

    }
    Consola.pausar();
  }

  private static void anagramas() {
    ArrayList<String> v = new ArrayList<String>();
    String palabra;
    Consola.println("tipee 'salir!' para terminar la busqueda");
    do {
      palabra = Consola.leer("Ingrese una palabra : ");
      long start = System.currentTimeMillis();
      ArrayList<String> anagramas = Texto.anagramas(palabra, v);
      long elapsedTimeMillis = System.currentTimeMillis()-start;
      
      if (anagramas.size()>0) {
        Consola.println("Se encontraron "+anagramas.size()+" anagramas para  "+palabra+"' en "+elapsedTimeMillis+" mili-segundos");
        Consola.println("---------------");
        Consola.listado(anagramas);
        Consola.println("---------------");
      }
      else {
        Consola.println("La palabra no tiene anagramas");
      }
      if (v.indexOf(palabra)==-1) {
        v.add(palabra);
      }
    } while (!palabra.equals("salir!"));
    Consola.pausar();
  }

  private static void cuadradoLatino() {
    int v[] = Consola.leerCSVInt("Ingrese la lista de números separados por coma \",\" : ");
    if (v.length>0) {
      try {
        Consola.print("El minimo de los "+v.length+" es : ");
        Consola.println(Algebra.minimo(v));
      } catch (Exception ex) {
        Consola.println("Error");
      }
      Consola.pausar();
    }
  }

}
