package Dominio;

public class Movimiento {

	String id;

	// Grado = true -->90
	// Grado = false -->-90
	public Cubo MovimientoL(Cubo cuboInicial, int columnaAgirar) {
		System.out.println("ACCION: L"+columnaAgirar);
		Cubo nuevoCubo = cuboInicial.clonar();

		if (columnaAgirar == 0) { // Estamos en la primera columna

			nuevoCubo.getMatriz()[Cara.LEFT.cara()]=Utilidad.getU().rotarMatriz(cuboInicial.getMatriz()[Cara.LEFT.cara()]);

		} else if (columnaAgirar == cuboInicial.getDimension() - 1) {// Estamos en la columna final
			nuevoCubo.getMatriz()[Cara.RIGHT.cara()]= Utilidad.getU().rotarMatriz(cuboInicial.getMatriz()[Cara.RIGHT.cara()]);
		}

		Utilidad.getU().sustituirColumna(nuevoCubo.getMatriz()[Cara.DOWN.cara()], 
				Utilidad.getU().cogerColumna(cuboInicial.getMatriz()[Cara.FRONT.cara()], columnaAgirar), columnaAgirar);
		Utilidad.getU().sustituirColumna(nuevoCubo.getMatriz()[Cara.BACK.cara()], 
				Utilidad.getU().cogerColumna(cuboInicial.getMatriz()[Cara.DOWN.cara()], columnaAgirar), columnaAgirar);
		
		Utilidad.getU().sustituirColumna(nuevoCubo.getMatriz()[Cara.UP.cara()], 
				Utilidad.getU().invertirArray(Utilidad.getU().cogerColumna(cuboInicial.getMatriz()[Cara.BACK.cara()], columnaAgirar)), cuboInicial.getDimension()-1-columnaAgirar);
		
		Utilidad.getU().sustituirColumna(nuevoCubo.getMatriz()[Cara.FRONT.cara()], 
				Utilidad.getU().invertirArray(Utilidad.getU().cogerColumna(cuboInicial.getMatriz()[Cara.UP.cara()], cuboInicial.getDimension()-columnaAgirar-1)), columnaAgirar);


		return nuevoCubo;

	}
	
	public Cubo Movimientol(Cubo cuboInicial, int columnaAgirar) {
		System.out.println("ACCION: l"+columnaAgirar);
		Cubo nuevoCubo = cuboInicial.clonar();

		if (columnaAgirar == 0) { // Estamos en la primera columna

			nuevoCubo.getMatriz()[Cara.LEFT.cara()]=Utilidad.getU().rotarMatriz(cuboInicial.getMatriz()[Cara.LEFT.cara()]);

		} else if (columnaAgirar == cuboInicial.getDimension() - 1) {// Estamos en la columna final
			nuevoCubo.getMatriz()[Cara.RIGHT.cara()]=Utilidad.getU().rotarMatriz(cuboInicial.getMatriz()[Cara.RIGHT.cara()]);
		}

		Utilidad.getU().sustituirColumna(nuevoCubo.getMatriz()[Cara.DOWN.cara()], 
				Utilidad.getU().cogerColumna(cuboInicial.getMatriz()[Cara.BACK.cara()], columnaAgirar), columnaAgirar);
		Utilidad.getU().sustituirColumna(nuevoCubo.getMatriz()[Cara.FRONT.cara()], 
				Utilidad.getU().cogerColumna(cuboInicial.getMatriz()[Cara.DOWN.cara()], columnaAgirar), columnaAgirar);
		Utilidad.getU().sustituirColumna(nuevoCubo.getMatriz()[Cara.UP.cara()], 
				Utilidad.getU().invertirArray(Utilidad.getU().cogerColumna(cuboInicial.getMatriz()[Cara.FRONT.cara()], columnaAgirar)), cuboInicial.getDimension()-columnaAgirar-1);
		Utilidad.getU().sustituirColumna(nuevoCubo.getMatriz()[Cara.BACK.cara()], 
				Utilidad.getU().invertirArray(Utilidad.getU().cogerColumna(cuboInicial.getMatriz()[Cara.UP.cara()], cuboInicial.getDimension()-columnaAgirar-1)), columnaAgirar);


		return nuevoCubo;

	}

