/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package obligatorio3.lib.biblioteca;

/**
 *
 * @author Administrator
 */
public class Capitulo {
  private String nombre;
  private Capitulo siguienteHermano;
  private Capitulo primerHijo;

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

}
