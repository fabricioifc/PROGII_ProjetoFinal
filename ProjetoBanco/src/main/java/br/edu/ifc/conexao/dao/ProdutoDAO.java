package br.edu.ifc.conexao.dao;

import br.edu.ifc.conexao.db.DatabaseConnection;
import br.edu.ifc.conexao.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO
    implements GenericDAO<Produto, Long> {

  private final String SQL_INSERT = "INSERT INTO produtos (nome, valor) VALUES (?,?)";
  private final String SQL_UPDATE = "UPDATE .....";
  private final String SQL_DELETE = "DELETE .....";
  private final String SQL_SELECT = "SELECT * FROM produtos";
  private final String SQL_SELECT_BY_ID = "SELECT ........";

  @Override
  public boolean salvar(Produto objeto) throws SQLException {
    try {
      PreparedStatement ps = DatabaseConnection.getInstance().getConnection()
          .prepareStatement(SQL_INSERT);
      ps.setString(1, objeto.getNome());
      ps.setDouble(2, objeto.getValor());
      boolean resultado = ps.executeUpdate() == 1;

      DatabaseConnection.commit();
      return resultado;
    } catch (SQLException ex) {
      DatabaseConnection.rollback();
      throw ex;
    } finally {
      DatabaseConnection.fecharConexao();
    }

  }

  @Override
  public boolean atualizar(Produto objeto, Long id) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean excluir(Long id) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Produto> listarTodos() throws SQLException {
    List<Produto> lista = new ArrayList<>();
    ResultSet rs;
    try {

      PreparedStatement ps = DatabaseConnection.getInstance().
          getConnection().prepareStatement(SQL_SELECT);
      rs = ps.executeQuery();
      while (rs.next()) {
        Produto produto = new Produto(
            rs.getLong("id"),
            rs.getString("nome"),
            rs.getDouble("valor"));
        lista.add(produto);
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
  public Produto getPorId(Long id) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
