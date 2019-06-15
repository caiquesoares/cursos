package com.cursos.controller;

import com.cursos.dao.CursoDao;
import com.cursos.model.Curso;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class CursoController implements IController<Curso> {
    private CursoDao CursoDao;

    public CursoController() {
        this.CursoDao = new CursoDao();
    }
    
    @Override
    public void Incluir(Curso item) {
        CursoDao.Incluir(item);
    }

    @Override
    public void Alterar(Curso item) {
        CursoDao.Alterar(item);
    }

    @Override
    public void Excluir(int id) {
        CursoDao.Excluir(id);
    }

    @Override
    public Curso Consultar(int id) {
        return CursoDao.Consultar(id);
    }

    @Override
    public DefaultTableModel CarregarTabela() {
        Object Colunas[] = {"Id", "Nome"};
        DefaultTableModel modeloTabelaCurso = new DefaultTableModel(Colunas, 0);
        
        ArrayList<Curso> listaCurso = CursoDao.Listar();
        for (int i = 0; i < listaCurso.size(); i++) {
            Object linha[] = new Object[]{listaCurso.get(i).getIdCurso(), listaCurso.get(i).getNome()};
            modeloTabelaCurso.addRow(linha);
        }
        return modeloTabelaCurso;
    }
    
}
