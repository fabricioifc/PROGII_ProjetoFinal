package br.edu.ifc.projeto.sistema.controller;

import br.edu.ifc.conexao.model.Produto;

public interface ProdutoListener {
    
  void carregar();
  boolean salvar(Produto produto) throws Exception;
  boolean excluir(Produto produto) throws Exception;
}
