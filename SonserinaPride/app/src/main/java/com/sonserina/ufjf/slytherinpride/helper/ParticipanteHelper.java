package com.sonserina.ufjf.slytherinpride.helper;

import com.sonserina.ufjf.slytherinpride.models.Participante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thassya on 10/10/17.
 */

public class ParticipanteHelper {
    public static final ParticipanteHelper instance = new ParticipanteHelper();
    private List<Participante> participanteList;

    public static ParticipanteHelper getInstance(){ return instance;}

    private ParticipanteHelper(){
        participanteList = new ArrayList<>(Arrays.asList(
                new Participante("Thassya", "thassya@ice.ufjf.br"),
                new Participante("Júlio", "julio@ice.ufjf.br"),
                new Participante("Igor", "Igor@ice.ufjf.br"),
                new Participante("Fernanda", "fe@ice.ufjf.br")
        ));
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
