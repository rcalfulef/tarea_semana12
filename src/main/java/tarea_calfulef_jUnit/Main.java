package tarea_calfulef_jUnit;

public class Main {
	
	public static void main(String[] args) {
	Cuenta cuenta = new Cuenta();
	
	System.out.println("Inicio sesion");
	cuenta.iniciarSesion();
	
	System.out.println("Realizando deposito de $5.000 pesos");
	cuenta.depositoPesos(5000);
	
	System.out.println("Realizando deposito de $15 dolares");
	cuenta.depositoDolares(15);
	
	System.out.println("Realizando giro de $200 pesos");
	cuenta.retiroPesos(200);
	
	System.out.println("Realizando giro de $1 dolar");
	cuenta.retiroDolares(1);
	
	System.out.print("Intentando realizar un giro de $1 dolar, Respuesta: ");
	cuenta.retiroDolares(1);
	
	System.out.println("Cerrando sesion para volver a realizar una transaccion");
	cuenta.cerrarSesion();
	
	System.out.println("Inicio sesion, nuevamente");
	cuenta.iniciarSesion();
	
	System.out.println("Realizando deposito de $5.000 pesos");
	cuenta.depositoPesos(5000);
	
	System.out.println("Transacciones");
	cuenta.verTransacciones();
	}

}
