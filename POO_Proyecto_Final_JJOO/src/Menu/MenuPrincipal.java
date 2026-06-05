
import Menu.*;
import Menu.GestionResultado;
import Organizacion.*;

import java.sql.SQLOutput;

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    JuegoOlimpico jo = new JuegoOlimpico("Juegos Olímpicos de París", "París, Francia", 2024);

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
                continuar = false;
                break;

            default:
                System.out.println("Opción inválida.");
        }
    }

}
