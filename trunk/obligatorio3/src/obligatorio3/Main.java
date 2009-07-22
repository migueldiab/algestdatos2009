/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package obligatorio3;

import obligatorio3.lib.biblioteca.*;
import util.Consola;

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
        
        Libro l = s .CrearLibro("Horacio Quiroga", "Cuentos");
        Consola.println("*** Muestro indice de libro recién creado");
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
        Consola.println("*** Muestro indice de libro");
        s.MostrarIndice(l);

        s.BorrarCapitulo(l, "2.2.1");
	Consola.println("*** Muestro indice borrando capitulo 2.2.1");
        s.MostrarIndice(l);

        s.AgregarCapitulo(l, "2.2", "Nueva Seccion");
        s.AgregarCapitulo(l, "3", "Parte A");
        s.AgregarCapitulo(l, "3", "Parte B");

	Consola.println("*** Muestro indice de Nivel 2 a 2");
        s.MostrarIndiceNiveles(l, 2, 2);

	Consola.println("*** Muestro indice de Nivel 2 a 5");
        s.MostrarIndiceNiveles(l, 2, 5);

	Consola.println("*** Muestro indice de Nivel 1 a 1");
        s.MostrarIndiceNiveles(l, 1, 1);

        s.AgregarPalabraClave(l, "2", "Excelnte");
        s.AgregarPalabraClave(l, "2", "Misterio");
	s.AgregarPalabraClave(l, "1", "camino");
        s.AgregarPalabraClave(l, "2.1", "playa");
        s.AgregarPalabraClave(l, "2.2.2", "CABALLO");
        s.AgregarPalabraClave(l, "3", "pincha");
        s.AgregarPalabraClave(l, "3", "corre");
        s.AgregarPalabraClave(l, "3", "carpeta");
        s.AgregarPalabraClave(l, "3", "arroz");
        s.AgregarPalabraClave(l, "3", "llama");
        s.AgregarPalabraClave(l, "3", "llanto");
        s.AgregarPalabraClave(l, "3", "llamadas");
        s.AgregarPalabraClave(l, "2.2.2", "cabalgata");
        s.AgregarPalabraClave(l, "2.2.2", "fuente");
        s.AgregarPalabraClave(l, "2.2.2", "perro");
        s.AgregarPalabraClave(l, "2.2.2", "gato");
        s.AgregarPalabraClave(l, "2.2.2", "vida");
        s.AgregarPalabraClave(l, "2.2.2", "historia");
        s.AgregarPalabraClave(l, "3", "dolor");
        s.AgregarPalabraClave(l, "3", "caballo");
        s.AgregarPalabraClave(l, "2.2.2", "caBaLLo");

        Consola.println("*** Indice con claves agregadas");
        s.MostrarIndiceConClaves(l);

        Consola.println("*** Busco Capitulos con clave 'caballo'");
        s.MostrarCapitulosConClave(l, "caballo");

        s.BorrarPalabraClave(l, "2.2.2", "Caballo");
        Consola.println("*** Indice con claves borradas");
        s.MostrarIndiceConClaves(l);

        Consola.println("*** Busco Capitulos con clave 'blah'");
        s.MostrarCapitulosConClave(l, "blah");

        Consola.println("*** Muestro camino desde 2.2.1");
        s.MostrarCamino(l, "2.2.1");

        Consola.println("*** Muestro camino desde 3.2.3 (inexistente)");
        s.MostrarCamino(l, "3.2.3");

        Consola.println("*** Muestro claves ordenadas para 2.2.2");
        s.MostrarClavesOrdenadas(l, "2.2.2");

        Consola.println("*** Muestro claves ordenadas para 3");
        s.MostrarClavesOrdenadas(l, "3");

    }

}
