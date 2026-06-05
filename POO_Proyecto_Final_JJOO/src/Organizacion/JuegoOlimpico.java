package Organizacion;

import Participante.Deporte;
import Participante.Disciplina;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class JuegoOlimpico implements Serializable {
    private String nombre;
    private String sede;
    private int anio;
    private static List<Delegacion> delegaciones = new ArrayList<>();
    private static List<Competencia> competiciones = new ArrayList<>();
    private static List<Instalacion> instalaciones = new ArrayList<>();
    private static List<Deporte> deportes = new ArrayList<>();
    private static List<Disciplina> disciplinas = new ArrayList<>();


    public JuegoOlimpico(String nombre, String sede, int anio) {
        this.nombre = nombre;
        this.sede = sede;
        this.anio = anio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSede() {
        return sede;
    }

    public int getAnio() {
        return anio;
    }

    public void agregarDisciplina(Disciplina d) {
        disciplinas.add(d);
    }

    public static Disciplina buscarDisciplina(String nombre) {
        Iterator<Disciplina> it = disciplinas.iterator();
        boolean encontrado = false;

        while (it.hasNext()) {
            Disciplina di = it.next();
            if (di.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("🔍 Encontrado: " + di);
                encontrado = true;

                return di;
            }
        }

        if (!encontrado) {
            System.out.println("❌ No se encontró la disciplina");
        }
        return null;
    }


    public static void agregarDelegacion(Delegacion delegacion) {
        Iterator<Delegacion> it = JuegoOlimpico.delegaciones.iterator();

        while (it.hasNext()) {
            Delegacion d = it.next();

            if (d.getNombre().equalsIgnoreCase(delegacion.getNombre())) {
                System.out.println("❌ La delegación ya existe en la lista");
                return;
            }
        }
        JuegoOlimpico.delegaciones.add(delegacion);
        System.out.println("✅ Delegación agregada correctamente");
    }


    public void buscarDelegacion(String nombre) {
        Iterator<Delegacion> it = JuegoOlimpico.delegaciones.iterator();
        boolean encontrado = false;

        while (it.hasNext()) {
            Delegacion d = it.next();
            if (d.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("🔍 Encontrado: " + d);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("❌ No se encontró la delegación");
        }
    }


    public static void agregarCompetencia(Competencia competencia) {
        competiciones.add(competencia);
        System.out.println("✅ Competencia agregada correctamente");
    }


    public static void agregarInstalacion(Instalacion instalacion) {
        Iterator<Instalacion> it = instalaciones.iterator();

        while (it.hasNext()) {
            Instalacion i = it.next();

            if (i.getNombre().equalsIgnoreCase(instalacion.getNombre())) {
                System.out.println("❌ La instalación ya existe en la lista");
                return;
            }
        }
        instalaciones.add(instalacion);
        System.out.println("✅ Instalación agregada correctamente");
    }

    public static void agregarDeporte(Deporte deporte) {
        deportes.add(deporte);
        System.out.println("✅ Deporte agregado correctamente");
    }

    public void obtenerInstalacion() {
        if (instalaciones.isEmpty()) {
            System.out.println("No hay instalaciones agregadas");
            return;
        }

        Iterator<Instalacion> it = instalaciones.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static Competencia buscarCompetencia(String nombre) {
        Iterator<Competencia> it = competiciones.iterator();

        while (it.hasNext()) {
            Competencia c = it.next();

            if (c.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("🔍 Encontrado: " + c);
                return c;
            }
        }

        System.out.println("❌ No se encontró la competencia");
        return null;
    }


    public Instalacion buscarInstalacion(String nombre) {
        Iterator<Instalacion> it = instalaciones.iterator();
        boolean encontrado = false;

        while (it.hasNext()) {
            Instalacion i = it.next();
            if (i.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("🔍 Encontrado: " + i);
                return i;
            }
        }

        if (!encontrado) {
            System.out.println("❌ No se encontró la instalación");
        }
        return null;
    }

    public static Deporte buscarDeporte(String nombre) {
        Iterator<Deporte> it = deportes.iterator();
        boolean encontrado = false;

        while (it.hasNext()) {
            Deporte de = it.next();
            if (de.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("🔍 Encontrado: " + de);
                return de;
            }
        }

        if (!encontrado) {
            System.out.println("❌ No se encontró el deporte");
        }
        return null;
    }

    public void mostrarRecords() {
        Iterator<Competencia> it = JuegoOlimpico.competiciones.iterator();

        while (it.hasNext()) {
            Competencia c = it.next();
            if (c.getRecordActual() != null) {
                System.out.println(c.getNombre() + " -> " + c.getRecordActual()
                );
            }
        }
    }

    @Override
    public String toString() {
        return ("Nombre del juego olimpico :" + nombre + " Sede: " + sede + " Año: " + anio);
    }
}


