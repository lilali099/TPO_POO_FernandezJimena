package Organizacion;


public class Instalacion {
    private String nombre;


    public Instalacion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return ("Nombre de la instalación: " + nombre);
    }
}
