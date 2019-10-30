package Dominio;

public class Principal {

	
	public static void main(String [] args) {
		

		LecturaJSON lectura = new LecturaJSON();
		Cubo c= lectura.leerJson("src/Pruebas/Cubo10x10.json");
		System.out.println(c.toString());
		
		
     	Cubo cl3= new Movimiento().Movimientol(c, 3);
     	System.out.println(cl3);
     	Cubo cD1 = new Movimiento().MovimientoD(cl3,1);
     	System.out.println(cD1);
     	Cubo cl1 = new Movimiento().Movimientol(cD1, 1);
     	System.out.println(cl1);
     	Cubo cd0 = new Movimiento().Movimientod(cl1, 0);
     	System.out.println(cd0);
     	Cubo cB0 = new Movimiento().MovimientoB(cd0, 0);
     	System.out.println(cB0);
     	Cubo cb5 = new Movimiento().Movimientob(cB0, 5);
     	System.out.println(cb5);
    	Cubo cl2= new Movimiento().Movimientol(cb5, 2);
     	System.out.println(cl2);
    	Cubo cd1 = new Movimiento().Movimientod(cl2, 1);
     	System.out.println(cd1);
     	
     	
 	
     
	}
	

 
}
