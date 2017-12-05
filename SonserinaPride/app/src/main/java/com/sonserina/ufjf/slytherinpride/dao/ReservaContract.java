package com.sonserina.ufjf.slytherinpride.dao;

import android.provider.BaseColumns;

/**
 * Created by thassya on 29/11/17.
 */

public class ReservaContract {

    public static final String TYPE_TEXT= " VARCHAR ";
    public static final String TYPE_INT = " INTEGER ";
    public static final String TYPE_DATE = " DATE";
    public static final String SEP = ", ";

    public static class Reserva implements BaseColumns {
        public static final String TABLE_NAME = "reserva";
        public static final String COLUMN_NAME_PARTICIPANTE = "participante";
        public static final String COLUMN_NAME_LIVRO = "livro";

        public static final String SQL_CREATE_RESERVA = "CREATE TABLE " + TABLE_NAME + "(" +
                Reserva._ID + TYPE_INT + " PRIMARY KEY AUTOINCREMENT" + SEP +
                Reserva.COLUMN_NAME_PARTICIPANTE + TYPE_INT + SEP +
                Reserva.COLUMN_NAME_LIVRO + TYPE_INT + SEP +
                " FOREIGN KEY ("+ COLUMN_NAME_PARTICIPANTE + ") REFERENCES "+
                ParticipanteContract.Participante.TABLE_NAME + "("+ParticipanteContract.Participante._ID + ")" + SEP+
                " FOREIGN KEY ("+ COLUMN_NAME_LIVRO + ") REFERENCES " +
                LivroContract.Livro.TABLE_NAME +"("+LivroContract.Livro._ID + "))";

        public static final String SQL_DROP_RESERVA ="DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String SQL_CONSULTA_RESERVAS = "SELECT participante._id, " + ParticipanteContract.Participante.COLUMN_NAME_NOME + " FROM " + TABLE_NAME +
                " INNER JOIN " + LivroContract.Livro.TABLE_NAME +
                " livro ON ("+ COLUMN_NAME_LIVRO+"=livro."+LivroContract.Livro._ID+")"+
                " INNER JOIN "+ParticipanteContract.Participante.TABLE_NAME+
                " participante ON ("+ COLUMN_NAME_PARTICIPANTE+"= participante."+ ParticipanteContract.Participante._ID+")";

        public static final String SQL_CONSULTA_RESERVAS_POR_LIVRO = "SELECT livro._id, " + LivroContract.Livro.COLUMN_NAME_TITULO + " FROM " + TABLE_NAME +
                " INNER JOIN " + LivroContract.Livro.TABLE_NAME +
                " livro ON ("+ COLUMN_NAME_LIVRO+"=livro."+LivroContract.Livro._ID+")"+
                " INNER JOIN "+ParticipanteContract.Participante.TABLE_NAME+
                " participante ON ("+ COLUMN_NAME_PARTICIPANTE+"= participante."+ ParticipanteContract.Participante._ID+")";

    }

    public ReservaContract(){}
}
