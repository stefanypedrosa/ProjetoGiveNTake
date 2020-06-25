package com.giventake.api.structure.search;

import com.giventake.api.structure.node.NodeEmprestimo;

public class BuscaSeqEmprestimo {
	public NodeEmprestimo BuscaEmprestimo(NodeEmprestimo inicio, int codigo) {
		NodeEmprestimo tmp = inicio;
		do {
			if(tmp.getElemento().getCodEmprestimo() == codigo) {
				return tmp;
			}
			tmp = tmp.getProximo();
		} while(tmp != inicio);
		
		return null;
	}
}
