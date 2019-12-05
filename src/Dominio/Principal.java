package Dominio;

import java.io.File;

import java.util.Scanner;

public class Principal {

	
	private static Scanner reader;

	public static void main(String [] args) {
		
		String ruta ="src/Pruebas/Cubo2x2NuevoNuevo.json";
		File f = new File(ruta);
	
		if(f.exists()) {
			Problema p = new Problema(ruta);
		 
			
			reader = new Scanner(System.in);
			
			System.out.println("Introduce la estrategia\n0:Anchura\n1:Profundidad\n2:Profundida Acotada\n3:Profundidad Iterativa\n4:Coste Uniforme\n5:Voraz\n6:A*");
			int estrategia = reader.nextInt();
			System.out.println("Introduce Profundidad Máxima");
			int profMax = reader.nextInt();
			System.out.println("Introduce incremento profundidad");
			int incProc= reader.nextInt();

			

		 	long principio = System.currentTimeMillis();
		 	System.out.println("---RESOLVIENDO EL CUBO DE RUBIK---");
		 	
		 	BusquedaSolucion b = new BusquedaSolucion();
		 	b.Busqueda(p, estrategia, profMax, incProc, true);

		 	long fin = System.currentTimeMillis();
		 	System.out.println("---CUBO DE RUBIK RESUELTO---");
		 	
		 	System.out.println("El programa ha tardado en ejecutarse:" + (double) (fin-principio)/1000 +"s");
		}
		else {
			System.out.println("La ruta del fichero no existe!");
		}
	 	
		
 	
    

	}
}
