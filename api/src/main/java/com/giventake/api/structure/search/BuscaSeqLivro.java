package com.giventake.api.structure.search;

import com.giventake.api.structure.node.NodeLivro;

public class BuscaSeqLivro {
	public NodeLivro BuscaLivro(NodeLivro inicio, int codigo) {
		NodeLivro tmp = inicio;
		do {
			if(tmp.getElemento().getCodLivro() == codigo) {
				return tmp;
			}
			tmp = tmp.getProximo();
		} while(tmp != inicio);
		
		return null;
	}
}
