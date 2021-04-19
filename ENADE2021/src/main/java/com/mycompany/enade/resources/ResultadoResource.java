/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.resources;

import com.mycompany.enade.dao.ResultadoDAO;
import com.mycompany.enade.model.Resultado;
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
@Path("resultado")
public class ResultadoResource {
     @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosResultado")
    public List<Resultado> TodosResultado(){
        
        List<Resultado> resultado = ResultadoDAO.getInstance().buscarTodas(Resultado.class);
        
        return resultado;
    }
    
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosResultado/(codigo)")
    public Resultado GetResultado(@PathParam("idResultado") int idResultado){
        return ResultadoDAO.getInstance().buscar(Resultado.class, idResultado);
    }
    
    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluirresultado/(codigo)")
    public String Excluir(@PathParam("idResultado") Integer idResultado){
        
        try{
            ResultadoDAO.getInstance().remover(Resultado.class, idResultado);
            return "Registro excluído!";
        }catch(Exception e){
            return "Erro ao excluir!" + e.getMessage();
        }
    }
    
    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluirTodosResultados")
    public String Excluir(){
        try{
            ResultadoDAO.getInstance().removeAll(Resultado.class);
            return "Todos os registros foram excluídos!";
        }catch(Exception e){
            return "Erro ao excluir!" + e.getMessage();
        }
    }
    
    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrarresultado")
    public String Cadastrar(Resultado resultado){
        Resultado rt = new Resultado();
        try{
            rt.setIdResultado(resultado.getId());
            rt.setValorObtido(resultado.getValorObtido());
            rt.setProvaidProva(resultado.getProvaidProva());
            rt.setUsuarioidUsuario(resultado.getUsuarioidUsuario());
            ResultadoDAO.getInstance().persistir(rt);
            return "Registro salvo!";
        }catch (Exception e){
            return "Erro ao cadastrar." + e.getMessage();
        }
    }
    
    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrarresultado")
    public String Alterar(Resultado resultado){
        Resultado rt = new Resultado();
        try{
            rt.setIdResultado(resultado.getId());
            rt.setValorObtido(resultado.getValorObtido());
            rt.setProvaidProva(resultado.getProvaidProva());
            rt.setUsuarioidUsuario(resultado.getUsuarioidUsuario());
            ResultadoDAO.getInstance().persistir(rt);
            return "Registro salvo!";
        }catch (Exception e){
            return "Erro ao cadastrar." + e.getMessage();
        }
    }
}
