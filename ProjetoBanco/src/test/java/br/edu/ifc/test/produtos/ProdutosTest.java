package br.edu.ifc.test.produtos;

import br.edu.ifc.conexao.dao.ProdutoDAO;
import br.edu.ifc.conexao.model.Produto;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author fabricio
 */
public class ProdutosTest {

    private ProdutoDAO dao;

    public ProdutosTest() {
        dao = new ProdutoDAO();
    }

    @Test
    public void consultandoProdutos() {
//        Produto p1 = new Produto(null, "Macarrão", 4.50);

        try {
            List<Produto> lista = dao.listarTodos();

            for (Produto p : lista) {
                System.out.println(p.getNome());
            }
            assertNotNull(lista);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
