/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package obligatorio_1.lib.math;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class AlgebraTest {

    public AlgebraTest() {
    }

  @BeforeClass
  public static void setUpClass() throws Exception {
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
  }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

  /**
   * Test of minimo method, of class Algebra.
   */
  @Test
  public void testMinimoBorde1() throws Exception {
    System.out.println("testMinimoBorde1");
    int[] v = {1,2,3};
    int expResult = 1;
    int result = Algebra.minimo(v);
    assertEquals(expResult, result);
  }
  /**
   * Test of minimo method, of class Algebra.
   */
  @Test
  public void testMinimoBorde2() throws Exception {
    System.out.println("testMinimoBorde2");
    int[] v = {7,6,5};
    int expResult = 5;
    int result = Algebra.minimo(v);
    assertEquals(expResult, result);
  }
  /**
   * Test of minimo method, of class Algebra.
   */
  @Test
  public void testMinimoMedio() throws Exception {
    System.out.println("testMinimoMedio");
    int[] v = {6,5,3,56,45,1,23,54,34,2};
    int expResult = 1;
    int result = Algebra.minimo(v);
    assertEquals(expResult, result);
  }
  /**
   * Test of minimo method, of class Algebra.
   */
  @Test
  public void testMinimoNegativo() throws Exception {
    System.out.println("testMinimoMedio");
    int[] v = {6,5,3,56,-45,1,-23,54,-34,2};
    int expResult = -45;
    int result = Algebra.minimo(v);
    assertEquals(expResult, result);
  }
  /**
   * Test of posDelMinimo method, of class Algebra.
   */
  @Test
  public void testPosDelMinimo() {
    System.out.println("posDelMinimo");
    int[] v = {6,5,3,56,-45,1,-23,54,-34,2};
    int expResult = 4;
    int result = Algebra.posDelMinimo(v);
    assertEquals(expResult, result);
  }

  /**
   * Test of menorDe5 method, of class Algebra.
   */
  @Test
  public void testMenorDe5() throws Exception {
    System.out.println("menorDe5");
    int[] v = {6,5,3,56,45};
    int expResult = 3;
    int result = Algebra.menorDe5(v);
    assertEquals(expResult, result);
  }

  /**
   * Test of estaOrdenado method, of class Algebra.
   */
  @Test
  public void testEstaOrdenado() {
    System.out.println("estaOrdenado");
    int[] v = {1,2,3,4,5,6,7,8,9};
    int desde = 2;
    int hasta = 7;
    boolean expResult = true;
    boolean result = Algebra.estaOrdenado(v, desde, hasta);
    assertEquals(expResult, result);
  }

  /**
   * Test of estanIntercambiados method, of class Algebra.
   */
  @Test
  public void testEstanIntercambiados() {
    System.out.println("estanIntercambiados");
    int i = 1;
    int ii = 3;
    int j = 3;
    int jj = 1;
    boolean expResult = true;
    boolean result = Algebra.estanIntercambiados(i, ii, j, jj);
    assertEquals(expResult, result);
  }

  /**
   * Test of intercambio method, of class Algebra.
   */
  @Test
  public void testIntercambio() {
    System.out.println("intercambio");
    int[] v = {5,4,3,7,5,6,4,2,4};
    int i = 2;
    int j = 4;
    int[] expResult = {5,4,5,7,3,6,4,2,4};
    int[] result = Algebra.intercambio(v, i, j);
    assertArrayEquals(expResult, result);
  }

  /**
   * Test of ordenarAsc method, of class Algebra.
   */
  @Test
  public void testOrdenarAsc() {
    System.out.println("ordenarAsc");
    int[] v = {8,34,2,3,2};
    int[] expResult = {2,2,3,8,34};
    int[] result = Algebra.ordenarAsc(v);
    assertArrayEquals(expResult, result);
  }

  /**
   * Test of ordeno method, of class Algebra.
   */
  @Test
  public void testOrdeno() {
    System.out.println("ordeno");
    int[] v = {5,4,3,78,56,23,2,1};
    int desde = 2;
    int hasta = 6;
    int[] expResult = {5,4,2,3,23,56,78,1};
    int[] result = Algebra.ordeno(v, desde, hasta);
    assertArrayEquals(expResult, result);
  }

    /**
   * Test of ordeno method, of class Algebra.
   */
  @Test
  public void testOrdenoUnicoElemento() {
    System.out.println("ordeno");
    int[] v = {5};
    int desde = 0;
    int hasta = 0;
    int[] expResult = {5};
    int[] result = Algebra.ordeno(v, desde, hasta);
    assertArrayEquals(expResult, result);
  }

    /**
   * Test of ordeno method, of class Algebra.
   */
  @Test
  public void testOrdenoIguales() {
    System.out.println("ordeno");
    int[] v = {3,3,3,3,3,3};
    int desde = 0;
    int hasta = v.length-1;
    int[] expResult = {3,3,3,3,3,3};
    int[] result = Algebra.ordeno(v, desde, hasta);
    assertArrayEquals(expResult, result);
  }

  /**
   * Test of posicionDelMayor method, of class Algebra.
   */
  @Test
  public void testPosicionDelMayor() {
    System.out.println("posicionDelMayor");
    int[] v = {5,4,3,78,56,23,2,1};
    int desde = 2;
    int hasta = 6;
    int expResult = 3;
    int result = Algebra.posicionDelMayor(v, desde, hasta);
    assertEquals(expResult, result);
  }
  /**
   * Test of posicionDelMayor method, of class Algebra.
   */
  @Test
  public void testPosicionDelMayorIguales() {
    System.out.println("posicionDelMayor");
    int[] v = {0,0,0};
    int desde = 0;
    int hasta = 2;
    int expResult = 0;
    int result = Algebra.posicionDelMayor(v, desde, hasta);
    assertEquals(expResult, result);
  }  /**
   * Test of posicionDelMayor method, of class Algebra.
   */
  @Test
  public void testPosicionDelMayorNegativos() {
    System.out.println("posicionDelMayor");
    int[] v = {-15,-18,-3,-12,-6};
    int desde = 0;
    int hasta = 4;
    int expResult = 2;
    int result = Algebra.posicionDelMayor(v, desde, hasta);
    assertEquals(expResult, result);
  }
}