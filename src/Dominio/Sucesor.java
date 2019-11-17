package Dominio;

public class Sucesor {

	private String accion;
	private Estado nuevoEstado;
	private int coste;
	
	public Sucesor(String accion, Estado nuevoEstado, int coste) {
		super();
		this.accion = accion;
		this.nuevoEstado = nuevoEstado;
		this.coste = coste;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ACCION:"+accion + "\n"+ nuevoEstado.getId() +"\nCOSTE:"+  coste;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Estado getNuevoEstado() {
		return nuevoEstado;
	}

	public void setNuevoEstado(Estado nuevoEstado) {
		this.nuevoEstado = nuevoEstado;
	}

	public int getCoste() {
		return coste;
	}

	public void setCoste(int coste) {
		this.coste = coste;
	}
	
	
	
	
}
