package Participante;

import Organizacion.Competencia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Disciplina {
    private String nombre;
    private Atleta atleta;
    private static List<Competencia> competencias = new ArrayList<>();


    public Disciplina(String nombre, Deporte deporte) {
        this.nombre = nombre;
        this.atleta = atleta;
    }

    public String getNombre() {
        return nombre;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    @Override
    public String toString() {
        return ("Nombre: "+ nombre );
    }

    public Iterable<Object> getCompetencias() {
        return null;
    }

    public void mostrarCompetencias() {
        System.out.println("\n🏅 Competencias de la disciplina " + nombre);
        Iterator<Competencia> it = competencias.iterator();

        while (it.hasNext()) {
            Competencia c = it.next();
            System.out.println(c.getNombre());
        }
    }
}
