package br.edu.ifc.conexao.dao;

import br.edu.ifc.conexao.db.DatabaseConnection;
import br.edu.ifc.conexao.model.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsuarioDAO implements GenericDAO<Usuarios, Long> {

  private final String SQL_INSERT = "INSERT INTO usuarios (nome, usuario, senha, status) values (?,?,?,?)";
  private final String SQL_UPDATE = "UPDATE usuarios set nome = ?, usuarios = ?, senha = ?, status = ? where id = ?";
  private final String SQL_DELETE = "DELETE FROM usuarios where id = ?";
  private final String SQL_SELECT = "SELECT * FROM usuarios";
  private final String SQL_SELECT_BY_ID = "SELECT * FROM usuarios where id = ?";
  private final String SQL_VALIDAR_USUARIO = "SELECT * FROM usuarios where usuario = ? and senha = ?";

  public Boolean validarUsuario(String usuario, String senha) throws SQLException {
    try {
      ResultSet rs = null;
      PreparedStatement ps = null;

      ps = DatabaseConnection.getInstance().getConnection().prepareStatement(SQL_VALIDAR_USUARIO);
      ps.setString(1, usuario);
      ps.setString(2, senha);
      rs = ps.executeQuery();

      if (rs.next()) {
        return true;
      }
      return false;
    } catch (SQLException ex) {
      DatabaseConnection.rollback();
      return false;
    } finally {
      DatabaseConnection.fecharConexao();
    }
  }

  @Override
  public boolean salvar(Usuarios objeto) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean atualizar(Usuarios objeto, Long id) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean excluir(Long id) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Usuarios> listarTodos() throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Usuarios getPorId(Long id) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
