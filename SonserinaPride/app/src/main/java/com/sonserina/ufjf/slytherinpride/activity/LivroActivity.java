package com.sonserina.ufjf.slytherinpride.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.sonserina.ufjf.slytherinpride.R;
import com.sonserina.ufjf.slytherinpride.adapter.ReservaAdapter;
import com.sonserina.ufjf.slytherinpride.helper.ReservaHelper;
import com.sonserina.ufjf.slytherinpride.models.Livro;

/**
 * Created by thassya on 22/10/17.
 */

public class LivroActivity extends AppCompatActivity {

    TextView txtTitulo;
    TextView txtEditora;
    TextView txtAno;
    ListView lstParticipantes;
    Button btnVoltar;
    ReservaAdapter reservaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhes_livro);

        txtTitulo = (TextView) findViewById(R.id.txtTitulo);
        txtEditora = (TextView) findViewById(R.id.txtEditora);
        txtAno = (TextView) findViewById(R.id.txtAno);
        lstParticipantes = (ListView) findViewById(R.id.lstParticipantes);
        btnVoltar = (Button)findViewById(R.id.btnVoltar);

        Intent it = getIntent();
        Livro livro = it.getParcelableExtra("participante");
        if(livro!=null){
            txtTitulo.setText(livro.getTitulo());
            txtEditora.setText(livro.getEditora());
            txtAno.setText(livro.getAno().toString());

            reservaAdapter = new ReservaAdapter(getApplicationContext(), ReservaHelper.getInstance().getLstReservasLivros(livro));
            lstParticipantes.setAdapter(reservaAdapter);
        }


        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
