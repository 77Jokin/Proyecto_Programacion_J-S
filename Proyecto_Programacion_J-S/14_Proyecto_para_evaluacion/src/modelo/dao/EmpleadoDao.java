package modelo.dao;

import java.util.List;

import modelo.entidades.Empleado;

public interface EmpleadoDao extends  InterGenericoCrud<Integer, Empleado> {

	double salarioTotal();
	double salarioTotal(int idDepar);
	List<Empleado> empleadosByDepartamento (int idDepar);
	List<Empleado> empleadosBySexo (char sexo);
	List<Empleado> empleadosByApellido (String subcadena);
}
