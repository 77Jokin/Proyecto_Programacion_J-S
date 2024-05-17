package principales;

import java.math.BigDecimal;
import java.util.Scanner;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entidades.Cliente;



public class GestionClientes {
	
	private static Scanner leer;
	private static ClienteDao cdao;
	

	static {
		leer = new Scanner(System.in);
		cdao = new ClienteDaoImplMy8Jpa();
	}
	    public static void main(String[] args) {
	        int opcion = 0;

	        do {

	        	opcion = mostrarMenu();
	        	if(opcion == 5)
	        		break;
	            switch (opcion) {
	                case 1:
	                    alta();
	                    break;
	                case 2:
	                    uno();
	                    break;
	                case 3:
	                    todos();
	                    break;
	                case 4:
	                    eliminar();
	                    break;

	                default:
	                    System.out.println("Opción no válida.");
	            }
	        } while (opcion != 5);
	    }

	    private static int mostrarMenu() {
	    	int opcion = 0;
	    	System.out.println("\n\n==================================");
	        System.out.println("**Menú Gestión de Clientes**\n");
	        System.out.println("1. Alta del Cliente");
	        System.out.println("2. Buscar un Cliente");
	        System.out.println("3. Mostrar Todos");
	        System.out.println("4. Eliminar un cliente");
	        System.out.println("5. Salir");
	        System.out.print("Seleccione una opción: ");
	        opcion = leer.nextInt();
	        System.out.println("==================================\n");
	        
	        while (opcion < 1 || opcion > 5) {
	        	System.out.println("Solo del 1 al 5");
	        	opcion = leer.nextInt();
	        	
	        }
	        return opcion;
	    }
	    
	    private static void alta() {
	    	 
	    	      /* Scanner scanner = new Scanner(System.in);

	    	        System.out.print("Enter ID: ");
	    	        String id = scanner.nextLine();

	    	        System.out.print("Enter Name: ");
	    	        String name = scanner.nextLine();

	    	        System.out.print("Enter Address: ");
	    	        String address = scanner.nextLine();

	    	        System.out.print("Enter Balance: ");
	    	        BigDecimal balance = scanner.nextBigDecimal();

	    	        System.out.print("Enter Contact Person: ");
	    	        String contactPerson = scanner.next();

	    	        System.out.print("Enter Rating: ");
	    	        int rating = scanner.nextInt();

	    	        scanner.close();

	    	        Cliente cli = new Cliente(id, name, address, balance, contactPerson, rating);
	    	    */
	    	
	    	Cliente cli = new Cliente("111111111A", "Martinez Ruiz", "c/ Julián Camarillo, 6", new BigDecimal("21000.50"), "Pablo", 3);
	    	System.out.println("SE HA AÑADIDO:" + cdao.alta(cli));
	    	cdao.buscarUno("111111111A");
	    	System.out.println("\n" + cli.getNombre() + " " + cli.getApellidos());
	    	
	    }


	    private static void uno() {
	    	Cliente cli = cdao.buscarUno("A22222222");  
	    	System.out.println("\nCliente buscado:");
	    	System.out.println(" -> " + cli.getNombre() + " " + cli.getApellidos());
	    	
	    }
	    
	    private static void todos() {
	    	System.out.println("\nLista clientes:");
	    	cdao.buscarTodos().forEach(System.out::println);
	    }
	    
	    private static void eliminar() {
	    	cdao.eliminar("111111111A"); 
	    	cdao.buscarTodos().forEach(System.out::println);
	    }
	  }


