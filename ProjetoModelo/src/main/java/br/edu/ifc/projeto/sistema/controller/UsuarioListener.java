package br.edu.ifc.projeto.sistema.controller;

import br.edu.ifc.conexao.model.Usuarios;

public interface UsuarioListener {
    
  void carregar();
  boolean salvar(Usuarios produto) throws Exception;
  boolean excluir(Usuarios produto) throws Exception;
}
