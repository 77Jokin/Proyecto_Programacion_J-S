package test.daos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Cliente;
import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;
import modelo.entidades.Proyecto;

public class TestProyectoDaoJpa {
	private static ProyectoDao pdao;
	static {
		pdao = new ProyectoDaoImplMy8Jpa();
	}
	public static void main(String[] args) {
		//alta();
		uno();
		//todos();
		//eliminar();
		//modificar();

	}
	private static void alta() {
	  	
			@SuppressWarnings("deprecation")
			Proyecto pro = new Proyecto("FOR2021011", new BigDecimal(50000), new BigDecimal(33000), "Formación en finanzas", "TERMINADO", 
							new Date(2024,05,10), new Date(2024,05,9), new Date(2021,9,15), new BigDecimal(40000), 
							new Cliente("111111111A", "Martinez Ruiz", "Sevilla", new BigDecimal("21000.50"), "Pablo", 3), 
							new Empleado(103, "Perez", "marta@tt.com", new Date(2020, 05, 11), new Date(1995, 11, 22), "M", "Marta", "marta", new BigDecimal(50000), 
									new Departamento(40, "Financiero", "Sevilla"), 
									new Perfil(1, "Control de Gestión", new BigDecimal(120)), new ArrayList<>()));
			
			System.out.println("SE HA AÑADIDO:" + pdao.alta(pro));
			pdao.buscarUno("FOR2021011");
			System.out.println("\n" + pro.getIdProyecto() + " -> " + pro.getEmpleado());
	
	 }


	 private static void uno() {
		 Proyecto pro = pdao.buscarUno("FOR2021000");
		 System.out.println("\nProyecto buscado:");
		 System.out.println("\n" + pro.getIdProyecto() + " -> " + pro.getEmpleado());
	
	 }

	 private static void todos() {
		 System.out.println("\nLista proyectos:");
		 pdao.buscarTodos().forEach(System.out::println);
	 }

	 private static void eliminar() {
		 pdao.eliminar("FOR2021011"); 
		 pdao.buscarTodos().forEach(System.out::println);
	 }
	 
	 private static void modificar() {
		 Proyecto pro = pdao.buscarUno("FOR2021001"); 
		 pro.setEstado("TERMINADO");
		 System.out.println(pdao.modificar(pro));
		 System.out.println(pdao.buscarUno("FOR2021001")); 

	 }

}
