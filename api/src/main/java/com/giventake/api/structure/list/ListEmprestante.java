package com.giventake.api.structure.list;

import com.giventake.api.model.Emprestante;
import com.giventake.api.structure.node.NodeEmprestante;
import com.giventake.api.structure.search.BuscaSeqEmprestante;

public class ListEmprestante {

	private NodeEmprestante inicio;
	private BuscaSeqEmprestante busca = new BuscaSeqEmprestante();

	public ListEmprestante() {
		this.inicio = null;
	}
	
	public int tamanhoLista() {
		NodeEmprestante tmp;
		tmp = getInicio();
		int tamanho = 0;
		do {
			tamanho++;
			tmp = tmp.getProximo();
		} while(tmp != getInicio());
		return tamanho;
	}
	
	public NodeEmprestante getInicio() {
		return inicio;
	}

	public boolean isEmpty() {
		return (this.getInicio() == null);
	}

	public void inserirFinal(Emprestante elemento) {
		NodeEmprestante novo = new NodeEmprestante();
		novo.setElemento(elemento);

		if(isEmpty()) {
			novo.setProximo(novo);
			novo.setAnterior(novo);
			inicio = novo;
		}
		else {
			NodeEmprestante tmp = getInicio();
			while (tmp.getProximo() != getInicio()) {
				tmp = tmp.getProximo();
			}
			getInicio().setAnterior(novo);
			tmp.setProximo(novo);
			novo.setAnterior(tmp);
			novo.setProximo(getInicio());
		}
	}

	public NodeEmprestante buscarPosicao(int codigo) {
		return busca.BuscaEmprestante(getInicio(), codigo);
	}
	
	public Emprestante consultarEmprestante(int codigo) {
		NodeEmprestante resultado = buscarPosicao(codigo);
		return resultado.getElemento();
	}

//	public void emprestarLivro(int codigo) {
//		NodeLivro resultado = buscarPosicao(codigo);
//		resultado.getElemento().setStatus("Emprestado");
//	}
//	
//	public void devolverLivro(int codigo) {
//		NodeLivro resultado = buscarPosicao(codigo);
//		resultado.getElemento().setStatus("Disponível");
//	}

	public void removerFinal() {
		if(isEmpty()) {
			throw new RuntimeException("Lista Vazia!");
		}
		else {
			NodeEmprestante tmp = getInicio();
			NodeEmprestante ultimo = getInicio();
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
			NodeEmprestante tmp = getInicio();
			NodeEmprestante novoInicio = tmp.getProximo();
			novoInicio.setAnterior(tmp.getAnterior());
			while (tmp.getProximo() != getInicio()) {
				tmp = tmp.getProximo();
			}
			tmp.setProximo(novoInicio);
			inicio = novoInicio;
		}
	}


	
	public String consultarEmprestantes() {
		String listaEmprestantes = "[";
		NodeEmprestante tmp;
		tmp = getInicio();
		do {
			listaEmprestantes+="{\"codEmprestante\":" + tmp.getElemento().getCodEmprestante() 
				+ ",\"nomeEmprestante\":\"" + tmp.getElemento().getNomeEmprestante()
				+ "\",\"contato\":\"" + tmp.getElemento().getContato()
				+ "\",\"dataNasc\":\"" + tmp.getElemento().getDataNasc()
				+ "\",\"responsavel\":\"" + tmp.getElemento().getResponsavel()
				+ "\",\"alunoReferencia\":\"" + tmp.getElemento().getAlunoReferencia()+ "\"},";
			tmp = tmp.getProximo();
		} while(tmp != getInicio());
		listaEmprestantes = listaEmprestantes.substring(0, listaEmprestantes.length()-1);
		listaEmprestantes+="]";
		return listaEmprestantes;
	}

}
