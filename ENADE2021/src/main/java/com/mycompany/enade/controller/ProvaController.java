/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.controller;

import com.mycompany.enade.dao.ProvaDAO;
import com.mycompany.enade.model.Prova;
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
public class ProvaController implements Serializable{
    Prova prova = new Prova();
    List<Prova> provas = new ArrayList<Prova>();
    
    public ProvaController(){
        prova = new Prova();
        provas = ProvaDAO.getInstance().buscarTodas(Prova.class);
    }
    
    public void gravar(){
        ProvaDAO.getInstance().persistir(prova);
        provas = ProvaDAO.getInstance().buscarTodas(Prova.class);
    }
    
    public void remover(){
        ProvaDAO.getInstance().remover(Prova.class, prova.getId());
        provas = ProvaDAO.getInstance().buscarTodas(Prova.class);
    }
    
    public void onRowEdit(RowEditEvent<Prova> event) {
        ProvaDAO.getInstance().atualizar(prova);
        provas = ProvaDAO.getInstance().buscarTodas(Prova.class);
        prova = new Prova();
        FacesMessage msg = new FacesMessage("Editado", event.getObject().getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Prova> event) {
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

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public List<Prova> getProvas() {
        return provas;
    }

    public void setProvas(List<Prova> provas) {
        this.provas = provas;
    }
    
    
}
