package test.daos;

import java.math.BigDecimal;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entidades.Cliente;

public class TestClientesDao {
	private static ClienteDao cdao;
	
	static {
		cdao = new ClienteDaoImplMy8Jpa();
	}
	
	public static void main(String[] args) {
			
		 // uno();
		 // todos();
		 // alta();
		 // eliminar();
		  modi();
		}
	private static void alta() {
		Cliente cli = new Cliente("111111111A", "Martinez Ruiz", "Madrid", new BigDecimal("21000.50"), "Pablo", 3);
  		System.out.println("SE HA AÑADIDO:" + cdao.alta(cli));
		cdao.buscarUno("111111111A");
		System.out.println("\n" + cli.getNombre() + " " + cli.getApellidos());
	}


	private static void uno() {
		Cliente cli = cdao.buscarUno("A22222222");  
		System.out.println("\nCliente buscado:");
		System.out.println(" -> " + cli.getNombre() + " " + cli.getApellidos());
	
	}

	private static void todos() {
		System.out.println("\nLista clientes:");
		cdao.buscarTodos().forEach(System.out::println);
	}

	private static void eliminar() {
		cdao.eliminar("111111111A"); 
		cdao.buscarTodos().forEach(System.out::println);
	}
	
	private static void modi() {
		Cliente cli = cdao.buscarUno("A22222222");
		cli.setDomicilio("Madrid");
		System.out.println(cdao.modificar(cli));
		System.out.println(cdao.buscarUno("A22222222"));
		
	}
	
	
}
