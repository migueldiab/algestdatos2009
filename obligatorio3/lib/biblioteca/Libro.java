/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package obligatorio3.lib.biblioteca;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Libro {
  private String titulo;
  private Autor autor;
  private Capitulo capitulos;

  public Autor getAutor() {
    return autor;
  }

  public void setAutor(Autor autor) {
    this.autor = autor;
  }

  public Capitulo getCapitulos() {
    return capitulos;
  }

  public void setCapitulos(Capitulo capitulos) {
    this.capitulos = capitulos;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  boolean agregarCapitulo(ArrayList<Integer> indice, String descripcion) {
    Capitulo unCapitulo = this.buscoNumeroNivel(this.getCapitulos(), 0, indice);
    if (unCapitulo!=null) {

    }
    return true;

  }

  ArrayList<Capitulo> obtenerCapitulos() {
    throw new UnsupportedOperationException("Not yet implemented");
  }
  
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public String toString() {
    return this.getAutor() + " - " + this.getTitulo();
  }

  private Capitulo buscoNumeroNivel(Capitulo raiz, int nivel, ArrayList<Integer> niveles) {
    Capitulo unCapitulo = new Capitulo();
    if (esVacio(raiz)) {
        return raiz;
    }
    else {
      if (niveles.get(nivel)==1 && niveles.get(nivel+1)==-1) {
          return raiz;
      }
      if (niveles.get(nivel)==1 && niveles.get(nivel+1)!=-1) {
          return buscoNumeroNivel(raiz.getPrimerHijo(), nivel+1,niveles);
      }
      if (niveles.get(nivel)>1) {
          niveles.set(nivel, niveles.get(nivel)-1);
          return buscoNumeroNivel(raiz.getSiguienteHermano(), nivel,niveles);
      }
    }
    return unCapitulo;
  }

  private boolean esVacio(Capitulo raiz) {
    return raiz==null;
  }
}
