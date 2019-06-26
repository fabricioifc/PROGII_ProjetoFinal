package br.edu.ifc.projeto.sistema.view;

import br.edu.ifc.projeto.sistema.PrincipalUtil;
import br.edu.ifc.projeto.sistema.controller.LoginController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginGUI extends javax.swing.JFrame {

  LoginController controller;

  public LoginGUI() {
    initComponents();
    this.setLocationRelativeTo(null); //Centralizar a tela
    controller = new LoginController();

    btnLogin.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          String usuario = txtUsuario.getText();
          String senha = new String(txtSenha.getPassword());

          if (usuario.equals("") || senha.equals("")) {
            JOptionPane.showMessageDialog(LoginGUI.this, "Informe usuário e senha!",
                "Aviso",
                JOptionPane.WARNING_MESSAGE);
            return;
          }

          Boolean valido = controller.validarUsuario(usuario, senha);
          if (valido) {
            LoginGUI.this.dispose();
            PrincipalUtil.getInstance().iniciarSistema();
          } else {
            JOptionPane.showMessageDialog(LoginGUI.this, "Usuário e/ou senha inválido!", "", JOptionPane.WARNING_MESSAGE, null);
          }
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(LoginGUI.this, ex.getMessage());
        }
      }
    });
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    txtUsuario = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    btnLogin = new javax.swing.JButton();
    txtSenha = new javax.swing.JPasswordField();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));

    jLabel1.setText("Usuário:");

    txtUsuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

    jLabel2.setText("Senha:");

    btnLogin.setText("Login");

    txtSenha.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(txtSenha)
          .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGap(178, 178, 178)
            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel1)
              .addComponent(jLabel2))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnLogin;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPasswordField txtSenha;
  private javax.swing.JTextField txtUsuario;
  // End of variables declaration//GEN-END:variables
}
