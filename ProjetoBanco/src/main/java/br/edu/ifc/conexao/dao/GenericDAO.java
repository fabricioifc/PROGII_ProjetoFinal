package br.edu.ifc.conexao.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<K, I extends Number> {
    boolean salvar(K objeto) throws SQLException;
    boolean atualizar(K objeto, I id) throws SQLException;
    boolean excluir(I id) throws SQLException;
    List<K> listarTodos()  throws SQLException;
    K getPorId(I id) throws SQLException;
}
