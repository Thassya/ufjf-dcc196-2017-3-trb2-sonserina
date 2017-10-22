package com.sonserina.ufjf.slytherinpride.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thassya on 21/10/17.
 */

public class Livro implements Parcelable {
    private String titulo;
    private String editora;
    private Integer ano;

    private ArrayList<Participante> reservas;

    public Livro() {
    }

    public Livro(String titulo, String editora, Integer ano) {
        this.titulo = titulo;
        this.editora = editora;
        this.ano = ano;
    }

    protected Livro(Parcel in) {
        titulo = in.readString();
        editora = in.readString();
        ano = in.readInt();
        reservas = in.createTypedArrayList(Participante.CREATOR);
    }

    public static final Creator<Livro> CREATOR = new Creator<Livro>() {
        @Override
        public Livro createFromParcel(Parcel in) {
            return new Livro(in);
        }

        @Override
        public Livro[] newArray(int size) {
            return new Livro[size];
        }
    };

    public String getTitulo() {
        return titulo;
    }

    public String getEditora() {
        return editora;
    }

    public Integer getAno() {
        return ano;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public ArrayList<Participante> getReservas() {
        return reservas;
    }

    public void setReserva(Participante participante) {
        this.reservas.add(participante);
    }

    @Override
    public String toString() {
        return getTitulo();
    }

    @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(editora);
        dest.writeInt(ano);
        dest.writeTypedList(reservas);
    }

    @Override
    public boolean equals(Object livro) {
        if (titulo.equals(((Livro) livro).getTitulo())
                && this.editora.equals(((Livro) livro).getEditora())){
            return true;
        }
        return false;
    }
}
