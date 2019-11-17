package Dominio;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Frontera {
	
	
	PriorityQueue<NodoArbol> frontera = new PriorityQueue<NodoArbol>();

	public Frontera() {
		
	}

	public void insertar(NodoArbol n) {
		
		frontera.add(n);
	}
	public NodoArbol eliminar() {
		
		return frontera.poll();
	}
	public boolean esVacia() {
		return frontera.size()==0;
	}

	public void insertaLista(ArrayList<NodoArbol> ln) {
		for (int i = 0; i < ln.size(); i++) {
			insertar(ln.get(i));
		}
		
	}
	
	
	
	
}
