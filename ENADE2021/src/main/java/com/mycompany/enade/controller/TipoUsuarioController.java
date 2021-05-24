/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.controller;

import com.mycompany.enade.dao.TipoUsuarioDAO;
import com.mycompany.enade.model.Tipousuario;
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
public class TipoUsuarioController implements Serializable{
    
    Tipousuario tipoUsuario = new Tipousuario();
    List<Tipousuario> tipoUsuarios = new ArrayList<Tipousuario>();
    
    public TipoUsuarioController(){
        tipoUsuario = new Tipousuario();
        tipoUsuarios = TipoUsuarioDAO.getInstance().buscarTodas(Tipousuario.class);
    }
    
    public void gravar(){
        TipoUsuarioDAO.getInstance().persistir(tipoUsuario);
        tipoUsuarios = TipoUsuarioDAO.getInstance().buscarTodas(Tipousuario.class);
    }
    
    public void remover(){
        TipoUsuarioDAO.getInstance().remover(Tipousuario.class, tipoUsuario.getId());
        tipoUsuarios = TipoUsuarioDAO.getInstance().buscarTodas(Tipousuario.class);
    }

    public Tipousuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Tipousuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<Tipousuario> getTipoUsuarios() {
        return tipoUsuarios;
    }

    public void setTipoUsuarios(List<Tipousuario> tipoUsuarios) {
        this.tipoUsuarios = tipoUsuarios;
    }

    
}
    
