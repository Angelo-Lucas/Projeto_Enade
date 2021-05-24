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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

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
        questao = new Questao();
        questoes = QuestaoDAO.getInstance().buscarTodas(Questao.class);
    }
    
    public void gravar(){
        QuestaoDAO.getInstance().persistir(questao);
        questoes = QuestaoDAO.getInstance().buscarTodas(Questao.class);
        questao = new Questao();
    }
    
    public void remover(){
        QuestaoDAO.getInstance().remover(Questao.class, questao.getId());
        questoes = QuestaoDAO.getInstance().buscarTodas(Questao.class);
        questao = new Questao();
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
    
    
    public void onRowEdit(RowEditEvent<Questao> event) {
        QuestaoDAO.getInstance().atualizar(questao);
        questoes = QuestaoDAO.getInstance().buscarTodas(Questao.class);
        questao = new Questao();
        FacesMessage msg = new FacesMessage("Editado", event.getObject().getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Questao> event) {
        FacesMessage msg = new FacesMessage("Cancelado", event.getObject().getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
}
