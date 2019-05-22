package br.edu.ifc.projeto.sistema.controller;

import br.edu.ifc.conexao.dao.ProdutoDAO;
import br.edu.ifc.conexao.model.Produto;
import br.edu.ifc.projeto.sistema.view.ProdutoGUI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import javax.swing.JInternalFrame;

/**
 *
 * @author fabricio
 */
public class ProdutoController implements ProdutoListener {

    private List<Produto> lista = new ArrayList<>();
    private ProdutoGUI tela;
    private ProdutoDAO dao;

    public ProdutoController(JInternalFrame tela) {
        this.tela = (ProdutoGUI) tela;
        dao = new ProdutoDAO();

//        lista.add(new Produto(1L, "Macarrão", 5.50));
    }

    @Override
    public boolean salvar(Produto produto) throws Exception {
        boolean salvou = false;
        // Se for produto novo
        if (produto.getId() == null) {
            produto.setId(Long.parseLong(String.valueOf(lista.size() + 1)));
//            salvou = lista.add(produto);
            salvou = dao.salvar(produto);
        } else {
            // senão, se for uma alteração
            //Remove da lista
//            lista.removeIf(new Predicate<Produto>() {
//                @Override
//                public boolean test(Produto t) {
//                    return t.getId().equals(produto.getId());
//                }
//            });
            // Adiciona na lista
//            salvou = lista.add(produto);
            salvou = dao.atualizar(produto);
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
//            tela.montarTabela(lista);
            tela.montarTabela(dao.listarTodos());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean excluir(Produto produto) {
        try {
//        boolean excluir = lista.remove(produto);
            boolean excluir = dao.excluir(produto);

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
