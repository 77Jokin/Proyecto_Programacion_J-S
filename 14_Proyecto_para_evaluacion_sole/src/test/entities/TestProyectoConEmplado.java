package test.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import modelo.entidades.Cliente;
import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;
import modelo.entidades.Proyecto;
import modelo.entidades.ProyectoConEmpleado;

public class TestProyectoConEmplado {

	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		ProyectoConEmpleado proEmpl = new ProyectoConEmpleado(6, new Date(2020,11,20), 80,
				new Empleado(103, "Perez", "marta@tt.com", new Date(2020, 05, 11), new Date(1995, 11, 22), "M", "Marta", "marta", new BigDecimal(50000), 
						new Departamento(40, "Financiero", "Sevilla"), new Perfil(1, "Control de Gestión", new BigDecimal(120)), new ArrayList<>()),
				new Proyecto("FOR2021011", new BigDecimal(50000), new BigDecimal(33000), "Formación en finanzas", "TERMINADO", 
						new Date(2024,05,10), new Date(2024,05,9), new Date(2021,9,15), new BigDecimal(40000), 
						new Cliente("111111111A", "Martinez Ruiz", "Sevilla", new BigDecimal("21000.50"), "Pablo", 3), 
						new Empleado(103, "Perez", "marta@tt.com", new Date(2020, 05, 11), new Date(1995, 11, 22), "M", "Marta", "marta", new BigDecimal(50000), 
								new Departamento(40, "Financiero", "Sevilla"), 
								new Perfil(1, "Control de Gestión", new BigDecimal(120)), new ArrayList<>())));
		
		System.out.println("Datos de proyectoConEmpleado:");
		System.out.println(proEmpl);
		System.out.println("\nCoste:");
		System.out.println(proEmpl.costeHorasAsignadas());

	}

}
