package com.sonserina.ufjf.slytherinpride.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.sonserina.ufjf.slytherinpride.R;
import com.sonserina.ufjf.slytherinpride.dao.FeiraLivrosDBHelper;
import com.sonserina.ufjf.slytherinpride.dao.ParticipanteContract;
import com.sonserina.ufjf.slytherinpride.dao.ReservaContract;

/**
 * Created by thassya on 21/10/17.
 */

public class ReservaAdapter extends CursorAdapter {
    private FeiraLivrosDBHelper feiraLivrosDBHelper;

    public ReservaAdapter(Context context, Cursor c) {
        super(context, c, 0);
        feiraLivrosDBHelper = new FeiraLivrosDBHelper(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.lista_view, parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtNome = (TextView) view.findViewById(R.id.txt_lista);

        String nome = cursor.getString(cursor.getColumnIndexOrThrow(ParticipanteContract.Participante.COLUMN_NAME_NOME));

        txtNome.setText(nome);
    }

    public void atualizar(){
        try {
            SQLiteDatabase db = feiraLivrosDBHelper.getReadableDatabase();
            String[] visao = {
                    ReservaContract.Reserva.COLUMN_NAME_LIVRO,
                    ReservaContract.Reserva.COLUMN_NAME_PARTICIPANTE,
            };
            String sort = ReservaContract.Reserva.COLUMN_NAME_LIVRO + " DESC";
            Cursor c = db.query(ReservaContract.Reserva.TABLE_NAME, visao, null, null, null, null, sort);
            this.changeCursor(c);
        }
        catch (Exception e) {
            Log.e("RESERVA", e.getLocalizedMessage());
            Log.e("RESERVA", e.getStackTrace().toString());
        }
    }

    public void inserirReserva(String idLivro , String idParticipante){
        try {
            SQLiteDatabase db = feiraLivrosDBHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(ReservaContract.Reserva.COLUMN_NAME_PARTICIPANTE, idParticipante);
            values.put(ReservaContract.Reserva.COLUMN_NAME_LIVRO, idLivro);
            long id = db.insert(ReservaContract.Reserva.TABLE_NAME, null, values);

        } catch (Exception e) {
            Log.e("INSERIR PARTICIPATE", e.getLocalizedMessage());
            Log.e("INSERIR PARTICIPATE", e.getStackTrace().toString());
        }

    }
    public String getId(int i){
        Cursor c = getCursor();
        c.moveToPosition(i);
        return c.getString(c.getColumnIndex("_id"));
    }
}
