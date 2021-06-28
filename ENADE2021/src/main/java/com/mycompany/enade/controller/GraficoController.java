/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.controller;

import com.mycompany.enade.dao.ResultadoDAO;
import com.mycompany.enade.dao.UsuarioDAO;
import com.mycompany.enade.model.Resultado;
import com.mycompany.enade.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author angelo.lucas
 */
@Named
@ViewScoped
public class GraficoController implements Serializable {
    	private static final long serialVersionUID = 1L;
	private PieChartModel pieModel;
	private BarChartModel barModel;
	private List<Resultado> resultados;
        private List<Usuario> usuarios;

	public GraficoController() {
		resultados = ResultadoDAO.getInstance().buscarTodas(Resultado.class);
                usuarios = UsuarioDAO.getInstance().buscarTodas(Usuario.class);
	}
        
        @PostConstruct
        public void init() {
            criarGraficoResultado();
            criarGraficoRealizacaoProva();
    }

	private void criarGraficoResultado() {
            barModel = new BarChartModel();
            BarChartSeries bar = new BarChartSeries();
            
            resultados.forEach((resultado) -> {
                bar.setLabel("Alunos");
                bar.set(resultado.getUsuarioidUsuario().getNome(), resultado.getValorObtido());
            });

            barModel.addSeries(bar);
            Axis xAxis = barModel.getAxis(AxisType.X);
            xAxis.setLabel("Alunos");
            Axis yAxis = barModel.getAxis(AxisType.Y);
            yAxis.setLabel("Resultados");
            yAxis.setMin(0);
            yAxis.setMax(100);
	}
        
        private void criarGraficoRealizacaoProva() {
            pieModel = new PieChartModel();

            resultados.forEach(resultado -> pieModel.set("Realizaram a Prova", resultado.getId()));
            resultados.forEach((resultado) -> {
                usuarios.forEach((usuario) -> {
                    if(!usuario.getId().equals(resultado.getUsuarioidUsuario().getId())){
                        pieModel.set("Não Realizaram a Prova", usuario.getId());
                    }
                });
            });

            pieModel.setTitle("Realização de Prova");
            pieModel.setLegendPosition("w");
            pieModel.setShowDataLabels(true);
            pieModel.setSeriesColors("E7E658, 1a85ba, 66ec66");
            pieModel.setDiameter(230);
            pieModel.setDataFormat("percent");
	}

        public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}
        
        public List<Resultado> getResultados() {
                return resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}
}
