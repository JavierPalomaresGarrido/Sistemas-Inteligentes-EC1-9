package Dominio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Hashtable;





public class BusquedaSolucion {
	

	//EL diccionario esta formado por una key que se corresponde con el id (md5) cubo 
	//El value es la f del cubo
	Hashtable<String, Double> ht = new Hashtable<String, Double>();
	
	public boolean Busqueda(Problema problema, int estrategia, int prof_Max, int inc_Prof, boolean realizarPoda) {
		int prof_Actual = inc_Prof;
		boolean sol = false;

		
		while (!sol && prof_Actual <= prof_Max) {
			sol = busquedaAcotada(problema, estrategia, prof_Max, realizarPoda);
			prof_Actual = prof_Actual + inc_Prof;
		}
		return sol;

	}
	


	private boolean busquedaAcotada(Problema prob, int estrategia, int profMax, boolean poda) {
		
		Frontera f = new Frontera();
		NodoArbol inicial = new NodoArbol(prob.getEstadoInicial(), 0, "NODO PADRE", 0, 0, null);
		inicial.setH(formatearDecimales(calcularHeuristica(inicial.getE().getCubo()), 2));
		if(estrategia == 1) {
			inicial.setF((double) 1/(inicial.getP()+1));
		}
		if(estrategia==5 || estrategia==6) {
			inicial.setF(inicial.getH());
		}
		inicial.setEstrategia(estrategia);
		
		
		f.insertar(inicial);
		boolean sol = false;
		NodoArbol actual = null;

		while (!sol && !f.esVacia() ) {

			actual = f.eliminar();
			
			
			if (prob.esObjetivo(actual.getE()))
				sol = true;
			else if (actual.getP() < profMax) {
				ArrayList<Sucesor> ls = prob.getEspacioEstados().crearSucesores(actual.getE());
				
				ArrayList<NodoArbol> ln = creaListaNodosArbol(f, prob, ls, actual, profMax, estrategia, poda);
				
				
				for (int i = 0; i < ln.size(); i++) {
					f.insertar(ln.get(i));
				}
			}
		}
		
		
		if(sol) {
			
			escribirAccion(actual, f, estrategia);
			
		}

		return sol;
	}
	
	public double calcularEntropiaCara(byte [][] cara) {
		double entropia = 0;
		double n = cara.length;
		int contador[] = new int[6];
		
		for (int i = 0; i < cara.length; i++) {
			for (int j = 0; j < cara[i].length; j++) {
				
				contador[cara[i][j]] +=1;
			}
		}
		
		for (int i = 0; i < contador.length; i++) {
			if(contador[i]>0) {
		
				entropia +=contador[i]/(n*n)* Math.log((double) contador[i]/(n*n))/Math.log(6);

			}
		}
		
		if(Double.isNaN(entropia)) {
			System.out.println(entropia);
		}
		
		return Math.abs(entropia);
	}
	
