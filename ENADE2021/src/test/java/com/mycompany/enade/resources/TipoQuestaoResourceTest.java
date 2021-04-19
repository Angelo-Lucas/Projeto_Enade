/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.resources;

import com.mycompany.enade.model.Tipoquestao;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author angelo.lucas
 */
public class TipoQuestaoResourceTest {
    
    TipoQuestaoResource tipoQuestaoResource = mock(TipoQuestaoResource.class);
    List<Tipoquestao> arrayTipoQuestao = new ArrayList<>();
    Tipoquestao tipoQuestao = mock(Tipoquestao.class);
    
    public TipoQuestaoResourceTest() {
    }
    
    @Test
    public void testTodosTipoQuestao() {
        arrayTipoQuestao.add(tipoQuestao);
        when(tipoQuestaoResource.TodosTipoQuestao()).thenReturn(arrayTipoQuestao);
        assertEquals(arrayTipoQuestao, tipoQuestaoResource.TodosTipoQuestao());
    }

    @Test
    public void testGetTipoQuestao() {
        when(tipoQuestaoResource.GetTipoQuestao(tipoQuestao.getId())).thenReturn(tipoQuestao);
        assertEquals(tipoQuestao, tipoQuestaoResource.GetTipoQuestao(tipoQuestao.getId()));
    }

    @Test
    public void testAlterar() {
        String tq = tipoQuestao.toString();
        when(tipoQuestaoResource.Alterar(tipoQuestao)).thenReturn(tq);
        assertEquals(tipoQuestao.toString(), tipoQuestaoResource.Alterar(tipoQuestao));
    }

    @Test
    public void testExcluirTodos() {
        when(tipoQuestaoResource.Excluir()).thenReturn("Todos os registros foram excluídos.");
        assertEquals("Todos os registros foram excluídos.", tipoQuestaoResource.Excluir());
    }

    @Test
    public void testRemove() {
        when(tipoQuestaoResource.Excluir(tipoQuestao.getId())).thenReturn("Registro excluído.");
        assertEquals("Registro excluído.", tipoQuestaoResource.Excluir(tipoQuestao.getId()));
    }

}
