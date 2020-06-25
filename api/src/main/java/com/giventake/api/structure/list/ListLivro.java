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






//public void inserirInicio(Livro elemento) {
//NodeLivro novo = new NodeLivro();
//novo.setElemento(elemento);
//
//if(isEmpty()) {
//	novo.setProximo(novo);
//	novo.setAnterior(novo);
//	inicio = novo;
//}
//else {
//	NodeLivro tmp = getInicio();
//	NodeLivro aux = getInicio().getAnterior();
//	novo.setProximo(getInicio());
//	novo.setAnterior(getInicio().getAnterior());
//	tmp.setAnterior(novo);
//	aux.setProximo(novo);
//	inicio = novo;
//}
//}









//public String consultarLivrosAlfabetica() {
//Collator col = Collator.getInstance();
//int aux;
//int tamanho = tamanhoLista();
//String listaLivros = "[";
//NodeLivro tmp = getInicio();
//NodeLivro aux1 = new NodeLivro();
//NodeLivro aux2 = new NodeLivro();
//
//for(int cont = 4; cont >= 1; cont--) {
//	for(int contAux = 4; contAux >= 1; contAux--) {
//		aux = col.compare(tmp.getElemento().getTitulo(), tmp.getProximo().getElemento().getTitulo());
//		System.out.println("{\"codLivro\":" + tmp.getElemento().getCodLivro() 
//				+ ",\"titulo\":\"" + tmp.getElemento().getTitulo().toString()+ "} |||||");
//		System.out.println("{\"codLivro\":" + tmp.getProximo().getElemento().getCodLivro() 
//				+ ",\"titulo\":\"" + tmp.getProximo().getElemento().getTitulo().toString()+ "}");
//		if(col.compare(tmp.getElemento().getTitulo(), tmp.getProximo().getElemento().getTitulo()) > 0) {
//			aux1.setElemento(tmp.getElemento());
//			aux2.setElemento(tmp.getProximo().getElemento());
//			tmp.getProximo().setElemento(aux1.getElemento());
//			tmp.setElemento(aux2.getElemento());
//			
//		}
//		System.out.println(cont + " - collator: "+ aux);
//		tmp = tmp.getProximo();
//	}
//	tmp = tmp.getProximo();
//}
//do {
//	listaLivros+="{\"codLivro\":" + tmp.getElemento().getCodLivro() 
//		+ ",\"titulo\":\"" + tmp.getElemento().getTitulo().toString()
//		+ "\",\"autor\":\"" + tmp.getElemento().getAutor().toString()
//		+ "\",\"genero\":\"" + tmp.getElemento().getGenero().toString()
//		+ "\",\"dataAquisicao\":\"" + tmp.getElemento().getDataAquisicao().toString()
//		+ "\",\"disponivel\":" + tmp.getElemento().isDisponivel() + "},";
//	tmp = tmp.getProximo();
//} while(tmp != getInicio());
//listaLivros = listaLivros.substring(0, listaLivros.length()-1);
//listaLivros+="]";
//return listaLivros;
//}









//public void exibirNaOrdem() {
//NodeLivro tmp;
//tmp = getInicio();
//do {
//	System.out.println("Elemento da Lista: " + tmp.getElemento().getCodLivro() 
//			+ "\n" + tmp.getElemento().getTitulo()
//			+ "\n" + tmp.getElemento().getAutor()
//			+ "\n" + tmp.getElemento().getGenero()
//			+ "\n" + tmp.getElemento().getDataAquisicao()
//			+ "\n" + tmp.getElemento().isDisponivel()
//			+ "\n" + tmp.getAnterior().toString()
//			+ "\n" + tmp.getProximo().toString());
//	tmp = tmp.getProximo();
//} while(tmp != getInicio());
//}
//
//public void exibirNaOrdemInversa() {
//NodeLivro tmp;
//tmp = getInicio();
//do {
//	System.out.println("Elemento da Lista: " + tmp.getElemento().getCodLivro() 
//			+ "\n" + tmp.getElemento().getTitulo()
//			+ "\n" + tmp.getElemento().getAutor()
//			+ "\n" + tmp.getElemento().getGenero()
//			+ "\n" + tmp.getElemento().getDataAquisicao()
//			+ "\n" + tmp.getElemento().isDisponivel()
//			+ "\n" + tmp.getAnterior().toString()
//			+ "\n" + tmp.getProximo().toString());
//	tmp = tmp.getAnterior();
//} while(tmp != getInicio());
//}