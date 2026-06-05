package Menu;

import Organizacion.Competencia;
import Organizacion.Delegacion;
import Organizacion.Inscripcion;
import Organizacion.JuegoOlimpico;
import Participante.Atleta;
import Participante.Disciplina;

import java.util.Scanner;

public class GestionDeParticipacion {

    private Scanner sc;
    private JuegoOlimpico jo;

    public GestionDeParticipacion(Scanner sc, JuegoOlimpico jo) {
        this.sc = sc;
        this.jo = jo;
    }

    public void mostrarMenu() {
        boolean volver = false;

        while (!volver) {

            System.out.println("\n===== GESTIÓN DE PARTICIPACIÓN =====");
            System.out.println("1. Inscribir atleta en competencia");
            System.out.println("2. Validar restricciones");
            System.out.println("0. Volver");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    registrarAtletaEnCompetencia();
                    break;
                case 2:
                    validarRestricciones();
                    break;

                case 0:
                    volver = true;
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        }

    }


    public void registrarAtletaEnCompetencia() {
        System.out.print("Ingrese el nombre del atleta: ");
        String nombreAtleta = sc.nextLine();
        System.out.print("Ingrese el apellido del atleta: ");
        String apellidoAtleta = sc.nextLine();
        System.out.print("Ingrese el nombre de la competencia: ");
        String nombreCompetencia = sc.nextLine();
        Atleta atleta = Delegacion.buscarAtleta(nombreAtleta, apellidoAtleta);
        Competencia competencia = jo.buscarCompetencia(nombreCompetencia);
        if (atleta == null || competencia == null) {
            System.out.println("❌ Atleta o competencia inexistente.");
            return;
        }

        if (!atleta.getEspecialidad().equals(competencia.getDisciplina())) {

            System.out.println("❌ El atleta no posee la especialidad requerida.");
            return;
        }

        Inscripcion inscripcion = new Inscripcion(atleta, competencia);
        competencia.agregarInscripcion(inscripcion);

        System.out.println("✅ Inscripción realizada.");
    }


    public void validarRestricciones() {
        System.out.print("Ingrese el nombre del atleta: ");
        String nombreAtleta = sc.nextLine();
        System.out.print("Ingrese el apellido del atleta: ");
        String apellidoAtleta = sc.nextLine();
        System.out.print("Ingrese el nombre de la competencia: ");
        String nombreCompetencia = sc.nextLine();

        Atleta atleta = Delegacion.buscarAtleta(nombreAtleta, apellidoAtleta);
        Competencia competencia = jo.buscarCompetencia(nombreCompetencia);

        boolean valido = GestionDeParticipacion.validarRestricciones(atleta, competencia);

        if (valido) {
            System.out.println("El atleta cumple las restricciones.");
        } else {
            System.out.println("El atleta no cumple las restricciones.");
        }
    }

    public static boolean validarRestricciones(Atleta atleta, Competencia competencia) {

        if(atleta == null || competencia == null)
            return false;

        if(competencia.estaInscripto(atleta))
            return false;

        if(!atleta.getEspecialidad().equalsIgnoreCase(competencia.getDisciplina().getNombre()))
            return false;

        return true;
    }
}



