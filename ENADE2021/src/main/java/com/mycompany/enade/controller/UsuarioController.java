/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.controller;

import com.mycompany.enade.dao.UsuarioDAO;
import com.mycompany.enade.model.Usuario;
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
public class UsuarioController implements Serializable{
    
    Usuario usuario = new Usuario();
    List<Usuario> usuarios = new ArrayList<Usuario>();
    
    public UsuarioController(){
        usuarios = UsuarioDAO.getInstance().buscarTodas(Usuario.class);
        usuario = new Usuario();
    }
    
    public void gravar(Usuario usuario){
        UsuarioDAO.getInstance().persistir(usuario);
        usuarios = UsuarioDAO.getInstance().buscarTodas(Usuario.class);
    }
    
    public void remover(Usuario usuario){
        UsuarioDAO.getInstance().remover(Usuario.class, usuario.getId());
        usuarios = UsuarioDAO.getInstance().buscarTodas(Usuario.class);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
}
