package br.edu.ifc.projeto.sistema.util;

import br.edu.ifc.conexao.model.Categoria;
import br.edu.ifc.conexao.model.Produto;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class ProdutoTabela extends AbstractTableModel {

  private String colunas[] = {"#", "Nome", "Valor", "Categoria", "objeto"};
  private List<?> lista;

  private final int COLUNA_ID = 0;
  private final int COLUNA_NOME = 1;
  private final int COLUNA_VALOR = 2;
  private final int COLUNA_CATEGORIA = 3;
  private final int COLUNA_OBJETO = 4;

  public ProdutoTabela(List<?> lista) {
    this.lista = lista;
  }

  @Override
  public int getRowCount() {
    return this.lista.size();
  }

  @Override
  public int getColumnCount() {
    return colunas.length;
  }

  @Override
  public String getColumnName(int indice) {
    return colunas[indice];
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    switch (columnIndex) {
      case COLUNA_ID:
        return Long.class;
      case COLUNA_NOME:
        return String.class;
      case COLUNA_CATEGORIA:
        return Categoria.class;
      case COLUNA_VALOR:
        return Double.class;
      default:
        return Object.class;
    }
  }

  @Override
  public Object getValueAt(int linha, int coluna) {
    Produto produto = (Produto) this.lista.get(linha);

    switch (coluna) {
      case COLUNA_ID:
        return produto.getId();
      case COLUNA_NOME:
        return produto.getNome();
      case COLUNA_VALOR:
        return produto.getValor();
      case COLUNA_CATEGORIA:
        return produto.getCategoria();
      case COLUNA_OBJETO:
        return produto;
    }
    return null;
  }

  @Override
  public void setValueAt(Object valor, int linha, int coluna) {
    Produto aluno = (Produto) this.lista.get(linha);

    switch (coluna) {
      case COLUNA_ID:
        aluno.setId(Long.parseLong(valor.toString()));
        break;
      case COLUNA_NOME:
        aluno.setNome(String.valueOf(valor));
        break;
      case COLUNA_VALOR:
        aluno.setValor(Double.parseDouble(valor.toString()));
        break;
      case COLUNA_CATEGORIA:
        aluno.setCategoria((Categoria) valor);
        break;
      case COLUNA_OBJETO:
        aluno = (Produto) valor;
        break;
    }
    fireTableDataChanged();
  }

  public void escondeColunaObjeto(JTable tabela) {
    int ultimaColuna = tabela.getColumnCount() - 1;
    TableColumn coluna = tabela.getColumnModel().getColumn(ultimaColuna);
    tabela.getColumnModel().removeColumn(coluna);
  }

  public void removerLinha(int linha) {
    lista.remove(linha);
    fireTableDataChanged();
  }

  public void removerLinhas() {
    lista.clear();
    fireTableDataChanged();
  }

  public void setTamanhoColuna(JTable tabela, int coluna, int tamanho) {
    TableColumnModel columnModel = tabela.getColumnModel();
    columnModel.getColumn(coluna).setMaxWidth(tamanho);
  }
}
