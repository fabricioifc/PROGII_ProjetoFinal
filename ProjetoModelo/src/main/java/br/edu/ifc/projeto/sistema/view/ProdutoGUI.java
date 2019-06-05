package br.edu.ifc.projeto.sistema.view;

import br.edu.ifc.conexao.model.Categoria;
import br.edu.ifc.conexao.model.Produto;
import br.edu.ifc.projeto.sistema.util.ProdutoTabela;
import br.edu.ifc.projeto.sistema.PrincipalUtil;
import br.edu.ifc.projeto.sistema.controller.ProdutoController;
import br.edu.ifc.projeto.sistema.relatorios.RelatorioModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ProdutoGUI extends javax.swing.JInternalFrame {

  private Produto produto;
  private ProdutoController controller;

  public ProdutoGUI() {
    initComponents();
    super.setName("Produtos");
    super.setClosable(true);
    super.setMaximizable(true);

    controller = new ProdutoController(this);
    controller.carregar();
    postContruct();
  }

  public final void postContruct() {
    limparTela();

    // Ação do botão Salvar
    btnSalvar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          produto.setNome(txtNome.getText());
          produto.setValor(Double.parseDouble(txtValor.getText()));
          produto.setCategoria((Categoria) cbCategoria.getSelectedItem());

          controller.salvar(produto);
        } catch (NumberFormatException ex) {
          PrincipalUtil.getInstance().getPrincipal()
              .getMensagens().setText("Não é um número válido");
          JOptionPane.showMessageDialog(ProdutoGUI.this, "Não é um número válido!", "Erro ao Salvar", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(ProdutoGUI.this, "Ocorreu um erro ao salvar o produto!", "Erro ao Salvar", JOptionPane.ERROR_MESSAGE);
          mostrarMensagem(ex.getMessage());
        }
      }
    });
    btnGerarRelatorio.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          RelatorioModel relatorio = new RelatorioModel("src/main/resources/relatorios/produtos.jrxml", "Produtos");
          PrincipalUtil.getInstance().getRelUtil().criarRelatorio(relatorio);
        } catch (Exception ex) {
          ex.printStackTrace();
          mostrarMensagem(ex.getMessage());
        }

      }
    });
  }

  public void mostrarMensagem(String mensagem) {
    PrincipalUtil.getInstance().
        getPrincipal().getMensagens().setText(mensagem);
  }

  public void limparTela() {
    produto = new Produto();
    txtNome.setText("");
    txtValor.setText("");
    txtNome.grabFocus();
    mostrarMensagem(null);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    txtNome = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    txtValor = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    cbCategoria = new javax.swing.JComboBox<>();
    jToolBar1 = new javax.swing.JToolBar();
    btnSalvar = new javax.swing.JButton();
    btnGerarRelatorio = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    tabela = new javax.swing.JTable();

    jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    jLabel1.setText("Nome: ");

    jLabel2.setText("Valor:");

    jLabel3.setText("Categoria:");

    cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
          .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2)
          .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(24, Short.MAX_VALUE))
    );

    jToolBar1.setRollover(true);

    btnSalvar.setText("Salvar");
    btnSalvar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSalvarActionPerformed(evt);
      }
    });
    jToolBar1.add(btnSalvar);

    btnGerarRelatorio.setText("Gerar Relatório");
    btnGerarRelatorio.setFocusable(false);
    btnGerarRelatorio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnGerarRelatorio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jToolBar1.add(btnGerarRelatorio);

    tabela.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String [] {
        "Title 1", "Title 2", "Title 3", "Title 4"
      }
    ));
    tabela.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tabelaMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(tabela);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jScrollPane1))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
      if (tabela.getSelectedRow() >= 0) {
        if (evt.getClickCount() == 2) {
          int linha = tabela.convertRowIndexToModel(tabela.getSelectedRow());
          int coluna = 4;

          produto = (Produto) tabela.getModel().getValueAt(linha, coluna);
          txtNome.setText(produto.getNome());
          txtValor.setText(produto.getValor().toString());
          cbCategoria.getModel().setSelectedItem(produto.getCategoria());
        }
      }
    }//GEN-LAST:event_tabelaMouseClicked


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnGerarRelatorio;
  private javax.swing.JButton btnSalvar;
  private javax.swing.JComboBox<String> cbCategoria;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JToolBar jToolBar1;
  private javax.swing.JTable tabela;
  private javax.swing.JTextField txtNome;
  private javax.swing.JTextField txtValor;
  // End of variables declaration//GEN-END:variables

  public void montarTabela(List<?> dados) {
    ProdutoTabela model = new ProdutoTabela(dados);
    tabela.setModel(model);

    //Ajustar o tamanho das colunas
    model.setTamanhoColuna(tabela, 0, 50);
    model.setTamanhoColuna(tabela, 2, 100);
    // Esconder a última coluna
    model.escondeColunaObjeto(tabela);

    tabela.addKeyListener(new KeyAdapter() {

      @Override
      public void keyReleased(KeyEvent e) {
        if (tabela.getSelectedRow() >= 0) {

          if (e.getKeyCode() == KeyEvent.VK_DELETE) {
            int linha = tabela.convertRowIndexToModel(tabela.getSelectedRow());
            int coluna = 4;

            produto = (Produto) tabela.getModel().getValueAt(linha, coluna);

            System.out.println(produto);
            controller.excluir(produto);
          }
        }
      }
    });
  }

  public void montarComboCategorias(List<Categoria> listarTodos) {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel(listarTodos.toArray());
    cbCategoria.setModel(modelo);
  }
}
