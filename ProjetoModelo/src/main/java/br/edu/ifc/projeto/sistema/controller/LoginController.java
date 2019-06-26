package br.edu.ifc.projeto.sistema.controller;

import br.edu.ifc.conexao.dao.UsuarioDAO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author fabricio
 */
public class LoginController {

  private UsuarioDAO dao;

  public LoginController() {
    dao = new UsuarioDAO();
  }

  public boolean validarUsuario(String usuario, String senha) throws Exception {
    String senhaCriptografada = criptografarSenha(senha);
    return dao.validarUsuario(usuario, senhaCriptografada);
  }

  private String criptografarSenha(String senha) throws Exception {
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(senha.getBytes());

    byte[] digest = md.digest();
    String senhaCriptografada = DatatypeConverter
        .printHexBinary(digest).toUpperCase();

    return senhaCriptografada;
  }

}
