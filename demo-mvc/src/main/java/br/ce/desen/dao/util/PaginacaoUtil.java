package br.ce.desen.dao.util;

import java.util.List;

public class PaginacaoUtil<T> {
	
	private int pagina;
	private int tamanho;
	private long totalDePaginas;
	private List<T> registros;
	
	
	public PaginacaoUtil(int pagina, int tamanho, long totalDePaginas, List<T> registros) {
		super();
		this.pagina = pagina;
		this.tamanho = tamanho;
		this.totalDePaginas = totalDePaginas;
		this.registros = registros;
	}


	public int getPagina() {
		return pagina;
	}


	public int getTamanho() {
		return tamanho;
	}


	public long getTotalDePaginas() {
		return totalDePaginas;
	}


	public List<T> getRegistros() {
		return registros;
	}


}
