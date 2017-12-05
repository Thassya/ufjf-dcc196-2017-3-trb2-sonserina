package com.sonserina.ufjf.slytherinpride.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.sonserina.ufjf.slytherinpride.R;
import com.sonserina.ufjf.slytherinpride.adapter.LivrosAdapter;
import com.sonserina.ufjf.slytherinpride.adapter.ParticipanteAdapter;
import com.sonserina.ufjf.slytherinpride.dao.FeiraLivrosDBHelper;
import com.sonserina.ufjf.slytherinpride.dao.ParticipanteContract;
import com.sonserina.ufjf.slytherinpride.models.Participante;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnCadastrarParticipante;
    Button btnCadastraReserva;
    Button btnCadastraLivros;
    ListView lstParticipantes;
    ListView lstLivros;

    private ParticipanteAdapter participanteAdapter;
    private LivrosAdapter livrosAdapter;
    private FeiraLivrosDBHelper feiraLivrosDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        feiraLivrosDBHelper = new FeiraLivrosDBHelper(getApplicationContext());

        lstParticipantes = (ListView) findViewById(R.id.lstParticipantes);
        lstLivros = (ListView) findViewById(R.id.lstLivros);
        btnCadastrarParticipante = (Button) findViewById(R.id.btnCadastrarParticipante);
        btnCadastraReserva = (Button) findViewById(R.id.btnCadastraReserva);
        btnCadastraLivros = (Button) findViewById(R.id.btnCadastraLivros);

        feiraLivrosDBHelper = new FeiraLivrosDBHelper(getApplicationContext());
        livrosAdapter = new LivrosAdapter(getBaseContext(), null);
        participanteAdapter = new ParticipanteAdapter(getBaseContext(), null);

        livrosAdapter.atualizar();
        participanteAdapter.atualizar();

        lstParticipantes.setAdapter(participanteAdapter);
        lstLivros.setAdapter(livrosAdapter);

        btnCadastrarParticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this, CadastroParticipanteActivity.class
                );
                startActivity(intent);
            }
        });

        btnCadastraLivros.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(
                        MainActivity.this, CadastroLivrosActivity.class
                );
                startActivity(intent);
            }
        });

        btnCadastraReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this, CadastroReseraActivity.class
                );
                startActivity(intent);
            }
        });

        lstParticipantes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Participante p = participanteAdapter.getParticipante((int)id);

                if(p.getDataEntrada().equals(null) || p.getDataEntrada().equals("")){
                    participanteAdapter.longClick(position,
                            ParticipanteContract.Participante.COLUMN_NAME_ENTRADA, Calendar.getInstance().getTime());

                    Toast.makeText(MainActivity.this, getResources().getText(R.string.entrada) + " - " + p.getDataEntrada(), Toast.LENGTH_SHORT).show();
                }
                else if(p.getDataSaida().equals(null) || p.getDataSaida().equals("")){
                    participanteAdapter.longClick(position,
                            ParticipanteContract.Participante.COLUMN_NAME_SAIDA, Calendar.getInstance().getTime());
                    Toast.makeText(MainActivity.this, getResources().getText(R.string.saida), Toast.LENGTH_SHORT).show();
                }
                else {
                    participanteAdapter.removeDatas((int)id);
                    Toast.makeText(MainActivity.this, getResources().getText(R.string.anulado), Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        lstParticipantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in = new Intent(MainActivity.this, ParticipanteActivity.class);
                in.putExtra("idParticipante", String.valueOf(id));
                startActivity(in);
            }
        });

        lstLivros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in = new Intent(MainActivity.this, LivroActivity.class);
                in.putExtra("idLivro", String.valueOf(id));
                startActivity(in);
            }
        });
    }

    @Override
    protected void onResume() {
        participanteAdapter.notifyDataSetChanged();
        livrosAdapter.notifyDataSetChanged();

        livrosAdapter.atualizar();
        participanteAdapter.atualizar();

        super.onResume();
    }

}
