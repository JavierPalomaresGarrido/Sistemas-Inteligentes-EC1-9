package Dominio;

import java.util.Arrays;
import java.util.Hashtable;

public class Principal {
	

	
	public static void main(String [] args) {
		Hashtable<String, int[][]> inicial = new Hashtable<String, int[][]>();
		
		
		inicial.put("back",crearMatriz(3, 3));
		inicial.put("front",crearMatriz(3, 2));
		inicial.put("down",crearMatriz(3, 1));
		inicial.put("up",crearMatriz(3, 0));
		inicial.put("right",crearMatriz(3, 5));
		inicial.put("left",crearMatriz(3, 4));
		
		
		Cubo c = new Cubo(3,inicial);
		System.out.println(c.toString());
		
		
		Cubo cnuevo= c.movimientoL(c, 1);
		System.out.println(cnuevo.toString());
		System.out.println(c.toString());
		
		
 	}
	
	public static int [][] crearMatriz(int dimension,int numero){
		int[][] devolver = new int[dimension][dimension];
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				devolver[i][j]=numero;
			}
		}
		return devolver;
	}
 
}
