package com.sonserina.ufjf.slytherinpride.dao;

import android.provider.BaseColumns;

/**
 * Created by thassya on 29/11/17.
 */

public class ParticipanteContract {

    public static final String TYPE_TEXT= " VARCHAR ";
    public static final String TYPE_INT = " INTEGER ";
    public static final String TYPE_DATE = " TIMESTAMP";
    public static final String SEP = ", ";


    public static class Participante implements BaseColumns {
        public static final String TABLE_NAME = "participante";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_ENTRADA = "entrada";
        public static final String COLUMN_NAME_SAIDA = "saida";

        public static final String SQL_CREATE_PARTICIPANTE = "CREATE TABLE " + TABLE_NAME + "(" +
                _ID + TYPE_INT +  " PRIMARY KEY AUTOINCREMENT " + SEP +
                COLUMN_NAME_NOME + TYPE_TEXT + SEP +
                COLUMN_NAME_EMAIL + TYPE_TEXT + SEP +
                COLUMN_NAME_ENTRADA + TYPE_TEXT + SEP +
                COLUMN_NAME_SAIDA + TYPE_TEXT + ")";

        public static final String SQL_DROP_PARTICIPANTE = " DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public ParticipanteContract(){

    }
}
