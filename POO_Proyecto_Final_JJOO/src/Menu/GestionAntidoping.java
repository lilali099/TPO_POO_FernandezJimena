package Menu;

import Organizacion.Delegacion;
import Organizacion.JuegoOlimpico;
import Participante.Atleta;

import java.util.Scanner;

public class GestionAntidoping {
    private Scanner sc;
    private JuegoOlimpico jo;

    public GestionAntidoping(Scanner sc, JuegoOlimpico jo) {
        this.sc = sc;
        this.jo = jo;
    }

    public void mostrarMenu() {
        boolean volver = false;

        while (!volver) {

            System.out.println("\n===== GESTIÓN ANTIDOPING =====");
            System.out.println("1. Mostrar resultado antidoping");
            System.out.println("0. Volver");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    mostrarResultadoAntidoping();
                    break;


                case 0:
                    volver = true;
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void mostrarResultadoAntidoping() {
        System.out.print("Ingrese nombre del atleta: ");
        String nombreAtleta = sc.nextLine();
        System.out.print("Ingrese apellido del atleta: ");
        String apellidoAtleta = sc.nextLine();
        Atleta atleta = Delegacion.buscarAtleta(nombreAtleta, apellidoAtleta);

        if (atleta == null) {
            System.out.println("❌ Atleta no encontrado");
        } else {
            System.out.print("¿El atleta dio positivo? (s/n): ");
            String respuesta = sc.nextLine();

            if (respuesta.equalsIgnoreCase("s")) {
                atleta.setDopingPositivo(true);
                atleta.quitarMedalla(true);
                System.out.println("❌ " + atleta.getNombre() + " dio positivo. Medallas retiradas.");
            } else {
                atleta.setDopingPositivo(false);
                System.out.println("✅ " + atleta.getNombre() + " pasó el control antidoping.");
            }
        }

    }

}