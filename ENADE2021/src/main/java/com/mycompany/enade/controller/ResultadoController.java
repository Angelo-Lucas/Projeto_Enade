/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.controller;


import com.mycompany.enade.dao.ResultadoDAO;
import com.mycompany.enade.model.Resultado;
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
public class ResultadoController implements Serializable{
    Resultado resultado = new Resultado();
    List<Resultado> resultados = new ArrayList<Resultado>();
    
    public ResultadoController(){
        resultado = new Resultado();
        resultados = ResultadoDAO.getInstance().buscarTodas(Resultado.class);
    }
    
    public void gravar(){
        ResultadoDAO.getInstance().persistir(resultado);
        resultados = ResultadoDAO.getInstance().buscarTodas(Resultado.class);
    }
    
    public void remover(){
        ResultadoDAO.getInstance().remover(Resultado.class, resultado.getId());
        resultados = ResultadoDAO.getInstance().buscarTodas(Resultado.class);
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }
    
    
}
