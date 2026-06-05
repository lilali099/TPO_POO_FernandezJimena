package Organizacion;

import Participante.Atleta;
import Premio.Medalla;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Pais implements Serializable {
    private String nombre;
    private static List<Delegacion> delegaciones = new ArrayList<>();

    public Pais(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarDelegacion(Delegacion delegacion) {
        Iterator<Delegacion> iterator = delegaciones.iterator();

        while (iterator.hasNext()) {
            Delegacion delegacionAux = (Delegacion) iterator.next();
            if (delegacionAux.getNombre().equals(delegacion.getNombre())) {
                System.out.println("La delegación ya existe en la lista");
            }
        }
        delegaciones.add(delegacion);
        System.out.println("Delegación agregada correctamente");
    }

    public Delegacion buscarDelegacion(String nombre){
        Iterator <Delegacion> iterator = delegaciones.iterator();
        boolean encontrado = false;
        while (iterator.hasNext()) {
            Delegacion delegacionAux = (Delegacion) iterator.next();
            if (getNombre().equals(delegacionAux.getNombre())) {
                System.out.println("Encrada"+ delegacionAux.getNombre());
                encontrado = true;
                return delegacionAux;
            }
        }
        if (!encontrado) {
            System.out.println("Delegación no encontrada");
        }
        return null;
    }


    public void mostrarMedallero(){

        int oro = 0;
        int plata = 0;
        int bronce = 0;
        System.out.println("Delegaciones del país: " + delegaciones.size());

        Iterator<Delegacion> itDelegaciones = delegaciones.iterator();

        while (itDelegaciones.hasNext()) {
            Delegacion delegacion = itDelegaciones.next();
            Iterator<Atleta> itAtletas = delegacion.getAtletas().iterator();
            System.out.println("Delegación: " + delegacion.getNombre());
            System.out.println("Atletas: " + delegacion.getAtletas().size());

            while (itAtletas.hasNext()) {

                Atleta atleta = itAtletas.next();
                Iterator<Medalla> itMedallas = atleta.getMedallas().iterator();

                while (itMedallas.hasNext()) {
                    Medalla medalla = itMedallas.next();

                    switch (medalla.getTipo()) {


                        case ORO:
                            oro++;
                            break;

                        case PLATA:
                            plata++;
                            break;

                        case BRONCE:
                            bronce++;
                            break;


                    }
                }
            }
        }

        System.out.println("\n🏅 MEDALLERO DE " + nombre.toUpperCase());
        System.out.println("🥇 Oro: " + oro);
        System.out.println("🥈 Plata: " + plata);
        System.out.println("🥉 Bronce: " + bronce);
    }



    @Override
    public String toString() {
        return ("Nombre: "+ nombre );
    }
}

