/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.math;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Texto {

  public static ArrayList<String> anagramas(String palabra, ArrayList<String> v) {
    ArrayList<String> lista = new ArrayList<String>();
    for (String tempPalabra : v) {
      if (esAnagrama(tempPalabra, palabra)) {
        lista.add(tempPalabra);
      }
    }     
    return lista;
  }

  private static boolean esAnagrama(String palabra1, String palabra2) {
    assert(palabra1!=null);
    assert(palabra2!=null);
    if (palabra1.toLowerCase().equals(palabra2.toLowerCase())) return true;
    else {
      if (ordenarPalabra(palabra1.toLowerCase()).equals(ordenarPalabra(palabra2.toLowerCase()))) {
        return true;
      }
      else {
        return false;
      }
    }
  }

  private static String ordenarPalabra(String palabra) {
    char[] palabraOrdenada = palabra.toCharArray();
    java.util.Arrays.sort(palabraOrdenada);
    return new String(palabraOrdenada);
  }

}
