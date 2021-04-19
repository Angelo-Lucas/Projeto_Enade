/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.resources;

import com.mycompany.enade.dao.QuestaoDAO;
import com.mycompany.enade.model.Questao;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author angelo.lucas
 */
@Path("questao")
public class QuestaoResource {
    
    
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosQuestao")
    public List<Questao> TodosQuestao(){
        
        List<Questao> questao = QuestaoDAO.getInstance().buscarTodas(Questao.class);
        
        return questao;
    }
    
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosQuestao/(codigo)")
    public Questao GetQuestao(@PathParam("idQuestao") int idQuestao){
        return QuestaoDAO.getInstance().buscar(Questao.class, idQuestao);
    }
    
    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluirquestao/(codigo)")
    public String Excluir(@PathParam("idQuestao") Integer idQuestao){
        
        try{
            QuestaoDAO.getInstance().remover(Questao.class, idQuestao);
            return "Registro excluído!";
        }catch(Exception e){
            return "Erro ao excluir!" + e.getMessage();
        }
    }
    
    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluirTodosQuestao")
    public String Excluir(){
        try{
            QuestaoDAO.getInstance().removeAll(Questao.class);
            return "Todos os registros foram excluídos!";
        }catch(Exception e){
            return "Erro ao excluir!" + e.getMessage();
        }
    }
    
    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrarquestao")
    public String Cadastrar(Questao questao){
        Questao qs = new Questao();
        try{
            qs.setIdQuestao(questao.getId());
            qs.setAlternativaA(questao.getAlternativaA());
            qs.setAlternativaB(questao.getAlternativaB());
            qs.setAlternativaC(questao.getAlternativaC());
            qs.setAlternativaD(questao.getAlternativaD());
            qs.setAlternativaE(questao.getAlternativaE());
            qs.setDescricaoQuestao(questao.getDescricaoQuestao());
            qs.setQuestaoCorreta(questao.getQuestaoCorreta());
            qs.setEstadoQuestao(questao.getEstadoQuestao());
            qs.setTipoQuestaoidTipoQuestao(questao.getTipoQuestaoidTipoQuestao());
            qs.setProvaList(questao.getProvaList());
            QuestaoDAO.getInstance().persistir(qs);
            return "Registro salvo!";
        }catch (Exception e){
            return "Erro ao cadastrar." + e.getMessage();
        }
    }
    
    //*****CORRIGIR SET******
    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterarquestao")
    public String Alterar(Questao questao){
        Questao qs = new Questao();
        try{
            qs.setIdQuestao(questao.getId());
            qs.setAlternativaA(questao.getAlternativaA());
            qs.setAlternativaB(questao.getAlternativaB());
            qs.setAlternativaC(questao.getAlternativaC());
            qs.setAlternativaD(questao.getAlternativaD());
            qs.setAlternativaE(questao.getAlternativaE());
            qs.setDescricaoQuestao(questao.getDescricaoQuestao());
            qs.setQuestaoCorreta(questao.getQuestaoCorreta());
            qs.setEstadoQuestao(questao.getEstadoQuestao());
            qs.setTipoQuestaoidTipoQuestao(questao.getTipoQuestaoidTipoQuestao());
            qs.setProvaList(questao.getProvaList());
            QuestaoDAO.getInstance().persistir(qs);
            return "Registro salvo!";
        }catch (Exception e){
            return "Erro ao cadastrar." + e.getMessage();
        }
    }
}
