package br.edu.ifc.projeto.sistema.relatorios;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.sf.jasperreports.engine.JRParameter;

/**
 *
 * @author fabricio
 */
public class RelatorioModel {

  private String caminhoParaRelatorio;
  private String nomeRelatorio;
  private final String logo = "src/main/resources/imagens/logo.png";
  private String usuario = "Seu nome Aqui";
  private Map<String, Object> parametros;

  public RelatorioModel(String caminhoParaRelatorio, String nomeRelatorio) throws Exception {
    this.caminhoParaRelatorio = caminhoParaRelatorio;
    this.nomeRelatorio = nomeRelatorio;

    parametros = new HashMap<>();
    parametros.put("usuario", usuario);
    parametros.put("logo", new FileInputStream(logo));
    parametros.put(JRParameter.REPORT_LOCALE, new Locale("pt", "BR"));
  }

  public String getLogo() {
    return logo;
  }

  public Map<String, Object> getParametros() {
    return parametros;
  }

  public String getCaminhoParaRelatorio() {
    return caminhoParaRelatorio;
  }

  public void setCaminhoParaRelatorio(String caminhoParaRelatorio) {
    this.caminhoParaRelatorio = caminhoParaRelatorio;
  }

  public String getNomeRelatorio() {
    return nomeRelatorio;
  }

  public void setNomeRelatorio(String nomeRelatorio) {
    this.nomeRelatorio = nomeRelatorio;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

}
