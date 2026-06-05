package Menu;

import Calificacion.*;
import Organizacion.Competencia;
import Organizacion.Delegacion;
import Organizacion.JuegoOlimpico;
import Participante.Atleta;
import Participante.Entrenador;
import Premio.Medalla;
import Premio.TipoMedalla;

import java.util.Iterator;
import java.util.Scanner;

import static Organizacion.Competencia.resultados;

public class GestionResultado {
    private Scanner sc = new Scanner(System.in);
    private JuegoOlimpico jo;


    public GestionResultado(Scanner sc, JuegoOlimpico jo) {
        this.sc = sc;
        this.jo = jo;
    }

    public void mostrarMenu() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n===== GESTIÓN DE RESULTADOS =====");
            System.out.println("1. Registrar resultado/marca");
            System.out.println("2. Determinar ranking de la competencia");
            System.out.println("3. Asignar medallas");
            System.out.println("4. Registrar y actualizar récord");
            System.out.println("0. Volver");

            System.out.print("Ingrese una opción: ");


        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {

            case 1:
                registrarResultado();
                break;


            case 2:
                determinarRanking();
                break;

            case 3:
                asignarMedalla();
                break;

            case 4:
                registrarRecord();
                break;

            case 0:
                volver = true;
                break;

            default:
                System.out.println("Opción inválida");
        }


        }
    }


        private void registrarResultado() {
            System.out.print("Competencia: ");
            String nombreCompetencia = sc.nextLine();

            System.out.print("Atleta: ");
            String nombreAtleta = sc.nextLine();

            System.out.println("Tipo de marca:");
            System.out.println("1. Tiempo");
            System.out.println("2. Distancia");
            System.out.println("3. Puntaje");

            int tipo = sc.nextInt();

            System.out.print("Valor de la marca: ");
            double valor = sc.nextDouble();

            System.out.print("Posición obtenida: ");
            int posicion = sc.nextInt();

            sc.nextLine();
            Competencia competencia = jo.buscarCompetencia(nombreCompetencia);
            String apellidoAtleta = null;
            Atleta atleta = Delegacion.buscarAtleta(nombreAtleta, apellidoAtleta);

            if (competencia == null) {
                System.out.println("❌ No existe la competencia.");
                return;
            }

            if (atleta == null) {
                System.out.println("❌ No existe el atleta.");
                return;
            }

            Marca marca;

            switch (tipo) {
                case 1:
                    marca = new Tiempo(valor);
                    break;
                case 2:
                    marca = new Distancia(valor);
                    break;
                case 3:
                    marca = new Puntaje(valor);
                    break;
                default:
                    System.out.println("❌ Tipo de marca inválido.");
                    return;
            }

            Resultado resultado = new Resultado(atleta, marca, posicion);
            competencia.agregarResultado(resultado);
            System.out.println("✅ Resultado registrado.");
        }

    private void determinarRanking() {

        System.out.print("Competencia: ");
        String nombreCompetencia = sc.nextLine();
        Competencia competencia = jo.buscarCompetencia(nombreCompetencia);

        if (competencia == null) {
            System.out.println("❌ Competencia inexistente.");
            return;
        }

        competencia.determinarRanking();
        System.out.println("✅ Ranking generado.");
    }






    private void asignarMedalla() {
        System.out.print("Competencia: ");
        String nombreCompetencia = sc.nextLine();

        Competencia competencia = jo.buscarCompetencia(nombreCompetencia);

        if (competencia == null) {
            System.out.println("❌ Competencia inexistente.");
            return;
        }

        competencia.asignarMedalla();
        System.out.println("✅ Medallas asignadas.");
    }


    public void registrarRecord() {
        System.out.print("Competencia: ");
        String nombreCompetencia = sc.nextLine();
        Competencia competencia = jo.buscarCompetencia(nombreCompetencia);

        if (competencia == null) {
            System.out.println("❌ Competencia inexistente.");
            return;
        }

        competencia.verificarRecord();
        System.out.println("✅ Récord actualizado.");
    }
}
