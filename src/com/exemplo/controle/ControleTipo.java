package com.exemplo.controle;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.exemplo.entidade.Tipo;

@SuppressWarnings("all")
@ManagedBean
@ViewScoped
public class ControleTipo implements Serializable{
 
    private Tipo tipo;
    private List<Tipo> todosTipos;
 
    public List<Tipo> getTodosTipos() {
        return Arrays.asList(Tipo.values());
    }
 
    public void setTodosTipos(List<Tipo> todosTipos) {
        this.todosTipos = todosTipos;
    }
 
    public Tipo getTipo() {
        return tipo;
    }
 
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}