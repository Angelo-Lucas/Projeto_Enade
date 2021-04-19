/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author angelo.lucas
 */
@Entity
@Table(name = "tipoquestao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoquestao.findAll", query = "SELECT t FROM Tipoquestao t"),
    @NamedQuery(name = "Tipoquestao.findByIdTipoQuestao", query = "SELECT t FROM Tipoquestao t WHERE t.idTipoQuestao = :idTipoQuestao"),
    @NamedQuery(name = "Tipoquestao.findByNomeTipoQuestao", query = "SELECT t FROM Tipoquestao t WHERE t.nomeTipoQuestao = :nomeTipoQuestao")})
public class Tipoquestao implements EntidadeBase {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoQuestao")
    private Integer idTipoQuestao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomeTipoQuestao")
    private String nomeTipoQuestao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoQuestaoidTipoQuestao")
    private List<Questao> questaoList;

    public Tipoquestao() {
    }

    public Tipoquestao(Integer idTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
    }

    public Tipoquestao(Integer idTipoQuestao, String nomeTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
        this.nomeTipoQuestao = nomeTipoQuestao;
    }

    @Override
    public Integer getId() {
        return idTipoQuestao;
    }

    public void setIdTipoQuestao(Integer idTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
    }

    public String getNomeTipoQuestao() {
        return nomeTipoQuestao;
    }

    public void setNomeTipoQuestao(String nomeTipoQuestao) {
        this.nomeTipoQuestao = nomeTipoQuestao;
    }

    @XmlTransient
    public List<Questao> getQuestaoList() {
        return questaoList;
    }

    public void setQuestaoList(List<Questao> questaoList) {
        this.questaoList = questaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoQuestao != null ? idTipoQuestao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoquestao)) {
            return false;
        }
        Tipoquestao other = (Tipoquestao) object;
        if ((this.idTipoQuestao == null && other.idTipoQuestao != null) || (this.idTipoQuestao != null && !this.idTipoQuestao.equals(other.idTipoQuestao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.enade.model.Tipoquestao[ idTipoQuestao=" + idTipoQuestao + " ]";
    }
    
}
