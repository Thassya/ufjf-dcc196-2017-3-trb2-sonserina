package com.sonserina.ufjf.slytherinpride.adapter;

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
        return LayoutInflater.from(context).inflate(R.layout.cadastro_participante, parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtNome = (TextView) view.findViewById(R.id.txtNomeParticipante);
        TextView txtEmail = (TextView) view.findViewById(R.id.txtEmailParticipante);

        String nome = cursor.getString(cursor.getColumnIndexOrThrow(FeiraLivrosContract.Participante.COLUMN_NAME_NOME));
        String email = cursor.getString(cursor.getColumnIndexOrThrow(FeiraLivrosContract.Participante.COLUMN_NAME_EMAIL));

        txtNome.setText(nome);
        txtEmail.setText(email);
    }

    public void atualizar(){
        try {
            SQLiteDatabase db = feiraLivrosDBHelper.getReadableDatabase();
            String[] visao = {
                    FeiraLivrosContract.Participante._ID,
                    FeiraLivrosContract.Participante.COLUMN_NAME_NOME,
                    FeiraLivrosContract.Participante.COLUMN_NAME_EMAIL
            };
            String sort = FeiraLivrosContract.Participante.COLUMN_NAME_NOME + " DESC";
            Cursor c = db.query(FeiraLivrosContract.Participante.TABLE_NAME, visao, null, null, null, null, sort);
            this.changeCursor(c);
        }
        catch (Exception e) {
            Log.e("PARTICIPANTE", e.getLocalizedMessage());
            Log.e("PARTICIPANTE", e.getStackTrace().toString());
        }
    }


}
