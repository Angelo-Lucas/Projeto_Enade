/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.dao;

import com.mycompany.enade.model.Resultado;
import com.mycompany.enade.util.PersistenceUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author angelo.lucas
 */
public class ResultadoDAO extends GenericDAO<Resultado>{
     public static ResultadoDAO resultadoDAO;
    
    public static ResultadoDAO getInstance(){
        if(resultadoDAO == null){
            resultadoDAO = new ResultadoDAO();
        }
        return resultadoDAO;
    }
    
    
}
