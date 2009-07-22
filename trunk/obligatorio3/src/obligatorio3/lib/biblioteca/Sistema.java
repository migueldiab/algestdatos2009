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

  public Retorno BorrarPalabraClave(Libro l, String nroPadre, String palabraClave) {
    ArrayList<Integer> indice = this.ParseIndice(nroPadre);
    if (indice!=null) {
      Libro unLibro;
      if ((unLibro = this.ObtenerLibro(l))!=null) {
        if (unLibro.borrarPalabraClave(indice, palabraClave)) {
          return Retorno.OK;
        }
        else {
          return Retorno.ERROR;
        }
      }
      return Retorno.ERROR;
    }
    return Retorno.ERROR;
  }

  public Retorno MostrarClavesOrdenadas(Libro l, String nroPadre) {
    Libro unLibro = new Libro();
    ArrayList<Integer> indice = this.ParseIndice(nroPadre);

    if ((unLibro = this.ObtenerLibro(l))!=null) {
      Consola.println(unLibro.toString());
      if (unLibro.getCapitulos()!=null) {
        String claves = unLibro.mostrarIndiceConClavesOrdenadas(indice);
        Consola.println(claves);
        return Retorno.OK;
      }
      else {
        Consola.println("No se ingresaron capítulos");
      }
    }
  return Retorno.ERROR;
        
    }

  public Retorno MostrarIndiceNiveles(Libro l, int inicio, int fin) {
    Libro unLibro = new Libro();
    if ((unLibro = this.ObtenerLibro(l))!=null) {
      Consola.println(unLibro.toString());
      if (unLibro.getCapitulos()!=null) {
        String indice = unLibro.mostrarIndiceNiveles(inicio, fin);
        Consola.println(indice);
        return Retorno.OK;
      }
      else {
        Consola.println("No se ingresaron capítulos");
      }
    }
    return Retorno.ERROR;
  }

  public enum Retorno{OK,ERROR,NO_IMPLEMENTADA};

  public Retorno AgregarPalabraClave(Libro l, String nroPadre, String clave) {
    ArrayList<Integer> indice = this.ParseIndice(nroPadre);
    if (indice!=null) {
      Libro unLibro;
      if ((unLibro = this.ObtenerLibro(l))!=null) {
        if (unLibro.agregarPalabraClave(indice, clave)) {
          return Retorno.OK;
        }
        else {
          return Retorno.ERROR;
        }
      }
      return Retorno.ERROR;
    }
    return Retorno.ERROR;
  }

  public Retorno BorrarCapitulo(Libro l, String nroPadre) {
    ArrayList<Integer> indice = this.ParseIndice(nroPadre);
    if (indice!=null) {
      Libro unLibro;
      if ((unLibro = this.ObtenerLibro(l))!=null) {
        if (unLibro.borrarCapitulo(indice)) {
          return Retorno.OK;
        }
        else {
          return Retorno.ERROR;
        }
      }
      return Retorno.ERROR;
    }
    return Retorno.ERROR;
  }

  public Retorno MostrarCamino(Libro l, String nroPadre) {
    ArrayList<Integer> indice = this.ParseIndice(nroPadre);
    Libro unLibro;
    if (indice!=null) {
      if ((unLibro = this.ObtenerLibro(l))!=null) {
        Consola.println(unLibro.toString());
        if (unLibro.getCapitulos()!=null) {
          String camino = unLibro.mostrarIndiceOrdenado(indice);
          Consola.println(camino);
          return Retorno.OK;
        }
        else {
          Consola.println("No se ingresaron capítulos");
        }
      }
    }
    return Retorno.ERROR;
  }

  public Retorno MostrarCapitulosConClave(Libro l, String string) {
    Libro unLibro;
    if ((unLibro = this.ObtenerLibro(l))!=null) {
      Consola.println(unLibro.toString());
      if (unLibro.getCapitulos()!=null) {
        String indice = unLibro.mostrarIndiceConClaves(string);
        Consola.println(indice);
        return Retorno.OK;
      }
      else {
        Consola.println("No se ingresaron capítulos");
      }
    }
    return Retorno.ERROR;
  }

  public Retorno MostrarIndice(Libro l) {
    Libro unLibro = new Libro();
    if ((unLibro = this.ObtenerLibro(l))!=null) {
      Consola.println(unLibro.toString());
      if (unLibro.getCapitulos()!=null) {
        String indice = unLibro.mostrarIndice();
        Consola.println(indice);
        return Retorno.OK;
      }
      else {
        Consola.println("No se ingresaron capítulos");        
      }
    }
    return Retorno.ERROR;
  }

  public Retorno MostrarIndiceConClaves(Libro l) {
    Libro unLibro = new Libro();
    if ((unLibro = this.ObtenerLibro(l))!=null) {
      Consola.println(unLibro.toString());
      if (unLibro.getCapitulos()!=null) {
        String indice = unLibro.mostrarIndiceConClaves(null);
        Consola.println(indice);
        return Retorno.OK;
      }
      else {
        Consola.println("No se ingresaron capítulos");
      }
    }
    return Retorno.ERROR;
  }

  public Libro CrearLibro(String autor, String titulo) {
    Libro unLibro = new Libro();
    Autor unAutor = this.ObtenerAutorPorNombre(autor);
    if (unAutor==null) {
      if (this.CrearAutor(autor)==Retorno.OK) {
        unAutor = this.ObtenerAutorPorNombre(autor);
      }
    }
    unLibro.setAutor(unAutor);
    unLibro.setTitulo(titulo);
    this.libros.add(unLibro);
    return unLibro;
    
  }
  public Libro VaciarLibro(Libro l) {
    Libro unLibro;
    if ((unLibro = this.ObtenerLibro(l))!=null) {
      unLibro.setCapitulos(null);
    }
    return unLibro;
  }

  public Retorno AgregarCapitulo(Libro l, String nroPadre, String descripcion) {
    ArrayList<Integer> indice = this.ParseIndice(nroPadre);
    if (indice!=null) {
      Libro unLibro;
      if ((unLibro = this.ObtenerLibro(l))!=null) {
        if (unLibro.agregarCapitulo(indice, descripcion)) {
          return Retorno.OK;
        }
        else {
          return Retorno.ERROR;
        }
      }
      return Retorno.ERROR;
    }
    return Retorno.ERROR;
  }

  private Retorno CrearAutor(String autor) {
    Autor unAutor = new Autor();
    unAutor.setNombre(autor);
    this.autores.add(unAutor);
    return Retorno.OK;
  }

  private Autor ObtenerAutorPorNombre(String autor) {
    for (Autor unAutor : autores) {
      if (unAutor.getNombre().equals(autor)) {
        return unAutor;
      }
    }
    return null;
  }

  private Libro ObtenerLibro(Libro l) {
    int i;
    if ((i = libros.indexOf(l))!=-1) {
       return libros.get(i);
    }
    return null;
  }

  private ArrayList<Integer> ParseIndice(String nroPadre) {
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
