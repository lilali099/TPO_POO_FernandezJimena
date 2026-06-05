package Calificacion;


import java.io.Serializable;

public class Tiempo extends Marca implements Serializable {


    public Tiempo(double valor) {
        super(valor);

    }


    @Override
    public boolean esMejorQue(Marca otraMarca) {
        return this.valor < otraMarca.getValor();
    }

    @Override
    public String mostrarMarca() {
       return "Tiempo: " +this.valor;

    }
}
