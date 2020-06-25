package com.giventake.api.structure.list;

import com.giventake.api.model.Emprestimo;
import com.giventake.api.structure.node.NodeEmprestimo;
import com.giventake.api.structure.search.BuscaSeqEmprestimo;

public class ListEmprestimo {

	private NodeEmprestimo inicio;
	private BuscaSeqEmprestimo busca = new BuscaSeqEmprestimo();

	public ListEmprestimo() {
		this.inicio = null;
	}
	
	public int tamanhoLista() {
		NodeEmprestimo tmp;
		tmp = getInicio();
		int tamanho = 0;
		do {
			tamanho++;
			tmp = tmp.getProximo();
		} while(tmp != getInicio());
		return tamanho;
	}
	
	public NodeEmprestimo getInicio() {
		return inicio;
	}

	public boolean isEmpty() {
		return (this.getInicio() == null);
	}

	public void inserirFinal(Emprestimo elemento) {
		NodeEmprestimo novo = new NodeEmprestimo();
		novo.setElemento(elemento);

		if(isEmpty()) {
			novo.setProximo(novo);
			novo.setAnterior(novo);
			inicio = novo;
		}
		else {
			NodeEmprestimo tmp = getInicio();
			while (tmp.getProximo() != getInicio()) {
				tmp = tmp.getProximo();
			}
			getInicio().setAnterior(novo);
			tmp.setProximo(novo);
			novo.setAnterior(tmp);
			novo.setProximo(getInicio());
		}
	}

	public NodeEmprestimo buscarPosicao(int codigo) {
		return busca.BuscaEmprestimo(getInicio(), codigo);
	}
	
	public Emprestimo consultarEmprestimo(int codigo) {
		NodeEmprestimo resultado = buscarPosicao(codigo);
		return resultado.getElemento();
	}

	public void removerFinal() {
		if(isEmpty()) {
			throw new RuntimeException("Lista Vazia!");
		}
		else {
			NodeEmprestimo tmp = getInicio();
			NodeEmprestimo ultimo = getInicio();
			while (tmp.getProximo() != getInicio()) {
				tmp = tmp.getProximo();
				ultimo = tmp.getAnterior();
			}

			getInicio().setAnterior(ultimo);
			ultimo.setProximo(getInicio());

		}
	}

	public void removerInicio() {
		if(isEmpty()) {
			throw new RuntimeException("Lista Vazia!");
		}
		else {
			NodeEmprestimo tmp = getInicio();
			NodeEmprestimo novoInicio = tmp.getProximo();
			novoInicio.setAnterior(tmp.getAnterior());
			while (tmp.getProximo() != getInicio()) {
				tmp = tmp.getProximo();
			}
			tmp.setProximo(novoInicio);
			inicio = novoInicio;
		}
	}


	
	public String consultarEmprestimos() {
		String listaEmprestimos = "[";
		NodeEmprestimo tmp;
		tmp = getInicio();
		do {
			listaEmprestimos+="{\"codEmprestimo\":" + tmp.getElemento().getCodEmprestimo()
				+ ",\"codLivro\":" + "{\"codLivro\":" + tmp.getElemento().getCodLivro().getCodLivro() + "}"
				+ ",\"codEmprestante\":" + "{\"codLivro\":" + tmp.getElemento().getCodEmprestante().getCodEmprestante() + "}"
				+ ",\"dataDevolucao\":\"" + tmp.getElemento().getDataDevolucao()
				+ "\",\"responsavel\":\"" + tmp.getElemento().getResponsavel()
				+ "\"},";
			tmp = tmp.getProximo();
		} while(tmp != getInicio());
		listaEmprestimos = listaEmprestimos.substring(0, listaEmprestimos.length()-1);
		listaEmprestimos+="]";
		return listaEmprestimos;
	}

}