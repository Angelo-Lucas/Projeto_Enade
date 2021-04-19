/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.dao;

import com.mycompany.enade.model.Tipoquestao;

/**
 *
 * @author angelo.lucas
 */
public class TipoQuestaoDAO extends GenericDAO<Tipoquestao>{
    
    public static TipoQuestaoDAO tipoQuestaoDAO;
    
    public static TipoQuestaoDAO getInstance(){
        if(tipoQuestaoDAO == null){
            tipoQuestaoDAO = new TipoQuestaoDAO();
        }
        return tipoQuestaoDAO;
    }
}