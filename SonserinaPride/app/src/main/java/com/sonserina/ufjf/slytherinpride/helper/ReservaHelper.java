package com.sonserina.ufjf.slytherinpride.helper;

import android.widget.ListView;

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

    public List<Reserva> getLstReservasParticipante(Participante p){
        List<Reserva> resposta = new ArrayList<>();
        for(Reserva r : lstReservas){
            if(r.getParticipante().equals(p))
                resposta.add(r);
        }
        return resposta;
    }

    public List<Reserva> getLstReservas

}
