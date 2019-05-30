package com.example.jogodavelha;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import com.example.difines.Defines;
import com.example.difines.Resultados;
import com.example.jogodavelha.R;

public class TelaJogo extends Activity{
	
	private String lastPlay = "X";  //   -> Primeiro jogador é bolinha!

	private int contadorX = 0;
	private int contadorO = 0;
	private int contadorJogadas = 0;
	private boolean isGanhou = false; 
	private boolean vsHumano = false;	
	
	private Resultados resultados;
	private Defines define;
	private View view;	
	private View TelaJogo =  null;
	
	ArrayList<String> itens = null;
    

	@Override
	public void onCreate(final Bundle savedInstanceState) {
		this.define = new Defines();
		this.resultados = new Resultados();
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_jogo);
		
		this.TelaJogo = findViewById(R.id.activityTelaJogo);
		
		
		 new AlertDialog.Builder(this).setTitle(R.string.modo_title).setItems(
			        R.array.modo, new DialogInterface.OnClickListener() {
			          public void onClick(DialogInterface dialoginterface, int i) {
			            if(i == 0) {
			            	vsHumano = true;
			            }
			          }
			        }).show();
	}	
	
	public void clickRestart(View v) {
		resetJogo();
	}
	
	public void clickBack(View v) {
		finish();
	}
		
	public void clickInfo(View v) {
		Intent i = new Intent(this, About.class);
		startActivity(i);
	}

	public void clickQuadrado(View v) throws InterruptedException {	
		
		if (vsHumano) {
			vsHumano(v);
		}
		else {
			vsComputador(v);			
		}
		
	}
	
	public void vsComputador(View v) throws InterruptedException {
		//implementar 
		
		Button btn = (Button)v;
		if (btn.getText().equals("")) {
			//é a vez do jogador humano
			jogadaHumano(btn);
			
			//vez do computador
			jogadaComputador();		
		}
		else {
			Toast.makeText(this, "Escolha outro quadrado!", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void jogadaHumano(Button btn) {
		btn.setText(define.getBOLA());			
		verifica(btn);		
	}
	
	
	public void verifica(Button btn) {
		this.contadorJogadas++;
		isQuatroQuadrados(btn);
		if (!isGanhou) {
			isTresQuadrados(btn);
			isVelha();
		}
		else {
			resetJogo();
		}
	}
	
	public void jogadaComputador() throws InterruptedException {
		Button btn = sortearQuadrado();
		//Thread.sleep(1000);
		btn.setText(define.getXIS());
		
		
		verifica(btn);		
	}
	
	public Button sortearQuadrado() {
		Button btn = (Button) this.TelaJogo.findViewWithTag(define.getQUADRADO() + SortearPosicao());
		if (!btn.getText().equals("")) {
			btn = sortearQuadrado();
		}
		return btn;
	}

	private int SortearPosicao() {	
		return new Random().nextInt(15) + 1;
	}

	public void vsHumano(View v) {
		Button btn = (Button)v;
		if(btn.getText().equals("")){
			if (getLastPlay().equals(define.getXIS())) {
				((Button)v).setText(define.getBOLA());	
				setLastPlay(define.getBOLA());
			}
			else {
				((Button)v).setText(define.getXIS());
				setLastPlay(define.getXIS());		
			}
			this.contadorJogadas++;
			isQuatroQuadrados(btn);
			if (!isGanhou) {
				isTresQuadrados(btn);
				isVelha();
			}
			else {
				resetJogo();
			}
		}
		else {
			Toast.makeText(this, "Escolha outro quadrado!", Toast.LENGTH_SHORT).show();
		}	
	}
	
	
	
	//---------------------------
	public void isVelha() {
		if(define.getTotalQuadrados() == this.contadorJogadas && verificaJogo()) {

			if(contadorX > contadorO) {
				isFim("JOGADOR X GANHOU!");
			}
			else if (contadorO > contadorX) {
				isFim("JOGADOR O GANHOU!");
			}
			else if (contadorO == contadorX) {
				isFim("DEU EMPATE!");
			}
		}
	}
	public void isFim(String str) {
		Toast.makeText(this, str, Toast.LENGTH_LONG).show();
	    isGanhou = true;
	    resetJogo();
	}
	
	public void resetJogo() {
		this.contadorO = 0;
		this.contadorX = 0;
		this.contadorJogadas = 0;
		
		getLabel("1").setText(define.getLABELDEFAULT() + "Nenhum");
		getLabel("2").setText(define.getLABELDEFAULT() + "Nenhum");
		
		isGanhou = false;
		lastPlay = "X";
		
		for(int i = 1; i<=16; i++) {
			if (getQuadrado(i) != null) {
				getQuadrado(i).setText("");				
			}
		}
	}	
	
	public boolean verificaJogo() {
		boolean velha = true;
		for(int i = 1; i<=16; i++) {
			if (getQuadrado(i).getText().equals("")) {
				velha = false; 				
			}
		}
		return velha;
	}
	
	
	//---------------------------
	
	public void isQuatroQuadrados(Button btn) {

		int index = Integer.parseInt(((String) btn.getTag()).substring(8));
		
		verificarMatrizQuatro(resultados.getQuatroLinhas(), index);
		verificarMatrizQuatro(resultados.getQuatroColunas(), index);
	}
		
	public void verificarMatrizQuatro(int[][] matriz, int indexButton) {
		for(int linha=0; linha<=4; ++linha){

			String s1="", s2="", s3="", s4="";
			
			if (indexButton == matriz[linha][0] || indexButton == matriz[linha][1] || indexButton == matriz[linha][2] || indexButton == matriz[linha][3] ) {
				
				s1 = getQuadrado(matriz[linha][0]).getText().toString();
				s2 = getQuadrado(matriz[linha][1]).getText().toString();
				s3 = getQuadrado(matriz[linha][2]).getText().toString();
				s4 = getQuadrado(matriz[linha][3]).getText().toString();
			}

			if ((!s1.equals("")) && (!s2.equals("")) && (!s3.equals("")) && (!s4.equals(""))){
				if(s1.equals(s2) && s2.equals(s3) && s3.equals(s4)){
					if(s1.equals("O")) {
						//JOGADOR 1 GANHOU!
						Toast.makeText(this, "JOGADOR O GANHOU!", Toast.LENGTH_LONG).show();
						isGanhou = true;
					}
					else if (s1.equals("X")) {
						//JOGADOR 2 GANHOU!
						Toast.makeText(this, "JOGADOR X GANHOU!", Toast.LENGTH_LONG).show();
						isGanhou = true;
					}
				}
			}
		}
	}
	
	//---------------------------
	public void isTresQuadrados(Button btn){
		
		int index = Integer.parseInt(((String) btn.getTag()).substring(8));		
		
		verificarMatrizTres(resultados.getTresLinhasCima(), index);
		verificarMatrizTres(resultados.getTresLinhasBaixo(), index);
		verificarMatrizTres(resultados.getTresColunasCima(), index);
		verificarMatrizTres(resultados.getTresColunasBaixo(), index);
		verificarMatrizTres(resultados.getTresDiagonalDireita(), index);
		verificarMatrizTres(resultados.getTresDiagonalEsquerda(), index);
	}
	
	public void verificarMatrizTres(int[][] matriz, int indexButton) {
		for(int linha=0; linha<=3; linha++) {
			String s1="", s2="", s3="";
			
			if (indexButton == matriz[linha][0] || indexButton == matriz[linha][1] || indexButton == matriz[linha][2] ) {
				s1 = getQuadrado(matriz[linha][0]).getText().toString();
				s2 = getQuadrado(matriz[linha][1]).getText().toString();
				s3 = getQuadrado(matriz[linha][2]).getText().toString();
			}

			if ((!s1.equals("")) && (!s2.equals("")) && (!s3.equals(""))){
				if(s1.equals(s2) && s2.equals(s3)){
					if(s1.equals("O")) {
						contarPontoJogadorO(matriz, linha);
					}
					else if (s1.equals("X")) {
						contarPontoJogadorX(matriz, linha);
					}
				}
			}
			
		}
	}
	
	public void contarPontoJogadorO(int[][] matriz, int linha) {
		this.contadorO++;
		getLabel("1").setText(define.getLABELDEFAULT() + contadorO + "  feitas");
		//setLinhaTres(x, R.color.vermelho);
	}
	
	public void contarPontoJogadorX(int[][] matriz, int linha) {
		this.contadorX++;
		getLabel("2").setText(define.getLABELDEFAULT() + contadorX + "  feitas");;
		//setLinhaTres(x, R.color.vermelho);
	}
	
	
	
	// GETTERS DO XML DA TELA DO JOGO
	public TextView getLabel(String str) {	
		return (TextView) TelaJogo.findViewWithTag(define.getLABELJOGADOR() + str);
	}

	public Button getQuadrado(int tagNum) {		
		return (Button) TelaJogo.findViewWithTag(define.getQUADRADO() + tagNum);		
	}
	
	//GETTERS E SETTERS DE VARIAVEIS DA TELA PRINCIAL ACTIVITY	
	public String getLastPlay() {
		return this.lastPlay;
	}
	public void setLastPlay(String lp) {
		this.lastPlay = lp;
	}

	public View getView() {
		return this.view;
	}
	public void setView(View view) {
		this.view = view;
	}

}