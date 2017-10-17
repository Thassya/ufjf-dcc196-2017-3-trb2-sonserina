package com.sonserina.ufjf.slytherinpride.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.sonserina.ufjf.slytherinpride.R;

public class MainActivity extends AppCompatActivity {

    Button btnCadastrarParticipante;
    Button btnCadastraReserva;
    Button btnCadastraLivros;
    ListView lstParticipantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstParticipantes = (ListView) findViewById(R.id.lstParticipantes);
       // lstParticipantes.setAdapter(participantesAdapter);

        btnCadastrarParticipante = (Button) findViewById(R.id.btnCadastrarParticipante);
        btnCadastrarParticipante.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                btnCadastrarParticipante.setText(R.string.app_name);
            }
        });
    }
}
