package com.sonserina.ufjf.slytherinpride.helper;

import com.sonserina.ufjf.slytherinpride.models.Participante;

import java.util.List;

/**
 * Created by thassya on 10/10/17.
 */

public class ParticipanteHelper {
    public static final ParticipanteHelper instance = new ParticipanteHelper();
    private List<Participante> participanteList;

    public static ParticipanteHelper getInstance(){ return instance;}

    private ParticipanteHelper(){
        //inicializa lista com participantes.


    }

    public List<Participante> getParticipanteList() {
        return participanteList;
    }

    public void setParticipanteList(List<Participante> participanteList) {
        this.participanteList = participanteList;
    }

    public void setParticipante(Participante model){
        participanteList.add(model);
    }
}
