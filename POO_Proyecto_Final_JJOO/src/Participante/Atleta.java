package Participante;

import Calificacion.Marca;
import Organizacion.Delegacion;
import Calificacion.Resultado;
import Premio.Medalla;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Atleta extends Persona implements Serializable {

    private double altura;
    private double peso;
    private Delegacion delegacion;
    private Resultado resultado;
    private String especialidad;
    private List<Medalla> medallas;
    private boolean dopingPositivo;

    public Atleta(String nombre, String apellido, int edad, String genero, String nacionalidad, double altura, double peso, String especialidad) {
        super(nombre, apellido, edad, genero, nacionalidad);
        this.altura = altura;
        this.peso = peso;
        this.especialidad = especialidad;
        medallas = new ArrayList<>();

    }


    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public Delegacion getDelegacion() {
        return delegacion;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public List<Medalla> getMedallas() {
        return medallas;
    }

    public void agregarMedalla(Medalla medalla) {
        medallas.add(medalla);
        System.out.println("✅ Medalla agregada correctamente");
    }

    public void agregarMarca(Marca marca) {
    }

    public boolean isDopingPositivo(){
        return dopingPositivo;
    }

    public void setDopingPositivo(boolean dopingPositivo){
        this.dopingPositivo = dopingPositivo;
    }

    public void quitarMedalla(boolean dopingPositivo){
        medallas.clear();
        System.out.println("Todas las medallas de: "+ getNombre()+ "fueron retiradas por doping positivo");

    }

    @Override
    public String toString() {
        return ("Altura: " + altura + " Peso:" + peso + " Especialidad:" + especialidad);
    }
}


