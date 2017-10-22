package com.sonserina.ufjf.slytherinpride.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by thassya on 10/10/17.
 */

//Parcelable pra poder enviar pra intent o objeto todo
public class Participante implements Parcelable  {
    private String nome;
    private String email;
    private Date dataEntrada;
    private Date dataSaida;

    public Participante() {
    }

    public Participante(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.dataEntrada = null;
        this.dataSaida = null;
    }

    public Participante(String nome, String email, Date dataEntrada) {
        this.nome = nome;
        this.email = email;
        this.dataEntrada = dataEntrada;
        this.dataSaida=null;
    }

    private Participante(Parcel from){
        nome = from.readString();
        email = from.readString();
        dataEntrada = new Date(from.readLong());
        dataSaida = new Date(from.readLong());
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

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
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
        dest.writeLong(dataEntrada == null ? -1 : dataEntrada.getTime());
        dest.writeLong(dataSaida == null ? -1 : dataSaida.getTime());
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
