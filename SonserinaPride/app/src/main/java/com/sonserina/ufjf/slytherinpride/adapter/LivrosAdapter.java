package com.sonserina.ufjf.slytherinpride.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sonserina.ufjf.slytherinpride.R;
import com.sonserina.ufjf.slytherinpride.models.Livro;

import java.util.Comparator;
import java.util.List;

/**
 * Created by thassya on 21/10/17.
 */

public class LivrosAdapter extends ArrayAdapter<Livro> {

    private static final Comparator<Livro> comparatorLivros = new Comparator<Livro>() {
        public int compare(Livro l1, Livro l2) {
            return l1.getTitulo().toLowerCase().compareTo(l2.getTitulo().toLowerCase());
        }
    };

    public LivrosAdapter(Context context, List<Livro> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Livro livro = getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lista_view, parent,false);
        }
        TextView txt_lista = convertView.findViewById(R.id.txt_lista);
        txt_lista.setText(livro.getTitulo());
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        this.setNotifyOnChange(false);
        this.sort(comparatorLivros);
        super.notifyDataSetChanged();
        this.setNotifyOnChange(true);
    }

}
