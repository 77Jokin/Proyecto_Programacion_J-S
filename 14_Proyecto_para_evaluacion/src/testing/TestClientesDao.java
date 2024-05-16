package testing;


import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.dao.ClienteDao;
import modelo.entidades.Cliente;

public class TestClientesDao {
	private static ClienteDao cdao;
	
	static {
		cdao = new ClienteDaoImplMy8Jpa();
	}
	
	public static void main(String[] args) {
			
			//uno();
			//todos();
		//	alta();
		//	eliminar();
		  	modi();
		}
	
	public static void modi() {
		Cliente c = cdao.buscarUno("ZZ");
		
	//	c.setCountryName("Zarzaparrilla");
	//	c.getRegion().setRegionId(4);
		System.out.println(cdao.modificar(c));
		
//		System.out.println(cdao.buscarUno("ZZ"));
		
	}
	public static void alta() {
		Cliente c = new Cliente("ZZ", "Zarza Zuli", cdao.buscarUno(1));
		System.out.println(cdao.alta(c));
		
	}
	
	public static void uno() {
		Cliente pais = cdao.buscarUno("AR");
		System.out.println(pais.getNumeroEmpleados());
	}
	public static void todos() {
		cdao.buscarTodos().forEach(System.out::println);
	}
	
	
	
	
	
	
	
	
	}
