package com.sonserina.ufjf.slytherinpride.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sonserina.ufjf.slytherinpride.R;
import com.sonserina.ufjf.slytherinpride.models.Reserva;

import java.util.List;

/**
 * Created by thassya on 21/10/17.
 */

public class ReservaAdapter extends ArrayAdapter<Reserva> {
    public ReservaAdapter(Context context, List<Reserva> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Reserva reserva = getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lista_view, parent,false);
        }
        TextView txt_lista = convertView.findViewById(R.id.txt_lista);
        txt_lista.setText(reserva.toString());

        return convertView;
    }
}
