/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.controller;

import com.mycompany.enade.dao.UsuarioDAO;
import com.mycompany.enade.model.Usuario;
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
public class UsuarioController implements Serializable{
    
    Usuario usuario = new Usuario();
    List<Usuario> usuarios = new ArrayList<Usuario>();
    
    public UsuarioController(){
        usuario = new Usuario();
        usuarios = UsuarioDAO.getInstance().buscarTodas(Usuario.class);
    }
    
    public void gravar(){
        UsuarioDAO.getInstance().persistir(usuario);
        usuarios = UsuarioDAO.getInstance().buscarTodas(Usuario.class);
        usuario = new Usuario();
    }
    
    public void remover(){
        UsuarioDAO.getInstance().remover(Usuario.class, usuario.getId());
        usuarios = UsuarioDAO.getInstance().buscarTodas(Usuario.class);
        usuario = new Usuario();
    }
    
    public String efetuaLogin() {
		usuarios = UsuarioDAO.getInstance().buscarTodas(Usuario.class);
		FacesContext context = FacesContext.getCurrentInstance();
		if(!usuarios.isEmpty() ) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			return "index?faces-redirect=true";
                }
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Usuário não encontrado"));
                    
		return "login?faces-redirect=true";
	}
	
	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		return "login?faces-redirect=true";
	}
        
        public void onRowEdit(RowEditEvent<Usuario> event) {
        UsuarioDAO.getInstance().atualizar(usuario);
        usuarios = UsuarioDAO.getInstance().buscarTodas(Usuario.class);
        usuario = new Usuario();
        FacesMessage msg = new FacesMessage("Editado", event.getObject().getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Usuario> event) {
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
