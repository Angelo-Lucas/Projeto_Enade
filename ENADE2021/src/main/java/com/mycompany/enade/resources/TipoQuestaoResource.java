package com.mycompany.enade.resources;

import com.mycompany.enade.dao.TipoQuestaoDAO;
import com.mycompany.enade.model.Tipoquestao;
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
@Path("tipoquestao")
public class TipoQuestaoResource {
    
     @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosTipoQuestao")
    public List<Tipoquestao> TodosTipoQuestao(){
         return TipoQuestaoDAO.getInstance().buscarTodas(Tipoquestao.class);
    }
    
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosTipoQuestao/(codigo)")
    public Tipoquestao GetTipoQuestao(@PathParam("idTipoQuestao") int idTipoQuestao){
        return TipoQuestaoDAO.getInstance().buscar(Tipoquestao.class, idTipoQuestao);
    }
    
    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluirtipoquestao/(codigo)")
    public String Excluir(@PathParam("codigo") Integer codigo){
        
        try{
            TipoQuestaoDAO.getInstance().remover(Tipoquestao.class, codigo);
            return "Registro excluído!";
        }catch(Exception e){
            return "Erro ao excluir!" + e.getMessage();
        }
    }
    
    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluirTodosTipoQuestao")
    public String Excluir(){
        try{
            TipoQuestaoDAO.getInstance().removeAll(Tipoquestao.class);
            return "Todos os registros foram excluídos!";
        }catch(Exception e){
            return "Erro ao excluir!" + e.getMessage();
        }
    }
    
    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrartipoquestao")
    public String Cadastrar(Tipoquestao tipoQuestao){
        Tipoquestao tp = new Tipoquestao();
        try{
            tp.setIdTipoQuestao(tipoQuestao.getId());
        tp.setNomeTipoQuestao(tipoQuestao.getNomeTipoQuestao());
            TipoQuestaoDAO.getInstance().persistir(tipoQuestao);
            return "Registro salvo!";
        }catch (Exception e){
            return "Erro ao cadastrar." + e.getMessage();
        }
    }
    
    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/alterartipoquestao")
    public String Alterar(Tipoquestao tipoQuestao){
        Tipoquestao tp = new Tipoquestao();
        try{
            tp.setIdTipoQuestao(tipoQuestao.getId());
            tp.setNomeTipoQuestao(tipoQuestao.getNomeTipoQuestao());
            TipoQuestaoDAO.getInstance().persistir(tipoQuestao);
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
