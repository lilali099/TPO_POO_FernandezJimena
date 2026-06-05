package Calificacion;

import Participante.Atleta;
import Premio.Medalla;

public class Resultado {

    private Atleta atleta;

    private Marca marca;

    private int posicion;

    private Record record;

    private Medalla medalla;

    public Resultado(Atleta atleta, Marca marca, int posicion) {
        this.atleta = atleta;
        this.marca = marca;
        this.posicion = posicion;

    }


    public Record getRecord() {
        return record;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public Marca getMarca() {
        return marca;
    }

    public int getPosicion() {
        return posicion;
    }

    public Medalla getMedalla() {
        return medalla;
    }


    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void asignarMedalla(Medalla medalla) {

        this.medalla = medalla;
    }

    public void asignarRecord(Record record) {

        this.record = record;
    }
}
