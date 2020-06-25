package com.giventake.api.model;

public class Emprestimo {
	private int codEmprestimo;
	private Livro codLivro;
	private Emprestante codEmprestante;
	private String dataDevolucao;
	private String responsavel;
	
	public int getCodEmprestimo() {
		return codEmprestimo;
	}
	public void setCodEmprestimo(int codEmprestimo) {
		this.codEmprestimo = codEmprestimo;
	}
	public Livro getCodLivro() {
		return codLivro;
	}
	public void setCodLivro(Livro codLivro) {
		this.codLivro = codLivro;
	}
	public Emprestante getCodEmprestante() {
		return codEmprestante;
	}
	public void setCodEmprestante(Emprestante codEmprestante) {
		this.codEmprestante = codEmprestante;
	}
	public String getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	

}
