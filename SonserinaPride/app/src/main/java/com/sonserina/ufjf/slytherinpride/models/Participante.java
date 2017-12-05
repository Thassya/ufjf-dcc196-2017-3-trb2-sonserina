package com.sonserina.ufjf.slytherinpride.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by thassya on 10/10/17.
 */

//Parcelable pra poder enviar pra intent o objeto todo
public class Participante implements Parcelable  {
    private String nome;
    private String email;
    private String dataEntrada;
    private String dataSaida;

    public Participante() {
    }

    public Participante(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.dataEntrada = null;
        this.dataSaida = null;
    }

    private Participante(Parcel from){
        nome = from.readString();
        email = from.readString();
        dataEntrada =from.readString();
        dataSaida = from.readString();
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    @Override
    public String toString() {
        return nome;
    }


    @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(email);
        dest.writeString(dataEntrada);
        dest.writeString(dataSaida);
    }

    @Override
    public boolean equals(Object participante) {
        if (nome.equals(((Participante) participante).getNome())
                && this.email.equals(((Participante) participante).getEmail())){
            return true;
        }
        return false;
    }
}
