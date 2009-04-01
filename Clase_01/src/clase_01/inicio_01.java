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
        int v[] = {2,6,45,32,3,76,4,32,17,94};
        int desde = 0;
        int hasta = 9;
        v = ordeno(v, 5, 9);
        muestro(v, desde, hasta);
    }

    private static boolean estaOrdenado(int[] v, int desde, int hasta) {
        return true;
    }

    private static boolean estanIntercambiados(int i, int ii, int j, int jj) {
        return (i==jj && j==ii);
    }

    private static int[] intercambio(int[] v, int i, int j) {
        // pre
        int ii=v[i];
        int jj=v[j];
        int aux = v[i];
        v[i]=v[j];
        v[j]=aux;
        assert(estanIntercambiados(v[i],ii,v[j],jj));
        return v;

    }

    private static void muestro(int[] v, int desde, int hasta) {
        for (int i=desde;i<=hasta;i++) {
            System.out.println(v[i]);
        }
    }

    private static int[] ordeno(int[] v, int desde, int hasta) {
        assert(desde<=hasta);
        // pre desde y hasta pertenecen al rango de v

        for(int ultimo=hasta; ultimo>=desde; ultimo--) {
            v = intercambio(v, ultimo, posicionDelMayor(v,desde,ultimo));
            
        }

        assert(estaOrdenado(v,desde,hasta));
        //pos contiene los mismos datos

        return v;
    }

    private static int posicionDelMayor(int[] v, int desde, int hasta) {
        assert(desde<=hasta);
        // pre desde y hasta pertenecen al rango de v

        int pos=desde;
        for (int i=desde+1;i<=hasta;i++) {
            if (v[i]>v[pos]) pos=i;
        }
        return pos;

        // pos retorna la posición del mayor entre desde y hasta
    }

}
