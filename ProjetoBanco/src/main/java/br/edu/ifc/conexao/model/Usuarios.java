package br.edu.ifc.conexao.model;

public class Usuarios {

  private Long id;
  private String nome;
  private String usuario;
  private String senha;
  private Boolean status;

  public Usuarios() {
  }

  public Usuarios(Long id, String nome, String usuario, String senha, Boolean status) {
    this.id = id;
    this.nome = nome;
    this.usuario = usuario;
    this.senha = senha;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

}
