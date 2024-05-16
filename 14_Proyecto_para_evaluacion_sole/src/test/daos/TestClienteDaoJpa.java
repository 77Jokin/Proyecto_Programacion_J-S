package test.daos;
import java.math.BigDecimal;


import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entidades.Cliente;

public class TestClienteDaoJpa {
	private static ClienteDao cdao;
	static {

		cdao = new ClienteDaoImplMy8Jpa();
	}
	
	public static void main(String[] args) {
		//alta();
		uno();
		//todos();
		//eliminar();
		//modificar();
	}
		 private static void alta() {
  	
  			Cliente cli = new Cliente("111111111A", "Martinez Ruiz", "Madrid", new BigDecimal("21000.50"), "Pablo", 3);
  			System.out.println("SE HA AÑADIDO:" + cdao.alta(cli));
  			cdao.buscarUno("111111111A");
  			System.out.println("\n" + cli.getNombre() + " " + cli.getApellidos());
  	
		 }


		 private static void uno() {
			 Cliente cli = cdao.buscarUno("A22222222");  // Carlos March
			 System.out.println("\nCliente buscado:");
			 System.out.println(" -> " + cli.getNombre() + " " + cli.getApellidos());
  	
		 }
  
		 private static void todos() {
			 System.out.println("\nLista clientes:");
			 cdao.buscarTodos().forEach(System.out::println);
		 }
  
		 private static void eliminar() {
			 cdao.eliminar("111111111A"); // Pablo Martinez Ruiz, 111111111A
			 cdao.buscarTodos().forEach(System.out::println);
		 }
		 
		 private static void modificar() {
			 Cliente cli = cdao.buscarUno("111111111A"); // Pablo Martinez Ruiz, Madrid, 111111111A
			 cli.setApellidos("Vazquez");
			 cli.setDomicilio("Londres");
			 System.out.println(cdao.modificar(cli));
			 System.out.println(cdao.buscarUno("111111111A")); // Pablo Vazquez, Londres, 111111111A

		 }
	

}