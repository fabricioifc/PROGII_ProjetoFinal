package br.edu.ifc.conexao.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<K, I extends Number> {
    boolean salvar() throws SQLException;
    boolean atualizar() throws SQLException;
    boolean excluir() throws SQLException;
    List listarTodos()  throws SQLException;
    K getPorId() throws SQLException;
}
