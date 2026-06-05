package Participante;

import Organizacion.Competencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Deporte implements Serializable {
    private String nombre;
    private List<Disciplina> disciplinas = new ArrayList<>();
    private List<Competencia> competencias = new ArrayList<>();


    public Deporte(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void agregarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
        System.out.println("✅ Disciplina agregada correctamente");

    }

    public void buscarDisciplina(String nombre) {
        Iterator<Disciplina> it = disciplinas.iterator();
        boolean encontrado = false;

        while (it.hasNext()) {
            Disciplina d = it.next();
            if (d.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("🔍 Encontrado: " + d);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("❌ No se encontró la disciplina" + nombre);
        }
    }

    public void mostrarCompetencias(){
        System.out.println("\n🏅 Competencias del deporte " + nombre);
        Iterator<Disciplina> itDisc = disciplinas.iterator();

        while (itDisc.hasNext()) {
            Disciplina d = itDisc.next();
            Iterator<Competencia> itComp = d.getCompetencias().iterator();
            while (itComp.hasNext()) {
                Competencia c = (Competencia) itComp.next();
                System.out.println(c.getNombre());
            }
        }
    }

    @Override
    public String toString() {
        return ("Nombre: "+ nombre );
    }
}


