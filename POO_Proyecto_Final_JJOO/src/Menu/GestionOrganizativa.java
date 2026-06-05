package Menu;

import Organizacion.Delegacion;
import Organizacion.JuegoOlimpico;
import Organizacion.Pais;
import Participante.Atleta;
import Participante.Entrenador;
import Participante.Persona;

import java.util.Scanner;

public class GestionOrganizativa {
    private Scanner sc;
    private JuegoOlimpico jo;

    public GestionOrganizativa(Scanner sc, JuegoOlimpico jo) {
        this.sc = sc;
        this.jo = jo;
    }

    public void mostrarMenu() {
        boolean volver = false;

        while (!volver) {

            System.out.println("\n===== GESTIÓN ORGANIZATIVA =====");
            System.out.println("1. Registrar país");
            System.out.println("2. Crear delegación");
            System.out.println("3. Registrar atleta");
            System.out.println("4. Registrar entrenador");
            System.out.println("0. Volver");

            System.out.print("Ingrese una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    registrarPais();
                    break;

                case 2:
                    crearDelegacion();
                    break;

                case 3:
                    registrarAtleta();
                    break;

                case 4:
                    registrarEntrenador();
                    break;

                case 0:
                    volver = true;
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void registrarPais() {

        System.out.print("Ingrese nombre del país: ");
        String nombre = sc.nextLine();
        Pais pais = new Pais(nombre);
        Delegacion.agregarPais(pais);
    }

    private void crearDelegacion() {

        System.out.print("Ingrese nombre de la delegación: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese nombre del país: ");
        String nombrePais = sc.nextLine();

        Pais pais = Delegacion.buscarPais(nombrePais);

        if (pais == null) {
            System.out.println("❌ País inexistente.");
            return;
        }

        Delegacion delegacion = new Delegacion(nombre);

        jo.agregarDelegacion(delegacion);

        pais.agregarDelegacion(delegacion);

        System.out.println("✅ Delegación creada correctamente.");
    }

    private void registrarAtleta() {

        System.out.print("Ingrese nombre del atleta: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese apellido del atleta: ");
        String apellidoAtleta = sc.nextLine();

        System.out.print("Ingrese edad del atleta: ");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese nacionalidad del atleta: ");
        String nacionalidadAtleta = sc.nextLine();

        System.out.print("Ingrese género del atleta: ");
        String generoAtleta = sc.nextLine();

        System.out.print("Ingrese altura del atleta: ");
        double altura = sc.nextDouble();

        System.out.print("Ingrese el peso del atleta: ");
        double peso = sc.nextDouble();
        sc.nextLine();

        System.out.print("Ingrse la especialidad atleta: ");
        String especialidad = sc.nextLine();



        Persona a = new Atleta (nombre, apellidoAtleta, edad, nacionalidadAtleta, generoAtleta, altura, peso, especialidad);
        Delegacion.agregarAtleta((Atleta) a);
    }

    private void registrarEntrenador() {

        System.out.print("Ingrese nombre del entrenador: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese apellido del entrenador/a: ");
        String apellidoEntrenador = sc.nextLine();

        System.out.print("Ingrese años de experiancia del entrenador/a: ");
        int aniosExperiencia = sc.nextInt();

        System.out.print("Ingrese nacionalidad del entrenador/a: ");
        String nacionalidadEntrenador = sc.nextLine();

        System.out.print("Ingrese género entrenador/a: ");
        String generoEntrenador = sc.nextLine();

        Persona e = new Entrenador(nombre, apellidoEntrenador, aniosExperiencia, nacionalidadEntrenador, generoEntrenador);
        Delegacion.agregarEntrenador();
    }

}
