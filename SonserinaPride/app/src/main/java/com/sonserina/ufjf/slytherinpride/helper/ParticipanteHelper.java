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
    public static ParticipanteHelper getInstance() {
        return INSTANCE;
    }

    private List<Participante> lstParticipantes;

    private ParticipanteHelper() {
        populaParticipantes();
    }

    private void populaParticipantes() {
        lstParticipantes = new ArrayList<>();
        lstParticipantes.add(new Participante("Snape Boladão", "snap@ice.ufjf.br"));
        lstParticipantes.add(new Participante("Valdemort Bonzinho", "vaval@ice.ufjf.br"));
        lstParticipantes.add(new Participante("Minervão", "minerva@ice.ufjf.br"));
    }


    public List<Participante> getListaParticipantes() {
        return lstParticipantes;
    }
    public List<Participante> getParticipantesNoEvento() {
        List<Participante> retorno = new ArrayList<>();
        retorno.add(new Participante());
        for (Participante part : lstParticipantes) {
            if(part.getDataEntrada()!=null && part.getDataSaida() == null){
                retorno.add(part);
            }
        }
        return retorno;
    }

    public void addParticipante(Participante participante) {
        lstParticipantes.add(participante);
    }
}
