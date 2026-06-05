package Menu;

import Organizacion.Competencia;
import Organizacion.Delegacion;
import Organizacion.JuegoOlimpico;
import Organizacion.Pais;
import Participante.Deporte;
import Participante.Disciplina;

import java.util.Scanner;

public class ConsultasDelSistema {
    private Scanner sc;
    private JuegoOlimpico jo;

    public ConsultasDelSistema(Scanner sc, JuegoOlimpico jo) {
        this.sc = sc;
        this.jo = jo;
    }

    public void mostrarMenu() {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n===== CONSULTAS DEL SISTEMA =====");
            System.out.println("1. Medallero por país");
            System.out.println("2. Competencia asociada a un deporte");
            System.out.println("3. Competencia asociada a una disciplina");
            System.out.println("4. Resultados de competencia");
            System.out.println("5. Récords vigentes");
            System.out.println("0. Volver");


            System.out.print("Ingrese una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();


            switch (opcion) {

                case 1:
                    medalleroPorPais();
                    break;
                case 2:
                    competenciaAsociadaADeporte();
                    break;
                case 3:
                    competenciaAsociadaADisciplina();
                    break;
                case 4:
                    resultadoCompetencia();
                    break;
                case 5:
                    recordVigente();
                    break;
                case 0:
                    volver = true;
                    break;

                default:
                    System.out.println("Opción inválida");

            }
        }
    }
    public void medalleroPorPais(){
        System.out.print("Ingrese el nombre del país: ");
        String nombrePais = sc.nextLine();

        Pais pais = Delegacion.buscarPais(nombrePais);

        if (pais == null) {
            System.out.println("❌ País no encontrado.");
            return;
        }

        pais.mostrarMedallero();

    }

    public void competenciaAsociadaADeporte(){
        System.out.print("Nombre del deporte: ");
        String nombre = sc.nextLine();

        Deporte deporte = JuegoOlimpico.buscarDeporte(nombre);

        if (deporte == null) {
            System.out.println("❌ Deporte inexistente");
            return;
        }

        deporte.mostrarCompetencias();
    }

    public void competenciaAsociadaADisciplina(){
        System.out.print("Nombre de la disciplina: ");
        String nombre = sc.nextLine();

        Disciplina disciplina = JuegoOlimpico.buscarDisciplina(nombre);

        if (disciplina == null) {
            System.out.println("❌ Disciplina inexistente");
            return;
        }

        disciplina.mostrarCompetencias();
    }
    public void resultadoCompetencia(){
        System.out.print("Competencia: ");
        String nombre = sc.nextLine();

        Competencia competencia = jo.buscarCompetencia(nombre);
        if (competencia == null) {
            System.out.println("❌ Competencia inexistente");
            return;
        }
        competencia.mostrarResultados();
    }
    public void recordVigente(){
        jo.mostrarRecords();
    }

}
