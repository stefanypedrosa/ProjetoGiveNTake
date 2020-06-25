package com.giventake.api.structure.search;

import com.giventake.api.structure.node.NodeEmprestante;

public class BuscaSeqEmprestante {
	public NodeEmprestante BuscaEmprestante(NodeEmprestante inicio, int codigo) {
		NodeEmprestante tmp = inicio;
		do {
			if(tmp.getElemento().getCodEmprestante() == codigo) {
				return tmp;
			}
			tmp = tmp.getProximo();
		} while(tmp != inicio);
		
		return null;
	}
}
