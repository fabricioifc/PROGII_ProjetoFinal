package br.edu.ifc.conexao.dao;

import br.edu.ifc.conexao.db.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

  private final String SQL_VALIDAR_USUARIO
      = "SELECT * FROM usuarios "
      + "WHERE usuario = ? AND upper(senha) = ? and status is true";

  public boolean validarUsuario(String usuario, String senha) throws Exception {
    try {
      //implementar
      ResultSet rs = null;
      PreparedStatement ps = null;
      boolean resultado = false;

      //Preparando o comando
      ps = DatabaseConnection.
          getInstance().
          getConnection().prepareStatement(SQL_VALIDAR_USUARIO);
      ps.setString(1, usuario);
      ps.setString(2, senha);

      rs = ps.executeQuery(); //Retorno do banco de dados

      // Se existir, então é usuário válido
      resultado = rs.next();
      return resultado;

    } catch (SQLException ex) {
      DatabaseConnection.rollback();
      throw ex;
    } finally {
      DatabaseConnection.fecharConexao();
    }
  }

}
