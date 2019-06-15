/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursos.model;

import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author Caique
 */
public class Curso {

    private int idCurso;
    private String nome;

    public Curso() {
    }

    public Curso(int idCurso, String nome) {
        this.idCurso = idCurso;
        this.nome = nome;
    }

    public Curso(int id, JTextField i_nomeCurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdCurso() {
        return idCurso;
    }
    
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void addAluno(Aluno a){
        a.setIdCurso(this);
        // listaAlunos.add(a);
    }
}
