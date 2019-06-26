package br.edu.ifc.projeto.sistema;

import br.edu.ifc.projeto.sistema.relatorios.RelatorioUtil;
import br.edu.ifc.projeto.sistema.view.LoginGUI;

public class PrincipalUtil {

  private static PrincipalUtil utilitario;
  private TelaPrincipal principal;
  private LoginGUI loginGUI;

  private RelatorioUtil relUtil;

  public PrincipalUtil() {
  }

  public static PrincipalUtil getInstance() {
    if (utilitario == null) {
      utilitario = new PrincipalUtil();
    }

    return utilitario;
  }

  public void iniciarTelaLogin() {
    try {
      this.loginGUI = new LoginGUI();
      this.loginGUI.setVisible(true);
      this.loginGUI.setEnabled(true);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }

  public void iniciarSistema() {
    try {
      if (this.principal == null) {
        this.principal = new TelaPrincipal();
      }
      //Iniciar a fila ao iniciar o sistema
      if (relUtil == null) {
        relUtil = new RelatorioUtil();
        relUtil.iniciarFilaRelatorios();
      }

      this.principal.setVisible(true);
      this.principal.setEnabled(true);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public TelaPrincipal getPrincipal() {
    return principal;
  }

  public RelatorioUtil getRelUtil() {
    return relUtil;
  }

}
