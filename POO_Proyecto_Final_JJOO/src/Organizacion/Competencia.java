package Organizacion;

import Calificacion.Marca;
import Calificacion.Resultado;
import Participante.Atleta;
import Participante.Disciplina;
import Participante.Entrenador;
import Premio.Medalla;
import Premio.TipoMedalla;
import Premio.Record;

import java.util.*;

import static jdk.internal.foreign.abi.s390.S390Architecture.Regs.r1;

public class Competencia {
    private String nombre;
    private Disciplina disciplina;
    private Marca marca;
    private static List<Inscripcion> inscripciones = new ArrayList<>();
    private static List<Instalacion> instalaciones = new ArrayList<>();
    public static List<Resultado> resultados = new ArrayList<>();
    private Record recordActual;


    public Competencia(String nombre, Disciplina disciplina) {
        this.nombre = nombre;
        this.disciplina = disciplina;
        this.inscripciones = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Marca getMarca() {
        return marca;
    }

    public Record getRecordActual() {
        return recordActual;
    }

    public void agregarInscripcion (Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }
    public void agregarInstalacion (Instalacion instalacion) {
        instalaciones.add(instalacion);
    }
    


    public boolean estaInscripto(Atleta atleta){

        for(Inscripcion i : inscripciones){

            if(i.getAtleta().equals(atleta)){
                return true;
            }
        }

        return false;
    }


    public void determinarRanking() {

        for (int i = 0; i < resultados.size() - 1; i++) {

            for (int j = i + 1; j < resultados.size(); j++) {

                Resultado r1 = resultados.get(i);
                Resultado r2 = resultados.get(j);

                if (!r1.getMarca().esMejorQue(r2.getMarca())) {

                    Resultado aux = resultados.get(i);
                    resultados.set(i, resultados.get(j));
                    resultados.set(j, aux);
                }
            }
        }

        int posicion = 1;

        Iterator<Resultado> it = resultados.iterator();

        while (it.hasNext()) {
            Resultado r = it.next();
            r.setPosicion(posicion++);
        }
    }



    public void asignarMedalla() {
        Iterator<Resultado> it = resultados.iterator();

        while (it.hasNext()) {

            Resultado r = it.next();

            switch (r.getPosicion()) {

                case 1:
                    r.getAtleta().agregarMedalla(
                            new Medalla(TipoMedalla.ORO));
                    break;

                case 2:
                    r.getAtleta().agregarMedalla(
                            new Medalla(TipoMedalla.PLATA));
                    break;

                case 3:
                    r.getAtleta().agregarMedalla(
                            new Medalla(TipoMedalla.BRONCE));
                    break;
            }
        }
    }


    public void agregarResultado(Resultado resultado) {
        resultados.add(resultado);
    }



    public void verificarRecord() {
        if (resultados.isEmpty()) {
            System.out.println("No hay resultados registrados.");
            return;
        }
        Resultado mejorResultado = resultados.get(0);

        if (recordActual == null) {
            recordActual = new Record(mejorResultado.getMarca());
            System.out.println("Primer récord registrado");
            return;
        }

        if (mejorResultado.getMarca().esMejorQue(recordActual.getMarca())) {
            recordActual.setMarca(mejorResultado.getMarca());
            System.out.println("Nuevo récord");
        }

    }
    public void mostrarResultados() {
        if (resultados.isEmpty()) {
            System.out.println("No hay resultados.");
            return;
        }
        Iterator<Resultado> it = resultados.iterator();

        while (it.hasNext()) {
            Resultado r = it.next();
            System.out.println(r.getPosicion() + "° - " + r.getAtleta().getNombre()
                            + " - " + r.getMarca().mostrarMarca()
            );
        }
    }


    @Override
    public String toString() {
        return ("Nombre competencia :" + nombre);
    }


}
