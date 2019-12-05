package Dominio;

public class Problema {

	private EspacioDeEstados espacioEstados;
	private Estado estadoInicial;
	
	
	public Problema(String json) {
		LecturaJSON lectura = new LecturaJSON();
		Cubo c= lectura.leerJson(json);
		
		this.estadoInicial = new Estado(c);
		this.espacioEstados = new EspacioDeEstados();
	}


	//FUNCION QUE COMPRUEBA QUE EL CUBO ES PERFECTO
	public boolean esObjetivo(Estado e) {
		boolean salir = false;
		int primeroElemento = 0;
		//RECORRE CARAS
		for (int i = 0; i < e.getCubo().getMatriz().length && !salir; i++) {
			
			//Se selecciona el elemento de la esquina superior izquierda
			primeroElemento = e.getCubo().getMatriz()[i][0][0];
			
			for (int j = 0; j < e.getCubo().getMatriz()[0].length && !salir; j++) {
				
				for (int k = 0; k < e.getCubo().getMatriz()[i][j].length && !salir; k++) {
					
					if(e.getCubo().getMatriz()[i][j][k] != primeroElemento) {
						salir = true;
					}
				}
			}
		}
		
		return !salir;
	}


	public EspacioDeEstados getEspacioEstados() {
		return espacioEstados;
	}


	public void setEspacioEstados(EspacioDeEstados espacioEstados) {
		this.espacioEstados = espacioEstados;
	}


	public Estado getEstadoInicial() {
		return estadoInicial;
	}


	public void setEstadoInicial(Estado estadoInicial) {
		this.estadoInicial = estadoInicial;
	}
	
	
}
