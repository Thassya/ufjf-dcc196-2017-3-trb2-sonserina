package com.sonserina.ufjf.slytherinpride.helper;

import android.os.Parcel;
import android.os.Parcelable;

import com.sonserina.ufjf.slytherinpride.models.Livro;
import com.sonserina.ufjf.slytherinpride.models.Participante;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thassya on 21/10/17.
 */

public class LivrosHelper {

    private static final LivrosHelper INSTANCE = new LivrosHelper();
    private List<Livro> lstLivros;

    private LivrosHelper() {
        populaLivros();
    }

    protected LivrosHelper(Parcel in) {
    }

    public static LivrosHelper getInstance() {
        return INSTANCE;
    }

    public List<Livro> getListaLivros() {
        return lstLivros;
    }


    public void addLivro(Livro livro) {
        lstLivros.add(livro);
    }

    public void addReserva(Livro livro, Participante p){
        livro.setReserva(p);
    }

    private void populaLivros() {
        lstLivros = new ArrayList<>();
        lstLivros.add(new Livro("Harry Potter", "Racco", 2012));
        lstLivros.add(new Livro("Guia do Mochileiro das Galáxias", "Publisher", 2010));
    }

}
