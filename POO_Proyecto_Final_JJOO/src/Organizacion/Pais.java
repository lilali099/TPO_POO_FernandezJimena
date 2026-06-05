package Organizacion;

import Participante.Atleta;
import Premio.Medalla;

import java.util.Iterator;
import java.util.List;



public class Pais {
    private String nombre;
    private List <Delegacion> delegaciones;

    public Pais(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }


    public void mostrarMedallero(){
        int oro = 0;
        int plata = 0;
        int bronce = 0;

        Iterator<Delegacion> itDelegaciones = delegaciones.iterator();

        while (itDelegaciones.hasNext()) {
            Delegacion delegacion = itDelegaciones.next();
            Iterator<Atleta> itAtletas = delegacion.getAtletas().iterator();

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

