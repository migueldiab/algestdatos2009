package obligatorio3;
import obligatorio3.lib.biblioteca.Sistema.Retorno;

public class Prueba {

static int	cantCorrectas, cantIncorrectas, cantNoImplementadas;
			
void inicializarResultadosPrueba() {
	cantCorrectas = cantIncorrectas = cantNoImplementadas = 0;
}

public void ver(Retorno retorno, Retorno retornoEsperado, String comentario)
{
	System.out.println();

	System.out.println( "----------------------------- Testeo --------------------------------");

	imprimirComentario(comentario);

	imprimirRetorno(retorno,retornoEsperado);

	System.out.println("---------------------------------------------------------------------");
    System.out.println();

    if (retorno.equals(retornoEsperado))
		cantCorrectas++;
	else
	{
		if (retorno.equals(Retorno.NO_IMPLEMENTADA))
			cantNoImplementadas++;
		else
			cantIncorrectas++;

	}
}

void imprimirComentario(String comentario)
{
	if ( comentario!=null || !comentario.isEmpty())
	{
		System.out.println("\n  Comentario: " + comentario );
		System.out.println();
	}
}

public void imprimirRetorno(Retorno retorno, Retorno retornoEsperado)
{
	System.out.println("  Retorno de la app.: "+ retorno +" -\t" + getStringRetorno(retorno));

	if ( retorno == retornoEsperado )
	{
		System.out.println( "\t\t.........OK........." );
	}
	else
	{
		System.out.println("  Se esperaba.......: " + retornoEsperado + " -\t" + getStringRetorno(retornoEsperado));
	}
}

public String getStringRetorno(Retorno retorno)
{
	if (retorno==Retorno.OK)
			return "OK";
        else if (retorno==Retorno.ERROR)
			return "ERROR";
        else if (retorno==Retorno.NO_IMPLEMENTADA)
		return "NO_IMPLEMENTADA";
        return "NO_IMPLEMENTADA";
}

void imprimirResultadosPrueba()
{
	System.out.println();
	System.out.println( "  +------------------------------+");
	System.out.println("    RESULTADOS DE LA PRUEBA    ");
	System.out.println( "    Pruebas Correctas: " + cantCorrectas);
	System.out.println("    Pruebas Incorrectas: " + cantIncorrectas );
	System.out.println("    Pruebas NI: " + cantNoImplementadas);
	System.out.println("  +------------------------------+");
	System.out.println();
}




}
