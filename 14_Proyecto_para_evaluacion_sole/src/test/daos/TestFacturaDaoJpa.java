package test.daos;

import modelo.dao.FacturaDao;
import modelo.dao.FacturaDaoImplMy8Jpa;
import modelo.entidades.Factura;

public class TestFacturaDaoJpa {
	private static FacturaDao fdao;
	static {
		fdao = new FacturaDaoImplMy8Jpa();
	}
	public static void main(String[] args) {
		//alta();
		uno();
	}
	
	//private static void alta() {
	//	Factura fac = new Factura("F2020006", "Formacion a cliente 2", "2021-10-25", "FOR2021005");
	//}
	
	private static void uno() {
		Factura fac = fdao.findById("F2020004");
		System.out.println("\nFactura buscada:");
		System.out.println(" -> " + fac);
	}

}
