package testMain;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

import adapterAutentificador.Autenticador;
import adapterAutentificador.IAdapterAutenticador;
import controllers.AdopcionController;
import controllers.AnimalController;
import controllers.ClienteController;
import controllers.SeguimientoController;
import controllers.UsuarioController;
import controllers.VisitaController;
import estadoCondicionMedica.Saludable;
import estadoSeguimiento.Finalizado;
import modelo.Animal;
import modelo.AnimalDomestico;
import modelo.AnimalSalvaje;
import modelo.CadenciaVisitas;
import modelo.Cliente;
import modelo.ERespuestaEncuesta;
import modelo.EpreferenciaRecordatorio;
import modelo.EtipoAnimal;
import modelo.FichaTecnica;
import modelo.Refugio;
import modelo.Seguimiento;
import modelo.Visita;
import modelo.Visitador;

public class MenuVisitador {

	public void menuVisitador() {
		// --------------CONTROLADORES-------------------------------
		ClienteController clienteController = new ClienteController();
		AnimalController animalController = new AnimalController();
		AdopcionController adopcionController = new AdopcionController();
		UsuarioController usuarioController = new UsuarioController();
		SeguimientoController seguimientoController = new SeguimientoController();
		VisitaController visitaController = new VisitaController();
		// --------------ANIMALES PARA PRUEBA ADOPCION------------------------
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
		// -------------CREACION DE CLASES PARA LAS PRUEBAS VISITADOR----------
		IAdapterAutenticador autenticacion = new Autenticador();
		Visitador pedro = new Visitador("Pedro", "Martinez", "pepe2023", "12345");
		Visitador raul = new Visitador("Raul", "Gomez", "rau2023", "6789");
		// --------------AUTENTICACION DE USUARIOS-------------------------------
		raul.setAdapter(autenticacion);
		pedro.setAdapter(autenticacion);

		// ---------------VARIABLES A UTILIZAR-----------------------------------
		Scanner sc = new Scanner(System.in);
		char opcion;
		// -------------VETERINARIO MOCKEADO CON INICIO DE SESION----------------
		System.out.println("-------REFUGIO GUD BOY-------");
		usuarioController.setUsuario(pedro);
		pedro.autenticar("pepe2023", "12345", pedro.getTipoUsuario());
		while (true) {
			System.out.println("------------------------------------");
			System.out.println("----------MENU----------");
			System.out.println("Seleccione una opción:");
			System.out.println("1-Ingresar un nuevo animal al refugio");
			System.out.println("2-Visualizar seguimientos");
			System.out.println("3-Registrar un nuevo cliente para adopcion");
			System.out.println("4-Visualizar animales del refugio");
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
				System.out.println("Ha seleccionado la opcion para visualizar los seguimientos de adopcion en curso");
				if (seguimientoController.getSeguimientoAdopciones().size() != 0) {
					seguimientoController.listarSeguimientos();
				} else {
					System.out.println("No hay seguimientos.");
				}
				boolean salirOpcion2 = false;
				while (!salirOpcion2) {
					System.out.println("a-Realizar seguimiento/crear visita");
					System.out.println("b-Ver visitas de un seguimiento");
					System.out.println("c-Volver al menu principal");
					char opcionOpcion2 = sc.nextLine().charAt(0);
					switch (opcionOpcion2) {
					case 'a':
						if (seguimientoController.getSeguimientoAdopciones().size() != 0) {
							System.out.println("Ha seleccionado la opcion para crear una visita");
							System.out.println(
									"Ingrese el numero de la lista del seguimiento al que quiere crearle una visita");
							Scanner sc2 = new Scanner(System.in);
							int opcionSeguimiento = sc2.nextInt() - 1;
							Seguimiento seguimiento = seguimientoController.getSeguimientoAdopciones()
									.get(opcionSeguimiento);
							solicitarDatosRealizarSeguimiento(seguimiento,seguimientoController);
						} else {
							System.out.println("No hay seguimientos.");
						}
						break;
					case 'b':
						if (seguimientoController.getSeguimientoAdopciones().size() != 0) {
							System.out.println("Ha seleccionado la opcion para ver las visitas de un seguimiento");
							System.out.println(
									"Ingrese el numero de la lista del seguimiento para ver las visitas asociadas");
							Scanner sc2 = new Scanner(System.in);
							int opcionSeguimiento = sc2.nextInt() - 1;
							Seguimiento seguimiento = seguimientoController.getSeguimientoAdopciones()
									.get(opcionSeguimiento);
							seguimientoController.listarVisitasDeSeguimiento(seguimiento);
							System.out.println(
									"Para finalizar una visita seleccione el numero de la lista, si presiona 0 se vuelve al menu anterior");
							int opcionVisita = sc2.nextInt();
							if (opcionVisita > 0) {
								Visita visita = seguimiento.getVisitas().get(opcionVisita - 1);
								solicitarDatosEncuesta(visita,visitaController);
								datosFinalizarVisita(seguimiento,seguimientoController);
							}
						} else {
							System.out.println("No hay seguimientos.");
						}
						break;
					case 'c':
						salirOpcion2 = true;
						break;
					default:
						System.out.println("Opcion invalida. Intente nuevamente");
					}
				}
				break;
			case '3':
				System.out.println("Ha seleccionado registrar un cliente");
				solicitarDatosCliente(clienteController);
				System.out.println(
						"A continuacion se le muestran los animales que hay en el refugio, ingresel id del animal que sera adoptado");
				if (animalController.getAnimales().size() != 0) {
					animalController.listarAnimales();
					Scanner sc2 = new Scanner(System.in);
					int opcionId = sc2.nextInt();
					Animal animal = animalController.buscarAnimal(opcionId);
					if (animal != null) {
						adopcionController.crearAdopcion(
								clienteController.getClientes().get(clienteController.getClientes().size() - 1), animal,
								(Visitador) usuarioController.getUserConectado(), solicitarPreferenciaRecordatorio(),
								solicitarCadenciaVisitas());
					} else {
						System.out.println("El id ingresado no corresponde a un animal");
					}
				} else {
					System.out.println("No hay animales en el refugio.");
				}
				break;
			case '4':
				System.out.println("Ha seleccionado la opcion para visualizar los animales del refugio");
				if (animalController.getAnimales().size() != 0) {
					animalController.listarAnimales();
				} else {
					System.out.println("No hay animales en el refugio.");
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

	public EpreferenciaRecordatorio solicitarPreferenciaRecordatorio() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Por favor, para ingresar una preferencia de recordatorio llene los siguientes datos:");
		System.out.println("Seleccione un tipo de recordatorio: \n 1-SMS \n 2-Email \n 3-WhatsApp");
		String decision = sc.nextLine();
		while ((!decision.equals("1")) && (!decision.equals("2")) && (!decision.equals("3"))) {
			System.out.println("Error. Por favor seleccione una opcion");
			System.out.println("Seleccione un tipo de recordatorio: \n 1-SMS \n 2-Email \n 3-WhatsApp");
			decision = sc.nextLine();
		}
		switch (decision) {
		case "1":
			return EpreferenciaRecordatorio.SMS;
		case "2":
			return EpreferenciaRecordatorio.EMAIL;
		case "3":
			return EpreferenciaRecordatorio.WHATSAPP;
		}
		return null;
	}

	public CadenciaVisitas solicitarCadenciaVisitas() {
		Scanner scanner = new Scanner(System.in);
		CadenciaVisitas cadenciaVisitas = null;
		boolean datosInvalidos = true;
		do {
			try {
				// Solicitar el día de la semana
				System.out.print(
						"Ingrese el día de la semana (1: Lunes, 2: Martes, 3 Miercoles, 4: Jueves, 5: Viernes): ");
				int diaSemanaInt = scanner.nextInt();
				DayOfWeek diaSemana = DayOfWeek.of(diaSemanaInt);
				// Solicitar la hora de inicio del rango
				System.out.print("Ingrese la hora de inicio del rango (formato: HH:mm): ");
				String inicioRangoStr = scanner.next();
				LocalTime inicioRango = LocalTime.parse(inicioRangoStr);
				// Solicitar la hora de fin del rango
				System.out.print("Ingrese la hora de fin del rango (formato: HH:mm): ");
				String finRangoStr = scanner.next();
				LocalTime finRango = LocalTime.parse(finRangoStr);
				cadenciaVisitas = new CadenciaVisitas(diaSemana, inicioRango, finRango);
				datosInvalidos = false;
			} catch (InputMismatchException e) {
				System.out
						.println("Error: Se ingresó un valor invalido. Asegúrese de ingresar los datos correctamente.");
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println("Error: Ha ocurrido un problema al solicitar los datos. Intentelo nuevamente.");
				scanner.nextLine();
			}
		} while (datosInvalidos);
		return cadenciaVisitas;
	}

	public void solicitarDatosCliente(ClienteController clienteController) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Para registrar al cliente ingresar los siguientes datos:");
		System.out.println("Nombre del cliente: ");
		String nombre = sc.nextLine();
		System.out.println("Apellido del cliente:");
		String apellido = sc.nextLine();
		System.out.println("Estado civil del cliente: ");
		String estadoCivil = sc.nextLine();
		System.out.println("Email del cliente: ");
		String email = sc.nextLine();
		System.out.println("Telefono del cliente: ");
		String telefono = sc.nextLine();
		System.out.println("Ocupacion del cliente: ");
		String ocupacion = sc.nextLine();
		System.out.println("Tiene otras mascotas? (S/N)");
		String decision = sc.nextLine();
		boolean otrasMascota = true;
		if (decision.contentEquals("S")) {
			boolean otrasMascotas = true;
		} else {
			boolean otrasMascotas = false;
		}
		System.out.println("Motivo de adopcion: \n");
		String motivoAdopcion = sc.nextLine();
		System.out.println(
				"Por favor indique el tipo de animal que le interesa: Por ejemplo: Perro");
		String animalInteresado = sc.nextLine();
		clienteController.crearCliente(nombre, apellido, estadoCivil, email, telefono, ocupacion, otrasMascota,
				motivoAdopcion, animalInteresado, 0);
	}
	
	public void solicitarDatosEncuesta(Visita visita, VisitaController visitaController) {
	    ERespuestaEncuesta estadoGeneralAnimal = ERespuestaEncuesta.BUENO;
	    ERespuestaEncuesta limpiezaLugar = ERespuestaEncuesta.BUENO;
	    ERespuestaEncuesta ambiente = ERespuestaEncuesta.BUENO;
		Scanner sc = new Scanner(System.in);
		System.out.println("Por favor indique el estado general del animal");
    	System.out.println("1: Bueno, 2: Malo, 3: Regular");
    	String estadoGeneral = sc.nextLine();
    	while ((!estadoGeneral.equals("1")) && (!estadoGeneral.equals("2")) && (!estadoGeneral.equals("3"))) {
    		System.out.println("Error. Por favor indique el estado general del animal");
        	System.out.println("1: Bueno, 2: Malo, 3: Regular");
        	estadoGeneral = sc.nextLine();
    	}
    	switch(estadoGeneral){
    		case "1": estadoGeneralAnimal = ERespuestaEncuesta.BUENO;break;
    		case "2": estadoGeneralAnimal = ERespuestaEncuesta.MALO;break;
    		case "3": estadoGeneralAnimal = ERespuestaEncuesta.REGULAR;break;
    	}
    	
    	System.out.println("Por favor indique la limpieza del lugar");
    	System.out.println("1: Bueno, 2: Malo, 3: Regular");
    	String estadoLimpieza = sc.nextLine();
    	while ((!estadoLimpieza.equals("1")) && (!estadoLimpieza.equals("2")) && (!estadoLimpieza.equals("3"))) {
    		System.out.println("Error. Por favor indique la limpieza del lugar");
        	System.out.println("1: Bueno, 2: Malo, 3: Regular");
        	estadoLimpieza = sc.nextLine();
    	}
    	switch(estadoLimpieza){
			case "1": limpiezaLugar = ERespuestaEncuesta.BUENO;break;
			case "2": limpiezaLugar = ERespuestaEncuesta.MALO;break;
			case "3": limpiezaLugar = ERespuestaEncuesta.REGULAR;break;
    	}
    	
    	System.out.println("Por favor indique el estado del ambiente");
    	System.out.println("1: Bueno, 2: Malo, 3: Regular");
    	String estadoAmbiente = sc.nextLine();
    	while ((!estadoAmbiente.equals("1")) && (!estadoAmbiente.equals("2")) && (!estadoAmbiente.equals("3"))) {
    		System.out.println("Error. Por favor indique el estado general del animal");
        	System.out.println("1: Bueno, 2: Malo, 3: Regular");
        	estadoAmbiente = sc.nextLine();
    	}
    	switch(estadoAmbiente){
			case "1": ambiente = ERespuestaEncuesta.BUENO;break;
			case "2": ambiente = ERespuestaEncuesta.MALO;break;
			case "3": ambiente = ERespuestaEncuesta.REGULAR;break;
    	}
    	visitaController.completarEncuesta(visita, estadoGeneralAnimal, limpiezaLugar, ambiente);
	}
    public void datosFinalizarVisita(Seguimiento seguimiento,SeguimientoController seguimientoController) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Desea continuar con las visitas? (S/N)");
    	String continuarVisita = sc.nextLine();
    	while ((!continuarVisita.toUpperCase().equals("S")) && (!continuarVisita.toUpperCase().equals("N"))) {
    		System.out.println("Error. Desea continuar con las visitas? (S/N)");
    		continuarVisita = sc.nextLine();
    	}
		if(continuarVisita.toUpperCase().equals("N")) {
			seguimiento.cambiarEstado(new Finalizado());
			seguimientoController.eliminarSeguimiento(seguimiento);
		}
    }
    
