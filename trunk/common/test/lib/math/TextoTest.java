/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib.math;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class TextoTest {


  /**
   * Test of anagramas method, of class Texto.
   */
  @Test
  public void testAnagramaUnico() throws Exception {
    System.out.println("testAnagramaUnico");
    String palabra = "ROMA";
    ArrayList<String> v = new ArrayList<String>();
    v.add("AMOR");
    int expResult = 1;
    ArrayList<String> result = Texto.anagramas(palabra, v);
    assertEquals(expResult, result.size());
  }

  /**
   * Test of anagramas method, of class Texto.
   */
  @Test
  public void testAnagramasSinCoincidencia() throws Exception {
    System.out.println("testAnagramasSinCoincidencia");
    String palabra = "ROMA";
    ArrayList<String> v = new ArrayList<String>();
    v.add("PRUEBA");
    int expResult = 0;
    ArrayList<String> result = Texto.anagramas(palabra, v);
    assertEquals(expResult, result.size());
  }

  /**
   * Test of anagramas method, of class Texto.
   */
  @Test
  public void testAnagramasTodasCoincidencias() throws Exception {
    System.out.println("testAnagramasTodasCoincidencias");
    String palabra = "ROMA";
    ArrayList<String> v = new ArrayList<String>();
    v.add("AMOR");
    v.add("ROMA");
    v.add("MORA");
    v.add("RAMO");
    int expResult = 4;
    ArrayList<String> result = Texto.anagramas(palabra, v);
    assertEquals(expResult, result.size());
  }

  /**
   * Test of anagramas method, of class Texto.
   */
  @Test
  public void testAnagramasAlgunasCoincidencias() throws Exception {
    System.out.println("testAnagramasAlgunasCoincidencias");
    String palabra = "ROMA";
    ArrayList<String> v = new ArrayList<String>();
    v.add("AMOR");
    v.add("PRUEBA");
    v.add("ROMA");
    v.add("RELOJ");
    int expResult = 2;
    ArrayList<String> result = Texto.anagramas(palabra, v);
    assertEquals(expResult, result.size());
  }

  /**
   * Test of anagramas method, of class Texto.
   */
  @Test
  public void testAnagramasCapitalizacion() throws Exception {
    System.out.println("testAnagramasAlgunasCoincidencias");
    String palabra = "Roma";
    ArrayList<String> v = new ArrayList<String>();
    v.add("amor");
    v.add("rOmA");
    v.add("RaMo");
    int expResult = 3;
    ArrayList<String> result = Texto.anagramas(palabra, v);
    assertEquals(expResult, result.size());
  }

}