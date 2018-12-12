/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

public class ValorClasse {
    private double classeI;
    private double classeF;
    private double xi;
    private int ni;
    private double xi_ni;
    private double fi;
    
    public ValorClasse(double classeI, double classeF, double xi, int ni, 
                       double xi_ni, double fi) {
        this.classeI = classeI;
        this.classeF = classeF;
        this.xi = xi;
        this.ni = ni;
        this.xi_ni = xi_ni;
        this.fi = fi;
    }

    public double getXi_ni() {
        return xi_ni;
    }

    public void setXi_ni(double xi_ni) {
        this.xi_ni = xi_ni;
    }

    public double getFi() {
        return fi;
    }

    public void setFi(double fi) {
        this.fi = fi;
    }

	public double getClasseI() {
		return classeI;
	}

	public void setClasseI(double classeI) {
		this.classeI = classeI;
	}

	public double getClasseF() {
		return classeF;
	}

	public void setClasseF(double classeF) {
		this.classeF = classeF;
	}

	public double getXi() {
		return xi;
	}

	public void setXi(double xi) {
		this.xi = xi;
	}

	public int getNi() {
		return ni;
	}

	public void setNi(int ni) {
		this.ni = ni;
	}
}
