package com.mycompany.enade.model;

import com.mycompany.enade.model.Questao;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-19T01:35:10")
@StaticMetamodel(Tipoquestao.class)
public class Tipoquestao_ { 

    public static volatile SingularAttribute<Tipoquestao, Integer> idTipoQuestao;
    public static volatile SingularAttribute<Tipoquestao, String> nomeTipoQuestao;
    public static volatile ListAttribute<Tipoquestao, Questao> questaoList;

}