package Dominio;



public class NodoArbol implements Comparable<NodoArbol> {

	private static int contador=0;
	private int id;
	private Estado e;
	private int costo;
	private String accion;
	private int p;
	private double f;
	private NodoArbol padre;
	private double h;
	private int estrategia;
	

	public NodoArbol(Estado e, int costo, String accion, int p, double f, NodoArbol padre) {
		super();
		this.e = e;
		this.costo = costo;
		this.accion = accion;
		this.p = p;
		this.f = f;
		this.padre = padre;
		this.id=contador;
		contador++;
	}
	
	
	public int getEstrategia() {
		return estrategia;
	}


	public void setEstrategia(int estrategia) {
		this.estrategia = estrategia;
	}


	public double getH() {
		return h;
	}




	public void setH(double h) {
		this.h = h;
	}

	
	

	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
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

	public double getF() {
		return f;
	}

	public void setF(double f) {
		this.f = f;
	}

	@Override
	public int compareTo(NodoArbol o) {
		int aux = 0;
		if(estrategia!=1) {
			
			if(o.getF() < this.getF()) {
				aux = 1;
			}else {
				if(o.getF() > this.getF()) {
					aux = -1;
				}else if(o.getId() < this.getId()) {
					aux=1;
				}else {
					aux = -1;
				}
			}
			
		}else {
			
			if(o.getF() < this.getF()) {
				aux = -1;
			}else {
				if(o.getF() > this.getF()) {
					aux = 1;
				}else if(o.getId() < this.getId()) {
					aux=1;
				}else {
					aux = -1;
				}
			}
		}
		
		return aux;
	}
	
	
	
}
