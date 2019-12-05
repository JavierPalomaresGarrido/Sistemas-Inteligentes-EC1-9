package Dominio;


import java.util.ArrayList;

public class EspacioDeEstados {

	private String[] ordenMovimientos= {"B","b","D","d","L","l"};
	
	//Este método crea los sucesores (accion,nuevoEstado,coste) usando el vector ordenMovimientos
	//que indica el tipo de movimiento y por cada elemento en el vector ordenMovimientos
	//realizar ese mismo movimiento tantas veces como dimension tenga el cubo
	public ArrayList<Sucesor> crearSucesores(Estado e) {
		
		ArrayList<Sucesor> sucesores = new ArrayList<Sucesor>();
		//TODO: OPTIMIZAR CON UN BUCLE WHILE Y CON UNA LISTA ORDENADA DE MOVIMIENTOS
		
		for (int i = 0; i < ordenMovimientos.length; i++) {
			sucesores.addAll(aplicarMovimiento(ordenMovimientos[i], e));
		}
		
		
//		for (int i = 0; i < e.getCubo().getDimension(); i++) {
//			sucesores.add(new Sucesor("B"+i,new Estado(Movimiento.getM().MovimientoB(e.getCubo(), i)),1));
//		}
//		for (int i = 0; i < e.getCubo().getDimension(); i++) {
//			sucesores.add(new Sucesor("b"+i,new Estado(Movimiento.getM().Movimientob(e.getCubo(), i)),1));
//		}
//		for (int i = 0; i < e.getCubo().getDimension(); i++) {
//			sucesores.add(new Sucesor("D"+i,new Estado(Movimiento.getM().MovimientoD(e.getCubo(), i)),1));
//		}
//		for (int i = 0; i < e.getCubo().getDimension(); i++) {
//			sucesores.add(new Sucesor("d"+i,new Estado(Movimiento.getM().Movimientod(e.getCubo(), i)),1));
//		}
//		for (int i = 0; i < e.getCubo().getDimension(); i++) {
//			sucesores.add(new Sucesor("L"+i,new Estado(Movimiento.getM().MovimientoL(e.getCubo(), i)),1));
//		}
//		for (int i = 0; i < e.getCubo().getDimension(); i++) {
//			sucesores.add(new Sucesor("l"+i,new Estado(Movimiento.getM().Movimientol(e.getCubo(), i)),1));
//					}
		return sucesores;
	}
	
	private ArrayList<Sucesor> aplicarMovimiento(String tipo, Estado e){
		ArrayList<Sucesor> listaSucesores = new ArrayList<Sucesor>();
		
		for (int i = 0; i < e.getCubo().getDimension(); i++) {
			
			switch (tipo) {
			case "B":
				listaSucesores.add(new Sucesor("B"+i,new Estado(Movimiento.getM().MovimientoB(e.getCubo(), i)),1));
				break;
			case "b":
				listaSucesores.add(new Sucesor("b"+i,new Estado(Movimiento.getM().Movimientob(e.getCubo(), i)),1));
				break;
			case "D":
				listaSucesores.add(new Sucesor("D"+i,new Estado(Movimiento.getM().MovimientoD(e.getCubo(), i)),1));
				break;
			case "d":
				listaSucesores.add(new Sucesor("d"+i,new Estado(Movimiento.getM().Movimientod(e.getCubo(), i)),1));
				break;
			case "L":
				listaSucesores.add(new Sucesor("L"+i,new Estado(Movimiento.getM().MovimientoL(e.getCubo(), i)),1));
				break;
			case "l":
				listaSucesores.add(new Sucesor("l"+i,new Estado(Movimiento.getM().Movimientol(e.getCubo(), i)),1));
				break;
			default:
				break;
			}
		}
		
		return listaSucesores;
	}
	
}
