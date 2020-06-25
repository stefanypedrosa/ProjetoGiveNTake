package com.giventake.api.model;

public class Emprestante {
	private Integer codEmprestante;
	private String nomeEmprestante;
	private String contato;
	private String dataNasc;
	private String responsavel;
	private String alunoReferencia;
	
	public Emprestante(){
		
	}
	
	public void CadastraEmprestante(Emprestante emprestante) {
		this.codEmprestante = emprestante.codEmprestante;
		this.nomeEmprestante = emprestante.nomeEmprestante;
		this.contato = emprestante.contato;
		this.dataNasc = emprestante.dataNasc;
		this.responsavel = emprestante.responsavel;
		this.alunoReferencia = emprestante.alunoReferencia;
	}

	public Integer getCodEmprestante() {
		return codEmprestante;
	}

	public void setCodEmprestante(Integer codEmprestante) {
		this.codEmprestante = codEmprestante;
	}

	public String getNomeEmprestante() {
		return nomeEmprestante;
	}

	public void setNomeEmprestante(String nomeEmprestante) {
		this.nomeEmprestante = nomeEmprestante;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getAlunoReferencia() {
		return alunoReferencia;
	}

	public void setAlunoReferencia(String alunoReferencia) {
		this.alunoReferencia = alunoReferencia;
	}
	
}