	public Cubo MovimientoD(Cubo cuboInicial, int filaAgirar) {
		System.out.println("ACCION: D"+filaAgirar);
		Cubo nuevoCubo = cuboInicial.clonar();

		if (filaAgirar == 0) { // Estamos en la primera columna

			nuevoCubo.getMatriz()[Cara.DOWN.cara()]=Utilidad.getU().rotarMatriz(cuboInicial.getMatriz()[Cara.DOWN.cara()]);

		} else if (filaAgirar == cuboInicial.getDimension() - 1) {// Estamos en la columna final
			nuevoCubo.getMatriz()[Cara.UP.cara()]=Utilidad.getU().rotarMatriz(nuevoCubo.getMatriz()[Cara.UP.cara()]);
		}

		
		Utilidad.getU().sustituirFila(nuevoCubo.getMatriz()[Cara.BACK.cara()],
				Utilidad.getU().invertirArray(
						Utilidad.getU().cogerColumna(cuboInicial.getMatriz()[Cara.LEFT.cara()], cuboInicial.getDimension()-1-filaAgirar)),
				cuboInicial.getDimension()-1-filaAgirar);
		
		Utilidad.getU().sustituirColumna(nuevoCubo.getMatriz()[Cara.RIGHT.cara()],
				Utilidad.getU().cogerFila(cuboInicial.getMatriz()[Cara.BACK.cara()], cuboInicial.getDimension()-1-filaAgirar), filaAgirar);
		
		
		Utilidad.getU().sustituirFila(nuevoCubo.getMatriz()[Cara.FRONT.cara()],
				Utilidad.getU().invertirArray(
						Utilidad.getU().cogerColumna(cuboInicial.getMatriz()[Cara.RIGHT.cara()], filaAgirar)),
				filaAgirar);
		
		Utilidad.getU().sustituirColumna(nuevoCubo.getMatriz()[Cara.LEFT.cara()],
				Utilidad.getU().cogerFila(cuboInicial.getMatriz()[Cara.FRONT.cara()], filaAgirar),  cuboInicial.getDimension()-1-filaAgirar);

		return nuevoCubo;

	}

