package Participante;

import Organizacion.Delegacion;

import java.io.Serializable;

public class Entrenador extends Persona implements Serializable {
    private int aniosExperiencia;


    public Entrenador(String nombre, String apellido, int edad, String genero, String nacionalidad) {
        super(nombre, apellido, edad, genero, nacionalidad);
        this.aniosExperiencia = 0;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    @Override
    public String toString() {
       return ("Años experiencia: "+ aniosExperiencia );
    }
}
