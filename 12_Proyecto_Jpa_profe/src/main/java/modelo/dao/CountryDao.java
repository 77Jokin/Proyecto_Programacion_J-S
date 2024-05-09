package modelo.dao;

import java.util.List;

import modelo.entidades.Country;



public interface CountryDao extends IntGenericoCrud<String, Country>{
	
	List<Country> buscarPaisesPorRegion(int regionId);
	List<Country> findByContryNameContaining(String cadena);

}
