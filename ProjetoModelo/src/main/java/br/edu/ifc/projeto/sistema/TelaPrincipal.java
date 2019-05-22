package br.edu.ifc.projeto.sistema;

import br.edu.ifc.projeto.sistema.view.ProdutoGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class TelaPrincipal extends javax.swing.JFrame {

  public TelaPrincipal() {
    initComponents();
    super.setTitle("Principal");
    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Tela inteira
    super.setExtendedState(JFrame.MAXIMIZED_BOTH);

    postConstruct();
  }

  private void postConstruct() {
    ActionListener sairListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int resposta = JOptionPane.showOptionDialog(
            TelaPrincipal.this,
            "Deseja Sair?",
            "Tem Certeza?",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[]{"Sim", "Cancelar"},
            "Sim");
        if (resposta == 0) {
          System.exit(0);
        }
      }
    };
    mnSair.addActionListener(sairListener);
    btnSair.addActionListener(sairListener);

    mnProdutos.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ProdutoGUI tela = new ProdutoGUI();
        criarTela(tela);
      }
    });
  }

  private void criarTela(JInternalFrame tela) {
    boolean telaExistente = false;
    for (JInternalFrame frameNaTela : desktop.getAllFrames()) {
      if (tela.getName().equals(frameNaTela.getName())) {
        telaExistente = true;
        break;
      }
    }

    if (!telaExistente) {
      tela.setVisible(true);
      desktop.add(tela);
    }

  }

  public JTextPane getMensagens() {
    return mensagens;
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jMenu3 = new javax.swing.JMenu();
    jFileChooser1 = new javax.swing.JFileChooser();
    desktop = new javax.swing.JDesktopPane();
    jToolBar1 = new javax.swing.JToolBar();
    btnSair = new javax.swing.JButton();
    jButton1 = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    mensagens = new javax.swing.JTextPane();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    mnSair = new javax.swing.JMenuItem();
    jMenu2 = new javax.swing.JMenu();
    mnProdutos = new javax.swing.JMenuItem();
    jMenuItem1 = new javax.swing.JMenuItem();

    jMenu3.setText("jMenu3");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
    desktop.setLayout(desktopLayout);
    desktopLayout.setHorizontalGroup(
      desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
    );
    desktopLayout.setVerticalGroup(
      desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 218, Short.MAX_VALUE)
    );

    jToolBar1.setRollover(true);

    btnSair.setText("Sair");
    btnSair.setFocusable(false);
    btnSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jToolBar1.add(btnSair);

    jButton1.setText("Oi");
    jButton1.setFocusable(false);
    jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jToolBar1.add(jButton1);

    jScrollPane1.setViewportView(mensagens);

    jMenu1.setText("Arquivo");

    mnSair.setText("Sair");
    jMenu1.add(mnSair);

    jMenuBar1.add(jMenu1);

    jMenu2.setText("Cadastros");

    mnProdutos.setText("Produtos");
    jMenu2.add(mnProdutos);

    jMenuItem1.setText("Cliente");
    jMenu2.add(jMenuItem1);

    jMenuBar1.add(jMenu2);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(desktop)
      .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jScrollPane1)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(desktop)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnSair;
  private javax.swing.JDesktopPane desktop;
  private javax.swing.JButton jButton1;
  private javax.swing.JFileChooser jFileChooser1;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenu jMenu2;
  private javax.swing.JMenu jMenu3;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JToolBar jToolBar1;
  private javax.swing.JTextPane mensagens;
  private javax.swing.JMenuItem mnProdutos;
  private javax.swing.JMenuItem mnSair;
  // End of variables declaration//GEN-END:variables
}
