package Calificacion;

import java.io.Serializable;

public abstract class Marca implements Serializable {
    protected double valor;

    public Marca(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public abstract boolean esMejorQue(Marca otraMarca);

    public abstract String mostrarMarca();



}
