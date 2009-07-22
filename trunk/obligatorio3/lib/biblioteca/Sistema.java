/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package obligatorio3.lib.biblioteca;

import java.util.ArrayList;
import java.util.StringTokenizer;
import util.Consola;

/**
 *
 * @author Administrator
 */
public class Sistema {
  private ArrayList<Libro> libros = new ArrayList<Libro>();
  private ArrayList<Autor> autores = new ArrayList<Autor>();

  public void MostrarIndice(Libro l) {
    Libro unLibro;
    if ((unLibro = this.obtenerLibro(l))!=null) {
      Consola.println(unLibro.toString());
      if (unLibro.getCapitulos()!=null) {
        for (Capitulo unC : unLibro.obtenerCapitulos()) {
          Consola.print(unC.getNombre());
        }
      }
      else {
        Consola.println("No se ingresaron capítulos");        
      }
    }
  }

  public Libro crearLibro(String autor, String titulo) {
    Libro unLibro = new Libro();
    Autor unAutor = this.obtenerAutorPorNombre(autor);
    if (unAutor==null) {
      if (this.crearAutor(autor)) {
        unAutor = this.obtenerAutorPorNombre(autor);
      }
    }
    unLibro.setAutor(unAutor);
    unLibro.setTitulo(titulo);
    this.libros.add(unLibro);
    return unLibro;
    
  }
  public boolean vaciarLibro(Libro l) {
    Libro unLibro;
    if ((unLibro = this.obtenerLibro(l))!=null) {
      unLibro.setCapitulos(null);
      return true;
    }
    return false;
  }

  public boolean AgregarCapitulo(Libro l, String nroPadre, String descripcion) {
    ArrayList<Integer> indice = this.parseIndice(nroPadre);
    if (indice!=null) {
      Libro unLibro;
      if ((unLibro = this.obtenerLibro(l))!=null) {
        if (unLibro.agregarCapitulo(indice, descripcion)) {
          return true;
        }
        else {
          return false;
        }
      }
      return false;
    }
    return false;
  }

  private boolean crearAutor(String autor) {
    Autor unAutor = new Autor();
    unAutor.setNombre(autor);
    this.autores.add(unAutor);
    return true;
  }

  private Autor obtenerAutorPorNombre(String autor) {
    for (Autor unAutor : autores) {
      if (unAutor.getNombre().equals(autor)) {
        return unAutor;
      }
    }
    return null;
  }

  private Libro obtenerLibro(Libro l) {
    int i;
    if ((i = libros.indexOf(l))!=-1) {
       return libros.get(i);
    }
    return null;
  }

  private ArrayList<Integer> parseIndice(String nroPadre) {
    ArrayList<Integer> indice = new ArrayList<Integer>();
    for (StringTokenizer stringTokenizer = new StringTokenizer(nroPadre, "."); stringTokenizer.hasMoreTokens();) {
      String token = stringTokenizer.nextToken();
      try {
        indice.add(Integer.parseInt(token));
      } catch (Exception e) {
        return null;
      }
    }
    return indice;
  }
}
