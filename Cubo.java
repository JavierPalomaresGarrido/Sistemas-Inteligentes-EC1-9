package Dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;



public class Cubo {
	
	
	private int dimension;
	private Hashtable<String, int[][]> cubo= new Hashtable<String,int[][]>();
	private Utilidad u = new Utilidad();

	public Cubo(int dimension, Hashtable<String, int[][]> cubo) {
		this.dimension=dimension;
		this.cubo= cubo;
	}
	
	public Cubo() {
		
	}
	
	public int getDimension() {
		return dimension;
	}



	public void setDimension(int dimension) {
		this.dimension = dimension;
	}



	public Hashtable<String, int[][]> getCubo() {
		return cubo;
	}

	public void setCubo(Hashtable<String, int[][]> cubo) {
		this.cubo = cubo;
	}

	public Cubo clonar(Cubo cubo) {
		Cubo cuboNuevo = new Cubo();
		
		cuboNuevo.setDimension(cubo.getDimension());
		
		Enumeration e = cubo.getCubo().keys();
		String clave;
		int[][] valor;
		while( e.hasMoreElements() ){
		  
			clave = (String) e.nextElement();
			int [][] matriz = u.copiarMatriz( cubo.getCubo().get(clave));
 			cuboNuevo.getCubo().put(clave, matriz);
		}
		return cuboNuevo;
		
	}
	
	public ArrayList<Cubo> movimientosValidos(Cubo cubo) {
		return null;
	}
	
	
	public Cubo movimientoL(Cubo cuboInicio, int columnaAgirar) {
		
		
		
		Cubo nuevoCubo = cuboInicio.clonar(cuboInicio);
		
		if(nuevoCubo == null) {
			System.out.println("no clonado");
		}else {
			System.out.println();
		}
		
		if(columnaAgirar == 0 || columnaAgirar == cuboInicio.getDimension()-1) {
			//TODO: 
		}
		else {
			
			u.sustituirColumna(nuevoCubo.getCubo().get("down"), u.cogerColumna(cuboInicio.getCubo().get("front"), columnaAgirar),columnaAgirar);
			u.sustituirColumna(nuevoCubo.getCubo().get("back"), u.cogerColumna(cuboInicio.getCubo().get("down"), columnaAgirar),columnaAgirar);
			u.sustituirColumna(nuevoCubo.getCubo().get("up"), u.cogerColumna(cuboInicio.getCubo().get("back"), columnaAgirar),columnaAgirar);
			u.sustituirColumna(nuevoCubo.getCubo().get("front"), u.cogerColumna(cuboInicio.getCubo().get("up"), columnaAgirar),columnaAgirar);

		}
		
		
		return nuevoCubo;
	}

	
	@Override
	public String toString() {
		
		String devolver = "";
		
		Enumeration e = cubo.keys();
		String clave;
		int[][] valor;
		while( e.hasMoreElements() ){
		  clave = (String) e.nextElement();
		  devolver += "Clave : " + clave + " - Valor : " + Arrays.deepToString(cubo.get(clave)) +"\n";
		}
		
		return devolver;
	}
}
