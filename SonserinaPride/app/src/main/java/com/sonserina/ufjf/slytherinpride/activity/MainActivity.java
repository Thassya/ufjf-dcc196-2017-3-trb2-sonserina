package com.sonserina.ufjf.slytherinpride.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.sonserina.ufjf.slytherinpride.R;
import com.sonserina.ufjf.slytherinpride.adapter.ParticipanteAdapter;
import com.sonserina.ufjf.slytherinpride.helper.ParticipanteHelper;
import com.sonserina.ufjf.slytherinpride.models.Participante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnCadastrarParticipante;
    Button btnCadastraReserva;
    Button btnCadastraLivros;
    ListView lstParticipantes;
    private ParticipanteAdapter participanteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instancia objetos da view
        lstParticipantes = (ListView) findViewById(R.id.lstParticipantes);
        btnCadastrarParticipante = (Button) findViewById(R.id.btnCadastrarParticipante);
        btnCadastraReserva = (Button) findViewById(R.id.btnCadastraReserva);
        btnCadastraLivros = (Button) findViewById(R.id.btnCadastraLivros);

        //popula lista de participantes com uma view cheia de nomes, criada no participante adapter.
        participanteAdapter = new ParticipanteAdapter(getApplicationContext(), ParticipanteHelper.getInstance().getListaParticipantes());
        lstParticipantes.setAdapter(participanteAdapter);



        btnCadastrarParticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastroParticipanteActivity.class);
                intent.putExtra("activity_title", getResources().getString(R.string.cadastroParticipante));
                startActivity(intent);
            }
        });

    }

}
