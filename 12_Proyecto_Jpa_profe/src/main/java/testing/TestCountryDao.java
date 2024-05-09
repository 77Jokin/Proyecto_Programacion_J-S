package testing;

import modelo.dao.CountryDao;
import modelo.dao.CountryDaoImplMy8Jpa;
import modelo.dao.RegionDao;
import modelo.dao.RegionDaoImplMy8Jpa;
import modelo.entidades.Country;

public class TestCountryDao {
	private static CountryDao cdao;
	private static RegionDao rdao;
	
	static {
		cdao = new CountryDaoImplMy8Jpa();
		rdao = new RegionDaoImplMy8Jpa();
	}

	public static void main(String[] args) {
		
		//uno();
		//todos();
	//	porPais();
	//	contiene();
	//	alta();
	//	eliminar();
	  	modi();
	 //	modi2();
	}	
	
	public static void modi2() {
//		Country c = cdao.buscarUno("ZZ");
		Country c = new Country("ZZ", "Zarza Zuli", rdao.buscarUno(1));
		c.getRegion().setRegionId(4);
		
	//	c.setCountryName("Zarzaparrilla");
	//	c.getRegion().setRegionId(4);
		System.out.println(((CountryDaoImplMy8Jpa)cdao).modificar2(c));
		
//		System.out.println(cdao.buscarUno("ZZ"));
		
	}
	
	public static void modi() {
//		Country c = cdao.buscarUno("ZZ");
		Country c = new Country("ZZ", "Zarza Zuli", rdao.buscarUno(1));
		c.getRegion().setRegionId(3);
		
	//	c.setCountryName("Zarzaparrilla");
	//	c.getRegion().setRegionId(4);
		System.out.println(cdao.modificar(c));
		
//		System.out.println(cdao.buscarUno("ZZ"));
		
	}
	
	public static void alta() {
		Country c = new Country("ZZ", "Zarza Zuli", rdao.buscarUno(1));
		System.out.println(cdao.alta(c));
		cdao.buscarPaisesPorRegion(1).forEach(System.out::println);
		
	}
	public static void contiene() {
		cdao.findByContryNameContaining("ra").forEach(System.out::println);
		
	}
		
	public static void porPais() {
		cdao.buscarPaisesPorRegion(1).forEach(System.out::println);
		
	}
	public static void uno() {
			Country pais = cdao.buscarUno("AR");
			System.out.println(pais.getCountryName());
			System.out.println(pais.getRegion().getRegionName());
		}
		public static void todos() {
			cdao.buscarTodos().forEach(System.out::println);
		}
		

	}


