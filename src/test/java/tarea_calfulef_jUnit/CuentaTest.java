package tarea_calfulef_jUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


public class CuentaTest {

	@BeforeEach
	protected void setUp() throws Exception {
		
	}
	
	@Test
	public void testCuentaInicial(){
		//GIVEN
		Cuenta cuenta = new Cuenta();
		cuenta.iniciarSesion();
		
		//WHEN
		int saldoPesos =  cuenta.getSaldoPesos();
		float saldoDolares =  cuenta.getSaldoDolares();
		cuenta.cerrarSesion();
		
		//THEN
		Assert.assertEquals("El saldo inicial deberia ser $1.000.000 Pesos",1000000, saldoPesos);
		Assert.assertEquals("El saldo incial deberia ser $1.000 USD",1000, saldoDolares, 0.0f);
	}
	
	@Test
	public void testCuentaRetiro() {
		//GIVEN
		Cuenta cuenta = new Cuenta();
		cuenta.iniciarSesion();
		
		//WHEN
		cuenta.retiroPesos(150000);
		cuenta.retiroDolares((float)50.0);
		int saldoPesos =  cuenta.getSaldoPesos();
		float saldoDolares =  cuenta.getSaldoDolares();
		cuenta.cerrarSesion();
		
		//THEN
		Assert.assertEquals("El saldo deberia ser $850.000 Pesos",850000, saldoPesos);
		Assert.assertEquals("El saldo deberia ser $945.5 USD", (float)950.0, saldoDolares, 0.0f);		
	}
	
	@Test
	public void testCuentaRetiroMaximo(){
		//GIVEN
		Cuenta cuenta = new Cuenta();
		cuenta.iniciarSesion();
		
		//WHEN
		cuenta.retiroPesos(200001);
		cuenta.retiroDolares((float)100.00001);
		int saldoPesos =  cuenta.getSaldoPesos();
		float saldoDolares =  cuenta.getSaldoDolares();
		cuenta.cerrarSesion();
		
		//THEN
		Assert.assertEquals("El saldo deberia ser $1.000.000 Pesos, ya que el retiro excede el monto maximo",1000000, saldoPesos);
		Assert.assertEquals("El saldo deberia ser $1.000 USD, ya que el retiro excede el monto maximo",1000, saldoDolares, 0.0f);	
	}

	@Test
	public void testCuentaDeposito() {
		//GIVEN
		Cuenta cuenta = new Cuenta();
		cuenta.iniciarSesion();
		
		//WHEN
		cuenta.depositoPesos(1);
		cuenta.depositoDolares((float)0.0000001);
		int saldoPesos =  cuenta.getSaldoPesos();
		float saldoDolares =  cuenta.getSaldoDolares();
		cuenta.cerrarSesion();
		
		//THEN
		Assert.assertEquals("El saldo deberia ser $1.000.001 Pesos", 1000001, saldoPesos);
		Assert.assertEquals("El saldo deberia ser $1.000,0000001 USD", (float)1000.0000001, saldoDolares, 0.0f);
	}
	
	@Test
	public void testCuentaDepositoNegativo() {
		//GIVEN
		Cuenta cuenta = new Cuenta();
		cuenta.iniciarSesion();
		
		//WHEN
		cuenta.depositoPesos(-1);
		cuenta.depositoDolares((float)-0.0001);
		int saldoPesos =  cuenta.getSaldoPesos();
		float saldoDolares =  cuenta.getSaldoDolares();
		cuenta.cerrarSesion();		
		
		//THEN
		Assert.assertEquals("El saldo deberia ser $1.000.000 Pesos, ya que no se aceptan montos negativos",1000000, saldoPesos);
		Assert.assertEquals("El saldo deberia ser $1.000 USD, ya que no se aceptan montos negativos",1000, saldoDolares, 0.0f);
	}
	
	@Test
	public void testCuentaRetiroNegativo() {
		//GIVEN
		Cuenta cuenta = new Cuenta();
		cuenta.iniciarSesion();
		
		//WHEN
		cuenta.retiroPesos(-1);
		cuenta.retiroDolares((float)-0.0001);
		int saldoPesos =  cuenta.getSaldoPesos();
		float saldoDolares =  cuenta.getSaldoDolares();
		cuenta.cerrarSesion();
		
		//THEN
		Assert.assertEquals("El saldo deberia ser $1.000.000 Pesos, ya que no se aceptan montos negativos",1000000, saldoPesos);
		Assert.assertEquals("El saldo deberia ser $1.000 USD, ya que no se aceptan montos negativos",1000, saldoDolares, 0.0f);	
	}
	
	@Test
	public void testCuentaMaxOperacionesPesos() {
		//GIVEN
		Cuenta cuenta = new Cuenta();
		cuenta.iniciarSesion();
		
		//WHEN
		cuenta.depositoPesos(1);
		cuenta.depositoDolares(1);
		cuenta.depositoPesos(1);
		cuenta.depositoDolares(1);
		cuenta.depositoPesos(1);
		int saldoPesos =  cuenta.getSaldoPesos();
		float saldoDolares =  cuenta.getSaldoDolares();
		
		cuenta.cerrarSesion();
		
		//THEN
		
		Assert.assertEquals("El saldo deberia ser $1.000.000, ya que solo se ejecuto hasta la 4ta transaccion ",1000002, saldoPesos);
		Assert.assertEquals("El saldo deberia ser $1.000 USD, ya que no se aceptan montos negativos",1002, saldoDolares, 0.0f);	
		
	}
	
	@Test
	public void testCuentaSeisOperaciones() {
		//GIVEN
		Cuenta cuenta = new Cuenta();
		cuenta.iniciarSesion();
		
		//WHEN
		cuenta.depositoPesos(1);
		cuenta.depositoDolares(1);
		cuenta.depositoPesos(1);
		cuenta.depositoDolares(1);
		
		cuenta.cerrarSesion();
		cuenta.iniciarSesion();
		cuenta.depositoPesos(1);
		cuenta.depositoDolares(1);
		
		int saldoPesos =  cuenta.getSaldoPesos();
		float saldoDolares =  cuenta.getSaldoDolares();
		
		cuenta.cerrarSesion();
		
		//THEN
		
		Assert.assertEquals("El saldo deberia ser $1.000.000, ya que solo se ejecuto hasta la 4ta transaccion ",1000003, saldoPesos);
		Assert.assertEquals("El saldo deberia ser $1.000 USD, ya que no se aceptan montos negativos",1003, saldoDolares, 0.0f);	
		
	}
	
	@Test
	public void testCuentasMostrarTransacciones() {
		//GIVEN
		Cuenta cuenta = new Cuenta();
		cuenta.iniciarSesion();
		
		//WHEN
		cuenta.depositoPesos(1);
		cuenta.depositoDolares(1);
		
		
				
	}
	

	

}
