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
    if (esCapituloRaiz(indice)) {
        Capitulo unCapitulo = new Capitulo();
        unCapitulo.setNombre(descripcion);
        Capitulo ultimoCapitulo = buscoUltimoCapitulo(getCapitulos());
        if (ultimoCapitulo!=null) {
          ultimoCapitulo.setSiguienteHermano(unCapitulo);
        }
        else {
          setCapitulos(unCapitulo);
        }
        return true;
    }
    else {

        Capitulo ultimoNivel = buscoUltimoNivel(getCapitulos(), 0, indice);        
        Capitulo ultimoCapitulo =  buscoUltimoCapitulo(ultimoNivel.getPrimerHijo());
        Capitulo unCapitulo = new Capitulo();
        unCapitulo.setNombre(descripcion);
        if (ultimoCapitulo!=null) {
          ultimoCapitulo.setSiguienteHermano(unCapitulo);
        }
        else {
            ultimoNivel.setPrimerHijo(unCapitulo);
        }
    }
    return true;
  }

  boolean agregarPalabraClave(ArrayList<Integer> indice, String clave) {
    Capitulo unCapitulo = buscarCapituloPorIndice(indice);
    if (esCapitulo(unCapitulo)) {
      unCapitulo.agregarPalabraClave(clave);
      return true;
    }
    else {
      return false;
    }
  }

  boolean borrarCapitulo(ArrayList<Integer> indice) {
    Capitulo unCapitulo = buscarCapituloPorIndice(indice);
    Capitulo anteriorCapitulo = getAnteriorHermano(indice);
    Capitulo padreCapitulo = getPadre(indice);

    if (esCapitulo(unCapitulo))
    {
      if (esCapitulo(anteriorCapitulo)) {
        if (tieneHermano(unCapitulo)) {
          anteriorCapitulo.setSiguienteHermano(unCapitulo.getSiguienteHermano());
        }
        else {
          anteriorCapitulo.setSiguienteHermano(null);
        }
      }
      else if (esCapitulo(padreCapitulo)) {
        if (tieneHermano(unCapitulo)) {
          padreCapitulo.setPrimerHijo(unCapitulo.getSiguienteHermano());
        }
        else {
          padreCapitulo.setPrimerHijo(null);
        }
      }
      else if (esCapituloRaiz(unCapitulo)) {
        if (tieneHermano(unCapitulo)) {
          setCapitulos(unCapitulo.getSiguienteHermano());
        }
        else {
          setCapitulos(null);
        }
      }
      return true;
    }
    else {
      return false;
    }
    
    
  }

  boolean borrarPalabraClave(ArrayList<Integer> indice, String palabraClave) {
    Capitulo unCapitulo = buscarCapituloPorIndice(indice);
    if (esCapitulo(unCapitulo)) {
      if (unCapitulo.borrarPalabraClave(palabraClave)) {
        return true;
      }
      else {
        return false;
      }
    }
    else {
      return false;
    }
  }

  String mostrarCamino(ArrayList<Integer> indice) {
    Capitulo unCapitulo = buscarCapituloPorIndice(indice);
    String camino = "";
    if (esCapitulo(unCapitulo)) {
      for (int niveles=indice.size()-1; niveles>=0; niveles--) {
        unCapitulo = buscarCapituloPorIndice(indice);
        String linea = getNumeroCapituloPorIndice(indice);
        linea = linea + " - " + unCapitulo;
        camino = camino + linea + '\n';
        indice.remove(niveles);
      }
    }
    else {
      camino = "Capitulo inexistente";
    }
    return camino;
  }

  String mostrarIndiceOrdenado(ArrayList<Integer> indice) {
    Capitulo unCapitulo = buscarCapituloPorIndice(indice);
    String camino = "";
    if (esCapitulo(unCapitulo)) {
      for (int niveles=indice.size()-1; niveles>=0; niveles--) {
        unCapitulo = buscarCapituloPorIndice(indice);
        String linea = getNumeroCapituloPorIndice(indice);
        linea = linea + " - " + unCapitulo;
        camino = camino + linea + '\n';
        indice.remove(niveles);
      }
    }
    else {
      camino = "Capitulo inexistente";
    }
    return camino;
  }

  String mostrarIndice() {
    ArrayList<Integer> nivelIndice = new ArrayList<Integer>();
    nivelIndice.add(1);
    Capitulo unCapitulo = getCapitulos();
    if (unCapitulo!=null) {
      return mostrarCapitulos(unCapitulo, nivelIndice, 0);
    }
    return null;
  }



  String mostrarIndiceConClaves(String clave) {
    ArrayList<Integer> nivelIndice = new ArrayList<Integer>();
    nivelIndice.add(1);
    Capitulo unCapitulo = getCapitulos();
    if (unCapitulo!=null) {
      return mostrarCapitulosConClaves(unCapitulo, nivelIndice, 0, clave);
    }
    return null;
  }

  String mostrarIndiceConClavesOrdenadas(ArrayList<Integer> indice) {
    Capitulo unCapitulo = buscarCapituloPorIndice(indice);
    String claves = "";
    if (esCapitulo(unCapitulo)) {
      String linea = getNumeroCapituloPorIndice(indice);
      linea = linea + " - " + unCapitulo;
      claves = unCapitulo.obtenerPalabrasClaveOrdenadas();
      claves = linea + '\n' + claves;
    }
    else {
      claves = "Capitulo inexistente";
    }
    return claves;
  }

  String mostrarIndiceNiveles(int inicio, int fin) {
    ArrayList<Integer> nivelIndice = new ArrayList<Integer>();
    nivelIndice.add(1);
    Capitulo unCapitulo = getCapitulos();
    if (unCapitulo!=null) {
      return mostrarCapitulosPorNivel(unCapitulo, nivelIndice, 0, inicio, fin);
    }
    return null;
  }

  ArrayList<Capitulo> obtenerCapitulos() {
    ArrayList<Capitulo> listaCapitulos = new ArrayList<Capitulo>();
    listaCapitulos.add(this.getCapitulos());
    return listaCapitulos;
  }
  
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public String toString() {
    return this.getAutor() + " - " + this.getTitulo();
  }

  private ArrayList<Integer> bajoNivelIndice(ArrayList<Integer> nivelIndice, int nivel) {
    if (nivelIndice.size()>nivel+1) {
      nivelIndice.remove(nivel+1);
    }
    nivelIndice.set(nivel, nivelIndice.get(nivel)+1);
    return nivelIndice;
  }

  private Capitulo buscarCapituloPorIndice(ArrayList<Integer> indice) {
    Capitulo unCapitulo = null;

    for (Integer idx : indice) {
      if (unCapitulo==null) {
        unCapitulo = getCapitulos();
      }
      else {
        unCapitulo = unCapitulo.getPrimerHijo();
      }
      if (unCapitulo==null) return null;
      for (int i=1; i<idx;i++) {
        unCapitulo = unCapitulo.getSiguienteHermano();
        if (unCapitulo==null) return null;
      }
    }
    return unCapitulo;
  }

  private Capitulo buscoUltimoNivel(Capitulo raiz, int nivel, ArrayList<Integer> niveles) {
    Capitulo unCapitulo = new Capitulo();
    if (esVacio(raiz)) {
        return null;
    }
    else {
      if (niveles.get(nivel)==1 && niveles.size()==nivel+1) {
          return raiz;
      }
      else if (niveles.get(nivel)==1 && niveles.size()>nivel+1) {
          return buscoUltimoNivel(raiz.getPrimerHijo(), nivel+1,niveles);
      }
      else if (niveles.get(nivel)>1) {
          niveles.set(nivel, niveles.get(nivel)-1);
          return buscoUltimoNivel(raiz.getSiguienteHermano(), nivel,niveles);
      }
    }
    return unCapitulo;
  }

  private Capitulo buscoUltimoCapitulo(Capitulo unCapitulo) {
    if (unCapitulo==null) {
      return null;
    }
    while (unCapitulo.getSiguienteHermano()!=null) {
      unCapitulo = unCapitulo.getSiguienteHermano();
    }
    return unCapitulo;
  }

  private boolean esCapitulo(Capitulo unCapitulo) {
    return unCapitulo!=null;
  }

  private boolean esCapituloRaiz(ArrayList<Integer> indice) {
    return indice.get(0)==0;
  }
  private boolean esCapituloRaiz(Capitulo unCapitulo) {
    if (esCapitulo(unCapitulo))
      return unCapitulo.equals(getCapitulos());
    else
      return false;
  }

  private boolean esVacio(Capitulo raiz) {
    return raiz==null;
  }

  private Capitulo getAnteriorHermano(ArrayList<Integer> indice) {
    if (indice.get(indice.size()-1)>1) {
      indice.set(indice.size()-1, indice.get(indice.size()-1)-1);
      return buscarCapituloPorIndice(indice);
    }
    else {
      return null;
    }
  }

  private String getNumeroCapituloPorIndice(ArrayList<Integer> indice) {
    String linea = "";
    for (Integer tmpNivel : indice) {
      linea = linea + tmpNivel + ".";
    }
    return linea;
  }

  private Capitulo getPadre(ArrayList<Integer> indice) {
    if (indice.size()>1) {
      indice.remove(indice.size()-1);
      return buscarCapituloPorIndice(indice);
    }
    else {
      return null;
    }
  }

  private String mostrarCapitulos(Capitulo unCapitulo, ArrayList<Integer> nivelIndice, int nivel) {
    String textoRetorno = "";
    while (unCapitulo!=null) {
      String linea = getNumeroCapituloPorIndice(nivelIndice);
      linea = linea + " - " + unCapitulo.getNombre() + '\n';
      if (unCapitulo.getPrimerHijo()!=null) {
        nivelIndice.add(1);
        linea = linea + mostrarCapitulos(unCapitulo.getPrimerHijo(), nivelIndice, nivel+1);
      }
      unCapitulo = unCapitulo.getSiguienteHermano();
      nivelIndice = bajoNivelIndice(nivelIndice, nivel);
      textoRetorno = textoRetorno + linea;
    }
    return textoRetorno;
  }

  private String mostrarCapitulosConClaves(Capitulo unCapitulo, ArrayList<Integer> nivelIndice, int nivel, String palabraClave) {
    String textoRetorno = "";
    while (unCapitulo!=null) {
      String linea = "";
      if (unCapitulo.tieneClave(palabraClave)) {
        for (Integer tmpNivel : nivelIndice) {
          linea = linea + tmpNivel + ".";
        }
        linea = linea + " - " + unCapitulo.getNombre() + ": ";
        if (palabraClave==null) {
          for (String clave : unCapitulo.obtenerPalabrasClave()) {
            linea = linea + clave + " ";
          }
          for (int i = 1; i < nivelIndice.size(); i++) {
            linea = "\t" + linea;              
          }
        }
        linea = linea + '\n';
      }
      if (unCapitulo.getPrimerHijo()!=null) {
        nivelIndice.add(1);
        linea = linea + mostrarCapitulosConClaves(unCapitulo.getPrimerHijo(), nivelIndice, nivel+1, palabraClave);
      }
      unCapitulo = unCapitulo.getSiguienteHermano();
      nivelIndice = bajoNivelIndice(nivelIndice, nivel);
      textoRetorno = textoRetorno + linea;
    }
    return textoRetorno;
  }

  private String mostrarCapitulosPorNivel(Capitulo unCapitulo, ArrayList<Integer> nivelIndice, int nivel, int inicio, int fin) {
    assert (inicio>0);
    assert(esCapitulo(unCapitulo)==true);
    String textoRetorno = "";
    while (unCapitulo!=null) {
      String linea = "";
      if (nivelIndice.size()>=inicio && nivelIndice.size()<=fin) {
        linea = getNumeroCapituloPorIndice(nivelIndice);
        linea = linea + " - " + unCapitulo.getNombre() + '\n';
      }
      if (nivelIndice.size()<fin && unCapitulo.getPrimerHijo()!=null) {
        nivelIndice.add(1);
        linea = linea + mostrarCapitulosPorNivel(unCapitulo.getPrimerHijo(), nivelIndice, nivel+1, inicio, fin);
      }
      unCapitulo = unCapitulo.getSiguienteHermano();
      nivelIndice = bajoNivelIndice(nivelIndice, nivel);
      textoRetorno = textoRetorno + linea;
    }
    return textoRetorno;
  }

  private boolean tieneHermano(Capitulo unCapitulo) {
    assert(esCapitulo(unCapitulo)==true);
    return unCapitulo.getSiguienteHermano()!=null;
  }
}
