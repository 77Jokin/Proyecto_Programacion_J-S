package test.entities;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;

import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;


public class TestEmpleado {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("deprecation")
		Empleado empl1 = new Empleado(103, "Perez", "marta@tt.com", new Date(2020, 05, 11), new Date(1995, 11, 22), "M", "Marta", "marta", new BigDecimal(50000), new Departamento(40, "Financiero", "Sevilla"), new Perfil(1, "Control de Gestión", new BigDecimal(120)), new ArrayList<>());
		
		System.out.println("\nDatos empleado/a:");
		System.out.println(empl1);
		
		System.out.println("\nSalario bruto:");
		System.out.println(empl1.salarioBruto());
		
		System.out.println("\nSalario mensual:");
		System.out.println(empl1.salarioMensual(12)); //Se introduce el mes
		
		System.out.println("\nSexo:");
		System.out.println(empl1.literalSexo());
		
		System.out.println("\nEmail:");
		System.out.println(empl1.obtenerEmail());
		
		System.out.println("\nNombre completo:");
		System.out.println(empl1.nombreCompleto());
		
	}
		

	

}



	   


	    
	   

