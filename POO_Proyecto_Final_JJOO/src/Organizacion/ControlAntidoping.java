package Organizacion;

import Participante.Atleta;

public class ControlAntidoping {
    private Atleta atleta;
    private Laboratorio laboratorio;
    private String estado;
    private String sustanciaEncontrada;


    public ControlAntidoping(Atleta atleta, Laboratorio laboratorio, String estado, String sustanciaEncontrada) {
        this.atleta = atleta;
        this.laboratorio = laboratorio;
        this.estado = estado;
        this.sustanciaEncontrada = sustanciaEncontrada;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public String getEstado() {
        return estado;
    }

    public String getSustanciaEncontrada() {
        return sustanciaEncontrada;
    }
}
