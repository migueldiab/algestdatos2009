/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package obligatorio_1.lib.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import obligatorio_1.lib.utils.I18n;

/**
 *
 * @author Administrator
 */
public class Consola {
	protected static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static int[] leerCSVInt(String msg) {
    String lista = "";
    do {
      lista = Consola.leer(msg);
      if (!lista.equals("exit")) {
        String listaVec[] = lista.split(",");
        if (listaVec != null) {
          try {
            int v[] = new int[listaVec.length];
            for (int i=0; i<listaVec.length; i++) {
              v[i] = Integer.parseInt(listaVec[i]);
            }
            return v;
          } catch (NumberFormatException e) {
            Consola.println("Error! - NumberFormatException");
            Consola.println(e.toString());
            Consola.println("Intente nuevamente o tipee 'exit' para salir...");
          }
        }
      }
    } while (!lista.equals("exit"));
    return new int[0];
  }

  public static void pausar() {
    Consola.leer("Presione Enter para continuar...");
  }

  public static void print(String s){
		System.out.print(s);

	}

  public static void println(String s){

		System.out.println(s);

	}

  public static void print(int i){
    System.out.print(i);

  }

  public static  void println(int i){
    System.out.println(i);
  }

  public static void print(double d){
    System.out.print(d);

  }

  public static  void println(double d){
    System.out.println(d);
  }

  public static void print(char c){
    System.out.print(c);

  }

  public static  void println(char c){
    System.out.println(c);
  }

  public static String leer(){

		try{
			return in.readLine();
		}catch(Exception e){return null;}

	}

  public static  String leer(String s){
		print(s);
		return leer();
	}

  public static String modificar(String s, String actual){

    try{
      print(s + "[" + actual + "] : ");
      String nuevo = leer();
      if (nuevo.equals(""))
        return actual;
      else if (nuevo.equals(" "))
        return "";
      else
        return nuevo;
    }catch(Exception e){return null;}

  }

  public static int modificarInt(String msg, int actual)
  {
    int num = -1;
    while(true){
      try{
        print(msg + "[" + actual + "] : ");
        String nuevo = leer();
        if (nuevo.equals(""))
          return actual;
        else {
          num = Integer.parseInt(nuevo);
          return num;
        }
      }catch(Exception e){}
    }
  }

  public static Date modificarFecha(String msg, Date actual)
  {
    Date fecha = null;
    while(true){
      try{
        print(msg + "[" + actual + "] : ");
        String nuevo = leer();
        if (nuevo.equals(""))
          return actual;
        else {
          fecha = I18n.sdf.parse(nuevo);
          return fecha;
        }
      }catch(Exception e){}
    }
  }

  public static double modificarDouble(String msg, double actual)
  {
    double num = 0.0;
    while(true){
      try{
        print(msg + "[" + actual + "] : ");
        String nuevo = leer();
        if (nuevo.equals(""))
          return actual;
        else {
          num = Double.parseDouble(nuevo);
          return num;
        }
      }catch(Exception e){}
    }
  }

  public static int leerInt(){
		return leerInt(null);
	}

  public static int leerInt(String msg){
		int num = -1;
		boolean ok = false;
		while(!ok){
			try{
				if (msg!=null){print(msg);}
				num = Integer.parseInt(leer());
				ok = true;
			}catch(Exception e){}
		}
		return num;
	}

  public static Calendar leerFecha(String msg) {
    Date d=null;
    boolean ok=false;
    do {
      try {
    	  String fechaInput=leer(msg);
        d = I18n.sdf.parse(fechaInput);

        ok = true;
      } catch (ParseException e) {
        println(I18n.ERROR);

      }
    } while (!ok);
    Calendar calendario = new GregorianCalendar();
    calendario.setTime(d);
    return calendario;
  }

  public static void printFecha(Date fecha) {
    System.out.println(I18n.sdf.format(fecha));
  }

  public static int menu(ArrayList opciones){
	  int salida=opciones.size();
		for(int x=0;x<opciones.size();x++){
			println( (x+1) + "-" + opciones.get(x).toString());
		}
		int opcion;
		do{
      println(I18n.SEPARADOR);
      opcion = leerInt("|  "+I18n.SELECCIONE_OPCION+" : ") - 1;

		}while(opcion < 0 || opcion > opciones.size());
		 if (opcion!=salida){
		return opcion;
		 }
		 return -1;
	}

public static int menu(ArrayList opciones, String titulo){
    println(I18n.SEPARADOR);
    println("|   "+titulo);
    println(I18n.SEPARADOR);
    return menu(opciones);
  }



  public static double leerDouble(String msg)
  {
    double doble = 0;

    boolean ok = false;
    while(!ok){
      try
      {
        doble = Double.parseDouble(leer(msg));
        ok = true;
      }
      catch (NumberFormatException e)
      {
        e.printStackTrace();
      }
    }
    return doble;
  }
  public static void listado(ArrayList lista){
    for(int x=0;x<lista.size();x++){
      println(lista.get(x).toString());
    }
  }


}
