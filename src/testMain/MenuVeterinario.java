package testMain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import adapterAutentificador.Autenticador;
import adapterAutentificador.IAdapterAutenticador;
import controllers.AlarmaController;
import controllers.AnimalController;
import controllers.UsuarioController;
import estadoCondicionMedica.Enfermo;
import estadoCondicionMedica.Saludable;
import estrategiaExportacion.AdapterExcel;
import estrategiaExportacion.AdapterPDF;
import estrategiaExportacion.ExportarExcel;
import estrategiaExportacion.ExportarPDF;
import estrategiaExportacion.IExportar;
import modelo.Accion;
import modelo.Alarma;
import modelo.Animal;
import modelo.AnimalDomestico;
import modelo.AnimalSalvaje;
import modelo.Control;
import modelo.EtipoAnimal;
import modelo.Exportador;
import modelo.FichaTecnica;
import modelo.Refugio;
import modelo.TratamientoMedico;
import modelo.Veterinario;

public class MenuVeterinario {

	public void MenuPrincipal() {
		// --------------CONTROLADORES QUE SE VAN A UTILIZAR--------------------
		AnimalController animalController = new AnimalController();
		AlarmaController alarmaController = new AlarmaController();
		UsuarioController usuarioController = new UsuarioController();
		// --------------ANIMALES PARA PRUEBA ------------------------
		Animal primerGato = new AnimalDomestico("gato", 15, 3, 5);
		FichaTecnica fichaTecnicGato = new FichaTecnica(primerGato);
		primerGato.setFichaTecnica(fichaTecnicGato);
		animalController.setAnimales(primerGato);
		primerGato.cambiarEstado(new Saludable());
		Animal primerTortuga = new AnimalDomestico("tortuga", 7, 9, 17);
		FichaTecnica fichaTecnicaTortuga = new FichaTecnica(primerTortuga);
		primerTortuga.setFichaTecnica(fichaTecnicaTortuga);
		animalController.setAnimales(primerTortuga);
		Animal primerZorro = new AnimalSalvaje("zorro", 20, 5, 7);
		FichaTecnica fichaTecnicaZorro = new FichaTecnica(primerZorro);
		primerZorro.setFichaTecnica(fichaTecnicaZorro);
		animalController.setAnimales(primerZorro);
		primerZorro.cambiarEstado(new Saludable());
		Animal primerHalcon = new AnimalSalvaje("halcon", 19, 29, 20);
		FichaTecnica fichaTecnicaHalcon = new FichaTecnica(primerHalcon);
		primerHalcon.setFichaTecnica(fichaTecnicaHalcon);
		animalController.setAnimales(primerHalcon);
		// -------------CREACION DE CLASES PARA LAS PRUEBAS VETERINARIO-----------
		IAdapterAutenticador autenticacion = new Autenticador();
		Veterinario juan = new Veterinario("Juan", "Martinez", "juan2023", "12345");
		Veterinario maria = new Veterinario("Maria", "Gomez", "maria2023", "6789");
		maria.setAdapter(autenticacion);
		juan.setAdapter(autenticacion);
		// -----------------EXPORTADOR---------------------------------------------
		Exportador exportador = new Exportador();
		IExportar exportarPDF = new ExportarPDF(new AdapterPDF());
		IExportar exportarExcel = new ExportarExcel(new AdapterExcel());
		// ---------------VARIABLES A UTILIZAR-----------------------------------
		Scanner sc = new Scanner(System.in);
		char opcion;
		// -------------VETERINARIO MOCKEADO CON INICIO DE SESION----------------
		System.out.println("-------REFUGIO GUD BOY-------");
		usuarioController.setUsuario(juan);
		juan.autenticar("juan2023", "12345", juan.getTipoUsuario());
		while (true) {
			System.out.println("---------------------------------------");
			System.out.println("------------------MENU-----------------");
			System.out.println("1-Ingresar un nuevo animal al refugio");
			System.out.println("2-Visualizar animales del refugio");
			System.out.println("3-Visualizar alarmas/notificaciones pendientes de atender");
			System.out.println("Presione 0 para salir del programa");
			opcion = sc.nextLine().charAt(0);
			switch (opcion) {
			case '1':
				System.out.println("Ha seleccionado la opcion para ingresar un nuevo animal");
				solicitarDatosAnimal(animalController);
				boolean salirOpcion1 = false;
				while (!salirOpcion1) {
					System.out.println("a-Ingresar otro animal");
					System.out.println("b-Volver al menu principal");
					char opcionOpcion1 = sc.nextLine().charAt(0);
					switch (opcionOpcion1) {
					case 'a':
						System.out.println("Ha seleccionado la opcion para ingresar otro animal");
						solicitarDatosAnimal(animalController);
						break;
					case 'b':
						salirOpcion1 = true;
						break;
					default:
						System.out.println("Opcion invalida. Intente nuevamente");
					}
				}
				break;
			case '2':
				System.out.println("Ha seleccionado la opcion para visualizar los animales del refugio");
				if (animalController.getAnimales().size() != 0) {
					animalController.listarAnimales();
				} else {
					System.out.println("No hay animales en el refugio.");
				}
				boolean salirOpcion2 = false;
				while (!salirOpcion2) {
					System.out.println("a-Exportar la ficha tecnica de un animal");
					System.out.println("b-Crear una nueva alarma de control para un animal");
					System.out.println("c-Crear una nueva alarma de tratamiento medico para un animal");
					System.out.println("d-Volver al menu principal");
					char opcionOpcion2 = sc.nextLine().charAt(0);
					switch (opcionOpcion2) {
					case 'a':
						if (animalController.getAnimales().size() != 0) {
							System.out.println("Ha seleccionado la opcion para exportar la ficha tecnica de un animal");
							System.out.println("Ingrese el id del animal que desea exportar su ficha tecnica");
							Scanner sc2 = new Scanner(System.in);
							int opcionId = sc2.nextInt();
							while (animalController.buscarAnimal(opcionId) == null) {
								System.out.println("Error. Por favor ingrese un id valido");
								opcionId = sc2.nextInt();
							}
							System.out.println("1-Exportar en PDF");
							System.out.println("2-Exportar en Excel");
							Scanner sc3 = new Scanner(System.in);
							int opcionExp = sc3.nextLine().charAt(0);
							switch (opcionExp) {
							case '1':
								exportador.cambiarEstrategia(exportarPDF);
								exportador.exportar(animalController.buscarAnimal(opcionId).getFichaTecnica());
								break;
							case '2':
								exportador.cambiarEstrategia(exportarExcel);
								exportador.exportar(animalController.buscarAnimal(opcionId).getFichaTecnica());
								break;
							}
						} else {
							System.out.println("No hay animales en el refugio.");
						}
						break;
					case 'b':
						if (animalController.getAnimales().size() != 0) {
							System.out.println(
									"Ha seleccionado la opcion para crear una alarma de control para un animal");
							System.out.println("Ingrese el id del animal");
							Scanner sc2 = new Scanner(System.in);
							int opcionId = sc2.nextInt();
							solicitarDatosConfiguracionAlarmaControl(animalController.buscarAnimal(opcionId), alarmaController);
						} else {
							System.out.println("No hay animales en el refugio.");
						}
						break;
					case 'c':
						if (animalController.getAnimales().size() != 0) {
							System.out.println(
									"Ha seleccionado la opcion para crear una alarma de tratamiento medico para un animal");
							System.out.println("Ingrese el id del animal");
							Scanner sc2 = new Scanner(System.in);
							int opcionId = sc2.nextInt();
							while (animalController.buscarAnimal(opcionId) == null) {
								System.out.println("Error. Por favor ingrese un id valido");
								opcionId = sc2.nextInt();
							}
							solicitarDatosConfiguracionAlarmaTratamiento(animalController.buscarAnimal(opcionId), alarmaController);
						} else {
							System.out.println("No hay animales en el refugio.");
						}
						break;
					case 'd':
						salirOpcion2 = true;
						break;
					default:
						System.out.println("Opcion invalida. Intente nuevamente");
					}
				}
				break;
			case '3':
				System.out.println("Ha seleccionado la opcion para visualizar las alarmas pendientes");
				if (alarmaController.getAlarmas().size() != 0) {
					alarmaController.listarAlarmas();
				} else {
					System.out.println("No hay ninguna alarma/notificacion pendiente de atencion");
				}
				boolean salirOpcion3 = false;
				while (!salirOpcion3) {
					System.out.println("a-Atender una alarma");
					System.out.println("b-Volver al menu principal");
					char opcionOpcion3 = sc.nextLine().charAt(0);
					switch (opcionOpcion3) {
					case 'a':
						if (alarmaController.getAlarmas().size() != 0) {
							System.out.println(
									"Ha seleccionado la opcion para atender una alarma pendiente de un animal");
							System.out.println("Ingrese el id del animal");
							Scanner sc2 = new Scanner(System.in);
							Scanner sc3 = new Scanner(System.in);
							int opcionId = sc2.nextInt();
							while (animalController.buscarAnimal(opcionId) == null) {
								System.out.println("Error. Por favor ingrese un id valido");
								opcionId = sc2.nextInt();
							}
							System.out.println("Ingrese el numero de la lista de la alarma que desea atender");
							int opcionAlarma = sc3.nextInt() - 1;
							Alarma alarma = alarmaController.getAlarmas().get(opcionAlarma);
							if (alarma.getTipo().getClass().equals(TratamientoMedico.class)) {
								solicitarDatosAtencionTratamiento(
										(Veterinario) usuarioController.getUserConectado(), alarma,
										animalController.buscarAnimal(opcionId),alarmaController);
								consultarEstadoAnimal(animalController.buscarAnimal(opcionId),animalController);
							} else if (alarma.getTipo().getClass().equals(modelo.Control.class)) {
								solicitarDatosAtencionControl((Veterinario) usuarioController.getUserConectado(),
										alarma, animalController.buscarAnimal(opcionId),alarmaController);
								consultarEstadoAnimal(animalController.buscarAnimal(opcionId),animalController);
							}
						} else {
							System.out.println("No hay alarmas/notificaciones pendientes de atencion.");
						}
						;
						break;
					case 'b':
						salirOpcion3 = true;
						break;
					default:
						System.out.println("Opcion invalida. Intente nuevamente");
					}
				}
				break;
			case '0':
				System.out.println("Saliendo del programa...");
				return;
			default:
				System.out.println("Opcion invalida. Intente nuevamente");
			}
		}
	}

