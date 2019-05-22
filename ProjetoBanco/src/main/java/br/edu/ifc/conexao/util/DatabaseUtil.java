package br.edu.ifc.conexao.util;

import br.edu.ifc.conexao.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUtil {

//    private static boolean verificarDatabaseExiste() throws SQLException {
//        Connection conn = DatabaseConnection.getInstance().getConnection();
//        String sql = "SELECT 1 from pg_database WHERE datname=?";
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setString(1, DatabaseConnection.DATABASE_NOME);
//        ResultSet rs = ps.executeQuery();
//
//        if (rs.next() && rs.getBoolean(1)) {
//            return true;
//        }
//        return false;
//    }
//    private static void criarDatabase() throws SQLException {
//        Connection conn = DatabaseConnection.getInstance().getConnection();
//        String sql = "CREATE DATABASE " + DatabaseConnection.DATABASE_NOME;
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.executeUpdate();
//    }
    private static void criarTabelas() throws SQLException {
        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            String sql = ArquivoUtil.getDump();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            
            DatabaseConnection.commit();
        } catch (SQLException ex) {
            DatabaseConnection.rollback();
            throw ex;
        } finally {
            DatabaseConnection.fecharConexao();
        }
    }

    public static void main(String[] args) throws Exception {
        criarTabelas();
        System.out.println("DUMP CARREGADO na base " + DatabaseConnection.DATABASE_NOME + "!");
    }
}
