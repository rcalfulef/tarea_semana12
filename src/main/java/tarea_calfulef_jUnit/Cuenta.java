package tarea_calfulef_jUnit;

import java.util.ArrayList;

public class Cuenta {
	private int saldoPesos;
	private float saldoDolares;
	private int cantOperaciones;
	private ArrayList<String> transacciones;
	
	public Cuenta() {
		this.saldoPesos = 1000000;
		this.saldoDolares = 1000;
		this.cantOperaciones = -1;
		transacciones = new ArrayList<String>();
	}
	
	public int getSaldoPesos() {
		return saldoPesos;
	}
	
	public float getSaldoDolares() {
		return saldoDolares;
	}
	
	public void retiroPesos(int monto) {
		if(this.cantOperaciones < 1) {
			System.out.println("No puede realizar mas transacciones, vuelva a iniciar sesion");
			return;
		}
		
		if(monto> 200000) {
			System.out.println("El monto maximo que se puede retirar es $200.000 Pesos");
			return;
		}
		if(monto< 0) {
			System.out.println("No se aceptan montos negativos");
			return;
		}
		
		this.saldoPesos -= monto;
		this.cantOperaciones-=1;
		this.transacciones.add(String.format("[%d CLP, %f USD]", this.saldoPesos, this.saldoDolares));
	}
	
	public void retiroDolares(float monto) {
		if(this.cantOperaciones < 1) {
			System.out.println("No puede realizar mas transacciones, vuelva a iniciar sesion");
			return;
		}
		if(monto > (float)100.0) {
			System.out.println("El monto maximo que se puede retirar es $100 USD");
			return;
		}
		if(monto< 0) {
			System.out.println("No se aceptan montos negativos");
			return;
		}
		
		this.saldoDolares -= monto;
		this.cantOperaciones-=1;
		this.transacciones.add(String.format("[%d CLP, %f USD]", this.saldoPesos, this.saldoDolares));
	}
	
	public void depositoPesos(int monto) {
		if(this.cantOperaciones < 1) {
			System.out.println("No puede realizar mas transacciones, vuelva a iniciar sesion");
			return;
		}
		if(monto< 0) {
			System.out.println("No se aceptan montos negativos");
			return;
		}
		this.saldoPesos += monto;
		this.cantOperaciones-=1;
		this.transacciones.add(String.format("[%d CLP, %f USD]", this.saldoPesos, this.saldoDolares));
	}
	
	public void depositoDolares(float monto) {
		if(this.cantOperaciones < 1) {
			System.out.println("No puede realizar mas transacciones, vuelva a iniciar sesion");
			return;
		}
		if(monto< 0) {
			System.out.println("No se aceptan montos negativos");
			return;
		}
		this.saldoDolares += monto;
		this.cantOperaciones-=1;
		this.transacciones.add(String.format("[%d CLP, %f USD]", this.saldoPesos, this.saldoDolares));
	}
	
	public void iniciarSesion() {
		this.cantOperaciones = 4;
	}
	
	public void cerrarSesion() {
		this.cantOperaciones = -1;
	}
	
	public void verTransacciones() {
		for(int i=0; i < this.transacciones.size(); i++) {
			System.out.println(this.transacciones.get(i));
		}
	}
		
}