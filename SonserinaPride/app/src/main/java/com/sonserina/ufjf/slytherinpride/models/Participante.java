package com.sonserina.ufjf.slytherinpride.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by thassya on 10/10/17.
 */

public class Participante implements Parcelable {
    private final String nome;
    private final String email;

    public Participante(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    private Participante(Parcel p){
        nome = p.readString();
        email = p.readString();
    }

    public static final Creator<Participante> CREATOR = new Creator<Participante>() {
        @Override
        public Participante createFromParcel(Parcel in) {
            return new Participante(in);
        }

        @Override
        public Participante[] newArray(int size) {
            return new Participante[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(email);
    }
}
