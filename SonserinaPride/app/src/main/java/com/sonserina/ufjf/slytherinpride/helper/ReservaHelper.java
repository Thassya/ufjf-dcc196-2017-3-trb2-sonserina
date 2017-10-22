package com.sonserina.ufjf.slytherinpride.helper;

import android.widget.ListView;

import com.sonserina.ufjf.slytherinpride.models.Livro;
import com.sonserina.ufjf.slytherinpride.models.Participante;
import com.sonserina.ufjf.slytherinpride.models.Reserva;

import java.util.ArrayList;
import java.util.List;


public class ReservaHelper {
    private List<Reserva> lstReservas;

    private static final ReservaHelper INSTANCE = new ReservaHelper();
    public static ReservaHelper getInstance() {
        return INSTANCE;
    }

    private ReservaHelper() {
        lstReservas = new ArrayList<>();
    }

    public List<Reserva> getLstReservas() {
        return lstReservas;
    }

    public void addReserva(Reserva reserva) {
        lstReservas.add(reserva);
    }

    public List<Reserva> getLstReservasParticipantes(Participante p){
        List<Reserva> resposta = new ArrayList<>();
        for(Reserva r : lstReservas){
            if(p.equals(r.getParticipante())) {
                resposta.add(r);
            }
        }
        return resposta;
    }

    public List<Reserva> getLstReservasLivros(Livro livro){
        List<Reserva> resposta = new ArrayList<>();
        for(Reserva r : lstReservas){
            if(livro.equals(r.getLivro())) {
                resposta.add(r);
            }
        }
        return resposta;
    }

}
