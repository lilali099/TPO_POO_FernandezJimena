package Organizacion;

import Participante.Atleta;
import Participante.Entrenador;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Delegacion {
    private String nombre;
    private static List<Pais> paises = new ArrayList<>();
    private static List<Atleta> atletas = new ArrayList<>();
    private static List<Entrenador> entrenadores = new ArrayList<>();

    public Delegacion(String nombre) {
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }

    public List<Atleta> getAtletas() {
        return atletas;
    }

    public static void agregarPais(Pais pais) {
        Iterator<Pais> it = paises.iterator();

        while (it.hasNext()) {
            Pais p = it.next();

            if (p.getNombre().equalsIgnoreCase(pais.getNombre())) {
                System.out.println("❌ El país ya existe en la lista");
                return;
            }
        }

        paises.add(pais);
        System.out.println("✅ País agregado correctamente");
    }

    public static void agregarAtleta(Atleta atleta) {
        Iterator<Atleta> it = atletas.iterator();

        while (it.hasNext()) {
            Atleta a = it.next();
            if (a.getNombre().equalsIgnoreCase(atleta.getNombre())) {
                System.out.println("❌El atleta ya existe en la lista");
                return;
            }
        }
        atletas.add(atleta);
        System.out.println("✅ Atleta agregado correctamente");
    }

    public static void agregarEntrenador(Entrenador entrenador) {
        Iterator<Entrenador> it = entrenadores.iterator();

        while (it.hasNext()) {
            Entrenador e = it.next();
            if (e.getNombre().equalsIgnoreCase(entrenador.getNombre())) {
                System.out.println("❌El/la entrenador/a ya existe en la lista");
                return;
            }
        }
        entrenadores.add(entrenador);
        System.out.println("✅ Entrenador/a agregado/a correctamente");
    }

    public static Atleta buscarAtleta(String nombre, String apellido) {
        Iterator<Atleta> it = atletas.iterator();

        while (it.hasNext()) {

            Atleta a = it.next();

            if (a.getNombre().equalsIgnoreCase(nombre)) {
                return a;
            }
        }

        return null;
    }


    public void buscarEntrenador(String nombre) {
        Iterator<Entrenador> it = entrenadores.iterator();
        boolean encontrado = false;

        while (it.hasNext()) {
            Entrenador e = it.next();
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("🔍 Encontrado: " + e);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("❌ No se encontró el/la entrenador/a" + nombre);
        }
    }

    public static Pais buscarPais(String nombre){
        Iterator<Pais> it = paises.iterator();

        while (it.hasNext()) {

            Pais p = it.next();

            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }

        return null;
    }


    @Override
    public String toString() {
        return ("Nombre de la delegación: " + nombre);
    }
}

