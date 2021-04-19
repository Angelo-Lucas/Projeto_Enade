/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.resources;

import com.mycompany.enade.dao.TipoUsuarioDAO;
import com.mycompany.enade.model.Tipousuario;
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
@Path("tipousuario")
public class TipoUsuarioResource {
    
      @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosTipoUsuario")
    public List<Tipousuario> TodosTipoUsuario(){
        
        List<Tipousuario> tipoUsuario = TipoUsuarioDAO.getInstance().buscarTodas(Tipousuario.class);
        
        return tipoUsuario;
    }
    
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosTipoUsuario/(codigo)")
    public Tipousuario GetTipoUsuario(@PathParam("idTipoUsuario") int idTipoUsuario){
        return TipoUsuarioDAO.getInstance().buscar(Tipousuario.class, idTipoUsuario);
    }
    
    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluirtipousuario/(codigo)")
    public String Excluir(@PathParam("idTipoUsuario") Integer idTipoUsuario){
        
        try{
            TipoUsuarioDAO.getInstance().remover(Tipousuario.class, idTipoUsuario);
            return "Registro excluído!";
        }catch(Exception e){
            return "Erro ao excluir!" + e.getMessage();
        }
    }
    
    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluirTodosTipoUsuario")
    public String Excluir(){
        try{
            TipoUsuarioDAO.getInstance().removeAll(Tipousuario.class);
            return "Todos os registros foram excluídos!";
        }catch(Exception e){
            return "Erro ao excluir!" + e.getMessage();
        }
    }
    
    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrartipousuario")
    public String Cadastrar(Tipousuario tipoUsuario){
        Tipousuario tu = new Tipousuario();
        try{
            tu.setIdTipoUsuario(tipoUsuario.getId());
            tu.setNomeTipoUsuario(tipoUsuario.getNomeTipoUsuario());
            TipoUsuarioDAO.getInstance().persistir(tipoUsuario);
            return "Registro salvo!";
        }catch (Exception e){
            return "Erro ao cadastrar." + e.getMessage();
        }
    }
    
    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterartipousuario")
    public String Alterar(Tipousuario tipoUsuario){
        Tipousuario tu = new Tipousuario();
        try{
            tu.setIdTipoUsuario(tipoUsuario.getId());
            tu.setNomeTipoUsuario(tipoUsuario.getNomeTipoUsuario());
            TipoUsuarioDAO.getInstance().persistir(tipoUsuario);
            return "Registro salvo!";
        }catch (Exception e){
            return "Erro ao cadastrar." + e.getMessage();
        }
    }
}
