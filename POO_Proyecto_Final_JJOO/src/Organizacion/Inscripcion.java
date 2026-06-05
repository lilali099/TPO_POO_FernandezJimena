package Organizacion;

import Participante.Atleta;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Inscripcion implements Serializable {

    private LocalDateTime fechaHoraInscripcion;
    private Atleta atleta;
    private Competencia competencia;


    public Inscripcion(Atleta atleta, Competencia competencia) {
        this.atleta = atleta;
        this.competencia= competencia;
        this.fechaHoraInscripcion = LocalDateTime.now();

    }

    public LocalDateTime getFechaInscripcion() {
        return fechaHoraInscripcion;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public Competencia getCompetencia() {
        return competencia;
    }


    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }





}

