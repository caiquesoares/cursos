/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public abstract class ConexaoDao<T> {
    public String StatusConexaoDB = "Não conectado";
    protected java.sql.Connection ConexaoDB;

    // Metodos Abstratos
    public abstract void Incluir(T item);

    public abstract void Alterar(T item);

    public abstract void Excluir(int id);

    public abstract T Consultar(int id);

    public abstract ArrayList<T> Listar();

    protected void AbrirConexaoDB() {
        ConexaoDB = null;
        try {
            String connectionString = "jdbc:mysql://localhost:3306/cursos_db";
            String username = "root";
            String password = "";

            ConexaoDB = DriverManager.getConnection(connectionString, username, password);

            if (ConexaoDB != null) {
                StatusConexaoDB = "Conectado com sucesso!";
            } else {
                StatusConexaoDB = "Não foi possivel realizar conexão";
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "Nao foi possivel conectar ao Banco de Dados.");
        }
    }
}
