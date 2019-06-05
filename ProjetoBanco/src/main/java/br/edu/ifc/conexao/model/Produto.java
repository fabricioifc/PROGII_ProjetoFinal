package br.edu.ifc.conexao.model;

public class Produto {

  private Long id;
  private String nome;
  private Double valor;
  private Categoria categoria;

  public Produto() {
  }

  public Produto(Long id, String nome, Double valor, Categoria categoria) {
    this.id = id;
    this.nome = nome;
    this.valor = valor;
    this.categoria = categoria;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
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

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

}
