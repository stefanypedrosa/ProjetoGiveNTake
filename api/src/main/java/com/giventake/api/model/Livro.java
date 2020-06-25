package com.giventake.api.model;

public class Livro {
	private Integer codLivro;
	private String titulo;
	private String autor;
	private String genero;
	private String dataAquisicao;
	private String status;
	
	public Livro() {
		
	}
	
	public Livro(Livro elemento) {
		this.codLivro = elemento.codLivro;
		this.titulo = elemento.titulo;
		this.autor = elemento.autor;
		this.genero = elemento.genero;
		this.dataAquisicao = elemento.dataAquisicao;
		this.status = "Disponível";
	}
	
	public Livro(String titulo, String autor, String genero, String dataAquisicao) {
		this.codLivro += 1;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.dataAquisicao = dataAquisicao;
		this.status = "Disponível";
	}
	
	public Integer getCodLivro() {
		return codLivro;
	}
	public void setCodLivro(Integer codLivro) {
		this.codLivro = codLivro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDataAquisicao() {
		return dataAquisicao;
	}
	public void setDataAquisicao(String dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
