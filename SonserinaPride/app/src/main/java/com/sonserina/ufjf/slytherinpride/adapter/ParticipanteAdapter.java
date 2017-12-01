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
import com.sonserina.ufjf.slytherinpride.models.Participante;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by thassya on 21/10/17.
 */

public class ParticipanteAdapter extends CursorAdapter {
    private SimpleDateFormat formatoData;
    private FeiraLivrosDBHelper feiraLivrosDBHelper;

    public ParticipanteAdapter(Context context, Cursor c) {
        super(context, c, 0);
        feiraLivrosDBHelper = new FeiraLivrosDBHelper(context);
        formatoData = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss");
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
                    ParticipanteContract.Participante._ID,
                    ParticipanteContract.Participante.COLUMN_NAME_NOME,
                    ParticipanteContract.Participante.COLUMN_NAME_EMAIL,
                    ParticipanteContract.Participante.COLUMN_NAME_ENTRADA,
                    ParticipanteContract.Participante.COLUMN_NAME_SAIDA
            };
            String sort = ParticipanteContract.Participante.COLUMN_NAME_NOME + " DESC";
            Cursor c = db.query(ParticipanteContract.Participante.TABLE_NAME, visao, null, null, null, null, null);
            this.changeCursor(c);
        }
        catch (Exception e) {
            Log.e("ATUALIZAR PARTICIPANTE", e.getLocalizedMessage());
            Log.e("ATUALIZAR PARTICIPANTE", e.getStackTrace().toString());
        }
    }

    public void inserir(Participante p){
        try{
            SQLiteDatabase db = feiraLivrosDBHelper.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(ParticipanteContract.Participante.COLUMN_NAME_NOME, p.getNome());
            values.put(ParticipanteContract.Participante.COLUMN_NAME_EMAIL, p.getEmail());

            if(p.getDataEntrada()!=null)
                values.put(ParticipanteContract.Participante.COLUMN_NAME_ENTRADA, p.getDataEntrada().toString());
            if(p.getDataSaida()!= null)
                values.put(ParticipanteContract.Participante.COLUMN_NAME_SAIDA,p.getDataSaida().toString());

            long id = db.insert(ParticipanteContract.Participante.TABLE_NAME, null, values);
            atualizar();
        }
        catch(Exception e){
            Log.e("INSERIR PARTICIPANTE", e.getLocalizedMessage());
            Log.e("INSERIR PARTICIPANTE", e.getStackTrace().toString());
        }
    }

    public Participante getParticipante(String id){
        Participante p = new Participante();

        try {
            SQLiteDatabase db = feiraLivrosDBHelper.getReadableDatabase();
            String[] visao = {
                    ParticipanteContract.Participante.COLUMN_NAME_NOME,
                    ParticipanteContract.Participante.COLUMN_NAME_EMAIL,
                    ParticipanteContract.Participante.COLUMN_NAME_ENTRADA,
                    ParticipanteContract.Participante.COLUMN_NAME_SAIDA
            };
            String selecao = ParticipanteContract.Participante._ID+"= "+id;
            Cursor c = db.query(ParticipanteContract.Participante.TABLE_NAME, visao, selecao, null, null, null, null);

            c.moveToFirst();

            p.setNome(c.getString(c.getColumnIndex(ParticipanteContract.Participante.COLUMN_NAME_NOME)));
            p.setEmail(c.getString(c.getColumnIndex(ParticipanteContract.Participante.COLUMN_NAME_EMAIL)));

            long entrada = c.getLong((int) c.getLong(c.getColumnIndex(ParticipanteContract.Participante.COLUMN_NAME_ENTRADA)));
            p.setDataEntrada(new Date(entrada));
            long saida = c.getLong((int) c.getLong(c.getColumnIndex(ParticipanteContract.Participante.COLUMN_NAME_SAIDA)));
            p.setDataSaida(new Date(saida));

        } catch (Exception e) {
            Log.e("BUSCA_PARTICIPANTE", e.getLocalizedMessage());
            Log.e("BUSCA_PARTICIPANTE", e.getStackTrace().toString());
        }

        return p;
    }

    public Participante getParticipante(int i){
        Participante p = new Participante();

        try{
            SQLiteDatabase db = feiraLivrosDBHelper.getReadableDatabase();
            String[] visao = {
                    ParticipanteContract.Participante.COLUMN_NAME_NOME,
                    ParticipanteContract.Participante.COLUMN_NAME_EMAIL,
                    ParticipanteContract.Participante.COLUMN_NAME_ENTRADA,
                    ParticipanteContract.Participante.COLUMN_NAME_SAIDA,
            };
            String selecao = ParticipanteContract.Participante._ID + " = " + i;
            Cursor c = db.query(ParticipanteContract.Participante.TABLE_NAME, visao, selecao, null,null,null,null);
            c.moveToFirst();
            p.setNome(c.getString(c.getColumnIndex(ParticipanteContract.Participante.COLUMN_NAME_NOME)));
            p.setEmail(c.getString(c.getColumnIndex(ParticipanteContract.Participante.COLUMN_NAME_EMAIL)));

            long entrada = c.getLong((int) c.getLong(c.getColumnIndex(ParticipanteContract.Participante.COLUMN_NAME_ENTRADA)));
            long saida = c.getLong((int) c.getLong(c.getColumnIndex(ParticipanteContract.Participante.COLUMN_NAME_SAIDA)));

            p.setDataEntrada(new Date(entrada));
            p.setDataSaida(new Date(saida));
        }catch (Exception e){
            Log.e("BUSCAR PARTICIPANTE", e.getLocalizedMessage());
            Log.e("BUSCAR PARTICIPANTE", e.getStackTrace().toString());
        }
        return p;
    }

    public void longClick(int i, String campo, Date data){
        String dataCompleta = formatoData.format(data);

        Cursor c = getCursor();
        c.moveToPosition(i);
        String id = c.getString(c.getColumnIndex(ParticipanteContract.Participante._ID));
        ContentValues values = new ContentValues();
        values.put(campo,dataCompleta);

        try{
            SQLiteDatabase db = feiraLivrosDBHelper.getWritableDatabase();
            db.update(ParticipanteContract.Participante.TABLE_NAME, values, ParticipanteContract.Participante._ID + "=" +id, null);

            atualizar();

        }catch (Exception e){
            Log.e("LONGCLICK PARTICIPANTE", e.getLocalizedMessage());
            Log.e("LONGCLICK PARTICIPANTE", e.getStackTrace().toString());
        }
    }

    public void removeDatas(int i){
        Cursor c = getCursor();
        c.moveToPosition(i);
        String id = c.getString(c.getColumnIndex(ParticipanteContract.Participante._ID));
        ContentValues values = new ContentValues();
        values.put(ParticipanteContract.Participante.COLUMN_NAME_ENTRADA,"");
        values.put(ParticipanteContract.Participante.COLUMN_NAME_SAIDA,"");
        try {
            SQLiteDatabase db = feiraLivrosDBHelper.getWritableDatabase();
            db.update(ParticipanteContract.Participante.TABLE_NAME, values, "_id="+id, null);
            atualizar();
        } catch (Exception e) {
            Log.e("LIMPADATA PARTICIPANTE", e.getLocalizedMessage());
            Log.e("LIMPADATA PARTICIPANTE", e.getStackTrace().toString());
        }
    }

    public String getId(int i){
        Cursor c = getCursor();
        c.moveToPosition(i);
        return c.getString(c.getColumnIndex(ParticipanteContract.Participante._ID));
    }

}
