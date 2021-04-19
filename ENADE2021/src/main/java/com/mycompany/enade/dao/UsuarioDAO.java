/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.dao;

import com.mycompany.enade.model.Tipoquestao;
import com.mycompany.enade.model.Usuario;
import com.mycompany.enade.util.PersistenceUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author angelo.lucas
 */
public class UsuarioDAO extends GenericDAO<Usuario>{
    
     public static UsuarioDAO usuarioDAO;
    
    public static UsuarioDAO getInstance(){
        if(usuarioDAO == null){
            usuarioDAO = new UsuarioDAO();
        }
        return usuarioDAO;
    } 
}
