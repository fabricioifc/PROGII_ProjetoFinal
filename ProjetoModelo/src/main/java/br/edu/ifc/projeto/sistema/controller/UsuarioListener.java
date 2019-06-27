package br.edu.ifc.projeto.sistema.controller;

import br.edu.ifc.conexao.model.Usuario;

public interface UsuarioListener {
    
  void carregar();
  boolean salvar(Usuario produto) throws Exception;
  boolean excluir(Usuario produto) throws Exception;
}
