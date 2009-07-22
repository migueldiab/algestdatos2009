/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package obligatorio3.lib.biblioteca;

/**
 *
 * @author Administrator
 */
public class Autor {

  private String nombre;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
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
