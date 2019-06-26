package br.edu.ifc.projeto.sistema.controller;

import br.edu.ifc.conexao.dao.UsuarioDAO;
import br.edu.ifc.conexao.model.Usuarios;
import br.edu.ifc.projeto.sistema.view.ProdutoGUI;
import br.edu.ifc.projeto.sistema.view.LoginGUI;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;

/**
 *
 * @author fabricio
 */
public class UsuarioController implements UsuarioListener {

  private List<Usuarios> lista = new ArrayList<>();
//  private UsuarioGUI tela;
  private UsuarioDAO dao;

  public UsuarioController(JInternalFrame tela) {
//    this.tela = (UsuarioGUI) tela;
    dao = new UsuarioDAO();
  }

  @Override
  public boolean salvar(Usuarios usuario) throws Exception {
    boolean salvou = false;
    // Se for produto novo
    if (usuario.getId() == null) {
      usuario.setId(Long.parseLong(String.valueOf(lista.size() + 1)));
      salvou = dao.salvar(usuario);
    } else {
      salvou = dao.atualizar(usuario, usuario.getId());
    }
    if (salvou) {
//      tela.limparTela();
//      tela.mostrarMensagem("Usuário Salvo com Sucesso!");
      carregar();
    }
    return salvou;

  }

  @Override
  public void carregar() {
    try {
      //Consulta
//      tela.montarTabela(dao.listarTodos());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean excluir(Usuarios produto) {
    try {
      boolean excluir = dao.excluir(produto.getId());

      if (excluir) {
//        tela.mostrarMensagem("Usuario Excluido com Sucesso!");
        carregar();
      }

      return excluir;
    } catch (Exception ex) {
      ex.printStackTrace();
//      tela.mostrarMensagem(ex.getMessage());
      return false;
    }
  }

}
