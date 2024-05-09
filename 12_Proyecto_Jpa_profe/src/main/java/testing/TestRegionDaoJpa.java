package testing;

import modelo.dao.RegionDao;
import modelo.dao.RegionDaoImplMy8Jpa;
import modelo.entidades.Region;

public class TestRegionDaoJpa {
	
	private static RegionDao rdao;
	
	static {
		rdao = new RegionDaoImplMy8Jpa();
	}
	
	public static void main(String[] args) {
	//	todos();
	//	uno();
		alta();
		
		
	}
	public static void alta() {
		Region region = new Region(5,"Castilla");
		System.out.println(rdao.alta(region));
		todos();
		
		
	}
	public static void uno() {
		System.out.println("BUCAR UNO");
		System.out.println(rdao.buscarUno(2));
		System.out.println(rdao.buscarUno(90));
		
		
	}
	public static void todos() {
		System.out.println("BUCAR TODOS");
		rdao.buscarTodos().forEach(System.out::println);
		
		
		
	}

}
