package com.sonserina.ufjf.slytherinpride.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.sonserina.ufjf.slytherinpride.R;
import com.sonserina.ufjf.slytherinpride.dao.FeiraLivrosDBHelper;
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
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.lista_view, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {


    }

}
