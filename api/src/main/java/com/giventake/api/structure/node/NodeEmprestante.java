package com.giventake.api.structure.node;

import com.giventake.api.model.Emprestante;

public class NodeEmprestante {
	private Emprestante elemento;
	private NodeEmprestante anterior;
	private NodeEmprestante proximo;

	public void setElemento(Emprestante elemento) {
		this.elemento = elemento;
	}

	public void setAnterior(NodeEmprestante anterior) {
		this.anterior = anterior;
	}

	public void setProximo(NodeEmprestante proximo) {
		this.proximo = proximo;
	}

	public Emprestante getElemento() {
		return this.elemento;
	}

	public NodeEmprestante getAnterior() {
		return this.anterior;
	}

	public NodeEmprestante getProximo() {
		return this.proximo;
	}
}

