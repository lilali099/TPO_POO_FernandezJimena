package Menu;

import Organizacion.Competencia;
import Organizacion.Instalacion;
import Organizacion.JuegoOlimpico;
import Participante.Deporte;
import Participante.Disciplina;

import java.util.Scanner;

public class GestionDeportiva {

    private Scanner sc;
    private JuegoOlimpico jo;

    public GestionDeportiva(Scanner sc, JuegoOlimpico jo) {
        this.sc = sc;
        this.jo = jo;
    }

    public void mostrarMenu() {
        boolean volver = false;

        while (!volver) {

            System.out.println("\n===== GESTIÓN DEPORTIVA =====");
            System.out.println("1. Registrar deportes");
            System.out.println("2. Registrar disciplina");
            System.out.println("3. Crear competencia");
            System.out.println("4. Registrar instalaciones");
            System.out.println("0. Volver");

            System.out.print("Ingrese una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    registrarDeporte();
                    break;
                case 2:
                    registrarDisciplina();
                    break;
                case 3:
                    registrarCompetencia();
                    break;
                case 4:
                    registrarInstalacion();
                    break;
                case 0:
                    volver = true;
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }
    }
    public void registrarDeporte() {
        System.out.print("Ingrese nombre del deporte: ");
        String nombreDeporte = sc.nextLine();
        Deporte deporte=  new Deporte(nombreDeporte);
        jo.agregarDeporte(deporte);

    }
    public void registrarDisciplina() {
        System.out.print("Ingrese nombre de la disciplina: ");
        String nombreDisciplina = sc.nextLine();
        System.out.print("Ingrese nombre del deporte: ");
        String nombreDeporte = sc.nextLine();
        Deporte deporte = jo.buscarDeporte(nombreDeporte);

        if (deporte == null) {
            System.out.println("❌ Deporte inexistente");
            return;
        }
        Disciplina disciplina= new Disciplina(nombreDisciplina, deporte);
        deporte.agregarDisciplina(disciplina);
        jo.agregarDisciplina(disciplina);
        System.out.println("✅ Disciplina registrada correctamente");
    }
    public void registrarCompetencia() {
        System.out.println("Ingrese nombre de la competencia: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la disciplina: ");
        String nombreDisciplina = sc.nextLine();
        Disciplina disciplina = jo.buscarDisciplina(nombreDisciplina);
        if (disciplina == null) {
            System.out.println("❌ Disciplina no encontrada");
            return;
        }
        Competencia competencia = new Competencia(nombre, disciplina);

        jo.agregarCompetencia(competencia);

        disciplina.agregarCompetencia(competencia);

        System.out.println("✅ Competencia registrada correctamente");

    }
    public void registrarInstalacion() {
        System.out.println("Ingrese nombre de la instalación: ");
        String nombreInstalacion = sc.nextLine();
        Instalacion instalacion = new Instalacion(nombreInstalacion);
        jo.agregarInstalacion(instalacion);

    }
}
