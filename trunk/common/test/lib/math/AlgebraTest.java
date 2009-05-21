/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.math;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class AlgebraTest {

  @Test
  public void testMiMaxUnElemento() throws Exception {
    System.out.println("testMiMaxUnElemento");
    int[] v = {5};
    int[] expResult = {5,5};
    int[] result = Algebra.miMax(v, 0, 0);
    assertArrayEquals(expResult, result);
  }

  @Test
  public void testMiMaxUnElementoVector() throws Exception {
    System.out.println("testMiMaxUnElemento");
    int[] v = {5,3,4,5,2,2};
    int[] expResult = {3,3};
    int[] result = Algebra.miMax(v, 1, 1);
    assertArrayEquals(expResult, result);
  }

  @Test
  public void testMiMaxNegativos() throws Exception {
    System.out.println("testMiMaxUnElemento");
    int[] v = {-6,-9,-12,-14,-3,-4,-7};
    int[] expResult = {-14,-3};
    int[] result = Algebra.miMax(v, 0, v.length-1);
    assertArrayEquals(expResult, result);
  }

  @Test
  public void testMiMaxGenerico() throws Exception {
    System.out.println("testMiMaxGenerico");
    int[] v = {6,-9,12,14,-3,4,-7};
    int[] expResult = {-9,14};
    int[] result = Algebra.miMax(v, 0, v.length-1);
    assertArrayEquals(expResult, result);
  }

  @Test
  public void testMiMaxBordeA() throws Exception {
    System.out.println("testMiMaxBordeA");
    int[] v = {-20,-9,12,14,-3,4,30};
    int[] expResult = {-20,30};
    int[] result = Algebra.miMax(v, 0, v.length-1);
    assertArrayEquals(expResult, result);
  }

  @Test
  public void testMiMaxBordeB() throws Exception {
    System.out.println("testMiMaxBordeB");
    int[] v = {20,-9,12,14,-3,4,-30};
    int[] expResult = {-30,20};
    int[] result = Algebra.miMax(v, 0, v.length-1);
    assertArrayEquals(expResult, result);
  }

  @Test
  public void testMinimoBorde1() throws Exception {
    System.out.println("testMinimoBorde1");
    int[] v = {1,2,3};
    int expResult = 1;
    int result = Algebra.minimo(v);
    assertEquals(expResult, result);
  }

  @Test
  public void testMinimoBorde2() throws Exception {
    System.out.println("testMinimoBorde2");
    int[] v = {7,6,5};
    int expResult = 5;
    int result = Algebra.minimo(v);
    assertEquals(expResult, result);
  }

  @Test
  public void testMinimoMedio() throws Exception {
    System.out.println("testMinimoMedio");
    int[] v = {6,5,3,56,45,1,23,54,34,2};
    int expResult = 1;
    int result = Algebra.minimo(v);
    assertEquals(expResult, result);
  }

  @Test
  public void testMinimoNegativo() throws Exception {
    System.out.println("testMinimoNegativo");
    int[] v = {6,5,3,56,-45,1,-23,54,-34,2};
    int expResult = -45;
    int result = Algebra.minimo(v);
    assertEquals(expResult, result);
  }

  @Test
  public void testPosDelMinimo() {
    System.out.println("testPosDelMinimo");
    int[] v = {6,5,3,56,-45,1,-23,54,-34,2};
    int expResult = 4;
    int result = Algebra.posDelMinimo(v);
    assertEquals(expResult, result);
  }

  @Test
  public void testMenorDe5() throws Exception {
    System.out.println("testMenorDe5");
    int[] v = {6,5,3,56,45};
    int expResult = 3;
    int result = Algebra.menorDe5(v);
    assertEquals(expResult, result);
  }

  @Test
  public void testEstaOrdenado() {
    System.out.println("testEstaOrdenado");
    int[] v = {1,2,3,4,5,6,7,8,9};
    int desde = 2;
    int hasta = 7;
    boolean expResult = true;
    boolean result = Algebra.estaOrdenado(v, desde, hasta);
    assertEquals(expResult, result);
  }

  @Test
  public void testEstanIntercambiados() {
    System.out.println("testEstanIntercambiados");
    int i = 1;
    int ii = 3;
    int j = 3;
    int jj = 1;
    boolean expResult = true;
    boolean result = Algebra.estanIntercambiados(i, ii, j, jj);
    assertEquals(expResult, result);
  }

  @Test
  public void testIntercambio() {
    System.out.println("testIntercambio");
    int[] v = {5,4,3,7,5,6,4,2,4};
    int i = 2;
    int j = 4;
    int[] expResult = {5,4,5,7,3,6,4,2,4};
    int[] result = Algebra.intercambio(v, i, j);
    assertArrayEquals(expResult, result);
  }

  @Test
  public void testOrdenarAsc() {
    System.out.println("testOrdenarAsc");
    int[] v = {8,34,2,3,2};
    int[] expResult = {2,2,3,8,34};
    int[] result = Algebra.ordenarAsc(v);
    assertArrayEquals(expResult, result);
  }

  @Test
  public void testOrdeno() {
    System.out.println("testOrdeno");
    int[] v = {5,4,3,78,56,23,2,1};
    int desde = 2;
    int hasta = 6;
    int[] expResult = {5,4,2,3,23,56,78,1};
    int[] result = Algebra.ordeno(v, desde, hasta);
    assertArrayEquals(expResult, result);
  }

  @Test
  public void testOrdenoUnicoElemento() {
    System.out.println("testOrdenoUnicoElemento");
    int[] v = {5};
    int desde = 0;
    int hasta = 0;
    int[] expResult = {5};
    int[] result = Algebra.ordeno(v, desde, hasta);
    assertArrayEquals(expResult, result);
  }

  @Test
  public void testOrdenoIguales() {
    System.out.println("testOrdenoIguales");
    int[] v = {3,3,3,3,3,3};
    int desde = 0;
    int hasta = v.length-1;
    int[] expResult = {3,3,3,3,3,3};
    int[] result = Algebra.ordeno(v, desde, hasta);
    assertArrayEquals(expResult, result);
  }

  @Test
  public void testPosicionDelMayor() {
    System.out.println("testPosicionDelMayor");
    int[] v = {5,4,3,78,56,23,2,1};
    int desde = 2;
    int hasta = 6;
    int expResult = 3;
    int result = Algebra.posicionDelMayor(v, desde, hasta);
    assertEquals(expResult, result);
  }

  @Test
  public void testPosicionDelMayorIguales() {
    System.out.println("testPosicionDelMayorIguales");
    int[] v = {0,0,0};
    int desde = 0;
    int hasta = 2;
    int expResult = 0;
    int result = Algebra.posicionDelMayor(v, desde, hasta);
    assertEquals(expResult, result);
  }

  @Test
  public void testPosicionDelMayorNegativos() {
    System.out.println("testPosicionDelMayorNegativos");
    int[] v = {-15,-18,-3,-12,-6};
    int desde = 0;
    int hasta = 4;
    int expResult = 2;
    int result = Algebra.posicionDelMayor(v, desde, hasta);
    assertEquals(expResult, result);
  }

  @Test
  public void testApareo() {
    System.out.println("testApareo");
    int[] v1 = {1,2,3};
    int[] v2 = {4,5,6};
    int[] expResult = {1,2,3,4,5,6};
    int[] result;
    result = Algebra.apareo(v1, v2);
    assertArrayEquals(expResult, result);
  }

  @Test
  public void testApareoVacio() {
    System.out.println("testApareoVacio");
    int[] v1 = {};
    int[] v2 = {};
    int[] expResult = {};
    int[] result;
    result = Algebra.apareo(v1, v2);
    assertArrayEquals(expResult, result);
  }

}