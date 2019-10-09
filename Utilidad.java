package Dominio;

import java.util.Arrays;

public class Utilidad {


	
	public Utilidad() {
		
	}
	


	public int[] cogerFila(int matriz[][],int fila) {
		
		return matriz[fila];
	}
	
	public int[] cogerColumna(int matriz [][], int columna) {
		
		
		int devolver[] = new int [matriz.length];
		
		for (int i = 0; i < matriz.length; i++) {
			
			devolver[i] = matriz[i][columna];
		}
		
		return devolver;
	}
	
	public void sustituirFila(int matriz[][], int[] nuevaFila, int filaASustituir) {
		
		matriz[filaASustituir] = nuevaFila;
		
	}
	
	public void sustituirColumna(int matriz[][], int[] columna, int columnaASustituir) {
		
		for (int i = 0; i < columna.length; i++) {
			
			matriz[i][columnaASustituir] = columna[i];
		}
	}
	
	public int[][] copiarMatriz(int [][] matriz){
		int [][] nueva = new int[matriz.length][matriz[0].length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				nueva[i][j] = matriz[i][j];
			}
		}
		return nueva;
	}
	
	
}
