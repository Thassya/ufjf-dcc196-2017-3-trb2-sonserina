package com.sonserina.ufjf.slytherinpride.models;

/**
 * Created by thassya on 22/10/17.
 */

public class Reserva {
    private Participante participante;
    private Livro livro;

    public Reserva(Participante participante, Livro livro) {
        this.participante = participante;
        this.livro = livro;
    }

    public Reserva() {
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public String toString() {
        return participante.getNome() + " - " + livro.getTitulo();
    }
}
