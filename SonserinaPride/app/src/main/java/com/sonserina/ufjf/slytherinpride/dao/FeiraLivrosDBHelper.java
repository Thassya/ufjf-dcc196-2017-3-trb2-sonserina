package com.sonserina.ufjf.slytherinpride.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by thassya on 28/10/17.
 */

public class FeiraLivrosDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "feiraLivros.db";

    public FeiraLivrosDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(FeiraLivrosContract.Livro.SQL_CREATE_LIVRO);
        sqLiteDatabase.execSQL(FeiraLivrosContract.Participante.SQL_CREATE_PARTICIPANTE);
        sqLiteDatabase.execSQL(FeiraLivrosContract.Reserva.SQL_CREATE_RESERVA);
        Log.i("FEIRA", "Tabelas Criadas! v" + DATABASE_VERSION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int antigo, int novo) {
        sqLiteDatabase.execSQL(FeiraLivrosContract.Livro.SQL_DROP_LIVRO);
        sqLiteDatabase.execSQL(FeiraLivrosContract.Participante.SQL_DROP_PARTICIPANTE);
        sqLiteDatabase.execSQL(FeiraLivrosContract.Reserva.SQL_DROP_RESERVA);

        Log.i("FEIRA", "Tabelas atualizadas de v" + antigo + " para v" + novo);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("FEIRA", "Tabelas revertidas de v" + oldVersion + " para v" + newVersion);
        onUpgrade(db,oldVersion,newVersion);
    }
}


