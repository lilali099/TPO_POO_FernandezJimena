package Participante;

import Organizacion.Competencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Disciplina implements Serializable {
    private String nombre;
    private Atleta atleta;
    private static List<Competencia> competencias = new ArrayList<>();


    public Disciplina(String nombre, Deporte deporte) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public static List<Competencia> getCompetencias() {
        return competencias;
    }

    public void agregarCompetencia(Competencia competencia){
        competencias.add(competencia);
        System.out.println("✅ Competencia agregada correctamente");
    }
    public void mostrarCompetencias() {
        System.out.println("\n🏅 Competencias de la disciplina " + nombre);
        Iterator<Competencia> it = competencias.iterator();

        while (it.hasNext()) {
            Competencia c = it.next();
            System.out.println(c.getNombre());
        }
    }

    @Override
    public String toString() {
        return ("Nombre disciplina: "+ nombre);
    }
}
