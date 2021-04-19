/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.resources;

import com.mycompany.enade.dao.UsuarioDAO;
import com.mycompany.enade.model.Usuario;
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
@Path("usuario")
public class UsuarioResource {
      @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosUsuario")
    public List<Usuario> TodosUsuario(){
        
        List<Usuario> tipoUsuario = UsuarioDAO.getInstance().buscarTodas(Usuario.class);
        
        return tipoUsuario;
    }
    
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosUsuario/(codigo)")
    public Usuario GetTipoUsuario(@PathParam("idUsuario") int idUsuario){
        return UsuarioDAO.getInstance().buscar(Usuario.class, idUsuario);
    }
    
    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluirusuario/(codigo)")
    public String Excluir(@PathParam("idUsuario") Integer idUsuario){
        
        try{
            UsuarioDAO.getInstance().remover(Usuario.class, idUsuario);
            return "Registro excluído!";
        }catch(Exception e){
            return "Erro ao excluir!" + e.getMessage();
        }
    }
    
    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluirTodosUsuarios")
    public String Excluir(){
        try{
            UsuarioDAO.getInstance().removeAll(Usuario.class);
            return "Todos os registros foram excluídos!";
        }catch(Exception e){
            return "Erro ao excluir!" + e.getMessage();
        }
    }
    
    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrarusuario")
    public String Cadastrar(Usuario usuario){
        Usuario us = new Usuario();
        try{
            us.setIdUsuario(usuario.getId());
            us.setNome(usuario.getNome());
            us.setEmail(usuario.getNome());
            us.setSenha(usuario.getSenha());
            us.setTipoUsuarioidTipoUsuario(usuario.getTipoUsuarioidTipoUsuario());
            UsuarioDAO.getInstance().persistir(usuario);
            return "Registro salvo!";
        }catch (Exception e){
            return "Erro ao cadastrar." + e.getMessage();
        }
    }
    
    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterartipousuario")
    public String Alterar(Usuario usuario){
        Usuario us = new Usuario();
        try{
            us.setIdUsuario(usuario.getId());
            us.setNome(usuario.getNome());
            us.setEmail(usuario.getNome());
            us.setSenha(usuario.getSenha());
            us.setTipoUsuarioidTipoUsuario(usuario.getTipoUsuarioidTipoUsuario());
            UsuarioDAO.getInstance().persistir(usuario);
            return "Registro salvo!";
        }catch (Exception e){
            return "Erro ao cadastrar." + e.getMessage();
        }
    }
}
