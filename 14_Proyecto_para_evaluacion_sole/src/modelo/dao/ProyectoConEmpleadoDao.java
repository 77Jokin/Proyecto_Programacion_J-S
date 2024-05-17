package modelo.dao;

import java.util.List;
import modelo.entidades.ProyectoConEmpleado;

public interface ProyectoConEmpleadoDao extends InterGenericoCrud<Integer, ProyectoConEmpleado>{
	
	int horasAsignadasAProyecto(String codigoProyecto);
	int asignarEmpleadosAProyecto(List<ProyectoConEmpleado> empleados); 
	double costeActualDeProyecto(String codigoProyecto);  
	double margenActualProyecto(String codigoProyecto);
	List<ProyectoConEmpleadoDao> empleadosByProyecto(String codigoProyecto); 
	 
}
