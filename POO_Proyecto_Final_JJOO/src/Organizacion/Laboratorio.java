package Organizacion;

import Participante.Atleta;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class Laboratorio implements Serializable {
    private String nombre;
    private String pais;
    List<ControlAntidoping> antidopings;

    public Laboratorio(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean realizarControl(Atleta atleta) {
        boolean positivo = atleta.isDopingPositivo();

        if (positivo) {
            System.out.println("❌ " + atleta.getNombre() + " dio positivo en el control antidoping.");
            atleta.quitarMedalla(true);
        } else {
            System.out.println("✅ " + atleta.getNombre() + " pasó el control antidoping.");
        }

        return positivo;
    }
}
