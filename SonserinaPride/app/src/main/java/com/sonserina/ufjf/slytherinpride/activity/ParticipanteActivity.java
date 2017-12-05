package com.sonserina.ufjf.slytherinpride.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.sonserina.ufjf.slytherinpride.R;
import com.sonserina.ufjf.slytherinpride.adapter.ParticipanteAdapter;
import com.sonserina.ufjf.slytherinpride.adapter.ReservaAdapter;
import com.sonserina.ufjf.slytherinpride.helper.ReservaHelper;
import com.sonserina.ufjf.slytherinpride.models.Participante;
import com.sonserina.ufjf.slytherinpride.models.Reserva;

/**
 * Created by thassya on 22/10/17.
 */

public class ParticipanteActivity extends AppCompatActivity {

    TextView txtNome;
    TextView txtEmail;
    TextView txtEntrada;
    TextView txtSaida;
//    ListView lstReservas;
    Button btnVoltar;
    ParticipanteAdapter participanteAdapter;
    ReservaAdapter reservaAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhes_participante);

        txtNome = (TextView) findViewById(R.id.txtNome);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtEntrada = (TextView) findViewById(R.id.txtEntrada);
        txtSaida = (TextView) findViewById(R.id.txtSaida);
//        lstReservas = (ListView) findViewById(R.id.lstReservas);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        reservaAdapter = new ReservaAdapter(getBaseContext(), null);
        participanteAdapter = new ParticipanteAdapter(getBaseContext(),null);
        Intent it = getIntent();
        String idParticipante = it.getStringExtra("idParticipante");
        Participante par = participanteAdapter.getParticipante(idParticipante);


        if(par!=null){
            txtNome.setText(par.getNome());
            txtEmail.setText(par.getEmail());
            txtEntrada.setText(par.getDataEntrada());
            txtSaida.setText(par.getDataSaida());

//            reservaAdapter.atualizar_p(idParticipante);
//            lstReservas.setAdapter(reservaAdapter);

        }


        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
