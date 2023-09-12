package testMain;

import java.util.Scanner;

public class testMenu {

	public static void main(String[] args) {
		//PARA HACER LAS PRUEBAS COMENTAR EL TEST QUE NO QUIERE PROBAR.
		//---------------VARIABLES A UTILIZAR-----------------------------------
		Scanner sc = new Scanner(System.in);
		char opcion;
		while(true) {
			System.out.println("------------------MENU-----------------");
			System.out.println("1-Ingresar al menu veterinario");
			System.out.println("2-Ingresar al menu visitador");
			System.out.println("Presione 0 para salir del programa");
			opcion = sc.nextLine().charAt(0);
			switch(opcion) {
			case '1':
				System.out.println("Ha seleccionado la opcion ingresar al menu veterinario");
				MenuVeterinario menuVeterinario = new MenuVeterinario();
				menuVeterinario.MenuPrincipal(); return;
			case '2':
				System.out.println("Ha seleccionado la opcion ingresar al menu visitador");
				MenuVisitador menuVisitador = new MenuVisitador();
				menuVisitador.menuVisitador(); return;
			case '0': 
				System.out.println("Saliendo del programa...");
				return;
			default:
				System.out.println("Opcion invalida. Intente nuevamente");}
			
		}
		//TEST VETERINARIO
//		MenuVeterinario menuVeterinario = new MenuVeterinario();
//		menuVeterinario.MenuPrincipal();
		//TEST VISITADOR
//		MenuVisitador menuVisitador = new MenuVisitador();
//		menuVisitador.menuVisitador(); 

	}

}
