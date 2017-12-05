package com.sonserina.ufjf.slytherinpride.activity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.sonserina.ufjf.slytherinpride.R;
import com.sonserina.ufjf.slytherinpride.adapter.LivrosAdapter;
import com.sonserina.ufjf.slytherinpride.adapter.ParticipanteAdapter;
import com.sonserina.ufjf.slytherinpride.adapter.ReservaAdapter;
import com.sonserina.ufjf.slytherinpride.helper.LivrosHelper;
import com.sonserina.ufjf.slytherinpride.helper.ParticipanteHelper;
import com.sonserina.ufjf.slytherinpride.helper.ReservaHelper;
import com.sonserina.ufjf.slytherinpride.models.Livro;
import com.sonserina.ufjf.slytherinpride.models.Participante;
import com.sonserina.ufjf.slytherinpride.models.Reserva;

/**
 * Created by thassya on 21/10/17.
 */

public class CadastroReseraActivity extends AppCompatActivity {

    private Button btnVoltarReserva;
    private Button btnSalvarReserva;
    private Spinner spnParticipantes;
    private Spinner spnLivros;

    private ReservaAdapter reservaAdapter;
    private LivrosAdapter livrosAdapter;
    private ParticipanteAdapter participanteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_reserva);

        btnSalvarReserva = (Button) findViewById(R.id.btnSalvarReserva);
        btnVoltarReserva = (Button) findViewById(R.id.btnVoltarReserva);

        spnParticipantes = (Spinner) findViewById(R.id.spnParticipantes);
        spnLivros = (Spinner) findViewById(R.id.spnLivros);

        livrosAdapter = new LivrosAdapter(getBaseContext(),null);
        participanteAdapter = new ParticipanteAdapter(getBaseContext(),null);
        reservaAdapter = new ReservaAdapter(getBaseContext(),null);

        livrosAdapter.atualizar();
        participanteAdapter.atualizar();


        spnParticipantes.setAdapter(participanteAdapter);
        spnLivros.setAdapter(livrosAdapter);


        btnSalvarReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(spnParticipantes.getSelectedItemPosition()==-1){
                ((TextView)spnParticipantes.getChildAt(0)).setError(getResources().getString(R.string.selecioneParticipante));
            }
            if(spnLivros.getSelectedItemPosition()==-1){
                ((TextView)spnLivros.getChildAt(0)).setError(getResources().getString(R.string.selecioneLivro));
            }
            else {
                String idPart = participanteAdapter.getId(spnParticipantes.getSelectedItemPosition());
                String idLivro = livrosAdapter.getId(spnLivros.getSelectedItemPosition());

                Participante p = participanteAdapter.getParticipante(idPart);
                Livro l = livrosAdapter.getLivro(idLivro);

                reservaAdapter.inserirReserva(idLivro,idPart);

                spnParticipantes.setSelection(0);
                spnLivros.setSelection(0);

                Toast.makeText(CadastroReseraActivity.this, "Livro " + l.getTitulo() + " reservado para " + p.getNome(), Toast.LENGTH_SHORT).show();
            }
            }
        });

        btnVoltarReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            setResult(RESULT_CANCELED);
            finish();
            }
        });

    }

}
