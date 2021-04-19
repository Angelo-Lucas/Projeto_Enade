/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.controller;

import com.mycompany.enade.dao.TipoQuestaoDAO;
import com.mycompany.enade.model.Tipoquestao;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author angelo.lucas
 */
@Named
@ViewScoped
public class TipoQuestaoController implements Serializable{
     Tipoquestao tipoQuestao = new Tipoquestao();
    List<Tipoquestao> tipoQuestoes = new ArrayList<Tipoquestao>();
    
    public TipoQuestaoController(){
        tipoQuestoes = TipoQuestaoDAO.getInstance().buscarTodas(Tipoquestao.class);
        tipoQuestao = new Tipoquestao();
    }
    
    public void gravar(Tipoquestao tipoQuestao){
        TipoQuestaoDAO.getInstance().persistir(tipoQuestao);
        tipoQuestoes = TipoQuestaoDAO.getInstance().buscarTodas(Tipoquestao.class);
    }
    
    public void remover(Tipoquestao tipoQuestao){
        TipoQuestaoDAO.getInstance().remover(Tipoquestao.class, tipoQuestao.getId());
        tipoQuestoes = TipoQuestaoDAO.getInstance().buscarTodas(Tipoquestao.class);
    }

    public Tipoquestao getTipoQuestao() {
        return tipoQuestao;
    }

    public void setTipoQuestao(Tipoquestao tipoQuestao) {
        this.tipoQuestao = tipoQuestao;
    }

    public List<Tipoquestao> getTipoQuestoes() {
        return tipoQuestoes;
    }

    public void setTipoQuestoes(List<Tipoquestao> tipoQuestoes) {
        this.tipoQuestoes = tipoQuestoes;
    }

    
}
