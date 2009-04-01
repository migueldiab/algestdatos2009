/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clase_01;

/**
 *
 * @author alumno
 */
public class inicio_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer v[] = {2,6,45,32,3,76,4,32,17,94};
        int desde = 0;
        int hasta = 9;
        ordeno(v, 2, 7);
        muestro(v, desde, hasta);
    }

    private static boolean estaOrdenado(Integer[] v, int desde, int hasta) {
        return true;
    }

    private static boolean estanIntercambiados(int i, int ii, int j, int jj) {
        return (i==jj && j==ii);
    }

    private static void intercambio(Integer i, Integer j) {
        // pre
        Integer ii=i;
        Integer jj=j;
        Integer aux = i;
        i=j;
        j=aux;
        assert(estanIntercambiados(i,ii,j,jj));

    }

    private static void muestro(Integer[] v, int desde, int hasta) {
        for (int i=desde;i<=hasta;i++) {
            System.out.println(v[i]);
        }
    }

    private static void ordeno(Integer[] v, int desde, int hasta) {
        assert(desde<=hasta);
        // pre desde y hasta pertenecen al rango de v

        for(int ultimo=hasta; ultimo>desde; ultimo--) {
            intercambio(v[ultimo], v[posicionDelMayor(v,desde,ultimo)]);
            
        }

        assert(estaOrdenado(v,desde,hasta));
        //pos contiene los mismos datos
    }

    private static int posicionDelMayor(Integer[] v, int desde, int hasta) {
        assert(desde<=hasta);
        // pre desde y hasta pertenecen al rango de v

        int pos=desde;
        for (int i=desde+1;i<hasta;i++) {
            if (v[i]>v[pos]) pos=i;
        }
        return pos;

        // pos retorna la posición del mayor entre desde y hasta
    }

}
