package br.edu.ifc.projeto.sistema.controller;

import br.edu.ifc.conexao.dao.CategoriaDAO;
import br.edu.ifc.conexao.dao.ProdutoDAO;
import br.edu.ifc.conexao.model.Produto;
import br.edu.ifc.projeto.sistema.view.ProdutoGUI;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;

/**
 *
 * @author fabricio
 */
public class ProdutoController implements ProdutoListener {

  private List<Produto> lista = new ArrayList<>();
  private ProdutoGUI tela;
  private ProdutoDAO dao;
  private CategoriaDAO categoriaDAO;

  public ProdutoController(JInternalFrame tela) {
    this.tela = (ProdutoGUI) tela;
    dao = new ProdutoDAO();
    categoriaDAO = new CategoriaDAO();
  }

  @Override
  public boolean salvar(Produto produto) throws Exception {
    boolean salvou = false;
    // Se for produto novo
    if (produto.getId() == null) {
      produto.setId(Long.parseLong(String.valueOf(lista.size() + 1)));
      salvou = dao.salvar(produto);
    } else {
      salvou = dao.atualizar(produto, produto.getId());
    }
    if (salvou) {
      tela.limparTela();
      tela.mostrarMensagem("Produto Salvo com Sucesso!");
      carregar();
    }
    return salvou;

  }

  @Override
  public void carregar() {
    try {
      //Consulta
      tela.montarTabela(dao.listarTodos());
      tela.montarComboCategorias(categoriaDAO.listarTodos());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean excluir(Produto produto) {
    try {
//        boolean excluir = lista.remove(produto);
      boolean excluir = dao.excluir(produto.getId());

      if (excluir) {
        tela.mostrarMensagem("Produto Excluido com Sucesso!");
        carregar();
      }

      return excluir;
    } catch (Exception ex) {
      ex.printStackTrace();
      tela.mostrarMensagem(ex.getMessage());
      return false;
    }
  }

}
