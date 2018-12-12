/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

public class Resultado {
	private int totReg;
	private int totVendas;
	private int media;
	private int mediana;
	private ArrayList<Integer> moda1;
	private double varianciaA;
	private double desvioPadrao;

	public Resultado(int totReg, int totVendas, int media, int mediana,
			ArrayList<Integer> moda1, double varianciaA,double desvioPadrao) {
		this.totReg = totReg;
		this.totVendas = totVendas;
		this.moda1 = moda1;
		this.media = media;
		this.varianciaA = varianciaA;
		this.desvioPadrao = desvioPadrao;
	}

	public int getTotReg() {
		return totReg;
	}

	public void setTotReg(int totReg) {
		this.totReg = totReg;
	}

	public int getTotVendas() {
		return totVendas;
	}

	public void setTotVendas(int totVendas) {
		this.totVendas = totVendas;
	}

	public int getMedia() {
		return media;
	}

	public void setMedia(int media) {
		this.media = media;
	}

	public int getMediana() {
		return mediana;
	}

	public void setMediana(int mediana) {
		this.mediana = mediana;
	}

	public ArrayList<Integer> getModa1() {
		return moda1;
	}

	public void setModa1(ArrayList<Integer> moda1) {
		this.moda1 = moda1;
	}

	public double getVarianciaA() {
		return varianciaA;
	}

	public void setVarianciaA(double varianciaA) {
		this.varianciaA = varianciaA;
	}

	public double getDesvioPadrao() {
		return desvioPadrao;
	}

	public void setDesvioPadrao(double desvioPadrao) {
		this.desvioPadrao = desvioPadrao;
	}
}
