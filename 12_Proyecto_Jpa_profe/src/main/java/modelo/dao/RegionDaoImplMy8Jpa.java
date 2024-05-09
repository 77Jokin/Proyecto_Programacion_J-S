package modelo.dao;

import java.util.List;

import modelo.entidades.Region;

public class RegionDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements RegionDao{

	@Override
	public boolean alta(Region obj) {
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		 
		
	}

	@Override
	public boolean eliminar(Integer clave) {
		try {
			Region region = buscarUno(clave);
			if (region != null) {
				tx.begin();
					em.remove(region);
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
	public boolean modificar(Region obj) {
		try {
			if (buscarUno(obj.getRegionId()) != null) {
				tx.begin();
					em.merge(obj);
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
	public Region buscarUno(Integer clave) {
		// TODO Auto-generated method stub
		return em.find(Region.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Region> buscarTodos() {
		jpql = "select r from Region r ";
		return em
				.createQuery(jpql)
				.getResultList();
	//	query = em.createQuery(jpql);
	//	return query.getResultList();
	}

	@Override
	public List<Region> findByNameContains(String cadena) {
		// TODO Auto-generated method stub
		return null;
	}

}
