package br.cesjf.lp3;


import br.cesjf.lp3.Tarefa;
import java.io.Serializable;
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
public class Etiqueta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String autor;
    private Integer titulo;
    private Tarefa tarefa;

    public Etiqueta() {
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
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the titulo
     */
    public Integer getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(Integer titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the tarefa
     */
    public Tarefa getTarefa() {
        return tarefa;
    }

    /**
     * @param tarefa the tarefa to set
     */
    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }
    
    
}
