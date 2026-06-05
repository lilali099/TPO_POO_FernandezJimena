package Premio;

import Calificacion.Marca;
import Participante.Atleta;

public class Record {
    private Atleta atleta;
    private Marca marca;
    private String tipoRecord;

    public Record(Marca marca) {
        this.marca = marca;

    }



    public String getTipoRecord() {
        return tipoRecord;
    }

    public Marca getMarca() {
        return marca;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
