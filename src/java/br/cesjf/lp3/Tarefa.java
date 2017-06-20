package br.cesjf.lp3;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RafaelaEmília
 */
@Entity
public class Tarefa implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private Date dataConcluir;
    private Date dataConclusao;

    public Tarefa() {
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the dataConcluir
     */
    public Date getDataConcluir() {
        return dataConcluir;
    }

    /**
     * @param dataConcluir the dataConcluir to set
     */
    public void setDataConcluir(Date dataConcluir) {
        this.dataConcluir = dataConcluir;
    }

    /**
     * @return the dataConclusao
     */
    public Date getDataConclusao() {
        return dataConclusao;
    }

    /**
     * @param dataConclusao the dataConclusao to set
     */
    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
     
    
    
   
    
    
}
