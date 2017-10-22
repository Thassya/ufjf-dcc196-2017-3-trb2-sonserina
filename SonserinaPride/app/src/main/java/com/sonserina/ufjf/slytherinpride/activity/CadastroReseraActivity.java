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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_reserva);

        btnSalvarReserva = (Button) findViewById(R.id.btnSalvarReserva);
        btnVoltarReserva = (Button) findViewById(R.id.btnVoltarReserva);
        spnParticipantes = (Spinner) findViewById(R.id.spnParticipantes);
        spnLivros = (Spinner) findViewById(R.id.spnLivros);



        ArrayAdapter<Livro> livroAdapter = new ArrayAdapter<Livro>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, LivrosHelper.getInstance().getListaLivros());
        livroAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spnLivros.setAdapter(livroAdapter);

        ArrayAdapter<Participante> participanteAdapter = new ArrayAdapter<Participante>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ParticipanteHelper.getInstance().getParticipantesNoEvento());
        participanteAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spnParticipantes.setAdapter(participanteAdapter);


        btnSalvarReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spnParticipantes.getSelectedItemPosition()==0){
                    ((TextView)spnParticipantes.getChildAt(0)).setError(getResources().getString(R.string.selecioneParticipante));
                }
                if(spnLivros.getSelectedItemPosition()==0){
                    ((TextView)spnLivros.getChildAt(0)).setError(getResources().getString(R.string.selecioneLivro));
                }
                else {
                    Participante p = (Participante) spnParticipantes.getSelectedItem();
                    Livro l = (Livro) spnLivros.getSelectedItem();
                    ReservaHelper.getInstance().addReserva(new Reserva(p, l));

                    spnParticipantes.setSelection(0);
                    spnLivros.setSelection(0);

                    Toast.makeText(CadastroReseraActivity.this, "Livro " + l.getTitulo() + " reservado para " + p.getNome(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnVoltarReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
