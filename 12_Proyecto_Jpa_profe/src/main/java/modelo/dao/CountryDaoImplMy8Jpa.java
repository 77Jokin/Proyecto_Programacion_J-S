package modelo.dao;

import java.util.List;

import modelo.entidades.Country;
import modelo.entidades.Region;

public class CountryDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa 
								implements CountryDao{
	
	
	
	public CountryDaoImplMy8Jpa() {
		super();
	}

	@Override
	public boolean alta(Country obj) {
		try {
			tx.begin();
				em.persist(obj);
			tx.commit();
			return true;
		}catch(Exception e) {
		//	e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
			
		}
		
	}

	@Override
	public boolean eliminar(String clave) {
		try {
			Country country = buscarUno(clave);
			if (country != null) {
				tx.begin();
					em.remove(country);
				tx.commit();
				return true;
			}else
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean modificar(Country obj) {
		try {
	 		Country country = buscarUno(obj.getCountryId());
			if (country != null) {
				tx.begin();
					em.persist(country);
				tx.commit();
				return true;
			}else
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Country buscarUno(String clave) {
		// TODO Auto-generated method stub
		return em.find(Country.class, clave);
	}

	 
	@SuppressWarnings("unchecked")
	@Override
	public List<Country> buscarTodos() {
		jpql = "select c from Country c";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Country> buscarPaisesPorRegion(int regionId) {
	//	jpql= "select c from Country c where c.region.regionId = ?1";
	 	jpql= "select c from Country c where c.region.regionId = :reg";
		
		query = em.createQuery(jpql);
	//	query.setParameter(1, regionId);
	 	query.setParameter("reg", regionId);
		return query.getResultList();
		
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Country> findByContryNameContaining(String cadena) {
		jpql= "select c from Country c where c.countryName like :patron";
		
		query = em.createQuery(jpql);
	//	query.setParameter(1, regionId);
	 	query.setParameter("patron", "%" + cadena + "%");
		return query.getResultList();
	}
	
	public boolean modificar2(Country obj) {
		try {
	 		Country country = buscarUno(obj.getCountryId());
			if (country != null) {
				tx.begin();
					em.persist(country);
				tx.commit();
				return true;
			}else
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
