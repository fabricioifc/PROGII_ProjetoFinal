package br.edu.ifc.projeto.sistema;

import br.edu.ifc.projeto.sistema.view.LoginGUI;

public class Main {

  public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
//        PrincipalUtil.getInstance().iniciarSistema();

        LoginGUI loginGUI = new LoginGUI();
        loginGUI.setVisible(true);
      }
    });

  }

}
