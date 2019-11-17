package Dominio;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class LecturaJSON {

	public Cubo leerJson(String rutaFichero) {

		JSONParser parser = new JSONParser();
		Cubo c = null;
		try {
		
			FileReader fichero = new FileReader(rutaFichero);

			JSONObject json = (JSONObject) parser.parse(fichero);
			JSONArray back=(JSONArray) json.get("BACK");
			
			c = new Cubo(back.size());
			
			c.getMatriz()[Cara.BACK.cara()]=convertirJSONaMatriz(back);
			c.getMatriz()[Cara.FRONT.cara()]=convertirJSONaMatriz((JSONArray) json.get("FRONT"));
			c.getMatriz()[Cara.LEFT.cara()]=convertirJSONaMatriz((JSONArray) json.get("LEFT"));
			c.getMatriz()[Cara.RIGHT.cara()]=convertirJSONaMatriz((JSONArray) json.get("RIGHT"));
			c.getMatriz()[Cara.UP.cara()]=convertirJSONaMatriz((JSONArray) json.get("UP"));
			c.getMatriz()[Cara.DOWN.cara()]=convertirJSONaMatriz((JSONArray) json.get("DOWN"));
	


		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return c;
	}

	public int[][] convertirJSONaMatriz(JSONArray arrayJson) {

		int[][] matriz = new int[arrayJson.size()][arrayJson.size()];

		for (int i = 0; i < arrayJson.size(); i++) {
			JSONArray array = (JSONArray) arrayJson.get(i);
			for (int j = 0; j < array.size(); j++) {

				matriz[i][j] = Integer.parseInt(array.get(j).toString());
			}

		}

		return matriz;
		
	}

}
