package com.exemplo.entidade;

public enum Tipo {
	Acabado(1), Elaboracao(2), Embalagem(3), Imobilizado(4); 
	public int valorTipo; 
	
	Tipo(int valor) { 
		valorTipo = valor; 
	}
}
