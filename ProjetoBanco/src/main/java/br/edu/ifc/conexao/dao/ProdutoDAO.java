/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.conexao.dao;

import br.edu.ifc.conexao.db.DatabaseConnection;
import br.edu.ifc.conexao.model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabricio
 */
public class ProdutoDAO implements GenericDAO<XXXXX, XXXXX> {

    private final String SQL_INSERT = "";
    private final String SQL_UPDATE = "";
    private final String SQL_DELETE = "";
    private final String SQL_SELECT = "";
    private final String SQL_SELECT_BY_ID = "";

    @Override
    public boolean salvar(Produto objeto) throws SQLException {
        throw new UnsupportedOperationException("Implemente este método.");
    }

    @Override
    public List<Produto> listarTodos() throws SQLException {
        throw new UnsupportedOperationException("Implemente este método.");
    }

    @Override
    public Produto getPorId(Long id, Produto objeto) throws SQLException {
        throw new UnsupportedOperationException("Implemente este método.");
    }

    @Override
    public boolean atualizar(Produto objeto) throws SQLException {
        throw new UnsupportedOperationException("Implemente este método.");
    }

    @Override
    public boolean excluir(Produto objeto) throws SQLException {
        throw new UnsupportedOperationException("Implemente este método.");
    }
}
