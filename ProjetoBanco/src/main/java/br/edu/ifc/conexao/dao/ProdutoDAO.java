package br.edu.ifc.conexao.dao;

import br.edu.ifc.conexao.db.DatabaseConnection;
import br.edu.ifc.conexao.model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO
    implements GenericDAO<Produto, Long> {

  private final String SQL_INSERT = "INSERT INTO produtos (nome, valor, categoria_id) values (?,?,?)";
  private final String SQL_UPDATE = "UPDATE produtos set nome = ?, valor = ?, categoria_id = ? where id = ?";
  private final String SQL_DELETE = "DELETE FROM produtos where id = ?";
  private final String SQL_SELECT = "SELECT * FROM produtos";
  private final String SQL_SELECT_BY_ID = "SELECT * FROM produtos where id = ?";

  private CategoriaDAO categoriaDAO;

  public ProdutoDAO() {
    categoriaDAO = new CategoriaDAO();
  }

  @Override
  public boolean salvar(Produto objeto) throws SQLException {
    try {
      PreparedStatement ps = DatabaseConnection.getInstance().getConnection()
          .prepareStatement(SQL_INSERT);
      ps.setString(1, objeto.getNome());
      ps.setDouble(2, objeto.getValor());
      ps.setLong(3, objeto.getCategoria().getId());
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
    try {
      PreparedStatement ps = DatabaseConnection.getInstance().getConnection()
          .prepareStatement(SQL_UPDATE);
      ps.setString(1, objeto.getNome());
      ps.setDouble(2, objeto.getValor());
      ps.setDouble(3, objeto.getCategoria().getId());
      ps.setDouble(4, id);
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
  public boolean excluir(Long id) throws SQLException {
    try {
      PreparedStatement ps = DatabaseConnection.getInstance().getConnection()
          .prepareStatement(SQL_DELETE);
      ps.setLong(1, id);
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
            rs.getDouble("valor"),
            categoriaDAO.getPorId(rs.getLong("categoria_id")));
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
    Produto produto = null;
    ResultSet rs;
    try {

      PreparedStatement ps = DatabaseConnection.getInstance().
          getConnection().prepareStatement(SQL_SELECT_BY_ID);
      ps.setLong(1, id);
      rs = ps.executeQuery();
      if (rs.next()) {
        produto = new Produto(
            rs.getLong("id"),
            rs.getString("nome"),
            rs.getDouble("valor"),
            categoriaDAO.getPorId(rs.getLong("categoria_id")));
      }

      DatabaseConnection.commit();
      return produto;
    } catch (SQLException ex) {
      DatabaseConnection.rollback();
      throw ex;
    } finally {
//      DatabaseConnection.fecharConexao();
    }
  }

}
