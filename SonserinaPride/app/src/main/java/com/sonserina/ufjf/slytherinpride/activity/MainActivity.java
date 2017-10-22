package com.sonserina.ufjf.slytherinpride.activity;

import android.content.Intent;
import android.icu.text.MessagePattern;
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
import com.sonserina.ufjf.slytherinpride.helper.LivrosHelper;
import com.sonserina.ufjf.slytherinpride.helper.ParticipanteHelper;
import com.sonserina.ufjf.slytherinpride.helper.ReservaHelper;
import com.sonserina.ufjf.slytherinpride.models.Livro;
import com.sonserina.ufjf.slytherinpride.models.Participante;

import java.nio.file.Files;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnCadastrarParticipante;
    Button btnCadastraReserva;
    Button btnCadastraLivros;
    ListView lstParticipantes;
    ListView lstLivros;
    private ParticipanteAdapter participanteAdapter;
    private LivrosAdapter livrosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instancia objetos da view
        lstParticipantes = (ListView) findViewById(R.id.lstParticipantes);
        lstLivros = (ListView) findViewById(R.id.lstLivros);
        btnCadastrarParticipante = (Button) findViewById(R.id.btnCadastrarParticipante);
        btnCadastraReserva = (Button) findViewById(R.id.btnCadastraReserva);
        btnCadastraLivros = (Button) findViewById(R.id.btnCadastraLivros);

        //popula lista de participantes com uma view cheia de nomes, criada no participante adapter.
        participanteAdapter = new ParticipanteAdapter(getApplicationContext(), ParticipanteHelper.getInstance().getListaParticipantes());
        lstParticipantes.setAdapter(participanteAdapter);

        livrosAdapter = new LivrosAdapter(getApplicationContext(), LivrosHelper.getInstance().getListaLivros());
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
                Participante p = participanteAdapter.getItem(position);
                if(p.getDataEntrada()==null){
                    p.setDataEntrada(Calendar.getInstance().getTime());

                    Toast.makeText(MainActivity.this, getResources().getText(R.string.entrada), Toast.LENGTH_SHORT).show();
                }
                else if(p.getDataSaida()==null){
                    p.setDataSaida(Calendar.getInstance().getTime());

                    Toast.makeText(MainActivity.this, getResources().getText(R.string.saida), Toast.LENGTH_SHORT).show();
                }
                else {
                    p.setDataEntrada(null);
                    p.setDataSaida(null);

                    Toast.makeText(MainActivity.this, getResources().getText(R.string.anulado), Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        lstParticipantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Participante part = participanteAdapter.getItem(position);
                Intent in = new Intent(MainActivity.this, ParticipanteActivity.class);
                in.putExtra("participante", part);
                startActivity(in);
            }
        });

        lstLivros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Livro livro = livrosAdapter.getItem(position);
                Intent in = new Intent(MainActivity.this, LivroActivity.class);
                in.putExtra("livro", livro);
                startActivity(in);
            }
        });
    }

    @Override
    protected void onResume() {
        participanteAdapter.notifyDataSetChanged();
        livrosAdapter.notifyDataSetChanged();
        super.onResume();
    }

}
