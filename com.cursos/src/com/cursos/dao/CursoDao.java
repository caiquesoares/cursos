package com.cursos.dao;

import com.cursos.model.Curso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CursoDao extends ConexaoDao<Curso> {

    @Override
    public void Incluir(Curso item) {
        try {
            AbrirConexaoDB();

            String instrucaoSql = "Insert into Curso (nome) values (?)";

            PreparedStatement comando = ConexaoDB.prepareStatement(instrucaoSql);
            comando.setString(1, item.getNome());

            comando.execute();

            ConexaoDB.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir curso.");
        }
    }

    @Override
    public void Alterar(Curso item) {
        try {
            AbrirConexaoDB();

            String instrucaoSql = "Update Curso set nome=? where id=?";

            PreparedStatement comando = ConexaoDB.prepareStatement(instrucaoSql);
            comando.setString(1, item.getNome());
            comando.setInt(2, item.getIdCurso());

            comando.execute();

            ConexaoDB.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar curso.");
        }
    }

    @Override
    public void Excluir(int id) {
        try {
            AbrirConexaoDB();

            String instrucaoSql = "Delete from curso where id=?";

            PreparedStatement comando = ConexaoDB.prepareStatement(instrucaoSql);
            comando.setInt(1, id);

            comando.execute();

            ConexaoDB.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar curso.");
        }
    }

    @Override
    public Curso Consultar(int id) {
        Curso curso = new Curso();

        try {
            AbrirConexaoDB();

            String instrucaoSql = "select * from curso where id=?";

            PreparedStatement comando = ConexaoDB.prepareStatement(instrucaoSql);
            comando.setInt(1, id);
            
            ResultSet resultado = comando.executeQuery(instrucaoSql);

            while (resultado.next()) {
                curso.setIdCurso(resultado.getInt("id"));
                curso.setNome(resultado.getString("nome"));
            }
            ConexaoDB.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar curso.");
        }
        return curso;
    }

    @Override
    public ArrayList<Curso> Listar() {
        ArrayList<Curso> cursos = new ArrayList<Curso>();

        try {
            AbrirConexaoDB();

            String instrucaoSql = "select * from curso";

            Statement comando = ConexaoDB.createStatement();

            ResultSet resultado = comando.executeQuery(instrucaoSql);

            while (resultado.next()) {
                Curso curso = new Curso();

                curso.setIdCurso(resultado.getInt("id"));
                curso.setNome(resultado.getString("nome"));

                cursos.add(curso);
            }

            ConexaoDB.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar cursos.");
        }

        return cursos;
    }
}
