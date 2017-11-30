package com.sonserina.ufjf.slytherinpride.dao;

import android.provider.BaseColumns;

/**
 * Created by thassya on 29/11/17.
 */

public class ReservaContract {

    public static final String TYPE_TEXT= " VARCHAR ";
    public static final String TYPE_INT = " INTEGER ";
    public static final String TYPE_DATE = "DATE";
    public static final String SEP = ", ";

    public static final String SQL_CREATE_RESERVA = "CREATE TABLE " + Reserva.TABLE_NAME + "(" +
            Reserva.COLUMN_NAME_PARTICIPANTE + TYPE_INT + SEP + "FOREIGN KEY (" +
            Reserva.COLUMN_NAME_PARTICIPANTE + ") REFERENCES " +
            ParticipanteContract.Participante.TABLE_NAME + "("+ ParticipanteContract.Participante._ID+") " + SEP +
            Reserva.COLUMN_NAME_LIVRO + TYPE_INT + SEP + "FOREIGN KEY (" + Reserva.COLUMN_NAME_LIVRO +") REFERENCES " +
            LivroContract.Livro.TABLE_NAME + " (" + LivroContract.Livro._ID  + " ));";

    public static final String SQL_DROP_RESERVA ="DROP TABLE IF EXISTS " + Reserva.TABLE_NAME;

    public static class Reserva implements BaseColumns {
        public static final String TABLE_NAME = "reserva";
        public static final String COLUMN_NAME_PARTICIPANTE = "participante";
        public static final String COLUMN_NAME_LIVRO = "livro";

    }

    public ReservaContract(){}
}