	public void solicitarDatosAnimal(AnimalController animalController) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Por favor, para ingresar un animal llene los siguientes datos:");
		System.out.println("Ingrese el tipo de animal: \n 1-Animal domestico \n 2-Animal salvaje");
		String decision = sc.nextLine();
		while ((!decision.equals("1")) && (!decision.equals("2"))) {
			System.out.println("Error. Por favor seleccione una opcion");
			System.out.println("Ingrese el tipo de animal: \n 1-Animal domestico \n 2-Animal salvaje");
			decision = sc.nextLine();
		}
		EtipoAnimal tipoAnimal = EtipoAnimal.DOMESTICO;
		if (decision.equals("1")) {
			tipoAnimal = EtipoAnimal.DOMESTICO;
		} else if (decision.equals("2")) {
			tipoAnimal = EtipoAnimal.SALVAJE;
		}
		System.out.println("Por favor, ingrese la especie del animal");
		String especie = sc.nextLine();
		System.out.println("Ingrese la altura del animal en cm: ");
		Double altura = sc.nextDouble();
		System.out.println("Ingrese el peso del animal en kg: ");
		Double peso = sc.nextDouble();
		System.out.println("Ingrese la edad aproximada del animal en anios: ");
		Double edad = sc.nextDouble();
		animalController.registrarAnimal(especie, altura, peso, edad, tipoAnimal);
		System.out.println("Se ha ingresado al animal correctamente");
	}

	public void solicitarDatosConfiguracionAlarmaControl(Animal animal, AlarmaController alarmaController) {
		ArrayList<Accion> acciones = new ArrayList<Accion>();
		Accion nuevaAccion = new Accion();
		Scanner sc = new Scanner(System.in);
		System.out.println("Configuración de alarma de control para el animal: " + animal);
		System.out.println(
				"Por favor indique las acciones a realizar. Se le solicitará el nombre de la acción y luego la descripción de la misma.");
		System.out.println("Nombre de la acción a realizar:");
		nuevaAccion.setNombreAccion(sc.nextLine());
		System.out.println("Descripción de la acción a realizar:");
		nuevaAccion.setDescripcion(sc.nextLine());
		acciones.add(nuevaAccion);
		System.out.println(
				"¿Desea agregar otra accion al control? Presione cualquier tecla para continuar, si desea dejar de añadir acciones presione N");
		String decision = sc.nextLine();
		while (!decision.toUpperCase().equals("N")) {
			System.out.println("Nombre de la acción a realizar:");
			nuevaAccion.setNombreAccion(sc.nextLine());
			System.out.println("Descripción de la acción a realizar:");
			nuevaAccion.setDescripcion(sc.nextLine());
			acciones.add(nuevaAccion);
			System.out.println(
					"¿Desea agregar otra accion al control? Presione cualquier tecla para continuar, si desea dejar de añadir acciones presione N");
			decision = sc.nextLine();
		}
		alarmaController.crearAlarmaControl(animal, acciones);
	}
	
	public void solicitarDatosConfiguracionAlarmaTratamiento(Animal animal, AlarmaController alarmaController) {
		ArrayList<Accion> acciones = new ArrayList<Accion>();
		Accion nuevaAccion = new Accion();
		Scanner sc = new Scanner(System.in);
		System.out.println("Configuración de alarma de tratamiento para el animal: " + animal);
		System.out.println("Por favor ingrese el nombre del tratamiento que se va a realizar");
		String nombreTratamiento = sc.nextLine();
		System.out.println("Por favor ingrese la descripción del tratamiento que se va a realizar");
		String descripcionTratamiento = sc.nextLine();
		System.out.println(
				"Por favor indique la periodicidad del tratamiento. (En número entero, el valor se contará como minutos, ejemplo: 2 -> Cada 2 minutos");
		int periodicidadTratamiento = sc.nextInt();
		System.out.println(
				"Por favor indique las acciones a realizar. Se le solicitará el nombre de la acción y luego la descripción de la misma.");
		System.out.println("Nombre de la acción a realizar:");
		Scanner sc2 = new Scanner(System.in);
		nuevaAccion.setNombreAccion(sc2.nextLine());
		System.out.println("Descripción de la acción a realizar:");
		Scanner sc3 = new Scanner(System.in);
		nuevaAccion.setDescripcion(sc3.nextLine());
		acciones.add(nuevaAccion);
		System.out.println(
				"¿Desea agregar otra accion al tratamiento? Presione cualquier tecla para continuar, si desea dejar de añadir acciones presione N");
		Scanner sc4 = new Scanner(System.in);
		String decision = sc4.nextLine();
		while ((!decision.toUpperCase().equals("N"))) {
			System.out.println("Nombre de la acción a realizar:");
			nuevaAccion.setNombreAccion(sc2.nextLine());
			System.out.println("Descripción de la acción a realizar:");
			nuevaAccion.setDescripcion(sc3.nextLine());
			acciones.add(nuevaAccion);
			System.out.println(
					"¿Desea agregar otra accion al tratamiento? Presione cualquier tecla para continuar, si desea dejar de añadir acciones presione N");
			decision = sc4.nextLine();
		}
		System.out.println("Por favor ingrese la fecha en la que iniciará el tratamiento");
		LocalDateTime fechaInicialTratamiento = Utilidades.solicitarUnaFecha();
		System.out.println("Por ultimo. Por favor ingrese la fecha en la que finalizará el tratamiento");
		LocalDateTime fechaFinalTratamiento = Utilidades.solicitarUnaFecha();
		alarmaController.crearAlarmaTratamientoMedico(animal, fechaInicialTratamiento, fechaFinalTratamiento, descripcionTratamiento, nombreTratamiento, periodicidadTratamiento, acciones);
	}
	
	public void solicitarDatosAtencionControl(Veterinario veterinario, Alarma alarma, Animal animal,AlarmaController alarmaController) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese a modo de comentario lo realizado en el control:");
		String comentario = sc.nextLine();
		alarmaController.atenderControl(veterinario, alarma, animal, comentario);
	}
	public void solicitarDatosAtencionTratamiento(Veterinario veterinario, Alarma alarma, Animal animal,AlarmaController alarmaController) {
		Scanner sc = new Scanner(System.in);
		boolean finalizarTratamiento = false;
		System.out.println("Desea finalizar el tratamiento: " + alarma.getTipo() + "? (S/N)");
		String respuesta = sc.nextLine();
		while ((!respuesta.toUpperCase().equals("S")) && (!respuesta.toUpperCase().equals("N"))) {
			System.out.println("Error. Desea finalizar el tratamiento: " + alarma.getTipo() + "? (S/N)");
			respuesta = sc.nextLine();
		}
		if (respuesta.toUpperCase().equals("S")) {
			finalizarTratamiento = true;
		}
		else {
			finalizarTratamiento = false;
		}
		System.out.println("Ingrese a modo de comentario lo realizado en el seguimiento del tratamiento:");
		String comentario = sc.nextLine();
		alarmaController.atenderTratamientoMedico(veterinario, alarma, animal, comentario,finalizarTratamiento);
	}
	
	public void consultarEstadoAnimal(Animal animal, AnimalController animalController) {
		Scanner sc = new Scanner(System.in);
		if (animal.getEstado().equals(Enfermo.class)) {
			System.out.println("El animal ya se encuentra saludable? (S/N)");
			String respuesta = sc.nextLine();
			while ((!respuesta.toUpperCase().equals("S")) && (!respuesta.toUpperCase().equals("N"))) {
				System.out.println("Error. El animal ya se encuentra saludable? (S/N)");
				respuesta = sc.nextLine();
			}
			if (respuesta.toUpperCase().equals("S")) {
				animalController.recuperar(animal);
			}
		} else if (animal.getEstado().equals(Saludable.class)) {
			System.out.println("El animal tiene algun problema de salud? (S/N)");
			String respuesta = sc.nextLine();
			while ((!respuesta.toUpperCase().equals("S")) && (!respuesta.toUpperCase().equals("N"))) {
				System.out.println("Error. El animal tiene algun problema de salud? (S/N)");
				respuesta = sc.nextLine();
			}
			if (respuesta.toUpperCase().equals("S")) {
				animalController.cambiarEstadoAnimal(animal, new Enfermo());
			}
		}
	}
}