	public Cubo Movimientod(Cubo cuboInicial, int filaAgirar) {
		System.out.println("ACCION d"+filaAgirar);
		Cubo nuevoCubo = cuboInicial.clonar();
		if (filaAgirar == 0) { // Estamos en la primera columna

			nuevoCubo.getMatriz()[Cara.DOWN.cara()]=Utilidad.getU().rotarMatrizInversa(cuboInicial.getMatriz()[Cara.DOWN.cara()]);

		} else if (filaAgirar == cuboInicial.getDimension() - 1) {// Estamos en la columna final
			nuevoCubo.getMatriz()[Cara.UP.cara()]=Utilidad.getU().rotarMatrizInversa(cuboInicial.getMatriz()[Cara.UP.cara()]);
		}

		Utilidad.getU().sustituirColumna(nuevoCubo.getMatriz()[Cara.RIGHT.cara()], Utilidad.getU().invertirArray(
				Utilidad.getU().cogerFila(cuboInicial.getMatriz()[Cara.FRONT.cara()], filaAgirar)), filaAgirar);
		
		Utilidad.getU().sustituirFila(nuevoCubo.getMatriz()[Cara.BACK.cara()],
				Utilidad.getU().cogerColumna(cuboInicial.getMatriz()[Cara.RIGHT.cara()],filaAgirar), cuboInicial.getDimension()-filaAgirar-1);
		
		Utilidad.getU().sustituirColumna(nuevoCubo.getMatriz()[Cara.LEFT.cara()], 
				Utilidad.getU().invertirArray(
				Utilidad.getU().cogerFila(cuboInicial.getMatriz()[Cara.BACK.cara()], cuboInicial.getDimension()-filaAgirar-1)), cuboInicial.getDimension()-filaAgirar-1);
		
		Utilidad.getU().sustituirFila(nuevoCubo.getMatriz()[Cara.FRONT.cara()],
				Utilidad.getU().cogerColumna(cuboInicial.getMatriz()[Cara.LEFT.cara()], cuboInicial.getDimension()-filaAgirar-1), filaAgirar);

		return nuevoCubo;

	}
	
	
	public Cubo MovimientoB(Cubo cuboInicial, int filaAgirar) {
		System.out.println("ACCION B"+filaAgirar);
		Cubo nuevoCubo = cuboInicial.clonar();

		if (filaAgirar == 0) { // Estamos en la primera columna

			nuevoCubo.getMatriz()[Cara.BACK.cara()]=Utilidad.getU().rotarMatriz(cuboInicial.getMatriz()[Cara.BACK.cara()]);

		} else if (filaAgirar == cuboInicial.getDimension() - 1) {// Estamos en la columna final
			nuevoCubo.getMatriz()[Cara.FRONT.cara()]=Utilidad.getU().rotarMatriz(cuboInicial.getMatriz()[Cara.FRONT.cara()]);
		}

		Utilidad.getU().sustituirFila(nuevoCubo.getMatriz()[Cara.DOWN.cara()],
				Utilidad.getU().cogerFila(cuboInicial.getMatriz()[Cara.LEFT.cara()],filaAgirar), filaAgirar);
		
		Utilidad.getU().sustituirFila(nuevoCubo.getMatriz()[Cara.RIGHT.cara()],
				Utilidad.getU().cogerFila(cuboInicial.getMatriz()[Cara.DOWN.cara()],filaAgirar), filaAgirar);
		
		Utilidad.getU().sustituirFila(nuevoCubo.getMatriz()[Cara.UP.cara()],
				Utilidad.getU().cogerFila(cuboInicial.getMatriz()[Cara.RIGHT.cara()],filaAgirar), filaAgirar);
		
		Utilidad.getU().sustituirFila(nuevoCubo.getMatriz()[Cara.LEFT.cara()],
				Utilidad.getU().cogerFila(cuboInicial.getMatriz()[Cara.UP.cara()],filaAgirar), filaAgirar);
		

		return nuevoCubo;

	}

	
	public Cubo Movimientob(Cubo cuboInicial, int filaAgirar) {
		
		System.out.println("ACCION b"+filaAgirar);
		
		Cubo nuevoCubo = cuboInicial.clonar();

		if (filaAgirar == 0) { // Estamos en la primera columna

			nuevoCubo.getMatriz()[Cara.BACK.cara()] = Utilidad.getU().rotarMatrizInversa(cuboInicial.getMatriz()[Cara.BACK.cara()]);

		} else if (filaAgirar == cuboInicial.getDimension() - 1) {// Estamos en la columna final
			nuevoCubo.getMatriz()[Cara.FRONT.cara()]=Utilidad.getU().rotarMatrizInversa(cuboInicial.getMatriz()[Cara.FRONT.cara()]);
		}

		Utilidad.getU().sustituirFila(nuevoCubo.getMatriz()[Cara.RIGHT.cara()],
				Utilidad.getU().cogerFila(cuboInicial.getMatriz()[Cara.UP.cara()],filaAgirar), filaAgirar);
		
		Utilidad.getU().sustituirFila(nuevoCubo.getMatriz()[Cara.DOWN.cara()],
				Utilidad.getU().cogerFila(cuboInicial.getMatriz()[Cara.RIGHT.cara()],filaAgirar), filaAgirar);
		
		Utilidad.getU().sustituirFila(nuevoCubo.getMatriz()[Cara.LEFT.cara()],
				Utilidad.getU().cogerFila(cuboInicial.getMatriz()[Cara.DOWN.cara()],filaAgirar), filaAgirar);
		
		Utilidad.getU().sustituirFila(nuevoCubo.getMatriz()[Cara.UP.cara()],
				Utilidad.getU().cogerFila(cuboInicial.getMatriz()[Cara.LEFT.cara()],filaAgirar), filaAgirar);
		

		return nuevoCubo;

	}

	@Override
	public String toString() {
		return id;
	}
}
