package com.sonserina.ufjf.slytherinpride.helper;

import com.sonserina.ufjf.slytherinpride.models.Participante;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thassya on 21/10/17.
 */

public class ParticipanteHelper {

    //padrão singleton
    private static final ParticipanteHelper INSTANCE = new ParticipanteHelper();
    private List<Participante> lstParticipantes;

    private ParticipanteHelper() {
        populaParticipantes();
    }

    public static ParticipanteHelper getInstance() {
        return INSTANCE;
    }

    private void populaParticipantes() {
        lstParticipantes = new ArrayList<>();
        lstParticipantes.add(new Participante("Thassya", "thassya@ice.ufjf.br"));
        lstParticipantes.add(new Participante("Júlio", "julio@ice.ufjf.br"));
        lstParticipantes.add(new Participante("Raiza", "raiza@ice.ufjf.br"));
        lstParticipantes.add(new Participante("Aline", "aline@ice.ufjf.br"));
    }


    public List<Participante> getListaParticipantes() {
        return lstParticipantes;
    }

    public void addParticipante(Participante participante) {
        lstParticipantes.add(participante);
    }
}
