/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursos.controller;

import javax.swing.table.DefaultTableModel;

public interface IController<T> {
    void Incluir(T item);
    void Alterar(T item);
    void Excluir(int id);    
    T Consultar(int id);
    DefaultTableModel CarregarTabela();
    
    
}
