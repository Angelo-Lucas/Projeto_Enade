/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.controller;

import com.mycompany.enade.dao.QuestaoDAO;
import com.mycompany.enade.model.Questao;
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
public class QuestaoController implements Serializable {
    Questao questao = new Questao();
    List<Questao> questoes = new ArrayList<Questao>();
    
    public QuestaoController(){
        questoes = QuestaoDAO.getInstance().buscarTodas(Questao.class);
        questao = new Questao();
    }
    
    public void gravar(Questao questao){
        QuestaoDAO.getInstance().persistir(questao);
        questoes = QuestaoDAO.getInstance().buscarTodas(Questao.class);
    }
    
    public void remover(Questao questao){
        QuestaoDAO.getInstance().remover(Questao.class, questao.getId());
        questoes = QuestaoDAO.getInstance().buscarTodas(Questao.class);
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }
    
    
}
