/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.dao;

import com.mycompany.enade.model.Prova;

/**
 *
 * @author angelo.lucas
 */
public class ProvaDAO extends GenericDAO<Prova>{
    
   public static ProvaDAO provaDAO;
    
    public static ProvaDAO getInstance(){
        if(provaDAO == null){
            provaDAO = new ProvaDAO();
        }
        return provaDAO;
    }
    
    
}
