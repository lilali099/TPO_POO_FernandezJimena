package Premio;

import java.io.Serializable;

public class Medalla implements Serializable {
    private TipoMedalla tipo;


    public Medalla(TipoMedalla tipo) {
        this.tipo = tipo;
    }

    public TipoMedalla getTipo() {
        return tipo;
    }
}
