package Calificacion;

import java.io.Serializable;

public class Puntaje extends Marca implements Serializable {


    public Puntaje(double valor) {
        super(valor);
    }


    @Override
    public boolean esMejorQue(Marca otraMarca) {
        return this.valor > otraMarca.getValor();
    }

    @Override
    public String mostrarMarca() {
        return "Puntaje: " +this.valor;
    }
}
