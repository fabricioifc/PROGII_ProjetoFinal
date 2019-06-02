package br.edu.ifc.conexao.dao;

import br.edu.ifc.conexao.model.Categoria;
import java.sql.SQLException;
import java.util.List;

public class CategoriaDAO
    implements GenericDAO<Categoria, Long> {

  @Override
  public boolean salvar(Categoria objeto) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean atualizar(Categoria objeto, Long id) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean excluir(Long id) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Categoria> listarTodos() throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Categoria getPorId(Long id) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
