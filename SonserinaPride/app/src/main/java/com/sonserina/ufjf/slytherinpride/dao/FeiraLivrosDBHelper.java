package com.sonserina.ufjf.slytherinpride.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by thassya on 28/10/17.
 */

public class FeiraLivrosDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "feiraLivros.db";

    public FeiraLivrosDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(LivroContract.Livro.SQL_CREATE_LIVRO);
        sqLiteDatabase.execSQL(ParticipanteContract.Participante.SQL_CREATE_PARTICIPANTE);
        Log.i("FEIRA  ", ParticipanteContract.Participante.SQL_CREATE_PARTICIPANTE);
        sqLiteDatabase.execSQL(ReservaContract.Reserva.SQL_CREATE_RESERVA);
        Log.i("FEIRA Livros", "Tabelas Criadas! v" + DATABASE_VERSION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int antigo, int novo) {
        sqLiteDatabase.execSQL(LivroContract.Livro.SQL_DROP_LIVRO);
        sqLiteDatabase.execSQL(ParticipanteContract.Participante.SQL_DROP_PARTICIPANTE);
        sqLiteDatabase.execSQL(ReservaContract.Reserva.SQL_DROP_RESERVA);

        Log.i("FEIRA Livros", "Tabelas atualizadas de v" + antigo + " para v" + novo);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("FEIRA Livros", "Tabelas revertidas de v" + oldVersion + " para v" + newVersion);
        onUpgrade(db,oldVersion,newVersion);
    }
}


