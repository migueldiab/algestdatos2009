/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package obligatorio_1;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import obligatorio_1.lib.math.Algebra;
import obligatorio_1.lib.utils.Consola;
import obligatorio_1.lib.utils.I18n;

/**
 *
 * @author alumno
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
      items.add("Minimo de 5 números");
      items.add("Posición del Menor");
      items.add("Minimo");
      items.add("Ordenar Ascendente");
      items.add("Apareo Ordenado");
      items.add(I18n.SALIR);
      opcion = (String) items.get(Consola.menu(items, I18n.PRINCIPAL));
      
      if (opcion.equals("Minimo de 5 números")) minimoDe5();
      if (opcion.equals("Posición del Menor")) posDelMenor();
      if (opcion.equals("Minimo")) minimo();
      if (opcion.equals(I18n.SALIR)) salir=true;
    } while (!salir);
    return salir;
  }

  private static void minimoDe5() {
    int v[] = new int[5];
    for (int i=0; i<5; i++) {
      v[i] = Consola.leerInt("Ingrese el número en la posición "+i+" : ");
    }
    Consola.print("El menor de los 5 es el : ");
    try {
      Consola.println(Algebra.menorDe5(v));
    } catch (Exception ex) {
      
    }
    Consola.pausar();
  }

  private static void minimo() {
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

  private static void posDelMenor() {
    String lista = Consola.leer("Ingrese la lista de números separados por coma \",\" : ");
    String listaVec[] = lista.split(",");

    if (listaVec != null) {
      try {
        int v[] = new int[listaVec.length];
        for (int i=0; i<listaVec.length; i++) {
          v[i] = Integer.parseInt(listaVec[i]);
        }
        Consola.print("El menor de los "+v.length+" es el : ");
        try {
          Consola.println(Algebra.minimo(v));
        } catch (Exception ex) {
          
        }
      } catch (NumberFormatException e) {
        Consola.println("Error! - NumberFormatException");
        Consola.println(e.toString());
      }
    }
    Consola.pausar();
  }
}