    public void solicitarDatosRealizarSeguimiento(Seguimiento seguimiento, SeguimientoController seguimientoController) {
    	Scanner sc = new Scanner(System.in);
    	LocalDateTime fechaInicioVisita = LocalDateTime.now();
        boolean datosInvalidos = true;
        do {
	        try {
			    System.out.println("Por favor indique la fecha cuando se va a realizar la visita: ");
			    fechaInicioVisita = Utilidades.solicitarUnaFecha();
		        while(!Utilidades.estaEnRangoHorario(fechaInicioVisita, seguimiento.getCadenciaVisitas().getDia(), seguimiento.getCadenciaVisitas().getRangoHorarioInicio(), seguimiento.getCadenciaVisitas().getRangoHorarioFin())) {
				    System.out.println("La fecha ingresada no corresponde con lo solicitado por el cliente. La cadencia es: " + seguimiento.getCadenciaVisitas());
				    System.out.println("Por favor indique la fecha cuando se va a realizar la visita: ");
				    fechaInicioVisita = (Utilidades.solicitarUnaFecha());
		        }
		        datosInvalidos = false;
	        } catch (InputMismatchException e) {
	        	System.out.println("Error: Se ingresó un valor inválido. Asegúrese de ingresar los datos correctamente.");
	        	sc.nextLine();
	        } catch (Exception e) {
	        	System.out.println("Error: Ha ocurrido un problema al solicitar los datos. Inténtelo nuevamente.");
	        	sc.nextLine();
	        }
        } while (datosInvalidos);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Por favor, indique los dias de anticipacion para el envio del recordatorio Ejemplo: 2 -> 2 dias antes"); 
        int dias = sc.nextInt();
        System.out.println("Se ha creado la visita");
        seguimientoController.realizarSeguimiento(seguimiento, fechaInicioVisita, dias);
    }
}