	public double calcularHeuristica(Cubo c) {
		double heuristica=0;
		for (int i = 0; i < c.getMatriz().length; i++) {
			heuristica += calcularEntropiaCara(c.getMatriz()[i]);
		}
		return heuristica;
	}
	public ArrayList<NodoArbol> creaListaNodosArbol(Frontera f, Problema prob, ArrayList<Sucesor> ls, NodoArbol actual,
		int profMax, int estrategia, boolean poda) {
		
		double valor = 0;
		int profundidad = actual.getP()+1;
		
		ArrayList<NodoArbol> ln = new ArrayList<NodoArbol>();
		
		for (int i = 0; i < ls.size(); i++) {
			
			switch (estrategia) {
			// ANCHURA
			case 0:
				valor = actual.getP() + 1;
				break;
			// PROFUNDIDAD SIMPLE
			case 1:
				
				valor = (double)1/(profundidad +1);
				break;
			// PROFUNDIDAD ACOTADA
			case 2:
				if (actual.getP() <= profMax)
					valor = actual.getP() - 1;
				break;
			// PROFUNIDADA ITERATIVA
			case 3:
				valor = actual.getP() - 1;
				break;
			// COSTE UNIFORME
			case 4:
				valor = actual.getCosto() + ls.get(i).getCoste();
				break;
			//VORAZ
			case 5:
				valor= calcularHeuristica(ls.get(i).getNuevoEstado().getCubo());
				break;
			//A
			case 6:
				valor= actual.getCosto() + ls.get(i).getCoste() + calcularHeuristica(ls.get(i).getNuevoEstado().getCubo());
				break;
				

			}
			
			valor = formatearDecimales(valor, 2);
			
			if (poda) {
				if (!ht.containsKey(ls.get(i).getNuevoEstado().getId())) {
					
					NodoArbol n =new NodoArbol(
							ls.get(i).getNuevoEstado(), 
							actual.getCosto() + ls.get(i).getCoste(),
							ls.get(i).getAccion(), 
							actual.getP() + 1, 
							valor, 
							actual);
					
					n.setEstrategia(estrategia);
					
					if(estrategia==5 || estrategia ==6)
						n.setH(formatearDecimales(calcularHeuristica(n.getE().getCubo()),2));
					
					ln.add(n);
				
					ht.put(ls.get(i).getNuevoEstado().getId(), valor);
				} else {
					if (estrategia == 1) { // PODA EN PROFUNDIDAD
						if (ht.get(ls.get(i).getNuevoEstado().getId()) > actual.getF()) {
							ht.remove(actual.getE().getId());
							ht.put(actual.getE().getId(), actual.getF());
						}
					} else { // PODA EN LAS RESTANTES
						if (ht.get(ls.get(i).getNuevoEstado().getId()) < actual.getF()) {
							ht.put(actual.getE().getId(), actual.getF());
							
						}
					}
					
					
					
				}
			} else {
				ln.add(new NodoArbol(ls.get(i).getNuevoEstado(), actual.getCosto() + ls.get(i).getCoste(),
						ls.get(i).getAccion(), actual.getP() + 1, valor, actual));
			}
		}
		
		
		return ln;
	}
	


	public void escribirAccion(NodoArbol x, Frontera f, int estrategia) {

		ArrayList<NodoArbol> fich = new ArrayList<NodoArbol>();

		while (x != null) {
			fich.add(x);
			x = x.getPadre();
		}

		Collections.reverse(fich);

		try {
			File file = new File("src/Resultados/fichero.txt");
			FileWriter fichero = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fichero);

			switch (estrategia) {
			case 0:
				bw.write("Estrategia: Anchura " + "\n");
				break;
			case 1:
				bw.write("Estrategia: Profundidad" + "\n");
				break;
			case 2:
				bw.write("Estrategia: Profundidad Acotada" + "\n");
				break;
			case 3:
				bw.write("Estrategia: Profundidad Iterativa" + "\n");
				break;
			case 4:
				bw.write("Estrategia: Coste Uniforme" + "\n");
				break;
			case 5:
				bw.write("Estrategia: Voraz" + "\n");
				break;
			case 6:
				bw.write("Estrategia: A*" + "\n");
				break;

			}

			
			bw.write("Profundidad: " + (fich.get(fich.size() - 1).getP() + 1) + "\n");
			bw.write("Coste: " + fich.get(fich.size() - 1).getCosto() + "\n");
			for (NodoArbol nodoArbol : fich) {
				bw.write("["+nodoArbol.getId()+"]["+nodoArbol.getAccion()+"] "+nodoArbol.getE().toString()+" c=" + nodoArbol.getCosto()+" p=" +nodoArbol.getP()+" h="+nodoArbol.getH() +" v= "+nodoArbol.getF());
			
				bw.newLine();
			}

			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static Double formatearDecimales(Double numero, Integer numeroDecimales) {
	    return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
	}

}