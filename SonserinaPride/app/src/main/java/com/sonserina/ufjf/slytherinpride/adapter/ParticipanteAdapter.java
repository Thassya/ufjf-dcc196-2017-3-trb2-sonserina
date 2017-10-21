package com.sonserina.ufjf.slytherinpride.adapter;

import android.content.Context;
import android.icu.text.MessagePattern;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sonserina.ufjf.slytherinpride.R;
import com.sonserina.ufjf.slytherinpride.models.Participante;

import org.w3c.dom.Text;

import java.util.Comparator;
import java.util.List;

/**
 * Created by thassya on 21/10/17.
 */

public class ParticipanteAdapter extends ArrayAdapter<Participante> {

    private static final Comparator<Participante> comparatorParticipante = new Comparator<Participante>() {
        public int compare(Participante p1, Participante p2) {
            return p1.getNome().toLowerCase().compareTo(p2.getNome().toLowerCase());
        }
    };

    public ParticipanteAdapter(Context context, List<Participante> objects) {
        super(context, 0, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Participante participante = getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lista_participantes, parent,false);
        }
        TextView txt_lista_participantes = convertView.findViewById(R.id.txt_lista_participantes);
        txt_lista_participantes.setText(participante.getNome());
        //sem email..
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        this.setNotifyOnChange(false);
        this.sort(comparatorParticipante);
        super.notifyDataSetChanged();
        this.setNotifyOnChange(true);
    }
}
