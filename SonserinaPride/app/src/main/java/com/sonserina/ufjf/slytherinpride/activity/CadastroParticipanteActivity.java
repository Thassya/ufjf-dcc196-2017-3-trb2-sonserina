package com.sonserina.ufjf.slytherinpride.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sonserina.ufjf.slytherinpride.R;
import com.sonserina.ufjf.slytherinpride.adapter.ParticipanteAdapter;
import com.sonserina.ufjf.slytherinpride.dao.FeiraLivrosDBHelper;
import com.sonserina.ufjf.slytherinpride.helper.ParticipanteHelper;
import com.sonserina.ufjf.slytherinpride.models.Participante;

import java.util.concurrent.ExecutionException;

/**
 * Created by thassya on 21/10/17.
 */

public class CadastroParticipanteActivity extends AppCompatActivity {

    private Button btnSalvarParticipante;
    private Button btnVoltar;
    private EditText txtNomeParticipante;
    private EditText txtEmailParticipante;
    private ParticipanteAdapter participanteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_participante);

        btnSalvarParticipante = (Button) findViewById(R.id.btnSalvarParticipante);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        txtNomeParticipante = (EditText) findViewById(R.id.txtNomeParticipante);
        txtEmailParticipante = (EditText) findViewById(R.id.txtEmailParticipante);
        participanteAdapter = new ParticipanteAdapter(getBaseContext(),null);

        btnSalvarParticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String nome = txtNomeParticipante.getText().toString();
            String email = txtEmailParticipante.getText().toString();

                if(nome.isEmpty()){
                    txtNomeParticipante.setError(getResources().getString(R.string.nomeObrigatorio));
                    txtNomeParticipante.requestFocus();
                }
                if(email.isEmpty()){
                    txtEmailParticipante.setError(getResources().getString(R.string.emailObrigatorio));
                    txtEmailParticipante.requestFocus();
                }
                else {
                    Participante p = new Participante(nome,email);

                    txtNomeParticipante.setText("");
                    txtEmailParticipante.setText("");

                   try{
                       participanteAdapter.inserir(p);
                       Toast.makeText(CadastroParticipanteActivity.this, "Participante cadastrado!", Toast.LENGTH_SHORT).show();
                   }
                   catch (Exception e){
                       Toast.makeText(CadastroParticipanteActivity.this, "OPS! " + e.getMessage(), Toast.LENGTH_SHORT).show();
                   }
                }
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }
}
