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
public class TipoQuestaoController implements Serializable{
     Tipoquestao tipoQuestao = new Tipoquestao();
    List<Tipoquestao> tipoQuestoes = new ArrayList<Tipoquestao>();
    
    public TipoQuestaoController(){
        tipoQuestao = new Tipoquestao();
        tipoQuestoes = TipoQuestaoDAO.getInstance().buscarTodas(Tipoquestao.class);
    }
    
    public void gravar(){
        TipoQuestaoDAO.getInstance().persistir(tipoQuestao);
        tipoQuestoes = TipoQuestaoDAO.getInstance().buscarTodas(Tipoquestao.class);
        tipoQuestao = new Tipoquestao();
    }
    
    public void remover(){
        TipoQuestaoDAO.getInstance().remover(Tipoquestao.class, tipoQuestao.getId());
        tipoQuestoes = TipoQuestaoDAO.getInstance().buscarTodas(Tipoquestao.class);
        tipoQuestao = new Tipoquestao();
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

    public void onRowEdit(RowEditEvent<Tipoquestao> event) {
        TipoQuestaoDAO.getInstance().atualizar(tipoQuestao);
        tipoQuestoes = TipoQuestaoDAO.getInstance().buscarTodas(Tipoquestao.class);
        tipoQuestao = new Tipoquestao();
        FacesMessage msg = new FacesMessage("Editado", event.getObject().getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Tipoquestao> event) {
        FacesMessage msg = new FacesMessage("Cancelado", event.getObject().getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
}
