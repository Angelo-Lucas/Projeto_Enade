/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.dao;

import com.mycompany.enade.model.EntidadeBase;
import com.mycompany.enade.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author angelo.lucas
 */
public abstract class GenericDAO<T extends EntidadeBase> {
    
    private static EntityManager em = getEM();
    
    public static EntityManager getEM(){
        return PersistenceUtil.getEntityManager();
    }
    
    public static GenericDAO genericDAO;
    
    
    protected GenericDAO(){
    }
    
    public T buscar(Class<T> t, int id){
        return em.find(t, id);
    }
    
    public List<T> buscarTodas(Class<T> t){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(t);
        query.from(t);
        return em.createQuery(query).getResultList();
    }
    
    public void remover(Class<T> classe, int id){
        T t = buscar(classe, id);
        em.getTransaction().begin();
        if(!em.contains(t)){
            t = em.merge(t);
        }
        em.remove(t);
        em.getTransaction().commit();
    }
    
    public T persistir(T t){
        em.getTransaction().begin();
        try{
            t = em.merge(t);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return t;
    }
    
    public T atualizar(T t) {
        em.getTransaction().begin();
        try {
            t = em.merge(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return t;
    }
    
    public void removeAll(Class<T> t){
        em.getTransaction().begin();
        Query query = em.createQuery("delete from T");
        query.setParameter("T", t);
        query.executeUpdate();
        em.getTransaction().commit();
    }
}
