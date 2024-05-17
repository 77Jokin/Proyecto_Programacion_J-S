package test.daos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import modelo.dao.FacturaDao;
import modelo.dao.FacturaDaoImplMy8Jpa;
import modelo.entidades.Cliente;
import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Factura;
import modelo.entidades.Perfil;
import modelo.entidades.Proyecto;

public class TestFacturaDaoJpa {
	private static FacturaDao fdao;
	static {
		fdao = new FacturaDaoImplMy8Jpa();
	}
	public static void main(String[] args) {
		//alta();
		uno();
	}
	
	private static void alta() {
		@SuppressWarnings("deprecation")
		Factura fac = new Factura("F2020006", "Formacion a cliente 2", new Date(2021,10,25),
				new Proyecto("FOR2021011", new BigDecimal(50000), new BigDecimal(33000), "Formación en finanzas", "TERMINADO", 
						new Date(2024,05,10), new Date(2024,05,9), new Date(2021,9,15), new BigDecimal(40000), 
						new Cliente("111111111A", "Martinez Ruiz", "Sevilla", new BigDecimal("21000.50"), "Pablo", 3), 
						new Empleado(103, "Perez", "marta@tt.com", new Date(2020, 05, 11), new Date(1995, 11, 22), "M", "Marta", "marta", new BigDecimal(50000), 
								new Departamento(40, "Financiero", "Sevilla"), 
								new Perfil(1, "Control de Gestión", new BigDecimal(120)), new ArrayList<>())));
		System.out.println("SE HA AÑADIDO:" + fdao.altaFactura(fac));
			fdao.findById("F2020006");
			System.out.println(fac.getIdFactura() + " --> " + fac.getDescripcion());
	}
	
	private static void uno() {
		Factura fac = fdao.findById("F2020004");
		System.out.println("\nFactura buscada:");
		System.out.println(" -> " + fac);
	}

}
