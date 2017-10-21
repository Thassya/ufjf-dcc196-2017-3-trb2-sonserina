package com.sonserina.ufjf.slytherinpride.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sonserina.ufjf.slytherinpride.R;
import com.sonserina.ufjf.slytherinpride.helper.ParticipanteHelper;
import com.sonserina.ufjf.slytherinpride.models.Participante;

/**
 * Created by thassya on 21/10/17.
 */

public class CadastroParticipanteActivity extends AppCompatActivity {

    private Button btnSalvarParticipante;
    private Button btnVoltar;
    private EditText txtNomeParticipante;
    private EditText txtEmailParticipante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_participante);

        btnSalvarParticipante = (Button) findViewById(R.id.btnSalvarParticipante);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        txtNomeParticipante = (EditText) findViewById(R.id.txtNomeParticipante);
        txtEmailParticipante = (EditText) findViewById(R.id.txtEmailParticipante);

        btnSalvarParticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String nome = txtNomeParticipante.getText().toString();
            String email = txtEmailParticipante.getText().toString();

                if(nome.isEmpty()){
                    txtNomeParticipante.setError(getResources().getString(R.string.nomeObrigatorio));
                    txtNomeParticipante.requestFocus();
                }
                else if(email.isEmpty()){
                    txtEmailParticipante.setError(getResources().getString(R.string.emailObrigatorio));
                    txtEmailParticipante.requestFocus();
                }
                else {
                    Participante p = new Participante(nome,email);
                    ParticipanteHelper.getInstance().addParticipante(p);
                    txtNomeParticipante.setText("");
                    txtEmailParticipante.setText("");
                }
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
