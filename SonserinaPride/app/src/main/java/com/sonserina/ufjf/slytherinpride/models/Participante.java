package com.sonserina.ufjf.slytherinpride.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by thassya on 10/10/17.
 */

public class Participante {
    private final String nome;
    private final String email;

    public Participante(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return nome + " - " + email;
    }


}
