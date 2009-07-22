/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package obligatorio3;

import obligatorio3.lib.biblioteca.*;

/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sistema s = new Sistema();
        
        Libro l = s.crearLibro("Horacio Quiroga", "Cuentos");
        s.MostrarIndice(l);

        s.AgregarCapitulo(l, "0", "El solitario");
        s.AgregarCapitulo(l, "0", "La insolacion");
        s.AgregarCapitulo(l, "2", "Parte 1");
        s.AgregarCapitulo(l, "0", "El alambre de pua");
        s.AgregarCapitulo(l, "2", "Parte 2");
        s.AgregarCapitulo(l, "2.2", "Seccion 1");
        s.AgregarCapitulo(l, "2.2", "Seccion 2");
        s.AgregarCapitulo(l, "2", "Parte 3");
        s.AgregarCapitulo(l, "2.3", " Seccion 3");
        s.MostrarIndice(l);

    }

}
