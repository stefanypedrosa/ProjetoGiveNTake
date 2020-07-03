package com.giventake.api.structure.list;


import com.giventake.api.model.Livro;
import com.giventake.api.structure.node.NodeLivro;
import com.giventake.api.structure.search.BuscaSeqLivro;

public class ListLivro {

	private NodeLivro inicio;
	private BuscaSeqLivro busca = new BuscaSeqLivro();

	public ListLivro() {
		this.inicio = null;
	}
	
	public int tamanhoLista() {
		NodeLivro tmp;
		tmp = getInicio();
		int tamanho = 0;
		do {
			tamanho++;
			tmp = tmp.getProximo();
		} while(tmp != getInicio());
		return tamanho;
	}
	
	public NodeLivro getInicio() {
		return inicio;
	}

	public boolean isEmpty() {
		return (this.getInicio() == null);
	}

	public void inserirFinal(Livro elemento) {
		NodeLivro novo = new NodeLivro();
		novo.setElemento(elemento);

		if(isEmpty()) {
			novo.setProximo(novo);
			novo.setAnterior(novo);
			inicio = novo;
		}
		else {
			NodeLivro tmp = getInicio();
			while (tmp.getProximo() != getInicio()) {
				tmp = tmp.getProximo();
			}
			getInicio().setAnterior(novo);
			tmp.setProximo(novo);
			novo.setAnterior(tmp);
			novo.setProximo(getInicio());
		}
	}

	public NodeLivro buscarPosicao(int codigo) {
		return busca.BuscaLivro(getInicio(), codigo);
	}
	
	public Livro consultarLivro(int codigo) {
		NodeLivro resultado = buscarPosicao(codigo);
		return resultado.getElemento();
	}

	public void emprestarLivro(int codigo) {
		NodeLivro resultado = buscarPosicao(codigo);
		resultado.getElemento().setStatus("Emprestado");
	}
	
	public void devolverLivro(int codigo) {
		NodeLivro resultado = buscarPosicao(codigo);
		resultado.getElemento().setStatus("Disponível");
	}

	public void removerFinal() {
		if(isEmpty()) {
			throw new RuntimeException("Lista Vazia!");
		}
		else {
			NodeLivro tmp = getInicio();
			NodeLivro ultimo = getInicio();
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
			NodeLivro tmp = getInicio();
			NodeLivro novoInicio = tmp.getProximo();
			novoInicio.setAnterior(tmp.getAnterior());
			while (tmp.getProximo() != getInicio()) {
				tmp = tmp.getProximo();
			}
			tmp.setProximo(novoInicio);
			inicio = novoInicio;
		}
	}


	
	public String consultarLivros() {
		String listaLivros = "[";
		NodeLivro tmp;
		tmp = getInicio();
		do {
			listaLivros+="{\"codLivro\":" + tmp.getElemento().getCodLivro() 
				+ ",\"titulo\":\"" + tmp.getElemento().getTitulo().toString()
				+ "\",\"autor\":\"" + tmp.getElemento().getAutor().toString()
				+ "\",\"genero\":\"" + tmp.getElemento().getGenero().toString()
				+ "\",\"dataAquisicao\":\"" + tmp.getElemento().getDataAquisicao().toString()
				+ "\",\"status\":\"" + tmp.getElemento().getStatus()+ "\"},";
			tmp = tmp.getProximo();
		} while(tmp != getInicio());
		listaLivros = listaLivros.substring(0, listaLivros.length()-1);
		listaLivros+="]";
		return listaLivros;
	}

	
	
}