/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package obligatorio3.lib.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Administrator
 */
public class Capitulo {
  private String nombre;
  private Capitulo siguienteHermano;
  private Capitulo primerHijo;
  private ArrayList<String> claves = new ArrayList<String>();

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Capitulo getPrimerHijo() {
    return primerHijo;
  }

  public void setPrimerHijo(Capitulo primerHijo) {
    this.primerHijo = primerHijo;
  }

  public Capitulo getSiguienteHermano() {
    return siguienteHermano;
  }

  public void setSiguienteHermano(Capitulo siguienteHermano) {
    this.siguienteHermano = siguienteHermano;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public String toString() {
    return this.getNombre();
  }

  boolean agregarPalabraClave(String clave) {
    if (!tieneClave(clave)) {
      this.claves.add(clave);
      return true;
    }
    return false;
  }

  boolean borrarPalabraClave(String clave) {
    if (tieneClave(clave)) {
      String unaClave = obtenerClave(clave);
      this.claves.remove(unaClave);
      return true;
    }
    return false;
  }

  Capitulo getAnteriorHermano(Capitulo capitulos) {
    Capitulo anteriorHermano = null;
    while (capitulos!=null) {
      if (capitulos.equals(this)) {
        return anteriorHermano;
      }
      anteriorHermano = capitulos;
      capitulos = anteriorHermano.getSiguienteHermano();
    }
    return anteriorHermano;
  }

  ArrayList<String> obtenerPalabrasClave() {
    return this.claves;
  }

  String obtenerPalabrasClaveOrdenadas() {
    String retorno = "";
    ArrayList claves = obtenerPalabrasClave();
    while (!estaOrdenada(claves)) {
      for (int i = 1; i < claves.size(); i++) {
        if (esAlfaAnterior(claves, i, i-1)) {
          claves = cambioClave(claves, i, i-1);
        }
      }
    }
    return muestroClaves(claves);
  }

  boolean tieneClave(String clave) {
    if (clave==null) return true;
    for (String palabraClave : claves) {
      if (palabraClave.equalsIgnoreCase(clave)) {
        return true;
      }
    }
    return false;
  }

  private ArrayList cambioClave(ArrayList claves, int i, int i0) {
    assert (claves!=null);
    String temp = claves.get(i0).toString();
    claves.set(i0, claves.get(i));
    claves.set(i, temp);
    return claves;
  }

  private boolean esAlfaAnterior(ArrayList claves, int original, int comparadaA) {
    String clavePrimera = claves.get(original).toString();
    String claveSegunda = claves.get(comparadaA).toString();
    return (clavePrimera.compareToIgnoreCase(claveSegunda)<0);
  }

  private boolean estaOrdenada(ArrayList claves) {
    for (int i = 1; i < claves.size(); i++) {
      if (esAlfaAnterior(claves, i, i-1)) {
        return false;
      }
    }
    return true;
  }

  private String muestroClaves(ArrayList claves) {
    String retorno = "";
    for (int i = 0; i < claves.size(); i++) {
      retorno = retorno + claves.get(i).toString() + '\n';
    }
    return retorno;
  }

  private String obtenerClave(String clave) {
    for (String palabraClave : claves) {
      if (clave.toUpperCase().equals(palabraClave.toUpperCase())) {
        return palabraClave;
      }
    }
    return null;
  }

  

}
