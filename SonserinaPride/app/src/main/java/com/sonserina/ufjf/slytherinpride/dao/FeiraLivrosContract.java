package com.sonserina.ufjf.slytherinpride.dao;

import android.provider.BaseColumns;

/**
 * Created by thassya on 28/10/17.
 */

public class FeiraLivrosContract {
    public static final String TYPE_TEXT= " VARCHAR ";
    public static final String TYPE_INT = " INTEGER ";
    public static final String TYPE_DATE = "DATE";
    public static final String SEP = ", ";

    public static class Livro implements BaseColumns {
        public static final String TABLE_NAME = "livro";
        public static final String COLUMN_NAME_TITULO = "titulo";
        public static final String COLUMN_NAME_EDITORA = "editora";
        public static final String COLUMN_NAME_ANO = "ano";

        public static final String SQL_CREATE_LIVRO = "CREATE TABLE " + TABLE_NAME + "(" +
                _ID + TYPE_INT +  " PRIMARY KEY AUTOINCREMENT" + SEP +
                COLUMN_NAME_TITULO + TYPE_TEXT+ SEP +
                COLUMN_NAME_EDITORA + TYPE_TEXT+ SEP +
                COLUMN_NAME_ANO + TYPE_INT + ")";

        public static final String SQL_DROP_LIVRO = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }


    public static class Participante implements BaseColumns {
        public static final String TABLE_NAME = "participante";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_ENTRADA = "dtEntrada";
        public static final String COLUMN_NAME_SAIDA = "dtSaida";

        public static final String SQL_CREATE_PARTICIPANTE = "CREATE TABLE " + TABLE_NAME + "(" +
                _ID + TYPE_INT +  " PRIMARY KEY AUTOINCREMENT" + SEP +
                COLUMN_NAME_NOME + TYPE_TEXT+ SEP +
                COLUMN_NAME_EMAIL + TYPE_TEXT+ SEP +
                COLUMN_NAME_ENTRADA + TYPE_DATE + SEP +
                COLUMN_NAME_SAIDA + TYPE_DATE + ")";

        public static final String SQL_DROP_PARTICIPANTE ="DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class Reserva implements BaseColumns {
        public static final String TABLE_NAME = "reserva";
        public static final String COLUMN_NAME_PARTICIPANTE = "participante";
        public static final String COLUMN_NAME_LIVRO = "livro";

        public static final String SQL_CREATE_RESERVA = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_NAME_PARTICIPANTE + TYPE_INT + SEP + "FOREIGN KEY (" + COLUMN_NAME_PARTICIPANTE + ") REFERENCES " + Participante.TABLE_NAME + "("+Participante._ID+") " + SEP +
                COLUMN_NAME_LIVRO + TYPE_INT + SEP + "FOREIGN KEY (" + COLUMN_NAME_LIVRO +") REFERENCES " + Livro.TABLE_NAME + " (" + Livro._ID  + " ));";

        public static final String SQL_DROP_RESERVA ="DROP TABLE IF EXISTS " + TABLE_NAME;
    }

}
