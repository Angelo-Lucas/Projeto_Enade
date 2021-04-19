/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.dao;

import com.mycompany.enade.model.Questao;


/**
 *
 * @author angelo.lucas
 */
public class QuestaoDAO extends GenericDAO<Questao> {
     public static QuestaoDAO QuestaoDAO;
    
    public static QuestaoDAO getInstance(){
        if(QuestaoDAO == null){
            QuestaoDAO = new QuestaoDAO();
        }
        return QuestaoDAO;
    }
    
    
}
