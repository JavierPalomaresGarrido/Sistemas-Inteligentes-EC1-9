package Dominio;



public class NodoArbol implements Comparable<NodoArbol> {

	private Estado e;
	private int costo;
	private String accion;
	private int p;
	private int f;
	private NodoArbol padre;
	
	public NodoArbol(Estado e, int costo, String accion, int p, int f, NodoArbol padre) {
		super();
		this.e = e;
		this.costo = costo;
		this.accion = accion;
		this.p = p;
		this.f = f;
		this.padre = padre;
	}



	public NodoArbol getPadre() {
		return padre;
	}

	public void setPadre(NodoArbol padre) {
		this.padre = padre;
	}

	public Estado getE() {
		return e;
	}

	public void setE(Estado e) {
		this.e = e;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	@Override
	public int compareTo(NodoArbol o) {
		int aux = 0;
		if (this.f < (o.getF()))
			aux = -1;
		if (this.f > (o.getF()))
			aux = 1;
		return aux;
	}
	

}
