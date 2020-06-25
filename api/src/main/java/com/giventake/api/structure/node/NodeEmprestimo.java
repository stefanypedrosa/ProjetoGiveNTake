package com.giventake.api.structure.node;

import com.giventake.api.model.Emprestimo;

public class NodeEmprestimo {
	private Emprestimo elemento;
	private NodeEmprestimo anterior;
	private NodeEmprestimo proximo;

	public void setElemento(Emprestimo elemento) {
		this.elemento = elemento;
	}

	public void setAnterior(NodeEmprestimo anterior) {
		this.anterior = anterior;
	}

	public void setProximo(NodeEmprestimo proximo) {
		this.proximo = proximo;
	}

	public Emprestimo getElemento() {
		return this.elemento;
	}

	public NodeEmprestimo getAnterior() {
		return this.anterior;
	}

	public NodeEmprestimo getProximo() {
		return this.proximo;
	}
}

