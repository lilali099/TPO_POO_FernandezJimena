package Organizacion;

import Participante.Atleta;

import java.util.List;

public class Laboratorio {
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
            atleta.quitarMedallas();
        } else {
            System.out.println("✅ " + atleta.getNombre() + " pasó el control antidoping.");
        }

        return positivo;
    }
}
