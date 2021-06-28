/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.controller;

import com.mycompany.enade.reports.Relatorio;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author angelo.lucas
 */
@Named
@ViewScoped
public class RelatorioController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String relatorio;
    private Map<String, String> tipos;
    
    public RelatorioController() {
        tipos = new HashMap<String, String>();
        tipos.put("Relatorio de Alunos", "alunos.jasper");
        tipos.put("Relatorio de Resultados", "ResultadosAlunos.jasper");
        tipos.put("Relatorio de Alunos com Prova Pendente", "AlunosPendentes.jasper");
    }
    
    public void gerarRelatorio() {
        Relatorio relatorio = new Relatorio();
        relatorio.getRelatorio(relatorio);
    }

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public Map<String, String> getTipos() {
        return tipos;
    }

    public void setTipos(Map<String, String> tipos) {
        this.tipos = tipos;
    }
}
