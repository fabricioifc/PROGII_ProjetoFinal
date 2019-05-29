package br.edu.ifc.conexao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

  private static DatabaseConnection instance;
  private Connection connection;

  private final String url = "jdbc:postgresql://localhost:5432/";
  public static final String DATABASE_NOME = "produtosdb";
  private static final String USUARIO = "postgres";
  private static final String SENHA = "postgres";

  private DatabaseConnection() throws SQLException {
    try {
      Class.forName("org.postgresql.Driver");
      this.connection = DriverManager.getConnection(url + DATABASE_NOME, USUARIO, SENHA);
      this.connection.setAutoCommit(false);
    } catch (ClassNotFoundException ex) {
      System.out.println("Erro na Conexão: " + ex.getMessage());
    }
  }

  public static DatabaseConnection getInstance() throws SQLException {
    if (instance == null) {
      instance = new DatabaseConnection();
    } else if (instance.getConnection().isClosed()) {
      instance = new DatabaseConnection();
    }

    return instance;
  }

  public Connection getConnection() {
    return connection;
  }

  public static void fecharConexao() throws SQLException {
    if (instance != null && instance.getConnection() != null) {
      instance.getConnection().close();
    }
  }

  public static void commit() throws SQLException {
    if (instance != null && instance.getConnection() != null) {
      instance.getConnection().commit();
    }
  }

  public static void rollback() throws SQLException {
    if (instance != null && instance.getConnection() != null) {
      instance.getConnection().rollback();
    }
  }

}
