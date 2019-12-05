package Dominio;

import java.math.BigInteger;
import java.security.MessageDigest;


public class Utilidad {


	private static Utilidad u;
	
	public static Utilidad getU() {
		if(u == null) {
			u = new Utilidad();
		}
		return u;
	} 

	public byte[] cogerFila(byte matriz[][],int fila) {
		
		return matriz[fila];
	}
	
	public byte[] cogerColumna(byte matriz [][], int columna) {
		
		
		byte devolver[] = new byte[matriz.length];
		
		for (int i = 0; i < matriz.length; i++) {
			
			devolver[i] = matriz[i][columna];
		}
		
		return devolver;
	}
	
	public void sustituirFila(byte matriz[][], byte[] nuevaFila, int filaASustituir) {
		
		matriz[filaASustituir] = nuevaFila;
		
	}
	
	public void sustituirColumna(byte matriz[][], byte[] columna, int columnaASustituir) {
		
		for (int i = 0; i < columna.length; i++) {
			
			matriz[i][columnaASustituir] = columna[i];
		}
	}
	
	public byte[][] copiarMatriz(byte[][] matriz){
		byte [][] nueva = new byte[matriz.length][matriz[0].length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				nueva[i][j] = matriz[i][j];
			}
		}
		return nueva;
	}
	
	public byte [][] rotarMatriz(byte[][] matriz){
		
	byte matrizRotada [][]= new byte [matriz.length][matriz[0].length]; 
		
		for (int i = 0; i < matriz.length; i++) {
			matrizRotada[i] = invertirArray(cogerColumna(matriz,i));
			
		}
		
		
		return matrizRotada;
		
	}
	
	public byte [][] rotarMatrizInversa(byte[][] matriz){
		
		byte matrizRotada [][]= new byte [matriz.length][matriz[0].length]; 
		
		for (int i = 0; i < matriz.length; i++) {
			
			sustituirColumna(matrizRotada, invertirArray(matriz[i]), i);
			
		}
		
		
		return matrizRotada;
		
	}

	
	public byte [] invertirArray(byte [] array) {
		byte [] devolver = new byte [array.length];
		
		for (int i = 0; i < array.length; i++) {
			
			devolver[i] = array[(array.length-1)-i];
		}
		
		return devolver;
	}
	
	public String encriptar(String source) {
		   String md5 = null;
		   try {
		         MessageDigest mdEnc = MessageDigest.getInstance("MD5"); //Encryption algorithm
		         mdEnc.update(source.getBytes(), 0, source.length());
		         md5 = new BigInteger(1, mdEnc.digest()).toString(16); //Encrypted string
		        } 
		    catch (Exception ex) {
		         return null;
		    }
		    return md5;
		}
}
