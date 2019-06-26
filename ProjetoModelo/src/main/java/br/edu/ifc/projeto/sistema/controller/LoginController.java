package br.edu.ifc.projeto.sistema.controller;

import br.edu.ifc.conexao.dao.UsuarioDAO;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author fabricio
 */
public class LoginController {

  private /*Classe UsuarioDAO AQUI*/ dao ;

  public LoginController() {
    dao = new /*Classe UsuarioDAO AQUI*/;
  }

  public boolean validarUsuario(String usuario, String senha) throws Exception {
    // Implementar
  }

  /**
   * Método que gera o HASH MD5 de um texto/palavra
   *
   * @param senha
   * @return
   * @throws Exception
   */
  private String criptografarSenha(String senha) throws Exception {
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(senha.getBytes());

    byte[] digest = md.digest();
    String senhaCriptografada = DatatypeConverter
        .printHexBinary(digest).toUpperCase();

    return senhaCriptografada;
  }

}
