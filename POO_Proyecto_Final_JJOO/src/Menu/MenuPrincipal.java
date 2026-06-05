
import Menu.*;
import Menu.GestionResultado;
import Organizacion.*;
import Persistencia.GestorPersistencia;

import java.sql.SQLOutput;

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    JuegoOlimpico jo = GestorPersistencia.cargar();

    if (jo == null) {
        jo = new JuegoOlimpico(
                "Juegos Olímpicos de París",
                "París, Francia",
                2024);
        System.out.println("Se creó un nuevo Juego Olímpico.");

    } else {

        System.out.println("Datos cargados correctamente.");
    }


    GestionOrganizativa menuOrg =
            new GestionOrganizativa(sc, jo);

    GestionDeportiva menuDepor =
            new GestionDeportiva(sc, jo);

    GestionDeParticipacion menuPar =
            new GestionDeParticipacion(sc, jo);

    GestionResultado menuResult =
            new GestionResultado(sc, jo);

    ConsultasDelSistema menuConsult =
            new ConsultasDelSistema(sc, jo);

    boolean continuar = true;

    while (continuar) {

        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Gestión Organizativa");
        System.out.println("2. Gestión Deportiva");
        System.out.println("3. Gestión de Participación");
        System.out.println("4. Gestión de Resultados");
        System.out.println("5. Consultas del Sistema");
        System.out.println("6. Control Antidoping");
        System.out.println("0. Salir");

        System.out.print("Ingrese una opción: ");

        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {

            case 1:
                menuOrg.mostrarMenu();
                break;

            case 2:
                menuDepor.mostrarMenu();
                break;

            case 3:


                menuPar.mostrarMenu();
                break;

            case 4:
                menuResult.mostrarMenu();
                break;

            case 5:
                menuConsult.mostrarMenu();
                break;


            case 0:
                GestorPersistencia.guardar(jo);
                continuar = false;
                break;

            default:
                System.out.println("Opción inválida.");
        }
    }
}


