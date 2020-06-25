package com.giventake.api.structure;


import com.giventake.api.model.Emprestante;
import com.giventake.api.model.Emprestimo;
import com.giventake.api.model.Livro;
import com.giventake.api.structure.list.ListEmprestante;
import com.giventake.api.structure.list.ListEmprestimo;
import com.giventake.api.structure.list.ListLivro;

public class Database {
	private ListEmprestante ListEmprestante;
	private ListEmprestimo ListEmprestimo;
	private ListLivro ListLivro;
	private int codigoEmprestante;
	private int codigoEmprestimo;
	private int codigoLivro;

	public Database() {
		ListEmprestante = new ListEmprestante();
		ListEmprestimo = new ListEmprestimo();
		ListLivro = new ListLivro();
	}

	/*		Métodos Livro		*/
	public void inserirLivro(Livro livro) {
		codigoLivro++;
		livro.setCodLivro(codigoLivro);
		ListLivro.inserirFinal(livro);
	}
	
	public Livro consultarLivro(int codigo) {
		return ListLivro.consultarLivro(codigo);
	}
	
	public void emprestarLivro(Livro livro) {
		ListLivro.emprestarLivro(livro.getCodLivro());
	}
	
	public void devolverLivro(Livro livro) {
		ListLivro.devolverLivro(livro.getCodLivro());
	}
	
	public String consultarLivros() {
		return ListLivro.consultarLivros();
	}
	
	public int quantidadeLivros() {
		return ListLivro.tamanhoLista();
	}
	
	
	
	/*		Métodos Emprestante		*/
	public void inserirEmprestante(Emprestante emprestante) {
		codigoEmprestante++;
		emprestante.setCodEmprestante(codigoEmprestante);
		ListEmprestante.inserirFinal(emprestante);
	}
	
	public Emprestante consultarEmprestante(int codigo) {
		return ListEmprestante.consultarEmprestante(codigo);
	}
	
	public String consultarEmprestantes() {
		return ListEmprestante.consultarEmprestantes();
	}
	
	public int quantidadeEmprestantes() {
		return ListEmprestante.tamanhoLista();
	}
	
	
	/*		Métodos Empréstimo		*/
	public void inserirEmprestimo(Emprestimo emprestimo) {
		codigoEmprestimo++;
		emprestimo.setCodEmprestimo(codigoEmprestimo);
		ListLivro.emprestarLivro(emprestimo.getCodLivro().getCodLivro());
		ListEmprestimo.inserirFinal(emprestimo);
	}
	
	public Emprestimo consultarEmprestimo(int codigo) {
		Emprestimo resultado = ListEmprestimo.consultarEmprestimo(codigo);
		int livro = resultado.getCodLivro().getCodLivro();
		int emprestante = resultado.getCodEmprestante().getCodEmprestante();
		resultado.setCodLivro(ListLivro.consultarLivro(livro));
		resultado.setCodEmprestante(ListEmprestante.consultarEmprestante(emprestante));
		return resultado;
	}
	
	public String consultarEmprestimos() {
		return ListEmprestimo.consultarEmprestimos();
	}
	
	public int quantidadeEmprestimos() {
		return ListEmprestimo.tamanhoLista();
	}
	
}



//public ArrayList<Livro> consultarLivros() {
//ArrayList<Livro> lista = new ArrayList<Livro>();
//NodeLivro tmp;
//tmp = ListLivro.getInicio();
//do {
//	/*System.out.println("Elemento da Lista: " + tmp.getElemento().getCodLivro() 
//				+ "\n" + tmp.getElemento().getTitulo()
//				+ "\n" + tmp.getElemento().getAutor()
//				+ "\n" + tmp.getElemento().getGenero()
//				+ "\n" + tmp.getElemento().getDataAquisicao()
//				+ "\n" + tmp.getElemento().isDisponivel()
//				+ "\n" + tmp.getAnterior().toString()
//				+ "\n" + tmp.getProximo().toString());*/
//	lista.add(tmp.getElemento());
//	tmp = tmp.getProximo();
//} while(tmp != ListLivro.getInicio());
//return lista;
//}
