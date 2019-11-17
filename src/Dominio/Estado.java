package Dominio;

public class Estado {
	
	String id;
	Cubo cubo;
	
	public Estado(Cubo cubo) {
		this.id=cubo.pasarMD5();
		this.cubo=cubo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Cubo getCubo() {
		return cubo;
	}

	public void setCubo(Cubo cubo) {
		this.cubo = cubo;
	}
	
	
	@Override
	public String toString() {
		
		return id;
		
	}
}
