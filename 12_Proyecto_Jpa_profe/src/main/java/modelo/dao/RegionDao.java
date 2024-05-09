package modelo.dao;

import java.util.List;

import modelo.entidades.Region;

public interface RegionDao extends IntGenericoCrud<Integer, Region>{
	
	
	List<Region> findByNameContains(String cadena);

}
