package Participante;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String nacionalidad;


    public Persona(String nombre, String apellido, int edad, String genero, String nacionalidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.nacionalidad = nacionalidad;

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    @Override
    public String toString() {
        return ("Nombre: "+ nombre+ " Apellido: " + apellido + " Edad: "+ edad + "Genero: "+ genero + " Nacionalidad: "+ nacionalidad );
    }
}
