package br.edu.ifc.conexao.dao;

import br.edu.ifc.conexao.db.DatabaseConnection;
import br.edu.ifc.conexao.model.Categoria;
import br.edu.ifc.conexao.model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO
    implements GenericDAO<Categoria, Long> {

  private final String SQL_SELECT = "select * from categorias";
  private final String SQL_SELECT_BY_ID = "SELECT * FROM categorias where id = ?";

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
    List<Categoria> lista = new ArrayList<>();
    ResultSet rs;
    try {

      PreparedStatement ps = DatabaseConnection.getInstance().
          getConnection().prepareStatement(SQL_SELECT);
      rs = ps.executeQuery();
      while (rs.next()) {
        Categoria categoria = new Categoria(
            rs.getLong("id"),
            rs.getString("nome"),
            rs.getBoolean("ativo"));
        lista.add(categoria);
      }

      DatabaseConnection.commit();
      return lista;
    } catch (SQLException ex) {
      DatabaseConnection.rollback();
      throw ex;
    } finally {
      DatabaseConnection.fecharConexao();
    }
  }

  @Override
  public Categoria getPorId(Long id) throws SQLException {
    Categoria categoria = null;
    ResultSet rs;
    try {

      PreparedStatement ps = DatabaseConnection.getInstance().
          getConnection().prepareStatement(SQL_SELECT_BY_ID);
      ps.setLong(1, id);
      rs = ps.executeQuery();
      if (rs.next()) {
        categoria = new Categoria(
            rs.getLong("id"),
            rs.getString("nome"),
            rs.getBoolean("ativo"));
      }

      DatabaseConnection.commit();
      return categoria;
    } catch (SQLException ex) {
      DatabaseConnection.rollback();
      throw ex;
    } finally {
//      DatabaseConnection.fecharConexao();
    }
  }

}
