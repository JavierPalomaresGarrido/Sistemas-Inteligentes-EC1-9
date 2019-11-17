package Dominio;

import java.util.ArrayList;
import java.util.Arrays;




public class Cubo {
	
	
	private int dimension;
	private int matriz[][][];

	private Utilidad u = new Utilidad();

	//CONSTRUCTOR
	public Cubo(int dimension) {
		this.dimension=dimension;
		this.matriz= new int[Cara.values().length][dimension][dimension];
	}
	//CONSTRUCTOR VACIO
	public Cubo() {
		
	}
	
	
	public int[][][] getMatriz() {
		return matriz;
	}

	public void setMatriz(int matriz[][][]) {
		this.matriz = matriz;
	}
	
	public int getDimension() {
		return dimension;
	}



	public void setDimension(int dimension) {
		this.dimension = dimension;
	}


	

	public Cubo clonar() {
		Cubo cuboNuevo = new Cubo();
		cuboNuevo.setDimension(this.dimension);
		int [][][] nuevaMatriz = new int [this.matriz.length][cuboNuevo.getDimension()][cuboNuevo.getDimension()];
	
		for (int i = 0; i < nuevaMatriz.length; i++) {
			nuevaMatriz[i]=u.copiarMatriz(this.matriz[i]);
		}
		cuboNuevo.setMatriz(nuevaMatriz);
		return cuboNuevo;
		
	}
	
	public ArrayList<Cubo> movimientosValidos(Cubo cubo) {
		return null;
	}
	

	public String pasarMD5() {
		String cadena = Arrays.deepToString(matriz[Cara.BACK.cara()]);
		cadena += Arrays.deepToString(matriz[Cara.DOWN.cara()]);
		cadena += Arrays.deepToString(matriz[Cara.FRONT.cara()]);
		cadena += Arrays.deepToString(matriz[Cara.LEFT.cara()]);
		cadena += Arrays.deepToString(matriz[Cara.RIGHT.cara()]);
		cadena += Arrays.deepToString(matriz[Cara.UP.cara()]);
		
		return Utilidad.getU().encriptar(cadena.replaceAll("[^\\dA-Za-z]",""));
	}
	@Override
	public String toString() {
		

		System.out.println(pasarMD5());
		
		
		
		
		return convertiraJSON();
		

	}

	public String convertiraJSON() {
		
		String retornar="{";
		retornar += "'"+Cara.BACK+"':"+" " +Arrays.deepToString(this.matriz[Cara.BACK.cara()])+",";
		retornar += "'"+Cara.DOWN+"':" +" " +Arrays.deepToString(this.matriz[Cara.DOWN.cara()])+",";
		retornar += "'"+Cara.FRONT+"':" +" " +Arrays.deepToString(this.matriz[Cara.FRONT.cara()])+",";
		retornar += "'"+Cara.LEFT+"':" +" " +Arrays.deepToString(this.matriz[Cara.LEFT.cara()])+",";
		retornar += "'"+Cara.RIGHT+"':" +" " +Arrays.deepToString(this.matriz[Cara.RIGHT.cara()])+",";
		retornar += "'"+Cara.UP+"':" +" " +Arrays.deepToString(this.matriz[Cara.UP.cara()])+"}";
		
		return retornar;
	}
	
}
