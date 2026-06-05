package Calificacion;


public class Distancia extends Marca{


    public Distancia(double valor) {
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
