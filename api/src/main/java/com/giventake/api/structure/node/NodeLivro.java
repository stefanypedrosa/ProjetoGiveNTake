package com.giventake.api.structure.node;

import com.giventake.api.model.Livro;

public class NodeLivro {
	private Livro elemento;
	private NodeLivro anterior;
	private NodeLivro proximo;

	public void setElemento(Livro elemento) {
		this.elemento = new Livro(elemento);
	}

	public void setAnterior(NodeLivro anterior) {
		this.anterior = anterior;
	}

	public void setProximo(NodeLivro proximo) {
		this.proximo = proximo;
	}

	public Livro getElemento() {
		return this.elemento;
	}

	public NodeLivro getAnterior() {
		return this.anterior;
	}

	public NodeLivro getProximo() {
		return this.proximo;
	}
}

