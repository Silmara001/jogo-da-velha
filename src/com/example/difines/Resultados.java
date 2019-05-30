package com.example.difines;

public class Resultados {

	//PARA COMPARAR AS #3
	private int[][] tresLinhasCima = new int[][] {
			{1,  2,  3}, 
			{2,  3,  4},   
			{5,  6,  7}, 
			{6,  7,  8} 
		};
	private int[][] tresLinhasBaixo = new int[][] {
			{9,  10, 11}, 
			{10, 11, 12},
			{13, 14, 15}, 
			{14, 15, 16} 
		};
	private int[][] tresColunasCima = new int[][] {
			{1,  5,  9}, 
			{2,  6,  10},
			{3,  7,  11},
			{4,  8,  12}
		};
	private int[][] tresColunasBaixo = new int[][] {
			{5,  9,  13},
			{6,  10, 14},
			{7, 11,  15},
			{8, 12,  16}
		};
	private int[][] tresDiagonalDireita = new int[][] {
			{1,  6,  11},  
			{6,  11, 16},
			{5,  10, 15},
			{2,  7,  12}
		};
	private int[][] tresDiagonalEsquerda= new int[][] {
			{4,  7,  10},
			{7,  10, 13},		 
			{3,  6,  9}, 
			{8,  11, 14}  
		};
		
		//PARA COMPARAR AS #4
	private int[][] quatroLinhas= new int[][] {
			{1,  2,  3,  4},     
			{5,  6,  7,  8},    
			{9,  10, 11, 12},
			{13, 14, 15, 16},
			{4,  7,  10, 13} 
		};
	private int[][] quatroColunas = new int[][] {
			{1,  5,  9,  13},
			{2,  6,  10, 14},
			{3,  7,  11, 15},
			{4,  8,  12, 16},
			{1,  6,  11, 16}
		};	
	
	
	public int[][] getTresLinhasCima() {
		return tresLinhasCima;
	}
	public void setTresLinhasCima(int[][] tresLinhasCima) {
		this.tresLinhasCima = tresLinhasCima;
	}
	public int[][] getTresLinhasBaixo() {
		return tresLinhasBaixo;
	}
	public void setTresLinhasBaixo(int[][] tresLinhasBaixo) {
		this.tresLinhasBaixo = tresLinhasBaixo;
	}
	public int[][] getTresColunasCima() {
		return tresColunasCima;
	}
	public void setTresColunasCima(int[][] tresColunasCima) {
		this.tresColunasCima = tresColunasCima;
	}
	public int[][] getTresColunasBaixo() {
		return tresColunasBaixo;
	}
	public void setTresColunasBaixo(int[][] tresColunasBaixo) {
		this.tresColunasBaixo = tresColunasBaixo;
	}
	public int[][] getTresDiagonalDireita() {
		return tresDiagonalDireita;
	}
	public void setTresDiagonalDireita(int[][] tresDiagonalDireita) {
		this.tresDiagonalDireita = tresDiagonalDireita;
	}
	public int[][] getTresDiagonalEsquerda() {
		return tresDiagonalEsquerda;
	}
	public void setTresDiagonalEsquerda(int[][] tresDiagonalEsquerda) {
		this.tresDiagonalEsquerda = tresDiagonalEsquerda;
	}
	public int[][] getQuatroLinhas() {
		return quatroLinhas;
	}
	public void setQuatroLinhas(int[][] quatroLinhas) {
		this.quatroLinhas = quatroLinhas;
	}
	public int[][] getQuatroColunas() {
		return quatroColunas;
	}
	public void setQuatroColunas(int[][] quatroColunas) {
		this.quatroColunas = quatroColunas;
	}
		
		
		
}
