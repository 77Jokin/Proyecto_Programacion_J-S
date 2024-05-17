package modelo.dao;

import java.util.Date;
import java.util.List;
import modelo.entidades.Proyecto;

public class ProyectoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ProyectoDao {

	@Override
	public boolean alta(Proyecto obj) {
		try {
			tx.begin();
				em.persist(obj);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean eliminar(String clave) {
		try {
			Proyecto pro = buscarUno(clave);
			if (pro != null) {
				tx.begin();
					em.remove(pro);
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
	public boolean modificar(Proyecto obj) {
		try {
			Proyecto pro = buscarUno(obj.getIdProyecto());
			if (pro != null) {
				tx.begin();
					em.persist(pro);
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
	public Proyecto buscarUno(String clave) {
		return em.find(Proyecto.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> buscarTodos() {
		jpql = "select p from Proyecto p";	
		return em.createQuery(jpql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	
	public List<Proyecto> proyectosByEstado(String estado) {
			jpql = "select p from Proyecto p where p.estado = :estado";
		return em.createQuery(jpql).setParameter("estado", estado).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		jpql = "select p from Proyecto p where p.cif = :cif";
		return em.createQuery(jpql).setParameter("cif", cif).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
		jpql = "select p from Proyecto p where p.empleado = :empleado and p.estado = :estado";
		return em.createQuery(jpql).setParameter("empleado", jefeProyecto).setParameter("estado", estado).getResultList();
	}

	@Override
	public double importesVentaProyectosTerminados() {

		jpql = "select sum(p.ventaPrevisto) from Proyecto p where p.estado = 'TERMINADO'";
		return (double) em.createQuery(jpql).getSingleResult();
	}

	@Override
	public double margenBrutoProyectosTerminados() {
		jpql = "select sum(p.importesPrevistos - p.costeReal) from Proyecto p where p.estado = 'TERMINADO";
		return (double) em.createQuery(jpql).getSingleResult();
	}

	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {

		 Proyecto pro = buscarUno(codigoProyecto);
		    if (pro.getEstado().equalsIgnoreCase("TERMINADO")) {
		        Date fechaFinPrevisto = pro.getFechaFinPrevisto();
		        Date fechaHoy = new Date();
		        long diff = fechaFinPrevisto.getTime() - fechaHoy.getTime();
		        return (int) (diff / (24 * 60 * 60 * 1000));
		    } else 
		        return 0;
		    
		
		
	}

}
