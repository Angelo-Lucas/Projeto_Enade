/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.resources;

import com.mycompany.enade.dao.ProvaDAO;
import com.mycompany.enade.model.Prova;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author angelo.lucas
 */
@Path("prova")
public class ProvaResource {
    
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosProva")
    public List<Prova> TodosProva(){
        
        List<Prova> prova = ProvaDAO.getInstance().buscarTodas(Prova.class);
        
        return prova;
    }
    
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosProva/(codigo)")
    public Prova GetProva(@PathParam("idProva") int id){
        return ProvaDAO.getInstance().buscar(Prova.class, id);
    }
    
    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluirprova/(codigo)")
    public String Excluir(@PathParam("codigo") Integer codigo){
        
        try{
            ProvaDAO.getInstance().remover(Prova.class, codigo);
            return "Registro excluído!";
        }catch(Exception e){
            return "Erro ao excluir!" + e.getMessage();
        }
    }
    
    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluirTodasProvas")
    public String Excluir(){
        try{
            ProvaDAO.getInstance().removeAll(Prova.class);
            return "Todos os registros foram excluídos!";
        }catch(Exception e){
            return "Erro ao excluir!" + e.getMessage();
        }
    }
    
    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrarprova")
    public String Cadastrar(Prova prova){
        Prova pr = new Prova();
        try{
            pr.setIdProva(prova.getId());
            pr.setDataProva(prova.getDataProva());
            pr.setQuestaoList(prova.getQuestaoList());
            pr.setResultadoList(prova.getResultadoList());
            ProvaDAO.getInstance().persistir(pr);
            return "Registro salvo!";
        }catch (Exception e){
            return "Erro ao cadastrar." + e.getMessage();
        }
    }
    
    //*****CORRIGIR SET******
    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrarprova")
    public String Alterar(Prova prova){
        Prova pr = new Prova();
        try{
            pr.setIdProva(prova.getId());
            pr.setDataProva(prova.getDataProva());
            pr.setQuestaoList(prova.getQuestaoList());
            pr.setResultadoList(prova.getResultadoList());
            ProvaDAO.getInstance().persistir(pr);
            return "Registro salvo!";
        }catch (Exception e){
            return "Erro ao cadastrar." + e.getMessage();
        }
    }
    
    @GET
    public Response ping(){
        return Response
                .ok("ping")
                .build();
    }
    
}
