package Utilidades;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Dominio.Cubo;

public class Leer_json {

	public Leer_json() {
		JSONParser parser = new JSONParser();

		try (FileReader reader = new FileReader("cubo")) {

			Object obj = parser.parse(reader);
			JSONObject represantacionCubo = (JSONObject) obj;
			

			JSONArray back = (JSONArray) represantacionCubo.get("BACK");
			JSONArray down = (JSONArray) represantacionCubo.get("DOWN");
			JSONArray front = (JSONArray) represantacionCubo.get("FRONT");
			JSONArray left = (JSONArray) represantacionCubo.get("LEFT");
			JSONArray right = (JSONArray) represantacionCubo.get("RIGHT");
			JSONArray up = (JSONArray) represantacionCubo.get("UP");
			
			Cubo c = new Cubo(3);
			c.crearCara(0, crearCara(back));
			c.crearCara(1, crearCara(down));
			c.crearCara(2, crearCara(front));
			c.crearCara(3, crearCara(left));
			c.crearCara(4, crearCara(right));
			c.crearCara(5, crearCara(up));
			
			System.out.println(c.toString());
			
			

		} catch (FileNotFoundException e) {
			// manejo de error
		} catch (IOException e) {
			// manejo de error
		} catch (ParseException e) {
			// manejo de error
		}

	}
	
	public int [][] crearCara(JSONArray arrayJson){
		
		int [][] devolver = new int [arrayJson.size()][arrayJson.size()];
		JSONArray fila;
		for (int i = 0; i < arrayJson.size(); i++) {
			fila = (JSONArray) arrayJson.get(i);
			for (int j = 0; j <fila.size(); j++) {
				devolver[i][j] = Integer.parseInt(fila.get(j).toString());
			}
		}
		
		return devolver;
						
	}

}
