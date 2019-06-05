package br.edu.ifc.conexao.model;

public class Categoria {

  private Long id;
  private String nome;
  private Boolean ativo;

  public Categoria() {
  }

  public Categoria(Long id, String nome, Boolean ativo) {
    this.id = id;
    this.nome = nome;
    this.ativo = ativo;
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

  public Boolean getAtivo() {
    return ativo;
  }

  public void setAtivo(Boolean ativo) {
    this.ativo = ativo;
  }

  @Override
  public String toString() {
    return this.id + " - " + this.nome;
  }

}
