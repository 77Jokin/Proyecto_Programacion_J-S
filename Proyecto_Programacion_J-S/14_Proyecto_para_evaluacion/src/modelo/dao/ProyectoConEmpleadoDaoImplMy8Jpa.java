package modelo.dao;

import java.util.List;

import modelo.entidades.ProyectoConEmpleado;

public class ProyectoConEmpleadoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ProyectoConEmpleadoDao{

	@Override
	public boolean alta(ProyectoConEmpleado obj) {
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
	public boolean eliminar(Integer clave) {
		try {
			ProyectoConEmpleado proyectoConEmpleado = buscarUno(clave);
			if (proyectoConEmpleado != null) {
				tx.begin();
					em.remove(proyectoConEmpleado);
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
	public boolean modificar(ProyectoConEmpleado obj) {
		try {
			ProyectoConEmpleado proyectoConEmpleado = buscarUno(obj.getNumeroOrden());
			if (proyectoConEmpleado != null) {
				tx.begin();
					em.persist(proyectoConEmpleado);
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
	public ProyectoConEmpleado buscarUno(Integer clave) {
		return em.find(ProyectoConEmpleado.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProyectoConEmpleado> buscarTodos() {
		jpql = "select d from Departamento d";	
		return em.createQuery(jpql).getResultList();
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public int horasAsignadasAProyecto(String codigoProyecto) {
		 int totalHoras = 0;
		    for (ProyectoConEmpleado proyectoConEmpleado : buscarTodos()) {
		        if (proyectoConEmpleado.getProyecto().getClass().equals(codigoProyecto)) {
		            totalHoras += proyectoConEmpleado.getHorasAsignadas();
		        }
		    }
		    return totalHoras;
	}

	@Override
	public int asignarEmpleadosAProyecto(List<ProyectoConEmpleado> empleados) {
		for (ProyectoConEmpleado empleado : empleados) {
            em.persist(empleado);
        }
        return empleados.size();
	}

	@Override
	public double costeActualDeProyecto(String codigoProyecto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double margenActualProyecto(String codigoProyecto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProyectoConEmpleadoDao> empleadosByProyecto(String codigoProyecto) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
