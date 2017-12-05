package com.sonserina.ufjf.slytherinpride.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.sonserina.ufjf.slytherinpride.R;
import com.sonserina.ufjf.slytherinpride.dao.FeiraLivrosDBHelper;
import com.sonserina.ufjf.slytherinpride.dao.LivroContract;
import com.sonserina.ufjf.slytherinpride.dao.ParticipanteContract;
import com.sonserina.ufjf.slytherinpride.models.Livro;

import java.util.Comparator;
import java.util.List;

/**
 * Created by thassya on 21/10/17.
 */

public class LivrosAdapter extends CursorAdapter {
    private FeiraLivrosDBHelper feiraLivrosDBHelper;

    public LivrosAdapter(Context context, Cursor c) {
        super(context, c, 0);
        feiraLivrosDBHelper = new FeiraLivrosDBHelper(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.lista_view, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtTitulo = (TextView) view.findViewById(R.id.txt_lista);

        String titulo = cursor.getString(cursor.getColumnIndexOrThrow(LivroContract.Livro.COLUMN_NAME_TITULO));
        int id = cursor.getInt(cursor.getColumnIndexOrThrow(LivroContract.Livro._ID));

        txtTitulo.setText(id + " - " + titulo);
    }

    public void atualizar() {
        try {
            SQLiteDatabase db = feiraLivrosDBHelper.getReadableDatabase();
            String[] visao = {
                    LivroContract.Livro._ID,
                    LivroContract.Livro.COLUMN_NAME_TITULO,
                    LivroContract.Livro.COLUMN_NAME_EDITORA,
                    LivroContract.Livro.COLUMN_NAME_ANO,
            };
            String sort = LivroContract.Livro.COLUMN_NAME_TITULO + " ASC";
            Cursor c = db.query(LivroContract.Livro.TABLE_NAME, visao, null, null, null, null, sort);
            this.changeCursor(c);

        } catch (Exception e) {
            Log.e("ATUALIZAR LIVRO", e.getLocalizedMessage());
            Log.e("ATUALIZAR LIVRO", e.getStackTrace().toString());
        }
    }

    public void inserir(Livro l){
        try {
            SQLiteDatabase db = feiraLivrosDBHelper.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(LivroContract.Livro.COLUMN_NAME_TITULO, l.getTitulo());
            values.put(LivroContract.Livro.COLUMN_NAME_EDITORA, l.getEditora());
            values.put(LivroContract.Livro.COLUMN_NAME_ANO, l.getAno());
            long id = db.insert(LivroContract.Livro.TABLE_NAME, null, values);
            atualizar();
        } catch (Exception e) {
            Log.e("INSERIR LIVRO", e.getLocalizedMessage());
            Log.e("INSERIR LIVRO", e.getStackTrace().toString());
        }
    }

    public Livro getLivro(int id){
        Livro livro = new Livro();
        try {
            SQLiteDatabase db = feiraLivrosDBHelper.getReadableDatabase();
            String[] visao = {
                    LivroContract.Livro.COLUMN_NAME_TITULO,
                    LivroContract.Livro.COLUMN_NAME_EDITORA,
                    LivroContract.Livro.COLUMN_NAME_ANO,
            };
            String selecao = LivroContract.Livro._ID+" = "+id;
            Cursor c = db.query(LivroContract.Livro.TABLE_NAME, visao, selecao, null, null, null, null);
            c.moveToFirst();
            livro.setTitulo(c.getString(c.getColumnIndex(LivroContract.Livro.COLUMN_NAME_TITULO)));
            livro.setEditora(c.getString(c.getColumnIndex(LivroContract.Livro.COLUMN_NAME_EDITORA)));
            livro.setAno(c.getInt(c.getColumnIndex(LivroContract.Livro.COLUMN_NAME_ANO)));

        } catch (Exception e) {
            Log.e("BUSCAR LIVRO", e.getLocalizedMessage());
            Log.e("BUSCAR LIVRO", e.getStackTrace().toString());
        }
        return livro;
    }

    public Livro getLivro(String id){
        Livro l= new Livro();
        try {
            SQLiteDatabase db = feiraLivrosDBHelper.getReadableDatabase();
            String[] visao = {
                    LivroContract.Livro.COLUMN_NAME_TITULO,
                    LivroContract.Livro.COLUMN_NAME_EDITORA,
                    LivroContract.Livro.COLUMN_NAME_ANO,
            };
            String selecao = LivroContract.Livro._ID+" = "+id;
            Cursor c = db.query(LivroContract.Livro.TABLE_NAME, visao, selecao, null, null, null, null);
            c.moveToFirst();
            l.setTitulo(c.getString(c.getColumnIndex(LivroContract.Livro.COLUMN_NAME_TITULO)));
            l.setEditora(c.getString(c.getColumnIndex(LivroContract.Livro.COLUMN_NAME_EDITORA)));
            l.setAno(c.getInt(c.getColumnIndex(LivroContract.Livro.COLUMN_NAME_ANO)));

        } catch (Exception e) {
            Log.e("BUSCA_LIVRO", e.getLocalizedMessage());
            Log.e("BUSCA_LIVRO", e.getStackTrace().toString());
        }
        return l;
    }

    public String getId(int i){
        Cursor c = getCursor();
        c.moveToPosition(i);
        return c.getString(c.getColumnIndex(LivroContract.Livro._ID));
    }
}
